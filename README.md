# WebService de Ventas

Este es un proyecto que implementa un WebService para registrar ventas, utilizando procedimientos almacenados en una base de datos.

## Descripción

El proyecto permite registrar ventas de productos, asignadas a un vendedor. El WebService utiliza Java, JDBC para la conexión a la base de datos y XML para la transmisión de datos.

### Tecnologías utilizadas:
- **Java** (JDK 11 o superior)
- **JDBC** (Java Database Connectivity)
- **SOAP WebService** (Con JAXB para la conversión de XML)
- **Base de datos** (Procedimientos almacenados)

## Funcionalidad

- **Registrar Venta**: El WebService recibe información sobre el vendedor y el producto que ha vendido, y registra esta información en una base de datos.
- **Procedimiento Almacenado**: El proceso de inserción de la venta es realizado por un procedimiento almacenado en la base de datos.

## Estructura del Proyecto

- **ProductoAsignadoVendedor**: Clase modelo que representa la venta, que incluye el nombre del vendedor y el código del producto.
- **VentaDAO**: Clase encargada de interactuar con la base de datos y ejecutar los procedimientos almacenados.
- **WebService**: Expone un método para registrar la venta de forma remota, que recibe un objeto `ProductoAsignadoVendedor`.
  
## Pasos para correr el proyecto

1. **Base de Datos**: Asegúrate de tener una base de datos configurada con el procedimiento almacenado que registe las ventas. El procedimiento se llama `RegistrarVentaCompleta`.

2. **Configuración de la Base de Datos en Java**:
    - En el archivo `VentaDAO`, configura tu URL, usuario y contraseña de la base de datos.
    - Asegúrate de tener los controladores JDBC adecuados para tu base de datos.

3. **Compilación y Ejecución**:
    - Compila el proyecto usando tu IDE favorito o la terminal de comandos.
    - Llama al método `registrarVenta` del WebService para registrar una venta.

4. **Ejemplo de XML para hacer la solicitud**:
    ```xml
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                      xmlns:pru="http://webservice.prueba/">
       <soapenv:Header/>
       <soapenv:Body>
          <pru:registrarVenta>
             <venta>
                <vendedorNombre>10370</vendedorNombre>
                <codigoProducto>104</codigoProducto>
             </venta>
          </pru:registrarVenta>
       </soapenv:Body>
    </soapenv:Envelope>
    ```

5. **Resultado**:
    - Si la venta se registra correctamente, el WebService devuelve un mensaje de éxito.
    - Si ocurre algún error (por ejemplo, problemas de conexión a la base de datos), se devuelve un mensaje de error.

## Archivos Importantes

- **ProductoAsignadoVendedor.java**: Define los datos de la venta, como el vendedor y el producto.
- **VentaDAO.java**: Maneja la lógica de base de datos para registrar las ventas.
- **WebService.java**: Expone el WebService para registrar las ventas remotamente.
- **Procedimiento Almacenado**: Asegúrate de tener el procedimiento almacenado `RegistrarVentaCompleta` configurado en tu base de datos.
