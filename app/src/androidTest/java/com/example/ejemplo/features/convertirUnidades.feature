# language: es
Caracteristica: Conversion de unidades.

Escenario: Acceder a pestania con temas

    Dado que el usuario se encuentre en el menu
    Cuando el usuario seleccione la funcionalidad de conversion de unidades
    Entonces el usuario accedera a la vista de conversion de unidades.

Esquema del escenario: Seleccion de una unidad

    Dado que el usuario esté visualizando las diferentes medidas con las que puede trabajar
    Cuando seleccione <unidad>
    Entonces la seccion de conversion se actualizara con las unidades de medida de <unidad>

    Ejemplos:
        | unidad      |
        | tiempo      |
        | espacio     |
        | volumen     |
        | masa        |
        | angulos     |
        | temperatura |

Esquema del escenario: Se realiza la operacion de conversion
    Dado que el usuario ha seleccionado una <unidad> con la que trabajar.
    Y ha introducido la <unidadOrigen> y <unidadResultado>
    Cuando Introduzca el <valor> que quiera convertir
    Entonces La aplicacion devuelve <resultado>

    Ejemplos:
        | unidad      | unidadOrigen | unidadResultado | valor | resultado |
        | tiempo      | segundo      | minuto          | 60    | 1         |
        | espacio     | milimetro    | kilometro       | 1     | 1000000   |
        | volumen     | mililitro    | litro           | 1     | 1000      |
        | masa        | kilogramo    | gramo           | 1     | 0.001     |
        | angulos     | radiantes    | grados          | 60    | 1.0472    |
        | temperatura | centigrados  | kelvin          | 60    | 333.15    |

Esquema del escenario: Se realiza la operacion de conversion
    Dado que el usuario ha seleccionado una <unidad> con la que trabajar.
    Cuando el usuario introduzca cambia a <nuevaUnidad>
    Entonces Todos los campos se borran
    Y la seccion de conversion se actualizara con las unidades de medida de <nuevaUnidad>

    Ejemplos:
        | unidad      | nuevaUnidad  |
        | tiempo      | espacio      |
        | espacio     | volumen      |
        | volumen     | masa         |
        | masa        | angulos      |
        | angulos     | temperatura  |
        | temperatura | tiempo       |

