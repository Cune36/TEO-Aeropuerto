package fp.vuelos;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vuelos {
	private String nombre;
	protected List<Vuelo> vuelos;
	
	public Vuelos(String nombre, List<Vuelo> vuelos) {
		this.nombre = nombre;
		this.vuelos = vuelos;
	}
	public String getNombre() {
		return nombre;
	}
	public List<Vuelo> getVuelos() {
		return vuelos;
	}
	public Integer getNumeroVuelos() {
		return vuelos.size();
	}
	public Integer getNumPasajeros() {
		return (int) vuelos.stream()
				.map(Vuelo::getNumPasajeros)
				.count();
	}
	public Double getPrecioMedio() {
		Double res = 0.0;
		for(Vuelo v:vuelos) {
			res += v.getPrecio();
		}
		if(vuelos.size() == 0)
			return null;
		else
			return res/vuelos.size();
	}
	public Integer getNumeroDestinos() {
		Set<String> res = new HashSet<>();
		for(Vuelo v:vuelos) {
			res.add(v.getDestino());
		}
		return res.size();
	}
@Override
	public String toString() {
		String texto = "";
		for(Vuelo v:vuelos) {
			texto += v.toString() + "\n";
		}
		return texto;
	}
@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		if(obj == null)
			return false;
		if(obj.getClass() != this.getClass())
			return false;
		Vuelos other = (Vuelos) obj;
		if(this.getNombre().equals(other.getNombre()) && this.vuelos.equals(other.vuelos))
			return true;
		else
			return false;
	}

	public Integer getNumPasajerosDestino(String destino) {
		return vuelos.stream()
				.filter(x-> x.getDestino().equals(destino))
				.mapToInt(Vuelo::getNumPasajeros)
				.sum();
	}
	public void incorporaVuelo(Vuelo v) {
		vuelos.add(v);
	}
	public void incorporaVuelos(Collection<Vuelo> vuelos) {
		this.vuelos.addAll(vuelos);
	}
	public void eliminaVuelo(Vuelo v) {
		vuelos.remove(v);
	}
	public void ordena() {
		vuelos.sort(null);
	}
	public Boolean existeVueloDestino(String destino) {
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino))
				return true;
		}
		return false;
	}

}
