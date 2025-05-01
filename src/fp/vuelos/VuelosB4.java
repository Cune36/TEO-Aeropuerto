package fp.vuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;
public class VuelosB4 extends Vuelos{
	public VuelosB4(String nombre, List<Vuelo> vuelos) {
		super(nombre, vuelos);
	}
	public Boolean existeVueloDestino(String destino) {
		return vuelos.stream()
				.anyMatch(v -> v.getDestino().equals(destino));
	}
	public Boolean TodosVuelosAlMenosNPasajeros(Integer n) {
		return vuelos.stream()
				.allMatch(v -> v.getNumPasajeros() >= n);
	}
	public Long getNumVuelosFecha(LocalDate fecha) {
		return vuelos.stream()
				.filter(v -> v.getFecha().equals(fecha))
				.count();
	}
	public List<Vuelo> getVuelosPosteriores(LocalDate fecha){
		return vuelos.stream()
				.filter(v -> v.getFecha().isAfter(fecha))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	public Set<String> getDestinoDeVuelosAnteriores(LocalDate fecha){
		return vuelos.stream()
				.filter(v -> v.getFecha().isBefore(fecha))
				.map(v -> v.getDestino())
				.collect(Collectors.toCollection(HashSet::new));
	}
	public Integer getNumPasajerosConDestinos(List<String> destinos) {
		return (int) vuelos.stream()
				.filter(v -> destinos.contains(v.getDestino()))
				.mapToInt(v -> v.getNumPasajeros())
				.sum();
	}
	public Double getPrecioMedioVuelosMes(Integer mes) {
		return vuelos.stream()
				.filter(v -> v.getFecha().getMonthValue() == mes)
				.mapToDouble(v -> v.getPrecio())
				.average()
				.orElse(0.0);
	}
	public Double getRecaudacionPorAno(Integer ano) {
		return vuelos.stream()
				.filter(v->v.getFecha().getYear() == ano)
				.mapToDouble(v -> v.getPrecio()*v.getNumPasajeros())
				.sum();
	}
	public Vuelo getVueloMasPasajeros() {
		return vuelos.stream()
				.max(Comparator.comparing(Vuelo::getNumPasajeros))
				.orElse(null);
	}
	public String getCodigoVueloMenorPrecioConDestino(String destino) {
		return vuelos.stream()
				.filter(v->v.getDestino().equals(destino))
				.min(Comparator.comparing(Vuelo::getPrecio))
				.map(v->v.getCodigo())
				.orElseThrow(NoSuchElementException::new);
	}
	public List<Vuelo> getNVuelosMasBaratos(Integer n) {
		return vuelos.stream()
				.sorted(Comparator.comparing(Vuelo::getPrecio))
				.collect(Collectors.toCollection(ArrayList::new)).subList(0, n);
	}
	public List<Vuelo> getNVuelosMasDuracion(Integer n){
		return vuelos.stream()
				.sorted(Comparator.comparing(Vuelo::getDuracion).reversed())
				.collect(Collectors.toCollection(ArrayList::new)).subList(0, n);
	}
}
