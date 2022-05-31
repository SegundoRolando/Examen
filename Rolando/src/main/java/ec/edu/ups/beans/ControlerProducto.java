
package ec.edu.ups.beans;
import ec.edu.ups.ejb.ProductoFacade;
import ec.edu.ups.entidades.Producto;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import java.util.List;


/**
 *
 * @author ASUS
 */
@Model
public class ControlerProducto {
    @EJB
    private ProductoFacade productoFacade;
    private Producto producto;
    private Long codigo;
    
    @PostConstruct
    public void init() {
        this.producto = new Producto();
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    

   public String guardar(){
        try {
            this.productoFacade.guardarProducto(producto);
        } catch (Exception e) {
        }
        return "CrudProducto.xhtml?faces-redirect=true";
    }
    
    
    
    @Produces
    @RequestScoped
    @Named("listadoBodega")
    public List<Producto>listadoBodega(){
        List<Producto> emp = productoFacade.listar();
        return emp;
    }
   
    public String eliminar(Long codigo){
         productoFacade.eliminar(codigo);
        return "CrudProducto.xhtml?faces-redirect=true";
    }
    
    public String editar(Long codigo){
        this.codigo = codigo;
        
        if (codigo != null && codigo > 0) {
            productoFacade.opcional(codigo).ifPresent(p -> {
                this.producto = p;
            });
        }
        return "CrearProducto.xhtml";
    }
    
}
