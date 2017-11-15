/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.InvestigacionPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class InvestigacionLogic {
    
    @Inject
    private InvestigacionPersistence persistence;
    
    @Inject
    private PoliticoLogic pol;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public InvestigacionEntity createInvestigacion(InvestigacionEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Investigacion " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Investigacions existentes en la base de datos.
     * @return una lista de Investigacions.
     */
   public List<InvestigacionEntity> getInvestigaciones(Long politicoId) throws BusinessLogicException
    {
            PoliticoEntity politico = pol.getPolitico(politicoId);
            return politico.getInvestigaciones();    
    }
    
    public InvestigacionEntity getInvestigacion( Long id, Long politicoId ) throws BusinessLogicException
	{
		InvestigacionEntity Investigacion = persistence.find( id, politicoId );
		if( Investigacion != null )
		{
			return Investigacion;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Investigacion con el id %s", id ));
	}
    
    public InvestigacionEntity updateInvestigacion (InvestigacionEntity entity, Long id) throws BusinessLogicException
    {
        InvestigacionEntity InvestigacionActual = persistence.find(id);
        
        if (!entity.getName().equals(InvestigacionActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Investigacion");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteInvestigacion (Long investigacion, Long politico) throws BusinessLogicException
    {
        if (getInvestigacion(investigacion, politico) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Investigacion que no existe");
        }
        else 
            persistence.delete(investigacion);
    }
    
}
