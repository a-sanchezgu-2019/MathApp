# language: es
Caracteristica: Conversion de unidades.

Escenario: Acceder a pestania con temas

    Dado que el usuario se encuentre en el menu
    Cuando el usuario seleccione la funcionalidad de conversion de unidades
    Entonces el usuario accedera a la vista de conversion de unidades.


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


