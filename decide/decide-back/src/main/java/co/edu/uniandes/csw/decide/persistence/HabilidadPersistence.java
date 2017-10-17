/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.HabilidadEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class HabilidadPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Habilidad que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public HabilidadEntity create(HabilidadEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Habilidad.
     * @param entity: el Habilidad que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Habilidad con los cambios aplicados.
     */
    public HabilidadEntity update(HabilidadEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Habilidad de la base de datos recibiendo como argumento el id del Habilidad
     * @param id: id correspondiente al Habilidad a borrar.
     */
    public void delete(Long id) {
        HabilidadEntity entity = em.find(HabilidadEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Habilidad con el id que se envía de argumento
     * @param id: id correspondiente al Habilidad buscado.
     * @return un Habilidad.
     */
    public HabilidadEntity find(Long id) {
            return em.find(HabilidadEntity.class, id);
    }

    /**
     * Devuelve todos los Habilidades de la base de datos.
     * @return una lista con todas los Habilidads que encuentre en la base de datos.
     */
    public List<HabilidadEntity> findAll() {
       TypedQuery query = em.createQuery("select u from HabilidadEntity u", HabilidadEntity.class);
       return query.getResultList();
    }

    public Object findByName(HabilidadEntity entity) {
        TypedQuery query = em.createQuery("select u from HabilidadEntity u where u.name = Habilidad", HabilidadEntity.class);
        query.setParameter("Habilidad", entity.getName());
        return (HabilidadEntity) query.getSingleResult();
    }
    
}
