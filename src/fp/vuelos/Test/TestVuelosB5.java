package fp.vuelos.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;

import fp.vuelos.FactoriaVuelos;
import fp.vuelos.Vuelo;
import fp.vuelos.VuelosB4;
import fp.vuelos.VuelosB5;

public class TestVuelosB5 {
	private static List<Vuelo> TestFactoriaVuelos(String nomfich){
		List<Vuelo> res = FactoriaVuelos.leeVuelos(nomfich);
		System.out.println("Numero de vuelos leidos:" + res.size());
		System.out.println("Los primeros 3:" + res.subList(0, 3));
		System.out.println("Los ultimos 3:" +  res.subList(res.size() - 3, res.size()));
		return res;
	}
	private static void TestGetNumDestinosDiferentesFecha(VuelosB5 vuelos, LocalDate fecha) {
		System.out.println("Hay " + vuelos.getNumDestinosDiferentesFecha(fecha) + " destinos diferentes en la fecha " + 
	fecha);
	}
	
	private static void TestGetVuelosOrdenados(VuelosB5 vuelos) {
		System.out.println("Estos son los vuelos ordenados:");
		SortedSet<Vuelo> res = vuelos.getVuelosOrdenados();
		for(Vuelo v: res) {
			System.out.println(v);
		}
	}
	
	public static void main(String args[]) {
		List<Vuelo> lista = TestFactoriaVuelos("aeropuerto.csv");
		VuelosB5 vuelos = new VuelosB5("xd", lista);
		System.out.println("===testGetNumDestinosDiferentesFecha ==========");
		TestGetNumDestinosDiferentesFecha(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("===testGetVuelosOrdenados ==========");
		TestGetVuelosOrdenados(vuelos);
		System.out.println("===testGetDestinosOrdenados ==========");
	}
}
