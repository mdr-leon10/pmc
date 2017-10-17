/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.PartidoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class PartidoPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Partido que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PartidoEntity create(PartidoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Partido.
     * @param entity: el Partido que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Partido con los cambios aplicados.
     */
    public PartidoEntity update(PartidoEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Partido de la base de datos recibiendo como argumento el id del Partido
     * @param id: id correspondiente al Partido a borrar.
     */
    public void delete(Long id) {
        PartidoEntity entity = em.find(PartidoEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Partido con el id que se envía de argumento
     * @param id: id correspondiente al Partido buscado.
     * @return un Partido.
     */
    public PartidoEntity find(Long id) {
            return em.find(PartidoEntity.class, id);
    }

    /**
     * Devuelve todos los Partidos de la base de datos.
     * @return una lista con todas los Partidos que encuentre en la base de datos.
     */
    public List<PartidoEntity> findAll() {
       TypedQuery query = em.createQuery("select u from PartidoEntity u", PartidoEntity.class);
       return query.getResultList();
    }

    public Object findByName(PartidoEntity entity) {
        TypedQuery query = em.createQuery("select u from PartidoEntity u where u.name = Partido", PartidoEntity.class);
        query.setParameter("Partido", entity.getName());
        return (PartidoEntity) query.getSingleResult();
    }
    
}
