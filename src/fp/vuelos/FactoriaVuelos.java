package fp.vuelos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FactoriaVuelos {
//a
	private static Vuelo parseaVuelo(String datosVuelo) {
		String[] res = datosVuelo.split(";");
		if(res.length != 9)
			throw new IllegalArgumentException("No valido");
		Trayecto trayecto = new Trayecto(res[0].strip(), res[1].strip());
		Double precio = Double.valueOf(res[2].strip());
		Integer num_pasajeros = Integer.valueOf(res[3].strip());
		Integer num_plazas = Integer.valueOf(res[4].strip());
		LocalDate fecha = LocalDate.parse(res[6].strip(), DateTimeFormatter.ofPattern("d/M/y"));
		Duration duracion = Duration.ofMinutes(Integer.valueOf(res[7].strip()));
		List<String> tripulantes = new ArrayList<>();
		String[] array_tripulantes = res[8].split(",");
		for(String x:array_tripulantes) {
			tripulantes.add(x.strip());
		}
		Vuelo vuelo = new Vuelo(trayecto, precio, num_pasajeros, num_plazas,res[5].strip(), fecha, duracion,tripulantes);
		return vuelo;
	}
	
	public static List<Vuelo> leeVuelos(String nomfich){
		try {
			List<String> vuelos_string = Files.lines(Paths.get("./data/" + nomfich))
										.collect(Collectors.toList());
			return vuelos_string.subList(1, vuelos_string.size()).stream()
					.map(s->parseaVuelo(s))
					.collect(Collectors.toList());
		}
		catch(IOException e) {}
			System.out.print("Skill issue");
			return null;
	}

}
