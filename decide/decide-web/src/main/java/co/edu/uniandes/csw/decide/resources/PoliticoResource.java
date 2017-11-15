/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.ejb.PoliticoLogic;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.dtos.PoliticoDTO;
import co.edu.uniandes.csw.decide.entities.CargoEntity;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mdr.leon10
 */
@Path( "/politicos" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class PoliticoResource {
    
    @Inject
    private PoliticoLogic logic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Politico en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Politico
	 * @return DTO con la información del Politico
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
	public PoliticoDTO createPolitico( PoliticoDTO dto ) throws BusinessLogicException
	{
		return new PoliticoDTO( logic.createPolitico( dto.toEntity( ) ) );
	}
	
	/**
	 * Retorna los Politicos que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Politicos que hacen parte del sistema
	 */
	@GET
	public List<PoliticoDTO> getPoliticos( )
	{
		return listEntity2DTO( logic.getPoliticos( ) );
	}
	
	/**
	 * Retorna un Politico cuyo id es dado por parámetro
	 *
	 * @param id Id del Politico en interés
	 * @return Politico cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Politico con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
	@Path( "{id: \\d+}" )
	public PoliticoDTO getPolitico( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
		return new PoliticoDTO( logic.getPolitico( id ) );
	}
	
	/**
	 * Actualiza un Politico cuyo id es dado por parámetro
	 *
	 * @param id  Id del Politico a ser modificado
	 * @param dto DTO con la nueva información del Politico
	 * @return DTO con la nueva información del Politico
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
	@Path( "{id: \\d+}" )
	public PoliticoDTO updatePolitico( @PathParam( "id" ) Long id, PoliticoDTO dto ) throws BusinessLogicException
	{
                
            PoliticoEntity entity = dto.toEntity();
            return new PoliticoDTO (logic.updatePolitico( entity, id ));
	}
	
	/**
	 * Elimina un Politico, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Politico a ser eliminado
	 */
	@DELETE
	@Path( "{id: \\d+}" )
	public void deletePolitico( @PathParam( "id" ) Long id ) throws BusinessLogicException
	{
                logic.deletePolitico( id );
	}
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<PoliticoDTO> listEntity2DTO( List<PoliticoEntity> entityList )
	{
		List<PoliticoDTO> list = new LinkedList<>( );
		
		for( PoliticoEntity entity : entityList )
		{
			list.add( new PoliticoDTO( entity ) );
		}
		return list;
	}
        
        @Path("{idPolitico: \\d+}/cargos")
        public Class<CargoResource> getCargosResource(@PathParam("idPolitico") Long idPolitico) throws BusinessLogicException 
        {
            
            PoliticoEntity entity = logic.getPolitico(idPolitico);
            
            if (entity == null)
            {
                throw new WebApplicationException("No existe un Politico con el id: " + idPolitico + ".", 404);
            }
            
            return CargoResource.class;
            
        }
        
        @Path("{idPolitico: \\d+}/investigaciones")
        public Class<InvestigacionResource> getInvestigacionesResource(@PathParam("idPolitico") Long idPolitico) throws BusinessLogicException 
        {
            PoliticoEntity entity = logic.getPolitico(idPolitico);
                 
            if (entity == null)
            {
                throw new WebApplicationException("No existe un Politico con el id: " + idPolitico + ".", 404);
            }
                return InvestigacionResource.class;
        }
        
        @Path("{idPolitico: \\d+}/propuestas")
        public Class<PropuestaResource> getPropuestaResource(@PathParam("idPolitico") Long idPolitico) throws BusinessLogicException 
        {
            PoliticoEntity entity = logic.getPolitico(idPolitico);
                 
            if (entity == null)
            {
                throw new WebApplicationException("No existe un Politico con el id: " + idPolitico + ".", 404);
            }
                return PropuestaResource.class;
        }
        
        @Path("{idPolitico: \\d+}/titulos")
        public Class<TituloResource> getTituloResource(@PathParam("idPolitico") Long idPolitico) throws BusinessLogicException 
        {
            PoliticoEntity entity = logic.getPolitico(idPolitico);
                 
            if (entity == null)
            {
                throw new WebApplicationException("No existe un Politico con el id: " + idPolitico + ".", 404);
            }
                return TituloResource.class;
        }
    
}
