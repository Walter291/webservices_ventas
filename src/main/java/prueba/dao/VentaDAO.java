package prueba.dao;

import prueba.model.ProductoAsignadoVendedor;
import prueba.model.ReporteVentas;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VentaDAO {

    private String url;
    private String user;
    private String password;
    private String driver;

    public VentaDAO() {
        // Cargar propiedades desde el archivo db.properties
        try (InputStream input = VentaDAO.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.err.println("Error: No se pudo cargar el archivo db.properties");
                return;
            }
            Properties prop = new Properties();
            prop.load(input);
            this.url = prop.getProperty("db.url");
            this.user = prop.getProperty("db.user");
            this.password = prop.getProperty("db.password");
            this.driver = prop.getProperty("db.driver");

            // Cargar el driver
            Class.forName(driver);
        } catch (Exception e) {
            System.err.println("Error al cargar las propiedades: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean registrarVenta(ProductoAsignadoVendedor venta) {
        String sql = "{call RegistrarVentaCompleta(?, ?, ?)}"; // Llamada al procedimiento almacenado combinado
        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = conn.prepareCall(sql)) {

            System.out.println("Conectando a la base de datos para registrar la venta completa...");

            // Validar y convertir el código del producto a entero
            int codigoProducto;
            try {
                codigoProducto = Integer.parseInt(venta.getCodigoProducto());
            } catch (NumberFormatException e) {
                System.err.println("Error: El código del producto no es un número válido.");
                return false;
            }

            // Obtener el monto vendido
            double montoVendido = venta.getMontoVendido();

            // Configurar los parámetros del procedimiento almacenado
            stmt.setString(1, venta.getVendedorNombre());
            stmt.setInt(2, codigoProducto);
            stmt.setDouble(3, montoVendido);

            int filas = stmt.executeUpdate();
            System.out.println("Filas afectadas: " + filas);


            return (filas > 0) || (filas == -1);

        } catch (SQLException ex) {
            System.err.println("Error al registrar la venta: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }



    // Método para obtener el reporte de ventas usando el procedimiento almacenado ObtenerReporteVentas
    public List<ReporteVentas> obtenerReporteVentas() {
        List<ReporteVentas> lista = new ArrayList<>();
        String sql = "{call ObtenerReporteVentas}"; // Llamada al procedimiento almacenado

        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = conn.prepareCall(sql)) {

            System.out.println("Conectando a la base de datos para obtener el reporte de ventas...");

            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("No se encontraron resultados en el reporte de ventas.");
            }
            while (rs.next()) {
                String vendedorNombre = rs.getString("VendedorNombre");  // Corregir aquí el nombre de la columna
                double totalVentas = rs.getDouble("totalVentas");
                lista.add(new ReporteVentas(vendedorNombre, totalVentas));
            }
        } catch (SQLException ex) {
            System.err.println("Error al obtener el reporte de ventas: " + ex.getMessage());
            ex.printStackTrace();
        }
        return lista;
    }
}

