# Universidad Politécnica Salesiana

Estructura de Datos
- Arboles Binarios
- Diccionarios con HashMap

[Proyecto Final]



# Sistema de Gestión de Contactos

Este proyecto implementa un sistema de gestión de contactos telefónicos utilizando el patrón Modelo-Vista-Controlador (MVC). A continuación, se detalla la estructura del proyecto y se brinda una explicación sobre los diccionarios y HashMap utilizados.

## Estructura del proyecto

El proyecto está organizado en las siguientes clases:

- `ArbolContactos`: Representa el árbol binario de búsqueda utilizado para almacenar los contactos. Esta clase implementa las operaciones de inserción, búsqueda y eliminación de contactos en el árbol. A su vez, se encuentran los metodos de ordenamiento, junto con los metodos para calcular el peso y altura del arbol binario. Añadiendo, esta clase contiene el menú como método.

- `Contacto`: Representa un contacto telefónico y contiene los atributos `nombre` y `telefono`. Además, se ha agregado una variable adicional llamada `redesSociales` que almacena una colección de redes sociales asociadas al contacto, junto con un atributo nuevo llamado Correos de tipo LinkedList con el fin de almacenar los mismos. A su vez, se encuentran los metodos para agregar correos y redes sociales.

- `Node`: Clase que representa un nodo del árbol binario de búsqueda. Cada nodo contiene una instancia de la clase `Contacto` y las referencias a los nodos izquierdo y derecho.

- `Gestion Telefonos`: Clase principal que contiene el punto de entrada del programa y se encarga de interactuar con el usuario a través de la consola. Podria considerarse la Vista del programa, en el cual se allá el menú, y se llaman los métodos como se requieran.

## Explicación de Diccionarios y HashMap

### Diccionarios

Los diccionarios son estructuras de datos que almacenan pares clave-valor, donde cada clave es única y se utiliza para acceder a su correspondiente valor. En este proyecto, la clase `HashMap` de Java se considera un diccionario, ya que almacena elementos en forma de pares clave-valor.

### HashMap

La clase `HashMap` en Java es una implementación de la interfaz `Map`, que proporciona una estructura de datos basada en tablas hash. Permite almacenar y acceder eficientemente a elementos utilizando claves únicas. En el contexto de este proyecto, se utiliza un `HashMap` para asociar el nombre de un contacto con su instancia correspondiente.





---

### Excepciones
Para evitar la aparicion de errores, se implemento el uso de excepciones generales en los métodos, esto sumado a las validaciones realizadas en los metodos otorga un extra de seguridad de compilación al código.

--- Paul Cuesta
