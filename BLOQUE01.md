# Fundamentos de Programación
# Ejercicio de teoría: Vuelos - Bloque 01 - Tipo contenedor

**Autor:** José C. Riquelme 
**Revisores:**  Toñi Reina, Mariano González. 
**Última modificación:** 03/04/2025.

# **1 Objetivos**

El objetivo de este bloque es trabajar un tipo contenedor simple.


## EJERCICIOS


En este segundo bloque se define el tipo contenedor **Vuelos**, que representa una entidad que gestiona vuelos como AENA y la factoría **FactoriaVuelos** con la siguiente descripción:

### Vuelos

**Propiedades:**

- **nombre:** de tipo *String* con el nombre del la entidad gestora. Consultable.
- **vuelos** de tipo *List\<Vuelo\>*, con los vuelos del contendor. Consultable. 
- **numero vuelos:** de tipo *Integer* con el número de vuelos. Consultable.
- **numero pasajeros:** de tipo *Integer* con el número total de pasajeros de todos los vuelos. Consultable.
- **precio medio:** de tipo *Double* con el precio medio de todos los vuelos. Consultable.
- **numero destinos** de tipo *Integer* con el número de destinos diferentes. Consultable.

**Constructor:**

- **C1**: Crea un objeto tomando como parámetros las propiedades básicas del mismo, en el orden en el que se describen arriba.

**Representación como cadena:**

- Una cadena formada por la representación como cadena de todos los vuelos, separados unos de otros por un salto de línea.

**Criterio de igualdad:**

- Dos objetos de tipo **Vuelos** son iguales si lo son su código y la lista de vuelos.

**Otras operaciones:**

- `Integer getNumPasajerosDestino(String destino)`: Dado un destino devuelve el número de pasajeros a ese destino.
- `void incorporaVuelo(Vuelo v)`: Dado un vuelo *v*, lo incorpora a los vuelos del contenedor.
- `void incorporaVuelos(Collection<Vuelo> vuelos)`: Dada una colección de vuelos, incorpora los vuelos de la colección al contenedor.
- `void eliminaVuelo(Vuelo v)`: Dado un vuelo *v*, lo elimina del contenedor. Si no existe, no hace nada.
- `void ordena()`: Ordena los vuelos del contenedor por su orden natural.
- `Boolean existeVueloDestino(String destino)`: Dado un destino, devuelve cierto si en el contenedor hay algún vuelo a ese destino. 


### FactoriaVuelos

**Operaciones:**

- `List<Vuelo> leeVuelos(String nomfich)`: Dado un archivo con datos de vuelos y devuelve una lista de vuelos a partir de los datos del archivo. 

- `Vuelo parseaVuelo(String datosVuelo)`: Dada una cadena de caracteres con el formato que se indica a continuación, devuelve un objeto de tipo *Vuelo* creado a partir de esa cadena. El formato esperado es el siguiente:

`Madrid;Barcelona;55.75;98;140;IB100;01/06/2023;75;PP0003,CP0004,AV0015,AV0006,AV0007`

En él se puede ver que el origen del vuelo es Madrid; el destino, Barcelona; el precio, 55.75 Euros; el vuelo tuvo 98 pasajeros, de las 140 plazas disponibles; el código del vuelo fue el IB100; la fecha del mismo el 01/06/2023; la duración de 75 minutos; y tuvo 5 tripulantes, un piloto (PP0003), un copiloto (CP0004) y tres asistentes (AV0015,AV0006 y AV0007).

Para implementar este método cree tres funciones auxiliares:

1. `parseaTripulacion`: Dada una cadena con tripulantes separadados por coma, devuelva una lista de cadenas con cada uno de los tripultales.

2. `parseaFecha`: Dada una cadena de caracteres, con el formato dia/mes/año devuelva un objeto de tipo *LocalDate*.

3. `parseaDuracion`: Dada una cadena de caracteres que representa los minutos de duración, devuelva un obejto de tipo Duration.

### Tests

Cree las clases `TestVuelos` y `TestFactoriaVuelos` para probar respectivamente las dos clases implementadas anteriormente. Defina un método de test por cada método a probar.
