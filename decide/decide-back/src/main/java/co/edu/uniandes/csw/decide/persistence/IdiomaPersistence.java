/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.IdiomaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class IdiomaPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto cargo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public IdiomaEntity create(IdiomaEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Idioma.
     * @param entity: el Idioma que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Idioma con los cambios aplicados.
     */
    public IdiomaEntity update(IdiomaEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Idioma de la base de datos recibiendo como argumento el id del Idioma
     * @param id: id correspondiente al Idioma a borrar.
     */
    public void delete(Long id) {
        IdiomaEntity entity = em.find(IdiomaEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Idioma con el id que se envía de argumento
     * @param id: id correspondiente al Idioma buscado.
     * @return un Idioma.
     */
    public IdiomaEntity find(Long id) {
            return em.find(IdiomaEntity.class, id);
    }

    /**
     * Devuelve todos los Idiomas de la base de datos.
     * @return una lista con todas los Idiomas que encuentre en la base de datos.
     */
    public List<IdiomaEntity> findAll() {
       TypedQuery query = em.createQuery("select u from IdiomaEntity u", IdiomaEntity.class);
       return query.getResultList();
    }

    public Object findByName(IdiomaEntity entity) {
        TypedQuery query = em.createQuery("select u from IdiomaEntity u where u.name = idioma", IdiomaEntity.class);
        query.setParameter("idioma", entity.getName());
        return (IdiomaEntity) query.getSingleResult();
    }

    
}
