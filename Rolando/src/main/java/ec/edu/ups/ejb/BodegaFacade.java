package ec.edu.ups.ejb;

import ec.edu.ups.entidades.Bodega;
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
public class BodegaFacade extends AbstractFacade<Bodega>{
    @PersistenceContext(name="my_persistence_unit")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public BodegaFacade(){
        super(Bodega.class);
    }
   
    public List<Bodega> listar() {
        return em.createQuery("select b from Bodega b left outer join fetch b.producto ", Bodega.class).getResultList();
    }
    
    
    public void guardarProducto(Bodega bodega){
        try {
            if(bodega.getCodigo()!= 0) {
            em.merge(bodega);
        } else {
            em.persist(bodega);
        }
        } catch (Exception e) {
        }
        
    }
    
    public Bodega buscar(Long codigo) {
        //return em.find(Producto.class, id);
        return em.createQuery("select b from Bodega e left outer join fetch b.producto where b.codigo=:codigo", Bodega.class)
                .setParameter("codigo", codigo)
                .getSingleResult();
    }
    //Elimiar al empleado por ID
    public void eliminar(Long codigo){
        Bodega bodega = buscar(codigo);
        em.remove(bodega);
    }
    
    //Para que no exista error al no existir empleados en la base
    public Optional<Bodega> opcional(Long codigo){
        return Optional.ofNullable(buscar(codigo));
    }
    
}
