/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.TemaEntity;
import java.util.List;
import javax.inject.Inject;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.TemaPersistence;

/**
 *
 * @author mdr.leon10
 */
public class TemaLogic {
    
    @Inject
    private TemaPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public TemaEntity createTema(TemaEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Tema " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Temas existentes en la base de datos.
     * @return una lista de Temas.
     */
    public List<TemaEntity> getTemas() {
        return persistence.findAll();
    }
    
    public TemaEntity getTema( Long id ) throws BusinessLogicException
	{
		TemaEntity Tema = persistence.find( id );
		if( Tema != null )
		{
			return Tema;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Tema con el id %s", id ));
	}
    
    public TemaEntity updateTema (TemaEntity entity, Long id) throws BusinessLogicException
    {
        TemaEntity TemaActual = persistence.find(id);
        
        if (!entity.getName().equals(TemaActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Tema");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteTema (Long Tema) throws BusinessLogicException
    {
        if (persistence.find(Tema) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Tema que no existe");
        }
        else 
            persistence.delete(Tema);
    }
}
