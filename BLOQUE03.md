# Fundamentos de Programación
# Ejercicio de teoría: Vuelos - Bloque 03 - SortedSet, Map y SortedMap

**Autor:** José C. Riquelme 
**Revisores:**  Toñi Reina, Mariano González. 
**Última modificación:** 03/04/2025.


# **1 Objetivos**

El objetivo de este bloque es trabajar con tratamientos secuenciales con `SortedSet`, ``Map`` y ``SortedMap``.


## EJERCICIOS

En el tipo contenedor **VuelosB3* añada las siguientes operaciones e impleméntelas exclusivamente con bucles. Tenga en cuenta que el tipo **VuelosB3** tiene exactamente las mismas propiedades y operaciones que **Vuelos**, y añade las siguientes. Reutilice mediante herencia **Vuelos**. 

1.	Devuelve un `Map` que asigne a cada destino el número de vuelos.

2.	Devuelve un `Map` que asigne a cada fecha el número de pasajeros.

3.	Devuelve un `Map` que asigne a cada destino una lista con los códigos de los vuelos a ese destino.

4.	Devuelve un `Map` que asigne a cada destino un conjunto con las fechas de vuelos a ese destino con plazas libres.

5.	Dado un destino devuelve un SortedSet con las fechas de los vuelos a ese destino.

6.	Devuelve un SortedSet con todos los vuelos ordenados por fecha. 

7.	Devuelve un SortedSet con todos los vuelos ordenados por orden alfabético de destino.

8.	Reescribe los métodos 1-4 para que devuelvan un `SortedMap`.

9.	Devuelve un `SortedMap` de forma que las claves sean los destinos ordenados por número de caracteres y los valores el número de vuelos a ese destino.

10.	Implemente un método que devuelva cuál es el destino con más vuelos.

11.	Implemente un método que devuelva cuál es el día con menos pasajeros.

12.	Implemente un método que devuelva un `Map` que asigne a cada destino el primer vuelo que tenga plazas libres.


Los resultados esperados para el dataset proporcionado son:

```

=== testGetNumVuelosPorDestino ===
{New York=1, Munich=1, Frankfurt=1, Milan=1, Rome=1, Barcelona=2, Amsterdam=1, Madrid=13, London=2, Valencia=2, Paris=2}

=== testGetNumPasajerosPorFecha ===
{2023-06-13=160, 2023-06-12=180, 2023-06-11=220, 2023-06-10=180, 2023-06-09=117, 2023-06-08=105, 2023-06-07=78, 2023-06-06=68, 2023-06-05=100, 2023-06-04=132, 2023-06-03=150, 2023-06-02=170, 2023-06-01=310}

=== testGetCodigosPorDestino ===
{New York=[AA700], Munich=[EW900], Frankfurt=[LH600], Milan=[AZ800], Rome=[VY1000], Barcelona=[IB100, IB100], Amsterdam=[KL500], Madrid=[IB101, RY201, AF301, BA401, KL501, LH601, AA701, AZ801, EW901, VY1001, IB101, RY201, KL301], London=[BA400, BA400], Valencia=[RY200, RY200], Paris=[AF300, KL300]}

=== testGetFechasPorDestino ===
{New York=[2023-06-06], Munich=[2023-06-08], Frankfurt=[2023-06-05], Milan=[2023-06-07], Rome=[2023-06-09], Barcelona=[2023-06-10, 2023-06-01], Madrid=[2023-06-12, 2023-06-10, 2023-06-09, 2023-06-08, 2023-06-07, 2023-06-06, 2023-06-05, 2023-06-04, 2023-06-03, 2023-06-02, 2023-06-01], London=[2023-06-13, 2023-06-03], Paris=[2023-06-12, 2023-06-02]}

=== testGetFechasOrdenadasParaDestino ===
[2023-06-01, 2023-06-02, 2023-06-03, 2023-06-04, 2023-06-05, 2023-06-06, 2023-06-07, 2023-06-08, 2023-06-09, 2023-06-10, 2023-06-11, 2023-06-12, 2023-06-13]

=== testGetVuelosOrdPorFecha ===
[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Valencia], codigo=RY200, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02], Vuelo [Trayecto=Trayecto[origen=Valencia, destino=Madrid], codigo=RY201, fecha=2023-06-02], Vuelo [Trayecto=Trayecto[origen=Paris, destino=Madrid], codigo=AF301, fecha=2023-06-03], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-03], Vuelo [Trayecto=Trayecto[origen=London, destino=Madrid], codigo=BA401, fecha=2023-06-04], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Amsterdam], codigo=KL500, fecha=2023-06-04], Vuelo [Trayecto=Trayecto[origen=Amsterdam, destino=Madrid], codigo=KL501, fecha=2023-06-05], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Frankfurt], codigo=LH600, fecha=2023-06-05], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=New York], codigo=AA700, fecha=2023-06-06], Vuelo [Trayecto=Trayecto[origen=Frankfurt, destino=Madrid], codigo=LH601, fecha=2023-06-06], Vuelo [Trayecto=Trayecto[origen=New York, destino=Madrid], codigo=AA701, fecha=2023-06-07], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Milan], codigo=AZ800, fecha=2023-06-07], Vuelo [Trayecto=Trayecto[origen=Milan, destino=Madrid], codigo=AZ801, fecha=2023-06-08], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Munich], codigo=EW900, fecha=2023-06-08], Vuelo [Trayecto=Trayecto[origen=Munich, destino=Madrid], codigo=EW901, fecha=2023-06-09], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Rome], codigo=VY1000, fecha=2023-06-09], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-10], Vuelo [Trayecto=Trayecto[origen=Rome, destino=Madrid], codigo=VY1001, fecha=2023-06-10], Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-11], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Valencia], codigo=RY200, fecha=2023-06-11], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=KL300, fecha=2023-06-12], Vuelo [Trayecto=Trayecto[origen=Valencia, destino=Madrid], codigo=RY201, fecha=2023-06-12], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-13], Vuelo [Trayecto=Trayecto[origen=Paris, destino=Madrid], codigo=KL301, fecha=2023-06-13]]

=== testGetConjOrdVuelosPorDestino ===
[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Amsterdam], codigo=KL500, fecha=2023-06-04], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-10], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Frankfurt], codigo=LH600, fecha=2023-06-05], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-03], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-13], Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Valencia, destino=Madrid], codigo=RY201, fecha=2023-06-02], Vuelo [Trayecto=Trayecto[origen=Paris, destino=Madrid], codigo=AF301, fecha=2023-06-03], Vuelo [Trayecto=Trayecto[origen=London, destino=Madrid], codigo=BA401, fecha=2023-06-04], Vuelo [Trayecto=Trayecto[origen=Amsterdam, destino=Madrid], codigo=KL501, fecha=2023-06-05], Vuelo [Trayecto=Trayecto[origen=Frankfurt, destino=Madrid], codigo=LH601, fecha=2023-06-06], Vuelo [Trayecto=Trayecto[origen=New York, destino=Madrid], codigo=AA701, fecha=2023-06-07], Vuelo [Trayecto=Trayecto[origen=Milan, destino=Madrid], codigo=AZ801, fecha=2023-06-08], Vuelo [Trayecto=Trayecto[origen=Munich, destino=Madrid], codigo=EW901, fecha=2023-06-09], Vuelo [Trayecto=Trayecto[origen=Rome, destino=Madrid], codigo=VY1001, fecha=2023-06-10], Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-11], Vuelo [Trayecto=Trayecto[origen=Valencia, destino=Madrid], codigo=RY201, fecha=2023-06-12], Vuelo [Trayecto=Trayecto[origen=Paris, destino=Madrid], codigo=KL301, fecha=2023-06-13], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Milan], codigo=AZ800, fecha=2023-06-07], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Munich], codigo=EW900, fecha=2023-06-08], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=New York], codigo=AA700, fecha=2023-06-06], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=KL300, fecha=2023-06-12], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Rome], codigo=VY1000, fecha=2023-06-09], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Valencia], codigo=RY200, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Valencia], codigo=RY200, fecha=2023-06-11]]

=== testGetMapOrdNumVuelosPorDestino ===
{Amsterdam=1, Barcelona=2, Frankfurt=1, London=2, Madrid=13, Milan=1, Munich=1, New York=1, Paris=2, Rome=1, Valencia=2}

=== testGetMapOrdLongitudNumVuelosPorDestino ===
{Rome=1, Milan=1, Paris=2, London=2, Madrid=13, Munich=1, New York=1, Valencia=2, Amsterdam=1, Barcelona=2, Frankfurt=1}

=== testGetDestinoMasVuelos ===
Madrid

=== testGetFechaMenosPasajeros ===
2023-06-06

=== testGetMapListaVuelosLibresPorDestino ===
{New York=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=New York], codigo=AA700, fecha=2023-06-06]], Munich=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Munich], codigo=EW900, fecha=2023-06-08]], Frankfurt=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Frankfurt], codigo=LH600, fecha=2023-06-05]], Milan=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Milan], codigo=AZ800, fecha=2023-06-07]], Rome=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Rome], codigo=VY1000, fecha=2023-06-09]], Barcelona=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-10]], Madrid=[Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-01], Vuelo [Trayecto=Trayecto[origen=Valencia, destino=Madrid], codigo=RY201, fecha=2023-06-02], Vuelo [Trayecto=Trayecto[origen=Paris, destino=Madrid], codigo=AF301, fecha=2023-06-03], Vuelo [Trayecto=Trayecto[origen=London, destino=Madrid], codigo=BA401, fecha=2023-06-04], Vuelo [Trayecto=Trayecto[origen=Amsterdam, destino=Madrid], codigo=KL501, fecha=2023-06-05], Vuelo [Trayecto=Trayecto[origen=Frankfurt, destino=Madrid], codigo=LH601, fecha=2023-06-06], Vuelo [Trayecto=Trayecto[origen=New York, destino=Madrid], codigo=AA701, fecha=2023-06-07], Vuelo [Trayecto=Trayecto[origen=Milan, destino=Madrid], codigo=AZ801, fecha=2023-06-08], Vuelo [Trayecto=Trayecto[origen=Munich, destino=Madrid], codigo=EW901, fecha=2023-06-09], Vuelo [Trayecto=Trayecto[origen=Rome, destino=Madrid], codigo=VY1001, fecha=2023-06-10], Vuelo [Trayecto=Trayecto[origen=Valencia, destino=Madrid], codigo=RY201, fecha=2023-06-12]], London=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-03], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-13]], Paris=[Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02], Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=KL300, fecha=2023-06-12]]}

=== testGetMapPrimerVueloPlazasLibresPorDestino ===
{New York=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=New York], codigo=AA700, fecha=2023-06-06], Munich=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Munich], codigo=EW900, fecha=2023-06-08], Frankfurt=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Frankfurt], codigo=LH600, fecha=2023-06-05], Milan=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Milan], codigo=AZ800, fecha=2023-06-07], Rome=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Rome], codigo=VY1000, fecha=2023-06-09], Barcelona=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Barcelona], codigo=IB100, fecha=2023-06-01], Madrid=Vuelo [Trayecto=Trayecto[origen=Barcelona, destino=Madrid], codigo=IB101, fecha=2023-06-01], London=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=London], codigo=BA400, fecha=2023-06-03], Paris=Vuelo [Trayecto=Trayecto[origen=Madrid, destino=Paris], codigo=AF300, fecha=2023-06-02]}

```
