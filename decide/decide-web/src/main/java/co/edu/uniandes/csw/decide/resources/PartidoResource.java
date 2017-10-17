/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.PartidoDTO;
import co.edu.uniandes.csw.decide.ejb.PartidoLogic;
import co.edu.uniandes.csw.decide.entities.PartidoEntity;
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
@Path( "/partidos" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class PartidoResource {
    @Inject
    private PartidoLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Partido en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Partido
	 * @return DTO con la información del Partido
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public PartidoDTO createPartido( PartidoDTO dto ) throws BusinessLogicException
	{
		return new PartidoDTO( logic.createPartido( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Partidos que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Partidos que hacen parte del sistema
	 */
	@GET
	public List<PartidoDTO> getPartidos( )
	{
		return listEntity2DTO( logic.getPartidos( ) );
	}
	
	/**
	 * Retorna un Partido cuyo id es dado por parámetro
	 *
	 * @param id Id del Partido en interés
	 * @return Partido cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Partido con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public PartidoDTO getPartido( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new PartidoDTO( logic.getPartido( id ) );
	}
	
	/**
	 * Actualiza un Partido cuyo id es dado por parámetro
	 *
	 * @param id  Id del Partido a ser modificado
	 * @param dto DTO con la nueva información del Partido
	 * @return DTO con la nueva información del Partido
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public PartidoDTO updatePartido( @PathParam( "id" ) Long id, PartidoDTO dto ) throws BusinessLogicException
	{
                
            PartidoEntity entity = dto.toEntity();
            return new PartidoDTO (logic.updatePartido( entity, id ));
	}
	
	/**
	 * Elimina un Partido, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Partido a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deletePartido( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deletePartido( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<PartidoDTO> listEntity2DTO( List<PartidoEntity> entityList )
	{
		List<PartidoDTO> list = new LinkedList<>( );
		
		for( PartidoEntity entity : entityList )
		{
			list.add( new PartidoDTO( entity ) );
		}
		return list;
	}
    
}
