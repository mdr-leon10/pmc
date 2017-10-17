/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.persistence;

import co.edu.uniandes.csw.decide.entities.CargoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mdr.leon10
 */
@Stateless
public class CargoPersistence {
    
    @PersistenceContext(unitName = "decidePU")
    protected EntityManager em;
    
     /**
     * @param entity objeto cargo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CargoEntity create(CargoEntity entity) {
        em.persist(entity);
        return entity;
    }

    /**
     * Actualiza un cargo.
     * @param entity: el cargo que viene con los nuevos cambios. Por ejemplo
     * el codigo pudo cambiar. En ese caso, se haria uso del método update.
     * @return un cargo con los cambios aplicados.
     */
    public CargoEntity update(CargoEntity entity) {
        return em.merge(entity);
    }

    /**
     *
     * Borra un cargo de la base de datos recibiendo como argumento el id del cargo
     * @param id: id correspondiente al cargo a borrar.
     */
    public void delete(Long id) {
        CargoEntity entity = em.find(CargoEntity.class, id);
        em.remove(entity);
    }

    /**
     * Busca si hay algun cargo con el id que se envía de argumento
     * @param id: id correspondiente al cargo buscado.
     * @return un cargo.
     */
    public CargoEntity find(Long id) {
            return em.find(CargoEntity.class, id);
    }

    /**
     * Devuelve todos los cargos de la base de datos.
     * @return una lista con todas los cargos que encuentre en la base de datos.
     */
    public List<CargoEntity> findAll() {
       TypedQuery query = em.createQuery("select u from CargoEntity u", CargoEntity.class);
       return query.getResultList();
    }

    public CargoEntity findByNameAndEntidad(CargoEntity cargo) {
        
        TypedQuery query = em.createQuery("select u from CargoEntity u where u.name = nombreCargo and u.entidad = entidadCargo", CargoEntity.class);
        query.setParameter("nombreCargo", cargo.getName());
        query.setParameter("entidadCargo", cargo.getEntidad());
        return (CargoEntity) query.getSingleResult();
        
    }
    
}
