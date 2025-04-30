package fp.vuelos.Test;

import java.time.LocalDate;
import java.util.List;

import fp.vuelos.FactoriaVuelos;
import fp.vuelos.Vuelo;
import fp.vuelos.VuelosB2;

public class TestVuelosB2 {
	
	private static void TestGetNumPasajerosDestino(VuelosB2 vuelos,String destino) {
		System.out.println("Pasajeros con destino" + destino + ": " + vuelos.getNumPasajerosDestino(destino));
	}
	
	private static List<Vuelo> TestFactoriaVuelos(String nomfich){
		List<Vuelo> res = FactoriaVuelos.leeVuelos(nomfich);
		System.out.println("Numero de vuelos leidos:" + res.size());
		System.out.println("Los primeros 3:" + res.subList(0, 3));
		System.out.println("Los ultimos 3:" +  res.subList(res.size() - 3, res.size()));
		return res;
	}
	
	private static void testGetNumPasajerosDestinoPrefijo(VuelosB2 vuelos, String chars) {
		System.out.println("Numero de pasajeros con destino que comienza por "+chars + ": " + vuelos.getNumPasajerosDestinoPrefijo(chars));
	}
	private static void testGetRecaudacionDestino(VuelosB2 vuelos, String destino) {
		System.out.println("Recaudación de los vuelos a " + destino + ": " + vuelos.getRecaudacionDestino(destino));
	}
	private static void testGetPrimerVueloDestino(VuelosB2 vuelos, String destino) {
		System.out.println("Primer vuelo a " + "destino" + ": " + vuelos.getPrimerVueloDestino(destino));
	}
	private static void testGetPrimerVueloDestinoMenorPrecio(VuelosB2 vuelos, String destino) {
		System.out.println("Primer vuelo a " + destino + " con menor precio: " + vuelos.getPrimerVueloDestino(destino));
	}
	private static void testGetPrimerVueloDestinoPlazasLibres(VuelosB2 vuelos, String destino) {
		System.out.println("Primer vuelo a " + destino + "con plazas libres: " + vuelos.getPrimerVueloDestinoPlazasLibres(destino));
	}
	private static void testGetConjuntoDestinosFecha(VuelosB2 vuelos, LocalDate fecha) {
		System.out.println("Destinos con vuelos en la fecha " + fecha.toString() + ": " + vuelos.getConjuntoDestinosFecha(fecha));
	}
	private static void testExisteVueloPrecioMenor(VuelosB2 vuelos, Double precio) {
		System.out.println("Existe vuelo con precio menor a " + precio +": " + vuelos.existeVueloPrecioMenor(precio));
	}
	private static void testEstanTodosPorcentajeMayor(VuelosB2 vuelos, Double porcentaje) {
		System.out.println("¿Todos los vuelos tienen ocupación mayor a " + porcentaje + "? " + vuelos.estanTodosPorcentajeMayor(porcentaje));
	}
	private static void testGetVueloMenorOcupacion(VuelosB2 vuelos) {
		System.out.println("Vuelo con menor ocupación: " + vuelos.getVueloMenorOcupacion());
	}
	private static void testGetVueloMasBaratoDestino(VuelosB2 vuelos, String destino) {
		System.out.println("Vuelo más barato a " + destino + ": " + vuelos.getVueloMasBaratoDestino(destino));
	}
	private static void testGetPrecioMedioVuelosPosteriores(VuelosB2 vuelos, LocalDate fecha) {
		System.out.println("Precio medio de los vuelos posteriores a " + fecha.toString() + ": " + vuelos.getPrecioMedioVuelosPosteriores(fecha));
	}
	private static void testGetListaOrdenadaPorPrecioDestino(VuelosB2 vuelos, String destino) {
		System.out.println("Lista de vuelos a "+ destino +" ordenados por precio:");
		List<Vuelo> res = vuelos.getListaOrdenadaPorPrecioDestino(destino);
		for(Vuelo v:res) {
			System.out.println(v);
		}
	}
	
	
	
	public static void main(String[] args) {
		List<Vuelo> res = TestFactoriaVuelos("aeropuerto.csv");
		VuelosB2 vuelos = new VuelosB2("aeropuerto", res);
		System.out.println("\n===testGetNumPasajerosDestino ===");
		TestGetNumPasajerosDestino(vuelos,"Madrid");
		System.out.println("\n===testGetNumPasajerosDestinoPrefijo ===");
		testGetNumPasajerosDestinoPrefijo(vuelos, "Barcelona");
		System.out.println("\n===testGetRecaudacionDestino ===");
		testGetRecaudacionDestino(vuelos, "Barcelona");
		System.out.println("\n===testGetPrimerVueloDestino ===");
		testGetPrimerVueloDestino(vuelos, "Paris");
		System.out.println("\n===testGetPrimerVueloDestinoMenorPrecio ===");
		testGetPrimerVueloDestino(vuelos, "Madrid");
		System.out.println("\n===testGetPrimerVueloDestinoPlazasLibres ===");
		testGetPrimerVueloDestinoPlazasLibres(vuelos, "Madrid");
		System.out.println("\n===testGetConjuntoDestinosFecha ===");
		testGetConjuntoDestinosFecha(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testExisteVueloPrecioMenor ===");
		testExisteVueloPrecioMenor(vuelos, 50.0);
		System.out.println("\n===testEstanTodosPorcentajeMayor ===");
		testEstanTodosPorcentajeMayor(vuelos, 75.0);
		System.out.println("\n===testGetVueloMenorOcupacion ===");
		testGetVueloMenorOcupacion(vuelos);
		System.out.println("\n===testGetVueloMasBaratoDestino ===");
		testGetVueloMasBaratoDestino(vuelos, "Paris");
		System.out.println("\n===testGetPrecioMedioVuelosPosteriores ===");
		testGetPrecioMedioVuelosPosteriores(vuelos, LocalDate.of(2023, 06, 04));
		System.out.println("\n===testGetListaOrdenadaPorPrecioDestino ===");
		testGetListaOrdenadaPorPrecioDestino(vuelos, "Paris");
		
	}

}
