package fp.vuelos.Test;

import java.util.List;
import java.util.Map;

import fp.vuelos.FactoriaVuelos;
import fp.vuelos.Vuelo;
import fp.vuelos.VuelosB3;

public class TestVuelosB3 {		
		
		private static List<Vuelo> TestFactoriaVuelos(String nomfich){
			List<Vuelo> res = FactoriaVuelos.leeVuelos(nomfich);
			System.out.println("Numero de vuelos leidos:" + res.size());
			System.out.println("Los primeros 3:" + res.subList(0, 3));
			System.out.println("Los ultimos 3:" +  res.subList(res.size() - 3, res.size()));
			return res;
		}
		private static void TestGetNumVuelosPorDestino(VuelosB3 vuelos){
			System.out.println(vuelos.getNumVuelosPorDestino());
		}
		private static void TestGetNumPasajerosPorFecha(VuelosB3 vuelos){
			System.out.println(vuelos.getNumPasajerosPorFecha());
		}
		private static void TestGetCodigosPorDestino(VuelosB3 vuelos) {
			System.out.println(vuelos.getCodigosPorDestino());
		}
		private static void TestGetFechasPorDestino(VuelosB3 vuelos) {
			System.out.println(vuelos.getFechasPorDestino());
		}
		private static void TestGetFechasOrdenadasParaDestino(VuelosB3 vuelos, String destino) {
			System.out.println(vuelos.getFechasOrdenadasParaDestino(destino));
		}
		private static void TestGetVuelosOrdPorFecha(VuelosB3 vuelos) {
			System.out.println(vuelos.getVuelosOrdPorFecha());
		}
		private static void TestGetConjOrdVuelosPorDestino(VuelosB3 vuelos) {
			System.out.println(vuelos.getConjOrdVuelosPorDestino());
		}
		private static void TestGetMapOrdNumVuelosPorDestino(VuelosB3 vuelos) {
			System.out.println(vuelos.getMapOrdNumVuelosPorDestino());

		}
		private static void TestGetDestinoMasVuelos(VuelosB3 vuelos) {
			System.out.println(vuelos.getDestinoMasVuelos());
		}
		private static void TestGetFechaMenosPasajeros(VuelosB3 vuelos) {
			System.out.println(vuelos.getFechaMenosPasajeros());
		}
		private static void TestGetMapPrimerVueloPlazasLibresPorDestino(VuelosB3 vuelos) {
			System.out.println(vuelos.getMapPrimerVueloPlazasLibresPorDestino());
		}
		
		public static void main(String args[]) {
			List<Vuelo> lista = TestFactoriaVuelos("aeropuerto.csv");
			VuelosB3 vuelos = new VuelosB3("xd", lista);
			System.out.println("\n=== testGetNumVuelosPorDestino ===");
			TestGetNumVuelosPorDestino(vuelos);
			System.out.println("\n=== testGetNumPasajerosPorFecha ===");
			TestGetNumPasajerosPorFecha(vuelos);
			System.out.println("\n=== testGetCodigosPorDestino ===");
			TestGetCodigosPorDestino(vuelos);
			System.out.println("\n=== testGetFechasPorDestino ===");
			TestGetFechasPorDestino(vuelos);
			System.out.println("\n=== testGetFechasOrdenadasParaDestino ===");
			TestGetFechasOrdenadasParaDestino(vuelos, "Madrid");
			System.out.println("\n=== testGetVuelosOrdPorFecha ===");
			TestGetVuelosOrdPorFecha(vuelos);
			System.out.println("\n=== testGetConjOrdVuelosPorDestino ===");
			TestGetConjOrdVuelosPorDestino(vuelos);
			System.out.println("\n=== testGetMapOrdNumVuelosPorDestino ===");
			TestGetMapOrdNumVuelosPorDestino(vuelos);
			System.out.println("\n=== testGetDestinoMasVuelos ===");
			TestGetDestinoMasVuelos(vuelos);
			System.out.println("\n=== testGetFechaMenosPasajeros ===");
			TestGetFechaMenosPasajeros(vuelos);
			System.out.println("\n=== testGetMapPrimerVueloPlazasLibresPorDestino ===");
			TestGetMapPrimerVueloPlazasLibresPorDestino(vuelos);
		}
}
