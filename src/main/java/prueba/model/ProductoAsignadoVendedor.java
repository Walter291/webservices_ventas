package prueba.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "venta")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductoAsignadoVendedor {

    @XmlElement(required = true)
    private String vendedorNombre;

    @XmlElement(required = true)
    private String codigoProducto;

    @XmlElement(required = true)
    private double montoVendido;

    // Constructor vacío (obligatorio para JAXB)
    public ProductoAsignadoVendedor() {
    }

    // Getters y Setters con validación
    public String getVendedorNombre() {
        return vendedorNombre;
    }

    public void setVendedorNombre(String vendedorNombre) {
        if (vendedorNombre == null || vendedorNombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del vendedor no puede estar vacío");
        }
        this.vendedorNombre = vendedorNombre;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        if (codigoProducto == null || codigoProducto.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del producto no puede estar vacío");
        }
        this.codigoProducto = codigoProducto;
    }

    public double getMontoVendido() {
        return montoVendido;
    }

    public void setMontoVendido(double montoVendido) {
        if (montoVendido < 0) {
            throw new IllegalArgumentException("El monto vendido no puede ser negativo");
        }
        this.montoVendido = montoVendido;
    }

    // Métodos equals, hashCode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoAsignadoVendedor that = (ProductoAsignadoVendedor) o;
        return Double.compare(that.montoVendido, montoVendido) == 0 &&
                vendedorNombre.equals(that.vendedorNombre) &&
                codigoProducto.equals(that.codigoProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendedorNombre, codigoProducto, montoVendido);
    }

    @Override
    public String toString() {
        return "ProductoAsignadoVendedor{" +
                "vendedorNombre='" + vendedorNombre + '\'' +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", montoVendido=" + montoVendido +
                '}';
    }
}
