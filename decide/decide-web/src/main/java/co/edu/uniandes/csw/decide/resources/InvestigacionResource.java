/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;


import co.edu.uniandes.csw.decide.dtos.InvestigacionDTO;
import co.edu.uniandes.csw.decide.ejb.InvestigacionLogic;
import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;
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
@Path( "/investigaciones" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class InvestigacionResource {
    
    @Inject
    private InvestigacionLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Investigacion en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Investigacion
	 * @return DTO con la información del Investigacion
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public InvestigacionDTO createInvestigacion( InvestigacionDTO dto ) throws BusinessLogicException
	{
		return new InvestigacionDTO( logic.createInvestigacion( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Investigacions que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Investigacions que hacen parte del sistema
	 */
	@GET
	public List<InvestigacionDTO> getInvestigacions( )
	{
		return listEntity2DTO( logic.getInvestigacions( ) );
	}
	
	/**
	 * Retorna un Investigacion cuyo id es dado por parámetro
	 *
	 * @param id Id del Investigacion en interés
	 * @return Investigacion cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Investigacion con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public InvestigacionDTO getInvestigacion( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new InvestigacionDTO( logic.getInvestigacion( id ) );
	}
	
	/**
	 * Actualiza un Investigacion cuyo id es dado por parámetro
	 *
	 * @param id  Id del Investigacion a ser modificado
	 * @param dto DTO con la nueva información del Investigacion
	 * @return DTO con la nueva información del Investigacion
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public InvestigacionDTO updateInvestigacion( @PathParam( "id" ) Long id, InvestigacionDTO dto ) throws BusinessLogicException
	{
                
            InvestigacionEntity entity = dto.toEntity();
            return new InvestigacionDTO (logic.updateInvestigacion( entity, id ));
	}
	
	/**
	 * Elimina un Investigacion, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Investigacion a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deleteInvestigacion( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deleteInvestigacion( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<InvestigacionDTO> listEntity2DTO( List<InvestigacionEntity> entityList )
	{
		List<InvestigacionDTO> list = new LinkedList<>( );
		
		for( InvestigacionEntity entity : entityList )
		{
			list.add( new InvestigacionDTO( entity ) );
		}
		return list;
	}
    
}
