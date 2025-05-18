package fp.vuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class VuelosB5 extends Vuelos{
	public VuelosB5(String nombre, List<Vuelo> vuelos) {
		super(nombre, vuelos);
	}
	
	public Long getNumDestinosDiferentesFecha (LocalDate fecha) {
		return this.getVuelos().stream()
				.filter(x-> x.getFecha().equals(fecha))
				.map(x-> x.getDestino())
				.distinct()
				.count();
	}
	public SortedSet<Vuelo> getVuelosOrdenados(){
		return this.getVuelos().stream()
				.collect(Collectors.toCollection(TreeSet::new));
	}
	
	public SortedSet<String> getDestinosOrdenados(Character c) {
		return this.getVuelos().stream()
				.map(x-> x.getDestino())
				.filter(x-> x.startsWith(String.valueOf(c)))
				.collect(Collectors.toCollection(()-> new TreeSet<String>(Comparator.naturalOrder())));
	}
	
	public SortedSet<String> getDestinosOrdenadosPorLongitud(){
		return this.getVuelos().stream()
				.map(x-> x.getDestino())
				.collect(Collectors.toCollection(() -> new TreeSet<String>(Comparator.comparing(String::length)
																			.thenComparing(Comparator.naturalOrder()))));
				
	}
	public Integer getNumVuelosFecha(LocalDate fecha) {
		return this.getVuelos().stream()
				.filter(x-> x.getFecha().equals(fecha))
				.collect(Collectors.toList()).size();
	}
	public Double getPrecioMedioVuelosMes(Integer mes) {
		return this.getVuelos().stream()
				.filter(x-> x.getFecha().getMonthValue() == (mes))
				.mapToDouble(x-> x.getPrecio())
				.average()
				.orElse(0.0);
	}
	
	public Double getRecaudacion(Integer anyo) {
		return this.getVuelos().stream()
				.filter(x-> x.getFecha().getYear() == anyo)
				.mapToDouble(x-> x.getPrecio()*x.getNumPasajeros())
				.sum();
	}
	
	public Vuelo getVueloMasPasajeros() {
		return Collections.max(this.getVuelos().stream()
				.collect(Collectors.toList()),
				Comparator.comparing(Vuelo::getNumPasajeros));
	}
	public Map<LocalDate, List<Vuelo>> getVuelosPorFecha(){
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha, Collectors.toList()));
	}
	
	public Map<LocalDate, Long> getNumVuelosPorFecha(){
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getFecha,
												Collectors.counting()));
	}
	
	public Map<String, Integer> getNumPlazasPorDestino(){
		 //Funcion auxiliar que convierta un List<Vuelo> en el numero de plazas totales
		Function<List<Vuelo>, Integer> listaVuelosAPlazasTotales = x-> x.stream()
				.mapToInt(y -> y.getNumPlazas())
				.sum();
		 //Convertir en un Map<String, List<Vuelo>> con los vuelos por destino
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino, 
						Collectors.collectingAndThen(Collectors.toList(), 
								listaVuelosAPlazasTotales)));
	}
	
	public Map<String, Double> getPrecioMedioPorDestino(){
		//Funcion auxiliar usada
		Function<List<Vuelo>, Double> ListaAMedia = x -> x.stream()
				.mapToDouble(y -> y.getPrecio())
				.average()
				.orElse(0.0);
		/*devolver Map<String, Double> a partir de uno cuyos valores son List<Vuelo> a las que se le aplica una aux que convierte en la
		*media de precios
		*/
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino, Collectors.collectingAndThen(Collectors.toList(), ListaAMedia)));
	}
	public Map<String, Set<LocalDate>> getFechasPorDestino(){
		//Funcion
		Function<List<Vuelo>, Set<LocalDate>> ListaVuelosToSetFechas = x -> x.stream()
				.map(Vuelo::getFecha)
				.collect(Collectors.toSet());
		return this.getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getDestino, Collectors.collectingAndThen(Collectors.toList(), ListaVuelosToSetFechas)));
	}
}
