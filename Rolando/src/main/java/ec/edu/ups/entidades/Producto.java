
package ec.edu.ups.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;

/**
 *
 * @author ASUS
 */
@NamedQuery(name = "getProducto", query = "SELECT  FROM  Producto p")
@Entity
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    private String nombre;
    private int stockActual;
    private double precio;
   
    public Producto() {
    }

    public Producto(long codigo, String nombre, int stockActual, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.precio = precio;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", stockActual=" + stockActual + ", precio=" + precio + '}';
    }

}
