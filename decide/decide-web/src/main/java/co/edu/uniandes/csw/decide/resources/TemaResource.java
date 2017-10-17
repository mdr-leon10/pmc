/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.TemaDTO;
import co.edu.uniandes.csw.decide.ejb.TemaLogic;
import co.edu.uniandes.csw.decide.entities.TemaEntity;
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
@Path( "/temas" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class TemaResource {
    
    @Inject
    private TemaLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Tema en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Tema
	 * @return DTO con la información del Tema
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public TemaDTO createTema( TemaDTO dto ) throws BusinessLogicException
	{
		return new TemaDTO( logic.createTema( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Temas que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Temas que hacen parte del sistema
	 */
	@GET
	public List<TemaDTO> getTemas( )
	{
		return listEntity2DTO( logic.getTemas( ) );
	}
	
	/**
	 * Retorna un Tema cuyo id es dado por parámetro
	 *
	 * @param id Id del Tema en interés
	 * @return Tema cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Tema con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public TemaDTO getTema( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new TemaDTO( logic.getTema( id ) );
	}
	
	/**
	 * Actualiza un Tema cuyo id es dado por parámetro
	 *
	 * @param id  Id del Tema a ser modificado
	 * @param dto DTO con la nueva información del Tema
	 * @return DTO con la nueva información del Tema
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public TemaDTO updateTema( @PathParam( "id" ) Long id, TemaDTO dto ) throws BusinessLogicException
	{
                
            TemaEntity entity = dto.toEntity();
            return new TemaDTO (logic.updateTema( entity, id ));
	}
	
	/**
	 * Elimina un Tema, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Tema a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteTema( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deleteTema( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<TemaDTO> listEntity2DTO( List<TemaEntity> entityList )
	{
		List<TemaDTO> list = new LinkedList<>( );
		
		for( TemaEntity entity : entityList )
		{
			list.add( new TemaDTO( entity ) );
		}
		return list;
	}
    
}
