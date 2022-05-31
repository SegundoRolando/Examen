
package ec.edu.ups.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
//
/**
 *
 * @author ASUS
 */
@Entity
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nombre;
    private String ciudad;
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public Bodega() {
    }

    public Bodega(Long codigo, String nombre, String ciudad, Producto producto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.producto = producto;
    }
    

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Bodega{" + "codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", producto=" + producto + '}';
    }

 
}
