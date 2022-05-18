# language: es
Característica: Cambiar de tema la aplicacion.

Escenario: Acceder a pestaña con temas

    Dado que estoy en el menu principal
    Cuando pulse en la configuracion
    Entonces accedere a la configuracion

Esquema del escenario: Selector de temas

    Dado que estoy en el selector de temas.
    Cuando selecciono el tema <tema>.
    Entonces El tema de la aplicacion cambia a <tema>

    Ejemplos:
        | tema       |
        | azul       |
        | naranja    |
        | daltonicos |
        | noche      |
        | claro      |



