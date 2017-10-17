/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.HabilidadEntity;
import co.edu.uniandes.csw.decide.entities.PropuestaEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.HabilidadPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class HabilidadLogic {
   
    @Inject
    private HabilidadPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public HabilidadEntity createHabilidad(HabilidadEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Habilidad " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Habilidads existentes en la base de datos.
     * @return una lista de Habilidads.
     */
    public List<HabilidadEntity> getHabilidads() {
        return persistence.findAll();
    }
    
    public HabilidadEntity getHabilidad( Long id ) throws BusinessLogicException
	{
		HabilidadEntity Habilidad = persistence.find( id );
		if( Habilidad != null )
		{
			return Habilidad;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Habilidad con el id %s", id ));
	}
    
    public HabilidadEntity updateHabilidad (HabilidadEntity entity, Long id) throws BusinessLogicException
    {
        HabilidadEntity HabilidadActual = persistence.find(id);
        
        if (!entity.getName().equals(HabilidadActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Habilidad");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteHabilidad (Long Habilidad) throws BusinessLogicException
    {
        if (persistence.find(Habilidad) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Habilidad que no existe");
        }
        else 
            persistence.delete(Habilidad);
    }
    
}
