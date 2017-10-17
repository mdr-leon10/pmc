/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.IdiomaEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.IdiomaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class IdiomaLogic {
    
    @Inject
    private IdiomaPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public IdiomaEntity createIdioma(IdiomaEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Idioma " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Idiomas existentes en la base de datos.
     * @return una lista de Idiomas.
     */
    public List<IdiomaEntity> getIdiomas() {
        return persistence.findAll();
    }
    
    public IdiomaEntity getIdioma( Long id ) throws BusinessLogicException
	{
		IdiomaEntity Idioma = persistence.find( id );
		if( Idioma != null )
		{
			return Idioma;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Idioma con el id %s", id ));
	}
    
    public IdiomaEntity updateIdioma (IdiomaEntity entity, Long id) throws BusinessLogicException
    {
        IdiomaEntity IdiomaActual = persistence.find(id);
        
        if (!entity.getName().equals(IdiomaActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Idioma");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteIdioma (Long Idioma) throws BusinessLogicException
    {
        if (persistence.find(Idioma) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Idioma que no existe");
        }
        else 
            persistence.delete(Idioma);
    }
}
