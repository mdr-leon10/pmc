/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.PartidoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.PartidoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class PartidoLogic {
    
     @Inject
    private PartidoPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PartidoEntity createPartido(PartidoEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Partido " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Partidos existentes en la base de datos.
     * @return una lista de Partidos.
     */
    public List<PartidoEntity> getPartidos() {
        return persistence.findAll();
    }
    
    public PartidoEntity getPartido( Long id ) throws BusinessLogicException
	{
		PartidoEntity Partido = persistence.find( id );
		if( Partido != null )
		{
			return Partido;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Partido con el id %s", id ));
	}
    
    public PartidoEntity updatePartido (PartidoEntity entity, Long id) throws BusinessLogicException
    {
        PartidoEntity PartidoActual = persistence.find(id);
        
        if (!entity.getName().equals(PartidoActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Partido");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deletePartido (Long v) throws BusinessLogicException
    {
        if (persistence.find(v) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Partido que no existe");
        }
        else 
            persistence.delete(v);
    }
    
}
