
package ec.edu.ups.ejb;
import ec.edu.ups.entidades.Producto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author ASUS
 */
@Stateless 
public class ProductoFacade extends AbstractFacade<Producto>{
    @PersistenceContext(name="my_persistence_unit")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return  em;
    }
    
    public ProductoFacade() {
        super(Producto.class);
    }
    //
    public void guardarProducto(Producto producto) {
        if (producto.getCodigo()!= 0 && producto.getCodigo() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }
    //
    public List<Producto> listar() {
        return em.createQuery("SELECT p FROM  producto b", Producto.class).getResultList();
    }
    //
    public Producto buscar(Long codigo) {
        return em.find(Producto.class, codigo);
    }
    //
    public Optional<Producto> optional(Long codigo) {
        return Optional.ofNullable(buscar(codigo));
    }
    //
    public void eliminar(Long codigo) {
        Producto producto = buscar(codigo);
        em.remove(producto);
    }
    public Optional<Producto> opcional(Long id) {
        return Optional.ofNullable(buscar(id));
    }

}
