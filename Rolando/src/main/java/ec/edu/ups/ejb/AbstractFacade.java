package ec.edu.ups.ejb;



import jakarta.persistence.EntityManager;
/**
 *
 * @author ASUS
 * @param <T>
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    
    public AbstractFacade(Class<T> enyClass){
        this.entityClass=enyClass;
    }
    protected abstract EntityManager getEntityManager();
    
    public void create(T entity){
        getEntityManager().persist(entity);
    }
    
    public void edit(T entity){
        getEntityManager().merge(entity);
    }
    
    public void remove(T entity){
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    public T find(Object id){
        return getEntityManager().find(entityClass, id);
    }
}
