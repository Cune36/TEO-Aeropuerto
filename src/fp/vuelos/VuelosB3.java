package fp.vuelos;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class VuelosB3 extends Vuelos{
	
	public VuelosB3(String nombre, List<Vuelo> vuelos) {
		super(nombre,vuelos);
	}
	
	public SortedMap<String, Integer> getNumVuelosPorDestino() {
		SortedMap<String, Integer> res = new TreeMap<>();
		for(Vuelo v:vuelos) {
			if(res.keySet().contains(v.getDestino())) {
				Integer valor = res.get(v.getDestino());
				res.put(v.getDestino(),valor + 1);
			}else
				res.put(v.getDestino(),1);
		}
		return res;
	}
	public SortedMap<LocalDate, Integer> getNumPasajerosPorFecha(){
		SortedMap<LocalDate, Integer> res = new TreeMap<>();
		for(Vuelo v:vuelos) {
			if(res.keySet().contains(v.getFecha())) {
				Integer valor = res.get(v.getFecha());
				res.put(v.getFecha(),valor + v.getNumPasajeros());
			}else
				res.put(v.getFecha(),v.getNumPasajeros());
		}
		return res;
	}
	public SortedMap<String, List<String>> getCodigosPorDestino(){
		SortedMap<String, List<String>> res = new TreeMap<>();
		for(Vuelo v:vuelos) {
			if(res.containsKey(v.getDestino())) {
				List<String> lista = res.get(v.getDestino());
				lista.add(v.getCodigo());
				res.put(v.getDestino(), lista);
			}else {
				List<String> lista = new ArrayList<String>();
				lista.add(v.getCodigo());
				res.put(v.getDestino(),lista);
			}
		}
		return res;
	}
	public SortedMap<String, List<LocalDate>> getFechasPorDestino(){
		SortedMap<String, List<LocalDate>> res = new TreeMap<>();
		for(Vuelo v:vuelos) {
			if(v.getPorcentajeOcupacion() != 1) {
				if(res.containsKey(v.getDestino())) {
					List<LocalDate> lista = res.get(v.getDestino());
					lista.add(v.getFecha());
					res.put(v.getDestino(), lista);
				}else {
					List<LocalDate> lista = new ArrayList<>();
					lista.add(v.getFecha());
					res.put(v.getDestino(), lista);
				}
			}
		}
		return res;
	}
	public SortedSet<LocalDate> getFechasOrdenadasParaDestino(String destino){
		SortedSet<LocalDate> res = new TreeSet<>();
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino))
				res.add(v.getFecha());
		}
		return res;
	}
	public SortedSet<Vuelo> getVuelosOrdPorFecha(){
		SortedSet<Vuelo> res = new TreeSet<Vuelo>(Comparator.comparing(Vuelo::getFecha).thenComparing(Comparator.naturalOrder()));
		for(Vuelo v:vuelos) {
			res.add(v);
		}
		return res;
	}
	public SortedSet<Vuelo> getConjOrdVuelosPorDestino(){
		SortedSet<Vuelo> res = new TreeSet<Vuelo>(Comparator.comparing(Vuelo::getDestino).thenComparing(Comparator.naturalOrder()));
		for(Vuelo v:vuelos) {
			res.add(v);
		}
		return res;
	}
	public SortedMap<String, Integer> getMapOrdNumVuelosPorDestino(){
		Comparator<String> comparacionPorTamaño = Comparator.comparing(x-> x.length());
		SortedMap<String, Integer> res = new TreeMap<>(comparacionPorTamaño.thenComparing(Comparator.naturalOrder()));
		for(Vuelo v:vuelos) {
			if(res.keySet().contains(v.getDestino())) {
				Integer valor = res.get(v.getDestino());
				res.put(v.getDestino(),valor + 1);
			}else
				res.put(v.getDestino(),1);
		}
		return res;
	}
	public String getDestinoMasVuelos() {
		Set<Entry<String, Integer>> dict = getNumVuelosPorDestino().entrySet();
		return Collections.max(dict,Comparator.comparing(Entry::getValue)).getKey();
		
	}
	public LocalDate getFechaMenosPasajeros() {
		Set<Entry<LocalDate, Integer>> dict = getNumPasajerosPorFecha().entrySet();
		Comparator<Entry<LocalDate, Integer>> comparacion = (x,y)-> x.getValue().compareTo(y.getValue());
		return Collections.min(dict, comparacion).getKey();
	}
	public Map<String, List<Vuelo>> getMapListaVuelosLibresPorDestino(){
		Map<String, List<Vuelo>> res = new HashMap<>();
		for(Vuelo v:vuelos) {
			if(v.getPorcentajeOcupacion() != 1) {
				if(res.containsKey(v.getDestino())) {
					List<Vuelo> lista = res.get(v.getDestino());
					lista.add(v);
					res.put(v.getDestino(), lista);
				}else {
					List<Vuelo> lista = new ArrayList<>();
					lista.add(v);
					res.put(v.getDestino(), lista);
				}
			}
		}
		return res;
	}
	public Map<String, Vuelo> getMapPrimerVueloPlazasLibresPorDestino(){
		Map<String, Vuelo> res = new HashMap<>();
		Map<String, List<Vuelo>> dict = getMapListaVuelosLibresPorDestino();
		for(Entry<String, List<Vuelo>> e: dict.entrySet()) {
			res.put(e.getKey(), Collections.min(e.getValue(),Comparator.comparing(Vuelo::getFecha)));
		}
		return res;
	}
}
