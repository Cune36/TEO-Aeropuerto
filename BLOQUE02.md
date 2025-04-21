# Fundamentos de Programación
# Ejercicio de teoría: Vuelos - Bloque 02 - Tratamientos secuenciales con bucles

**Autor:** José C. Riquelme 
**Revisores:**  Toñi Reina, Mariano González. 
**Última modificación:** 03/04/2025.


# **1 Objetivos**

El objetivo de este bloque es trabajar con tratamientos secuenciales con bucles.


## EJERCICIOS

En el tipo contenedor **VuelosB2** añada las siguientes operaciones e impleméntelas exclusivamente con bucles. Tenga en cuenta que el tipo **VuelosB2** tiene exactamente las mismas propiedades y operaciones que **Vuelos**, y añada las siguientes. Reutilice mediante herencia **Vuelos**. 


1.	Dada una cadena de caracteres con un destino devuelve el número total de pasajeros a ese destino

2.	Dada una cadena de caracteres s devuelve el número total de pasajeros de los destinos que tienen como prefijo s (esto es, comienzan por s).

3.	Dado un destino devuelve la recaudación de los vuelos a ese destino.

4.	Dado un destino devuelve el vuelo a ese destino con menor fecha.

5.	Dado un destino devuelve el vuelo a ese vuelo a ese destino  con menor fecha y de menor precio.

6.	Dado un destino devuelve el código del pvuelo a ese destino con mejor fecha y con plazas libres.

7.	Dada una fecha f devuelve el conjunto de destinos diferentes de todos los vuelos de fecha f.

8.	Dado un precio, ¿existe algún vuelo por debajo de ese precio?

9.	Dado un porcentaje de ocupación ¿Están todos los vuelos por encima de ese porcentaje?

10.	¿Cuál es el vuelo con menor ocupación?

11.	Dado un destino ¿Cuál es el vuelo más barato a ese destino?

12.	Dada una fecha f devuelve el precio medio de los vuelos con salida posterior a f. Si no hubiera vuelos devuelve 0.0

13.	Dado un destino, devuelve una lista con los vuelos a ese destino ordenados por precio (ascendentemente).

Los resultados esperados para el dataset proporcionado son:

```
===testGetNumPasajerosDestino ===
	Pasajeros con destino Madrid: 992

===testGetNumPasajerosDestinoPrefijo ===
	Pasajeros con destino que empieza por Barcelona: 198

===testGetRecaudacionDestino ===
	Recaudación de los vuelos a Barcelona: 11038.5

===testGetPrimerVueloDestino ===
	Primer vuelo a Paris: Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02]

===testGetPrimerVueloDestinoMenorPrecio ===
	Primer vuelo a Madrid con menor precio: Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-01]

===testGetPrimerVueloDestinoPlazasLibres ===
	Primer vuelo a Madrid con plazas libres: Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-01]

===testGetConjuntoDestinosFecha ===
	Destinos con vuelos en la fecha 2023-06-04: [Amsterdam, Madrid]

===testExisteVueloPrecioMenor ===
	¿Existe vuelo con precio menor a 50.0? true

===testEstanTodosPorcentajeMayor ===
	¿Todos los vuelos tienen ocupación mayor a 75.0%? false

===testGetVueloMenorOcupacion ===
	Vuelo con menor ocupación: Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-01]

===testGetVueloMasBaratoDestino ===
	Vuelo más barato a Paris: Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02]

===testGetPrecioMedioVuelosPosteriores ===
	Precio medio de los vuelos posteriores a 2023-06-04: 120.75

===testGetListaOrdenadaPorPrecioDestino ===
	Lista de vuelos a Paris ordenados por precio: 
		Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02]
		Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=KL300, fecha=2023-06-12]

```
