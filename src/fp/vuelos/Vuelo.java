package fp.vuelos;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.utiles.Checkers;
import fp.vuelos.Trayecto;
public class Vuelo implements Comparable<Vuelo>{
	private Trayecto trayecto;
	private Double precio;
	private Integer num_pasajeros;
	private Integer num_plazas;
	private String codigo;
	private LocalDate fecha;
	private Duration duracion;
	private List<String> tripulacion;
	
	private boolean comprobarCodigo(String codigo){
		if(codigo.length() != 6)
			return false;
		for(int i = 0; i <= 5; i++) {
			if(i == 0 || i == 1) {
				if(!(codigo.startsWith("PP") || codigo.startsWith("CP") || codigo.startsWith("AV")))
					return false;
			}else if(!(Character.isDigit(codigo.charAt(i))))
				return false;	
		}
		return true;
	}
	private boolean comprobarAuxiliares(List<String> tripulacion) {
		if(tripulacion.size() == 3)
			return true;
		List<String> res = tripulacion.subList(3, tripulacion.size() - 1);
		for(String t:res) {
			if(!(t.startsWith("AV")))
				return false;
		}
		return true;
	}
	
	public Vuelo(Trayecto trayecto, Double precio, Integer num_pasajeros, Integer num_plazas, String codigo,
			LocalDate fecha, Duration duracion, List<String> tripulacion) {
		super();
		Checkers.check("El numero de plazas debe ser mayor que cero", num_plazas>0);
		Checkers.check("El numero de pasajeros debe ser mayor que cero", num_pasajeros>0);
		Checkers.check("El precio debe ser mayor que cero", precio>0);
		Checkers.check("El numero de pasajeros debe ser menor o igual al numero de plazas", num_pasajeros <= num_plazas);
		Checkers.check("El numero de tripulantes debe ser mayor o igual que 3", tripulacion.size() >= 3);
		Checkers.check("Los codigos de la tripulación deben tener el formato correcto", 
				tripulacion.stream()
				.allMatch(x -> comprobarCodigo(x))
				);
		Checkers.check("A partir del 4º tripulante, todos deben ser auxiliares", comprobarAuxiliares(tripulacion));
		
		
		
		this.trayecto = trayecto;
		this.precio = precio;
		this.num_pasajeros = num_pasajeros;
		this.num_plazas = num_plazas;
		this.codigo = codigo;
		this.fecha = fecha;
		this.duracion = duracion;
		this.tripulacion = tripulacion;
	}
	public Trayecto getTrayecto() {
		return trayecto;
	}
	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getNumPasajeros() {
		return num_pasajeros;
	}
	public void setNumPasajeros(Integer num_pasajeros) {
		this.num_pasajeros = num_pasajeros;
	}
	public Integer getNumPlazas() {
		return num_plazas;
	}
	public void setNumPlazas(Integer num_plazas) {
		this.num_plazas = num_plazas;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Duration getDuracion() {
		return duracion;
	}
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	public List<String> getTripulacion() {
		return tripulacion;
	}
	public String getOrigen() {
		return trayecto.origen();
	}
	public String getDestino() {
		return trayecto.destino();
	}
	public Integer getDuracionMinutos() {
		return (int) duracion.toMinutes();
	}
	public boolean estaCompleto(){
		return num_plazas == num_pasajeros;
	}
	public Double getPorcentajeOcupacion() {
		return Double.valueOf(num_pasajeros)/Double.valueOf(num_plazas);
	}
	public void incrementaPrecioPorcentaje(Double porcentaje) {
		precio = precio*(1 + porcentaje);
	}
	
@Override
	public String toString() {
		return "Vuelo "+ "["+"Trayecto= "+ trayecto.toString() + ", " +"codigo=" +codigo + ", " +"fecha=" +  fecha + "]"; 
	}
@Override
	public int compareTo(Vuelo v) {
		int res = 0;
		if(!(this.fecha.equals(v.fecha)))
			res = this.fecha.compareTo(v.fecha);
		else if(!(this.codigo.equals(v.codigo)))
			res = this.codigo.compareTo(v.codigo);
		return res;
	}
@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(obj.getClass() != this.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if(this.fecha.equals(other.fecha) && this.codigo.equals(other.codigo))
			return true;
		else
			return false;
	}

}
