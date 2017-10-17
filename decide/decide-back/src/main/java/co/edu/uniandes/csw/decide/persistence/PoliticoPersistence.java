/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
public class PoliticoPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
    /**
     * @param entity objeto Politico que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PoliticoEntity create(PoliticoEntity entity) {
        em.persist(entity);
        return entity;
    }
    
    /**
     * Actualiza un Politico.
     * @param entity: el Politico que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un Politico con los cambios aplicados.
     */
    public PoliticoEntity update(PoliticoEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un Politico de la base de datos recibiendo como argumento el id del Politico
     * @param id: id correspondiente al Politico a borrar.
     */
    public void delete(Long id) {
        PoliticoEntity entity = em.find(PoliticoEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun Politico con el id que se envía de argumento
     * @param id: id correspondiente al Politico buscado.
     * @return un Politico.
     */
    public PoliticoEntity find(Long id) {
            return em.find(PoliticoEntity.class, id);
    }

    /**
     * Devuelve todos los Politicos de la base de datos.
     * @return una lista con todas los Politicos que encuentre en la base de datos.
     */
    public List<PoliticoEntity> findAll() {
       TypedQuery query = em.createQuery("select u from PoliticoEntity u", PoliticoEntity.class);
       return query.getResultList();
    }

    public Object findByName(PoliticoEntity entity) {
        TypedQuery query = em.createQuery("select u from PoliticoEntity u where u.name = Politico", PoliticoEntity.class);
        query.setParameter("Politico", entity.getName());
        return (PoliticoEntity) query.getSingleResult();
    }
    
}
