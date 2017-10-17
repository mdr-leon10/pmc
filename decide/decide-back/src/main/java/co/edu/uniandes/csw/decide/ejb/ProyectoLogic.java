/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;
import co.edu.uniandes.csw.decide.entities.ProyectoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.ProyectoPersistence;
import java.util.List;
import javax.inject.Inject;
/**
 *
 * @author mdr.leon10
 */
public class ProyectoLogic {
    
    @Inject
    private ProyectoPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public ProyectoEntity createProyecto(ProyectoEntity entity) throws BusinessLogicException {
        if (persistence.findByName(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Proyecto " + entity.getName() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los Proyectos existentes en la base de datos.
     * @return una lista de Proyectos.
     */
    public List<ProyectoEntity> getProyectos() {
        return persistence.findAll();
    }
    
    public ProyectoEntity getProyecto( Long id ) throws BusinessLogicException
	{
		ProyectoEntity Proyecto = persistence.find( id );
		if( Proyecto != null )
		{
			return Proyecto;
		}
                else
		throw new BusinessLogicException( String.format( "No existe el Proyecto con el id %s", id ));
	}
    
    public ProyectoEntity updateProyecto (ProyectoEntity entity, Long id) throws BusinessLogicException
    {
        ProyectoEntity ProyectoActual = persistence.find(id);
        
        if (!entity.getName().equals(ProyectoActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Proyecto");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteProyecto (Long Proyecto) throws BusinessLogicException
    {
        if (persistence.find(Proyecto) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un Proyecto que no existe");
        }
        else 
            persistence.delete(Proyecto);
    }
    
}
