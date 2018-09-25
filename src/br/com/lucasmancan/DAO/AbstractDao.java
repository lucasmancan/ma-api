package br.com.lucasmancan.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<PK extends Serializable, T> {
    
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @PersistenceContext
    EntityManager entityManager;
     
    protected EntityManager getEntityManager(){
        return this.entityManager;
    }
 
    protected T getByKey(PK key) {
        return (T) entityManager.find(persistentClass, key);
    }
 
    protected boolean persist(T entity) {
        try{
        	entityManager.persist(entity);
        }catch (Exception e) {
        	return false;
		}
        return true;
    }
     
    protected boolean update(T entity) {
    	try{
    		entityManager.merge(entity);
        }catch (Exception e) {
        	return false;
		}
        return true;
    }
 
    protected boolean delete(T entity){
    	try{
    		entityManager.remove(entity);
        }catch (Exception e) {
        	return false;
		}
        return true;
    }
 
}