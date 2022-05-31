package ec.edu.ups.beans;

import ec.edu.ups.ejb.BodegaFacade;

import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Bodega;
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
public class ControladorBodega {
    @EJB
    private BodegaFacade bodegaFacade;
    private Producto producto;
    private Long codigo;
    private Bodega bodega;
  

    
    @PostConstruct
    public void init() {
        this.producto = new Producto();
        this.bodega = new Bodega();
    }

    public BodegaFacade getBodegaFacade() {
        return bodegaFacade;
    }

    public void setBodegaFacade(BodegaFacade bodegaFacade) {
        this.bodegaFacade = bodegaFacade;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

   
    @Produces
    @RequestScoped
    @Named("listadoBodega")
    public List<Bodega>listadoBodega(){
        List<Bodega> emp = bodegaFacade.listar();
        return emp;
    }
   
    
    public String guardar(){
        try {
            bodega.setProducto(producto);
            this.bodegaFacade.guardarProducto(bodega);
        } catch (Exception e) {
        }
        return "CrudProducto.xhtml?faces-redirect=true";
    }
    
    public String eliminar(long codigo){
        bodegaFacade.eliminar(codigo);
        return "CrudProducto.xhtml?faces-redirect=true";
    }
    
 
    @Produces
    @RequestScoped
    @Named("listadobodega")
    public List<Bodega> listadobodega() {
        List<Bodega> bodega = bodegaFacade.listar();
        return bodega;
    }
     
}
