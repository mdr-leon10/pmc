/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.IdiomaEntity;
import co.edu.uniandes.csw.decide.entities.TemaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class TemaPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Tema que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TemaEntity create(TemaEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Tema.
     * @param entity: el Tema que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Tema con los cambios aplicados.
     */
    public TemaEntity update(TemaEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Tema de la base de datos recibiendo como argumento el id del Tema
     * @param id: id correspondiente al Tema a borrar.
     */
    public void delete(Long id) {
        TemaEntity entity = em.find(TemaEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Tema con el id que se envía de argumento
     * @param id: id correspondiente al Tema buscado.
     * @return un Tema.
     */
    public TemaEntity find(Long id) {
            return em.find(TemaEntity.class, id);
    }

    /**
     * Devuelve todos los Temas de la base de datos.
     * @return una lista con todas los Temas que encuentre en la base de datos.
     */
    public List<TemaEntity> findAll() {
       TypedQuery query = em.createQuery("select u from TemaEntity u", TemaEntity.class);
       return query.getResultList();
    }

    public Object findByName(TemaEntity entity) {
        TypedQuery query = em.createQuery("select u from TemaEntity u where u.name = Tema", TemaEntity.class);
        query.setParameter("Tema", entity.getName());
        return (TemaEntity) query.getSingleResult();
    }
    
}
