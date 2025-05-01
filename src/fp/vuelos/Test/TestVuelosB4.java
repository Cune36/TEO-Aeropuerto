package fp.vuelos.Test;

import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import fp.vuelos.FactoriaVuelos;
import fp.vuelos.Vuelo;
import fp.vuelos.VuelosB4;

public class TestVuelosB4 {
	private static List<Vuelo> TestFactoriaVuelos(String nomfich){
		List<Vuelo> res = FactoriaVuelos.leeVuelos(nomfich);
		System.out.println("Numero de vuelos leidos:" + res.size());
		System.out.println("Los primeros 3:" + res.subList(0, 3));
		System.out.println("Los ultimos 3:" +  res.subList(res.size() - 3, res.size()));
		return res;
	}
	private static void TestExisteVueloDestino(VuelosB4 vuelos, String destino) {
		System.out.println("Existe algun vuelo libre con destino " + destino + "?: " + vuelos.existeVueloDestino(destino));
	}
	private static void TestTodosVuelosAlMenosNPasajeros(VuelosB4 vuelos, Integer n) {
		System.out.println("¿Tienen todos al menos " + n + " pasajeros?: " + vuelos.TodosVuelosAlMenosNPasajeros(n));
	}
	private static void TestGetNumVuelosFecha(VuelosB4 vuelos, LocalDate fecha) {
		System.out.println("Hay " + vuelos.getNumVuelosFecha(fecha) + " vuelos en la fecha " + fecha);
	}
	private static void TestGetVuelosPosteriores(VuelosB4 vuelos, LocalDate fecha) {
		System.out.println("Los vuelos posteriores a "+ fecha + " son: ");
		List<Vuelo> res = vuelos.getVuelosPosteriores(fecha);
		for(Vuelo v:res) {
			System.out.println(v);
		}
	}
	private static void TestGetDestinoDeVuelosAnteriores(VuelosB4 vuelos, LocalDate fecha) {
		System.out.println("Los vuelos anteriores a "+ fecha + " son: ");
		Set<String> res = vuelos.getDestinoDeVuelosAnteriores(fecha);
		for(String v:res) {
			System.out.println(v);
		}
	}
	private static void TestGetNumPasajerosConDestinos(VuelosB4 vuelos,List<String> destinos) {
		System.out.println("Hay " + vuelos.getNumPasajerosConDestinos(destinos) + " para los destinos " + destinos);
	}
	private static void TestGetPrecioMedioVuelosMes(VuelosB4 vuelos, Integer mes) {
		System.out.println("El precio medio de los vuelos en el mes " + mes + " es " + vuelos.getPrecioMedioVuelosMes(mes));
	}
	private static void TestGetRecaudacionPorAno(VuelosB4 vuelos, Integer ano) {
		System.out.println("La recaudación de los vuelos en el año " + ano + " es " + vuelos.getRecaudacionPorAno(ano));
	}
	private static void TestGetVueloMasPasajeros(VuelosB4 vuelos) {
		System.out.println("El vuelo con más pasajeros es " + vuelos.getVueloMasPasajeros());
	}
	private static void TestGetCodigoVueloMenorPrecioConDestino(VuelosB4 vuelos, String destino) {
		System.out.println("El vuelo con menor precio a " + destino + " es " + vuelos.getCodigoVueloMenorPrecioConDestino(destino));
	}
	private static void TestGetNVuelosMasBaratos(VuelosB4 vuelos, Integer n) {
		System.out.println("Los " + n + "vuelos más baratos son:");
		List<Vuelo> res = vuelos.getNVuelosMasBaratos(n);
		for(Vuelo v:res) {
			System.out.println(v);
		}
	}
	private static void TestGetNVuelosMasDuracion(VuelosB4 vuelos, Integer n) {
		System.out.println("Los " + n + "vuelos con mayor duración son:");
		List<Vuelo> res = vuelos.getNVuelosMasDuracion(n);
		for(Vuelo v:res) {
			System.out.println(v);
		}
	}
	
	public static void main(String args[]) {
		List<Vuelo> lista = TestFactoriaVuelos("aeropuerto.csv");
		VuelosB4 vuelos = new VuelosB4("xd", lista);
		System.out.println("\n===testExisteVueloDestino ==========");
		TestExisteVueloDestino(vuelos, "Madrid");
		TestExisteVueloDestino(vuelos, "Sevilla");
		System.out.println("\n===testTodosVuelosAlMenosNPasajeros ==========");
		TestTodosVuelosAlMenosNPasajeros(vuelos, 100);
		TestTodosVuelosAlMenosNPasajeros(vuelos, 1000);
		System.out.println("\n===testGetNumVuelosFecha ==========");
		TestGetNumVuelosFecha(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testGetVuelosPosteriores ==========");
		TestGetVuelosPosteriores(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testGetVuelosAnteriores ==========");
		TestGetDestinoDeVuelosAnteriores(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testGetNumPasajerosConDestinos ==========");
		List<String> res = new ArrayList<>();
		res.add("Madrid");
		res.add("Barcelona");
		TestGetNumPasajerosConDestinos(vuelos, res);
		System.out.println("\n===testGetPrecioMedioVuelosMes ==========");
		TestGetPrecioMedioVuelosMes(vuelos, 6);
		System.out.println("\n===testGetRecaudacionPorAno ==========");
		TestGetRecaudacionPorAno(vuelos, 2023);
		System.out.println("\n===testGetVueloMasPasajeros ==========");
		TestGetVueloMasPasajeros(vuelos);
		System.out.println("\n===testGetCodigoVueloMenorPrecioConDestino ==========");
		TestGetCodigoVueloMenorPrecioConDestino(vuelos, "Madrid");
		try{
			TestGetCodigoVueloMenorPrecioConDestino(vuelos, "dgfgfg");
		}catch(NoSuchElementException e) {
			System.out.println(e);
		}
		System.out.println("\n===testGetNVuelosMasBaratos ==========");
		TestGetNVuelosMasBaratos(vuelos, 5);
		System.out.println("\n===testGetNVuelosMasDuracion ==========");
		TestGetNVuelosMasDuracion(vuelos, 5);
	}
}
