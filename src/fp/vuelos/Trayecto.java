package fp.vuelos;
import fp.utiles.*;

public record Trayecto(String origen, String destino) {
	public Trayecto{
		Checkers.check("El origen y el destino no pueden ser iguales", !(origen.equals(destino)));
	}
@Override
	public boolean equals(Object obj) {
	if(obj == null)
		return false;
	if(this == obj)
		return true;
	if(obj.getClass() != this.getClass())
		return false;
	Trayecto other = (Trayecto) obj;
	if(this.origen.equals(other.origen) && this.destino.equals(other.destino))
		return true;
	else
		return false;
	}
}
