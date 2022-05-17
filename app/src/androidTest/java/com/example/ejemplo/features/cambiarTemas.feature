# language: es
Característica: Cambiar de tema la aplicación.

Escenario: Acceder a pestaña con temas

    Dado que estoy en el menú principal
    Cuando pulse en la configuración
    Entonces accederé a la configuración

Esquema del escenario: Selector de temas

    Dado que estoy en el selector de temas.
    Cuando selecciono el tema <tema>.
    Entonces El tema de la aplicación cambia a <tema>

    Ejemplos:
        | tema       |
        | azul       |
        | naranja    |
        | daltónicos |
        | noche      |
        | claro      |



