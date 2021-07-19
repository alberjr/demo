## Documentacion Api Rest demoMeli Mutant

**FECHA CREACION**: 17/05/2016

**AUTOR (ES) CREACION**
Alber de Jesus Barros Miranda

## 1. Objetivo

El propósito de este documento es presentar la forma  de usar correctamente  la funcionalidad que se está desarrollando incluyendo la forma de interactuar con el sistema, su ingreso, las operaciones básicas prerrequisitos de uso. Sólo existirá un manual de usuario por funcionalidad, es decir en el caso de que varias iniciativas modifiquen la funcionalidad del sistema, se debe actualizar este documento.

## 2. Módulo MutantREST

### 2.1 Definiciones, acrónimos y abreviaciones 

No aplica
### 2.2 Referencias  

No aplica

### 2.3 Procedimiento

Se debe enviar un mensaje con estructura JSON al endpoint indicado en cada Funcionalidad, se retorna un mensaje con estructura JSON, los campos se muestra si el valor del campo es diferente de nulo.

#### 2.3.1 Descripción estructuras de objetos de entrada y salida

##### Tipo Stats

Estructura retornada que contiene los datos de las estadisticas de mutantes y humanos

**Nombre campo -- Tipo Campo -- Descripción**

countMutantDna -- Long -- Numero de Mutantes

countHumanDna -- Long -- Numero de Humanos

ratio         -- Double -- Division countMutantDna/countHumanDna

**Ejemplo de JSON**

    {
        "countMutantDna": 1,
        "countHumanDna": 2,
        "ratio": 0.5,

    }


##### Tipo DnaRequest

Estructura para hacer peticion ingresando el vector de Dna

**Nombre campo -- Tipo Campo -- Descripción**

dna -- String [] -- Dna

**Ejemplo de JSON**

    {
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }


##### Valores campo codigo
    
Valores de estado HTTP que se manejarán

**Valor codigo-----Descripción del valor retornado**

200----Ok

403----Forbidden

500----Error de ejecución

#### 2.3.2 Funcionalidad isMutant

##### Configuración para invocación

    Método
        POST
    Content-Type
        application/json
    Charset
        UTF-8
    Endpoint
        <protocolo>://<servidor_despliegue>:<puerto>/demo/mutant/

        En Local:
            http://localhost:5000/demo/mutant/
        En AWS:
            http://demomeli-env.eba-peugzzp7.us-east-1.elasticbeanstalk.com/demo/mutant/

##### Datos entrada
Se debe enviar en estructura JSON un mensaje con los siguientes campos:
**Nombre campo -- Tipo Campo -- Descripción**

dna          -- String [] -- Dna

**Ejemplo:**
    {
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
    }

##### Datos salida
En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden. En caso de error se retorna un HTTP 500- Internal Server Error


#### 2.3.3 Funcionalidad stats

##### Configuración para invocación

    Método
        GET
    Content-Type
        application/json
    Charset
        UTF-8
    Endpoint
        <protocolo>://<servidor_despliegue>:<puerto>/demo/stats/

        En Local:
            http://localhost:5000/demo/stats/
        En AWS:
            http://demomeli-env.eba-peugzzp7.us-east-1.elasticbeanstalk.com/demo/stats/

##### Datos entrada
Se debe enviar en estructura JSON vacio

##### Datos salida
En caso satisfactorio retorna salida tipo stats. 

**Ejemplo:**
    {
        "countMutantDna": 1,
        "countHumanDna": 2,
        "ratio": 0.5,

    }

Para error se retorna un HTTP 500- Internal Server Error.

**Nota: Se adjunta en el repositorio proyecto completo, .jar generado y coleccion de postman DemoMeli.postman_collection.json**




