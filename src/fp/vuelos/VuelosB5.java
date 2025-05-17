package fp.vuelos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
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
}
