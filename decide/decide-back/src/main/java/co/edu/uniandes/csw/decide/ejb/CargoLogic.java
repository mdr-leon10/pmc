/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;

import co.edu.uniandes.csw.decide.entities.CargoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.CargoPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mdr.leon10
 */
public class CargoLogic {
    
    @Inject
    private CargoPersistence persistence;
    
    /**
     *
     * @param entity
     * @return
     * @throws BusinessLogicException
     */
    public CargoEntity createCargo(CargoEntity entity) throws BusinessLogicException {
        if (persistence.findByNameAndEntidad(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el cargo " + entity.getName() + " en la entidad " + entity.getEntidad() + " pues este ya existe");
        return entity;
    }

    /**
     * Obtener todos los cargos existentes en la base de datos.
     * @return una lista de Cargos.
     */
    public List<CargoEntity> getCargos() {
        return persistence.findAll();
    }
    
    public CargoEntity getCargo( Long id ) throws BusinessLogicException
	{
		CargoEntity cargo = persistence.find( id );
		if( cargo != null )
		{
			return cargo;
		}
		throw new BusinessLogicException( String.format( "No existe el cargo con el id %s", id ));
	}
    
    public CargoEntity updateCargo (CargoEntity entity, Long id) throws BusinessLogicException
    {
        CargoEntity cargoActual = persistence.find(id);
        
        if (!entity.getName().equals(cargoActual.getName()) && !entity.getEntidad().equals(cargoActual.getEntidad()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre o entidad de un cargo");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
            
    public void deleteCargo (Long cargo) throws BusinessLogicException
    {
        if (persistence.find(cargo) == null)
        {
            throw new BusinessLogicException("No se puede eliminar un cargo que no existe");
        }
        else 
            persistence.delete(cargo);
    }
            
}
