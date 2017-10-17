/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.PropuestaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class PropuestaPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Propuesta que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PropuestaEntity create(PropuestaEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Propuesta.
     * @param entity: el Propuesta que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Propuesta con los cambios aplicados.
     */
    public PropuestaEntity update(PropuestaEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Propuesta de la base de datos recibiendo como argumento el id del Propuesta
     * @param id: id correspondiente al Propuesta a borrar.
     */
    public void delete(Long id) {
        PropuestaEntity entity = em.find(PropuestaEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Propuesta con el id que se envía de argumento
     * @param id: id correspondiente al Propuesta buscado.
     * @return un Propuesta.
     */
    public PropuestaEntity find(Long id) {
            return em.find(PropuestaEntity.class, id);
    }

    /**
     * Devuelve todos los Propuestas de la base de datos.
     * @return una lista con todas los Propuestas que encuentre en la base de datos.
     */
    public List<PropuestaEntity> findAll() {
       TypedQuery query = em.createQuery("select u from PropuestaEntity u", PropuestaEntity.class);
       return query.getResultList();
    }

    public Object findByName(PropuestaEntity entity) {
        TypedQuery query = em.createQuery("select u from PropuestaEntity u where u.name = Propuesta", PropuestaEntity.class);
        query.setParameter("Propuesta", entity.getName());
        return (PropuestaEntity) query.getSingleResult();
    }
    
}
