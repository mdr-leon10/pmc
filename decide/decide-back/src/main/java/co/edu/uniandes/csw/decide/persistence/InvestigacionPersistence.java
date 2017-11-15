/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class InvestigacionPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Investigacion que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public InvestigacionEntity create(InvestigacionEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Investigacion.
     * @param entity: el Investigacion que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Investigacion con los cambios aplicados.
     */
    public InvestigacionEntity update(InvestigacionEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Investigacion de la base de datos recibiendo como argumento el id del Investigacion
     * @param id: id correspondiente al Investigacion a borrar.
     */
    public void delete(Long id) {
        InvestigacionEntity entity = em.find(InvestigacionEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Investigacion con el id que se envía de argumento
     * @param id: id correspondiente al Investigacion buscado.
     * @return un Investigacion.
     */
    public InvestigacionEntity find(Long id) {
            return em.find(InvestigacionEntity.class, id);
    }

    /**
     * Devuelve todos los Investigacions de la base de datos.
     * @return una lista con todas los Investigacions que encuentre en la base de datos.
     */
    public List<InvestigacionEntity> findAll() {
       TypedQuery query = em.createQuery("select u from InvestigacionEntity u", InvestigacionEntity.class);
       return query.getResultList();
    }

    public Object findByName(InvestigacionEntity entity) {
        TypedQuery query = em.createQuery("select u from InvestigacionEntity u where u.name = :investigacion", InvestigacionEntity.class);
        query.setParameter("investigacion", entity.getName());
        return (InvestigacionEntity) query.getSingleResult();
    }

    public InvestigacionEntity find(Long id, Long politicoId) {
       TypedQuery<InvestigacionEntity> q = em.createQuery("select p from InvestigacionEntity p where (p.politico.id = :politicoid) and (p.id = :id)", InvestigacionEntity.class);
        q.setParameter("politicoid", politicoId);
        q.setParameter("id", id);
        return q.getSingleResult();
    }
    
}
