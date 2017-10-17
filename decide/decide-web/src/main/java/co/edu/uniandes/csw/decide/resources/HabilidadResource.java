/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.HabilidadDTO;
import co.edu.uniandes.csw.decide.ejb.HabilidadLogic;
import co.edu.uniandes.csw.decide.entities.HabilidadEntity;
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
@Path( "/habilidades" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class HabilidadResource {
    
    @Inject
    private HabilidadLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Habilidad en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Habilidad
	 * @return DTO con la información del Habilidad
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public HabilidadDTO createHabilidad( HabilidadDTO dto ) throws BusinessLogicException
	{
		return new HabilidadDTO( logic.createHabilidad( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Habilidads que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Habilidads que hacen parte del sistema
	 */
	@GET
	public List<HabilidadDTO> getHabilidads( )
	{
		return listEntity2DTO( logic.getHabilidads( ) );
	}
	
	/**
	 * Retorna un Habilidad cuyo id es dado por parámetro
	 *
	 * @param id Id del Habilidad en interés
	 * @return Habilidad cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Habilidad con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public HabilidadDTO getHabilidad( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new HabilidadDTO( logic.getHabilidad( id ) );
	}
	
	/**
	 * Actualiza un Habilidad cuyo id es dado por parámetro
	 *
	 * @param id  Id del Habilidad a ser modificado
	 * @param dto DTO con la nueva información del Habilidad
	 * @return DTO con la nueva información del Habilidad
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public HabilidadDTO updateHabilidad( @PathParam( "id" ) Long id, HabilidadDTO dto ) throws BusinessLogicException
	{
                
            HabilidadEntity entity = dto.toEntity();
            return new HabilidadDTO (logic.updateHabilidad( entity, id ));
	}
	
	/**
	 * Elimina un Habilidad, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Habilidad a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteHabilidad( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deleteHabilidad( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<HabilidadDTO> listEntity2DTO( List<HabilidadEntity> entityList )
	{
		List<HabilidadDTO> list = new LinkedList<>( );
		
		for( HabilidadEntity entity : entityList )
		{
			list.add( new HabilidadDTO( entity ) );
		}
		return list;
	}
    
}
