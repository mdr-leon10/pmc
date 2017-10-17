/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.IdiomaEntity;
import co.edu.uniandes.csw.decide.entities.ProyectoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class ProyectoPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Proyecto que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ProyectoEntity create(ProyectoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Proyecto.
     * @param entity: el Proyecto que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Proyecto con los cambios aplicados.
     */
    public ProyectoEntity update(ProyectoEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Proyecto de la base de datos recibiendo como argumento el id del Proyecto
     * @param id: id correspondiente al Proyecto a borrar.
     */
    public void delete(Long id) {
        ProyectoEntity entity = em.find(ProyectoEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Proyecto con el id que se envía de argumento
     * @param id: id correspondiente al Proyecto buscado.
     * @return un Proyecto.
     */
    public ProyectoEntity find(Long id) {
            return em.find(ProyectoEntity.class, id);
    }

    /**
     * Devuelve todos los Proyectos de la base de datos.
     * @return una lista con todas los Proyectos que encuentre en la base de datos.
     */
    public List<ProyectoEntity> findAll() {
       TypedQuery query = em.createQuery("select u from ProyectoEntity u", ProyectoEntity.class);
       return query.getResultList();
    }

    public Object findByName(ProyectoEntity entity) {
        TypedQuery query = em.createQuery("select u from ProyectoEntity u where u.name = Proyecto", ProyectoEntity.class);
        query.setParameter("Proyecto", entity.getName());
        return (ProyectoEntity) query.getSingleResult();
    }
    
}
