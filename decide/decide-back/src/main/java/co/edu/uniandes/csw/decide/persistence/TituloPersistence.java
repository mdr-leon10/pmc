/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.IdiomaEntity;
import co.edu.uniandes.csw.decide.entities.TituloEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class TituloPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Titulo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TituloEntity create(TituloEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Titulo.
     * @param entity: el Titulo que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Titulo con los cambios aplicados.
     */
    public TituloEntity update(TituloEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Titulo de la base de datos recibiendo como argumento el id del Titulo
     * @param id: id correspondiente al Titulo a borrar.
     */
    public void delete(Long id) {
        TituloEntity entity = em.find(TituloEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Titulo con el id que se envía de argumento
     * @param id: id correspondiente al Titulo buscado.
     * @return un Titulo.
     */
    public TituloEntity find(Long id) {
            return em.find(TituloEntity.class, id);
    }

    /**
     * Devuelve todos los Titulos de la base de datos.
     * @return una lista con todas los Titulos que encuentre en la base de datos.
     */
    public List<TituloEntity> findAll() {
       TypedQuery query = em.createQuery("select u from TituloEntity u", TituloEntity.class);
       return query.getResultList();
    }

    public Object findByName(TituloEntity entity) {
        TypedQuery query = em.createQuery("select u from TituloEntity u where u.name = Titulo", TituloEntity.class);
        query.setParameter("Titulo", entity.getName());
        return (TituloEntity) query.getSingleResult();
    }
    
}
