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
- **Obtener Reporte de Ventas**: El WebService también permite obtener un reporte de ventas, sin necesidad de parámetros adicionales.

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

4. **solicitud de registro de venta**:
     XML para registrar una venta:
    ```xml
    <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                      xmlns:pru="http://webservice.prueba/">
       <soapenv:Header/>
       <soapenv:Body>
          <pru:registrarVenta>
             <venta>
                <vendedorNombre>juan</vendedorNombre>
                <codigoProducto>104</codigoProducto>
                <montoVendido>1500.00</montoVendido>
             </venta>
          </pru:registrarVenta>
       </soapenv:Body>
    </soapenv:Envelope>
    ```

5. ** obtener reporte de ventas**:
    XML obtener reporte:
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
                xmlns:tns="http://webservice.prueba/">
        <S:Body>
            <tns:obtenerReporteVentas/>
        </S:Body>
    </S:Envelope>
    ```

6. **Resultado**:
    - Si la venta se registra correctamente, el WebService devuelve un mensaje de éxito.
    - Si ocurre algún error (por ejemplo, problemas de conexión a la base de datos), se devuelve un mensaje de error.

## Archivos Importantes

- **ProductoAsignadoVendedor.java**: Define los datos de la venta, como el vendedor y el producto.
- **VentaDAO.java**: Maneja la lógica de base de datos para registrar las ventas.
- **WebService.java**: Expone el WebService para registrar las ventas remotamente.
- **Procedimiento Almacenado**: Asegúrate de tener el procedimiento almacenado `RegistrarVentaCompleta` configurado en tu base de datos.

## Contribuciones

Si deseas contribuir al proyecto, por favor realiza un **fork** y crea un **pull request**. Asegúrate de seguir las buenas prácticas de programación.

---

¡Listo! Con estos pasos, puedes correr y modificar el proyecto según sea necesario. Si tienes alguna duda o necesitas más ayuda, no dudes en preguntar.



