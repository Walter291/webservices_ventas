package prueba.webservice;

import prueba.dao.VentaDAO;
import prueba.model.ProductoAsignadoVendedor;
import prueba.model.ReporteVentas;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;

@WebService(targetNamespace = "http://webservice.prueba/")
public class VentaWebService {

    private VentaDAO ventaDAO = new VentaDAO();

    @WebMethod(operationName = "registrarVenta")
    public String registrarVenta(@WebParam(name = "venta") ProductoAsignadoVendedor venta) {
        // Validación de datos: se verifica que los campos obligatorios no sean nulos y que el monto sea mayor a cero.
        if (venta == null ||
                venta.getVendedorNombre() == null ||
                venta.getCodigoProducto() == null ||
                venta.getMontoVendido() <= 0) {
            return "Error: Los datos de la venta son inválidos.";
        }

        try {
            boolean exito = ventaDAO.registrarVenta(venta);
            return exito ? "Venta registrada correctamente." : "Error al registrar la venta.";
        } catch (Exception e) {

            System.err.println("Excepción en registrarVenta: " + e.getMessage());
            return "Error: Ocurrió una excepción al registrar la venta.";
        }
    }


    // Método para obtener el reporte de ventas
    @WebMethod
    public List<ReporteVentas> obtenerReporteVentas() {
        try {
            return ventaDAO.obtenerReporteVentas();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el reporte de ventas: " + e.getMessage(), e);
        }
    }
}
