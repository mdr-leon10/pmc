/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.IdiomaDTO;
import co.edu.uniandes.csw.decide.ejb.IdiomaLogic;
import co.edu.uniandes.csw.decide.entities.IdiomaEntity;
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
@Path( "/idiomas" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class IdiomaResource {
    
    @Inject
    private IdiomaLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Idioma en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Idioma
	 * @return DTO con la información del Idioma
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public IdiomaDTO createIdioma( IdiomaDTO dto ) throws BusinessLogicException
	{
		return new IdiomaDTO( logic.createIdioma( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Idiomas que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Idiomas que hacen parte del sistema
	 */
	@GET
	public List<IdiomaDTO> getIdiomas( )
	{
		return listEntity2DTO( logic.getIdiomas( ) );
	}
	
	/**
	 * Retorna un Idioma cuyo id es dado por parámetro
	 *
	 * @param id Id del Idioma en interés
	 * @return Idioma cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Idioma con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public IdiomaDTO getIdioma( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new IdiomaDTO( logic.getIdioma( id ) );
	}
	
	/**
	 * Actualiza un Idioma cuyo id es dado por parámetro
	 *
	 * @param id  Id del Idioma a ser modificado
	 * @param dto DTO con la nueva información del Idioma
	 * @return DTO con la nueva información del Idioma
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public IdiomaDTO updateIdioma( @PathParam( "id" ) Long id, IdiomaDTO dto ) throws BusinessLogicException
	{
                
            IdiomaEntity entity = dto.toEntity();
            return new IdiomaDTO (logic.updateIdioma( entity, id ));
	}
	
	/**
	 * Elimina un Idioma, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Idioma a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteIdioma( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deleteIdioma( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<IdiomaDTO> listEntity2DTO( List<IdiomaEntity> entityList )
	{
		List<IdiomaDTO> list = new LinkedList<>( );
		
		for( IdiomaEntity entity : entityList )
		{
			list.add( new IdiomaDTO( entity ) );
		}
		return list;
	}
    
}
