package fp.vuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VuelosB2 extends Vuelos{
	public VuelosB2(String nombre, List<Vuelo> vuelos) {
		super(nombre,vuelos);
	}
	public Integer getNumPasajerosDestino(String destino) {
		Integer res = 0;
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino))
				res += v.getNumPasajeros();
		}
		return res;
	}
	public Integer getNumPasajerosDestinoPrefijo(String chars) {
		Integer res = 0;
		for(Vuelo v:vuelos) {
			if(v.getDestino().startsWith(chars))
				res += v.getNumPasajeros();
		}
		return res;
	}
	
	public Double getRecaudacionDestino(String destino) {
		Double res = 0.0;
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino))
				res += v.getPrecio()*v.getNumPasajeros();
		}
		return res;
	}
	
	public Vuelo getPrimerVueloDestino(String destino) {
		Vuelo res = null;
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino) && (res == null || v.getFecha().isBefore(res.getFecha())))
				res = v;
		}
		return res;
	}
	public Vuelo getPrimerVueloDestinoMenorPrecio(String destino) {
		List<Vuelo> res = new ArrayList<>();
		Vuelo menor_vuelo = null;
		res.add(getPrimerVueloDestino(destino));
		for(Vuelo v:vuelos){
			if(v.getFecha().equals(res.get(0).getFecha()))
				res.add(v);
		}
		for(Vuelo v:res) {
			if(menor_vuelo == null || v.getPrecio() < menor_vuelo.getPrecio())
				menor_vuelo = v;
		}
		return menor_vuelo;
}
	public Vuelo getPrimerVueloDestinoPlazasLibres(String destino) {
		Vuelo res = null;
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino) && !v.estaCompleto() && (res == null || v.getFecha().isBefore(res.getFecha())))
				res = v;
		}
		return res;
	}
	public Set<String> getConjuntoDestinosFecha(LocalDate fecha){
		Set<String> res = new HashSet<>();
		for(Vuelo v:vuelos) {
			if(v.getFecha().equals(fecha))
				res.add(v.getDestino());
		}
		return res;
	}
	public boolean existeVueloPrecioMenor(Double precio) {
		for(Vuelo v:vuelos) {
			if(v.getPrecio()<precio)
				return true;
		}
		return false;
	}
	public boolean estanTodosPorcentajeMayor(Double porcentaje) {
		boolean res = true;
		for(Vuelo v:vuelos) {
			if(v.getPorcentajeOcupacion() <= porcentaje)
				res = false;
		}
		return res;
	}
	public Vuelo getVueloMenorOcupacion() {
		Vuelo res = null;
		for(Vuelo v:vuelos) {
			//Aquel vuelo con menor ocupacion sera aquel con mayor plazas libres
			if(res == null || (res.getNumPlazas()- res.getNumPasajeros()) < (v.getNumPlazas()- v.getNumPasajeros()))
				res = v;
		}
		return res;
	}
	public Vuelo getVueloMasBaratoDestino(String destino) {
		Vuelo res = null;
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino) && (res == null || res.getPrecio() > v.getPrecio()))
				res = v;
		}
		return res;
	}
	public Double getPrecioMedioVuelosPosteriores(LocalDate fecha) {
		List<Double> res = new ArrayList<Double>();
		for(Vuelo v:vuelos) {
			if(v.getFecha().isAfter(fecha))
				res.add(v.getPrecio());
		}
		if(res.size() == 0)
			return 0.0;
		else {
			Double suma = 0.0;
			for(Double a:res) {
				suma += a;
			}
			return suma/res.size();
		}
	}
	public List<Vuelo> getListaOrdenadaPorPrecioDestino(String destino){
		List<Vuelo> res = new ArrayList<>();
		for(Vuelo v:vuelos) {
			if(v.getDestino().equals(destino))
				res.add(v);
		}
		Collections.sort(res, Comparator.comparing(Vuelo::getPrecio));
		return res;
	}
}

