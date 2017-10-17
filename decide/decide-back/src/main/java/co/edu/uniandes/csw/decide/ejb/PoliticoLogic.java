/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.PoliticoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class PoliticoLogic {
    
    @Inject
    private PoliticoPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public PoliticoEntity createPolitico(PoliticoEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Politico " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Politicos existentes en la base de datos.
     * @return una lista de Politicos.
     */
    public List<PoliticoEntity> getPoliticos() {
        return persistence.findAll();
    }
    
    public PoliticoEntity getPolitico( Long id ) throws BusinessLogicException
	{
		PoliticoEntity Politico = persistence.find( id );
		if( Politico != null )
		{
			return Politico;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Politico con el id %s", id ));
	}
    
    public PoliticoEntity updatePolitico (PoliticoEntity entity, Long id) throws BusinessLogicException
    {
        PoliticoEntity PoliticoActual = persistence.find(id);
        
        if (!entity.getName().equals(PoliticoActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Politico");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deletePolitico (Long Politico) throws BusinessLogicException
    {
        if (persistence.find(Politico) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Politico que no existe");
        }
        else 
            persistence.delete(Politico);
    }
    
}
