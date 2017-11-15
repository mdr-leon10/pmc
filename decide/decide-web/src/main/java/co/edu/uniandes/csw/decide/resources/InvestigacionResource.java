/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;


import co.edu.uniandes.csw.decide.dtos.InvestigacionDTO;
import co.edu.uniandes.csw.decide.dtos.PoliticoDTO;
import co.edu.uniandes.csw.decide.ejb.InvestigacionLogic;
import co.edu.uniandes.csw.decide.ejb.PoliticoLogic;
import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mdr.leon10
 */
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class InvestigacionResource {
    
    @Inject
    private InvestigacionLogic logic;
    
    @Inject
    private PoliticoLogic polLogic;
    
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
        public InvestigacionDTO createInvestigacion(@PathParam("idPolitico") Long idPolitico,InvestigacionDTO dto) throws BusinessLogicException 
        {
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if(pol==null)
            {
                throw new WebApplicationException("El politico no existe", 404);
            }
            dto.setPolitico(new PoliticoDTO(polLogic.getPolitico(idPolitico)));
            return new InvestigacionDTO(logic.createInvestigacion(dto.toEntity()));
        }
	
	/**
	 * Retorna los Investigacions que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Investigacions que hacen parte del sistema
	 */
	@GET
	public List<InvestigacionDTO> getInvestigaciones( @PathParam("idPolitico") Long idPolitico ) throws BusinessLogicException
	{
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if (pol == null)
            {
                throw new WebApplicationException("El politico no existe",404);
            }
            return listEntity2DTO( logic.getInvestigaciones(idPolitico) );
	}
	
	/**
	 * Retorna un Investigacion cuyo id es dado por parámetro
	 *
	 * @param id Id del Investigacion en interés
	 * @return Investigacion cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Investigacion con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
    @Path("{id: \\d+}")
    public InvestigacionDTO getInvestigacion(@PathParam("idPolitico") Long idPolitico, @PathParam("id") Long id) throws BusinessLogicException
    {   
        PoliticoEntity guia = polLogic.getPolitico(idPolitico);
        if(guia==null)
        {
            throw new WebApplicationException("El politico no existe", 404);
        }
        InvestigacionEntity entity = logic.getInvestigacion( id, idPolitico );
        if(entity==null)
        {
            throw new WebApplicationException("La investigacion pedida no existe",404);
        }  
        return new InvestigacionDTO(entity);
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
        @Path("{id: \\d+}")
        public InvestigacionDTO updateCalificacion(@PathParam("idPolitico") Long idPolitico, @PathParam("id") Long id, InvestigacionDTO dto) throws BusinessLogicException
        {  
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if(pol==null)
            {
                throw new WebApplicationException("El Politico no existe", 404);
            }
            InvestigacionEntity entity = dto.toEntity();
            InvestigacionEntity result = logic.updateInvestigacion(entity, id);
            if(result==null)
            {
                throw new WebApplicationException("La Investigacion no existe",404);
            }
            return new InvestigacionDTO(result);
    }
	
	
	/**
	 * Elimina un Investigacion, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Investigacion a ser eliminado
	 */
	@DELETE
        @Path("{id: \\d+}")
        public void deleteInvestigacion(@PathParam("idPolitico") Long idPolitico,@PathParam("id") Long id) throws BusinessLogicException
        {  
            InvestigacionEntity result = logic.getInvestigacion( id, idPolitico );
            if(result==null)
            {
                 throw new WebApplicationException("La calificación no existe",404);
            }
            logic.deleteInvestigacion(idPolitico,id);    
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
