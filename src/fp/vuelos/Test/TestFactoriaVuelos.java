package fp.vuelos.Test;
import java.util.List;

import fp.vuelos.FactoriaVuelos;
import fp.vuelos.Vuelo;
import fp.vuelos.Vuelos;

public class TestFactoriaVuelos {
	public static void main(String args[]) {
		List<Vuelo> res = FactoriaVuelos.leeVuelos("aeropuerto.csv");
		System.out.println("Numero de vuelos leidos:" + res.size());
		System.out.println("Los primeros 3:" + res.subList(0, 3));
		System.out.println("Los ultimos 3:" +  res.subList(res.size() - 3, res.size()));
		
		Vuelo v1 = res.get(0);
		Vuelo v2 = res.get(1);
		System.out.println(v1.compareTo(v2));
		
	}
		
}


