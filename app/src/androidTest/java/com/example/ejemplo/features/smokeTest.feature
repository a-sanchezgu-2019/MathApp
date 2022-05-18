# language: es
Caracteristica: Smoke test.

Escenario: Comprobar funcionalidades criticas

    Dado que el usuario se encuentre en el menu
    Cuando el usuario seleccione una opcion
    Entonces el usuario accede a una <Interfaz> sin que haya ningun problema .


Esquema del escenario: Se vuelve al menu
    Dado que el usuario ha entrado en una <Interfaz>.
    Cuando pulse el boton de volver al menú principal
    Entonces La aplicacion le devolverá al menú principal.

   Ejemplos:
           | Interfaz
           | Calculadora
           | CalculadoraTrigonometrica
           | Ecuaciones
           | Ecuaciones2
           | Conversación
           | Ruffini

 Esquema del escenario: Botones erroneos en las inetrfaces de calculadoras.
    Dado que el usuario ha seleccionado la interfaz Calculadora o  CalculadoraTrigonometrica.
    Cuando el usuario escoge el boton de la coma y el de igual
    Entonces la aplicacion ignorará esos input.

 Esquema del escenario: Botones erroneos en las inetrfaces de ecuaciones.
     Dado que el usuario ha seleccionado cualquiera de las inetrfaces de ecuaciones.
     Cuando el usuario escoge el boton de la coma y el de igual
     Entonces la aplicacion ignorará esos input.

Esquema del escenario: Conversion de unidades sin input en el valor de entrada.
     Dado que el usuario ha seleccionado la opción de Conversion de unidades.
     Cuando el usuario selecciona el boton de aceptar
     Y no haya introducido ningun valor en el input de valor entrada
     Entonces la aplicacion no realizará niguna acción.

Esquema del escenario: Ruffini sin tener parametros.
     Dado que el usuario ha seleccionado la opción de Ruffini.
     Cuando el usuario selecciona el boton de igual
     Y no haya introducido ningun valor en los inputs de entrada
     Entonces la aplicacion no realizará niguna acción.
