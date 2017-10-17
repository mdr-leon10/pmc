/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;


import co.edu.uniandes.csw.decide.entities.TituloEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.TituloPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class TituloLogic {
    
    @Inject
    private TituloPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public TituloEntity createTitulo(TituloEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Titulo " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Titulos existentes en la base de datos.
     * @return una lista de Titulos.
     */
    public List<TituloEntity> getTitulos() {
        return persistence.findAll();
    }
    
    public TituloEntity getTitulo( Long id ) throws BusinessLogicException
	{
		TituloEntity Titulo = persistence.find( id );
		if( Titulo != null )
		{
			return Titulo;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Titulo con el id %s", id ));
	}
    
    public TituloEntity updateTitulo (TituloEntity entity, Long id) throws BusinessLogicException
    {
        TituloEntity TituloActual = persistence.find(id);
        
        if (!entity.getName().equals(TituloActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Titulo");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteTitulo (Long Titulo) throws BusinessLogicException
    {
        if (persistence.find(Titulo) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Titulo que no existe");
        }
        else 
            persistence.delete(Titulo);
    }
}
