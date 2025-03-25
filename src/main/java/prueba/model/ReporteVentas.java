package prueba.model;

public class ReporteVentas {
    private String VendedorNombre;
    private double totalVentas;

    public ReporteVentas() {
    }

    public ReporteVentas(String VendedorNombre, double totalVentas) {
        this.VendedorNombre = VendedorNombre;
        this.totalVentas = totalVentas;
    }

    // Getters y Setters
    public String getVendedorNombre() {
        return VendedorNombre;
    }

    public void setVendedorNombre(String VendedorNombre) {
        this.VendedorNombre = VendedorNombre;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }
}
