package fp.vuelos.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
	
	private static void TestGetDestinosOrdenados(VuelosB5 vuelos, Character c) {
		SortedSet<String> res = vuelos.getDestinosOrdenados(c);
		System.out.println("Los destinos ordenados son: ");
		for(String a:res) {
			System.out.println(a);
		}
	}
	
	private static void TestGetDestinosOrdenadosPorLongitud(VuelosB5 vuelos){
		SortedSet<String> res = vuelos.getDestinosOrdenadosPorLongitud();
		System.out.println("Los destinos ordenados son: ");
		for(String a:res) {
			System.out.println(a);
		}
	}
	
	private static void TestGetNumVuelosFecha(VuelosB5 vuelos, LocalDate fecha) {
		Integer res = vuelos.getNumVuelosFecha(fecha);
		System.out.println("El numero de vuelos en la fecha " + fecha + " es: " + res);
	}
	
	private static void TestGetPrecioMedioVuelosMes(VuelosB5 vuelos, Integer mes) {
		Double res = vuelos.getPrecioMedioVuelosMes(mes);
		System.out.println("El precio medio en el mes " + mes + " es: " + res);
	}
	
	private static void TestGetRecaudacion(VuelosB5 vuelos, Integer anyo) {
		Double res = vuelos.getRecaudacion(anyo);
		System.out.println("La recaudacion en el año " + anyo + " fue de " + res);
	}
	
	private static void TestGetVueloMasPasajeros(VuelosB5 vuelos){
		Vuelo res = vuelos.getVueloMasPasajeros();
		System.out.println("El vuelo con mas pasajeros fue " + res);
	}
	
	private static void TestGetVuelosPorFecha(VuelosB5 vuelos) {
		Map<LocalDate, List<Vuelo>> res = vuelos.getVuelosPorFecha();
		System.out.println(" Los vuelos por fecha son ");
		for(LocalDate a:res.keySet()) {
			System.out.println(a + "=" + res.get(a));
		}
	}
	
	private static void TestGetNumVuelosPorFecha(VuelosB5 vuelos) {
		Map<LocalDate, Long> res = vuelos.getNumVuelosPorFecha();
		System.out.println("El numero de vuelos por fecha es ");
		for(LocalDate a:res.keySet()) {
			System.out.println(a + "=" + res.get(a));
		}
	}
	
	private static void TestGetNumPlazasPorDestino(VuelosB5 vuelos) {
		Map<String, Integer> res = vuelos.getNumPlazasPorDestino();
		System.out.println(" El número de plazas por destino es ");
		for(String a:res.keySet()) {
			System.out.println(a + "=" + res.get(a));
		}
	}
	
	private static void TestGetPrecioMedioPorDestino(VuelosB5 vuelos) {
		Map<String, Double> res = vuelos.getPrecioMedioPorDestino();
		System.out.println(" El precio medio por destino es ");
		for(String a:res.keySet()) {
			System.out.println(a + "=" + res.get(a));
		}
	} 
	
	private static void TestGetFechasPorDestino(VuelosB5 vuelos) {
		Map<String, Set<LocalDate>> res = vuelos.getFechasPorDestino();
		System.out.println(" Las fechas por destino son:  ");
		for(String a:res.keySet()) {
			System.out.println(a + "=" + res.get(a));
		}
	}
	
	public static void main(String args[]) {
		List<Vuelo> lista = TestFactoriaVuelos("aeropuerto.csv");
		VuelosB5 vuelos = new VuelosB5("xd", lista);
		System.out.println("\n===testGetNumDestinosDiferentesFecha ==========");
		TestGetNumDestinosDiferentesFecha(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testGetVuelosOrdenados ==========");
		TestGetVuelosOrdenados(vuelos);
		System.out.println("\n===testGetDestinosOrdenados ==========");
		TestGetDestinosOrdenados(vuelos, 'B');
		System.out.println("\n===testGetDestinosOrdenadosPorLongitud ==========");
		TestGetDestinosOrdenadosPorLongitud(vuelos);
		System.out.println("\n===testGetNumVuelosFecha ==========");
		TestGetNumVuelosFecha(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testGetPrecioMedioVuelosMes ==========");
		TestGetPrecioMedioVuelosMes(vuelos, 6);
		System.out.println("\n===testGetRecaudacion ==========");
		TestGetRecaudacion(vuelos, 2023);
		System.out.println("\n===testGetVueloMasPasajeros ==========");
		TestGetVueloMasPasajeros(vuelos);
		System.out.println("\n===testGetVuelosPorFecha ==========");
		TestGetVuelosPorFecha(vuelos);
		System.out.println("\n===testGetNumVuelosPorFecha ==========");
		TestGetNumVuelosPorFecha(vuelos);
		System.out.println("\n===testGetNumPlazasPorDestino ==========");
		TestGetNumPlazasPorDestino(vuelos);
		System.out.println("\n===testGetPrecioMedioPorDestino ==========");
		TestGetPrecioMedioPorDestino(vuelos);
		System.out.println("\n===testGetFechasPorDestino ==========");
		TestGetFechasPorDestino(vuelos);
	}
}
