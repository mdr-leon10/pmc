/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.ProyectoDTO;
import co.edu.uniandes.csw.decide.ejb.ProyectoLogic;
import co.edu.uniandes.csw.decide.entities.ProyectoEntity;
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
@Path( "/proyectos" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class proyectoResource {
    
    @Inject
    private ProyectoLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Proyecto en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Proyecto
	 * @return DTO con la información del Proyecto
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public ProyectoDTO createProyecto( ProyectoDTO dto ) throws BusinessLogicException
	{
		return new ProyectoDTO( logic.createProyecto( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Proyectos que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Proyectos que hacen parte del sistema
	 */
	@GET
	public List<ProyectoDTO> getProyectos( )
	{
		return listEntity2DTO( logic.getProyectos( ) );
	}
	
	/**
	 * Retorna un Proyecto cuyo id es dado por parámetro
	 *
	 * @param id Id del Proyecto en interés
	 * @return Proyecto cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Proyecto con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public ProyectoDTO getProyecto( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new ProyectoDTO( logic.getProyecto( id ) );
	}
	
	/**
	 * Actualiza un Proyecto cuyo id es dado por parámetro
	 *
	 * @param id  Id del Proyecto a ser modificado
	 * @param dto DTO con la nueva información del Proyecto
	 * @return DTO con la nueva información del Proyecto
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public ProyectoDTO updateProyecto( @PathParam( "id" ) Long id, ProyectoDTO dto ) throws BusinessLogicException
	{
                
            ProyectoEntity entity = dto.toEntity();
            return new ProyectoDTO (logic.updateProyecto( entity, id ));
	}
	
	/**
	 * Elimina un Proyecto, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Proyecto a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteProyecto( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deleteProyecto( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<ProyectoDTO> listEntity2DTO( List<ProyectoEntity> entityList )
	{
		List<ProyectoDTO> list = new LinkedList<>( );
		
		for( ProyectoEntity entity : entityList )
		{
			list.add( new ProyectoDTO( entity ) );
		}
		return list;
	}
    
}
