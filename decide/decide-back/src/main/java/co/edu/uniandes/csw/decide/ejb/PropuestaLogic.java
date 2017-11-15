/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.entities.PropuestaEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.PropuestaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class PropuestaLogic {
    
    @Inject
    private PropuestaPersistence persistence;
    
    @Inject
    private PoliticoLogic pol;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PropuestaEntity createPropuesta(PropuestaEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Propuesta " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Propuestas existentes en la base de datos.
     * @return una lista de Propuestas.
     */
   public List<PropuestaEntity> getPropuestas(Long politicoId) throws BusinessLogicException
    {
            PoliticoEntity politico = pol.getPolitico(politicoId);
            return politico.getPropuestas();    
    }
    
    public PropuestaEntity getPropuesta( Long id, Long idPolitico ) throws BusinessLogicException
	{
		PropuestaEntity Propuesta = persistence.find( id, idPolitico );
		if( Propuesta != null )
		{
                    return Propuesta;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Propuesta con el id %s", id ));
	}
    
    public PropuestaEntity updatePropuesta (PropuestaEntity entity, Long id) throws BusinessLogicException
    {
        PropuestaEntity PropuestaActual = persistence.find(id);
        
        if (!entity.getName().equals(PropuestaActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Propuesta");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deletePropuesta (Long propuesta, Long idPolitico) throws BusinessLogicException
    {
        if (getPropuesta(propuesta, idPolitico) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Propuesta que no existe");
        }
        else 
            persistence.delete(propuesta);
    }
    
}
