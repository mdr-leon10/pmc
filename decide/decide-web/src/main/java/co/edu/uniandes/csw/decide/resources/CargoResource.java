/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.CargoDTO;
import co.edu.uniandes.csw.decide.ejb.CargoLogic;
import co.edu.uniandes.csw.decide.entities.CargoEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mdr.leon10
 */
@Path( "/cargos" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class CargoResource {
    
    @Inject
    private CargoLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Cargo en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Cargo
	 * @return DTO con la información del Cargo
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public CargoDTO createCargo( CargoDTO dto ) throws BusinessLogicException
	{
		return new CargoDTO( logic.createCargo( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Cargos que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Cargos que hacen parte del sistema
	 */
	@GET
	public List<CargoDTO> getCargos( )
	{
		return listEntity2DTO( logic.getCargos( ) );
	}
	
	/**
	 * Retorna un Cargo cuyo id es dado por parámetro
	 *
	 * @param id Id del Cargo en interés
	 * @return Cargo cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Cargo con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public CargoDTO getCargo( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new CargoDTO( logic.getCargo( id ) );
	}
	
	/**
	 * Actualiza un Cargo cuyo id es dado por parámetro
	 *
	 * @param id  Id del Cargo a ser modificado
	 * @param dto DTO con la nueva información del Cargo
	 * @return DTO con la nueva información del Cargo
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public CargoDTO updateCargo( @PathParam( "id" ) Long id, CargoDTO dto ) throws BusinessLogicException
	{
                
            CargoEntity entity = dto.toEntity();
            return new CargoDTO (logic.updateCargo( entity, id ));
	}
	
	/**
	 * Elimina un Cargo, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Cargo a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteCargo( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deleteCargo( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<CargoDTO> listEntity2DTO( List<CargoEntity> entityList )
	{
		List<CargoDTO> list = new LinkedList<>( );
		
		for( CargoEntity entity : entityList )
		{
			list.add( new CargoDTO( entity ) );
		}
		return list;
	}
    
}
