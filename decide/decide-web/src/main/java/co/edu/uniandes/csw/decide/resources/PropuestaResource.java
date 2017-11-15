/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.PoliticoDTO;
import co.edu.uniandes.csw.decide.dtos.PropuestaDTO;
import co.edu.uniandes.csw.decide.dtos.TituloDTO;
import co.edu.uniandes.csw.decide.ejb.PoliticoLogic;
import co.edu.uniandes.csw.decide.ejb.PropuestaLogic;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.entities.PropuestaEntity;
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
public class PropuestaResource {
    
    @Inject
    private PropuestaLogic logic;
    
    @Inject
    private PoliticoLogic polLogic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Propuesta en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Propuesta
	 * @return DTO con la información del Propuesta
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
        public PropuestaDTO createTitulo(@PathParam("idPolitico") Long idPolitico,PropuestaDTO dto) throws BusinessLogicException 
        {
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if(pol==null)
            {
                throw new WebApplicationException("El politico no existe", 404);
            }
            dto.setPolitico(new PoliticoDTO(polLogic.getPolitico(idPolitico)));
            return new PropuestaDTO(logic.createPropuesta(dto.toEntity()));
        }
	
	/**
	 * Retorna los Propuestas que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Propuestas que hacen parte del sistema
	 */
	@GET
	public List<PropuestaDTO> getPropuestas( @PathParam("idPolitico") Long idPolitico ) throws BusinessLogicException
	{
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if (pol == null)
            {
                throw new WebApplicationException("El politico no existe",404);
            }
            return listEntity2DTO( logic.getPropuestas( idPolitico) );
	}
	
	/**
	 * Retorna un Propuesta cuyo id es dado por parámetro
	 *
	 * @param id Id del Propuesta en interés
	 * @return Propuesta cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Propuesta con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
	@GET
        @Path("{id: \\d+}")
        public PropuestaDTO getPropuesta(@PathParam("idPolitico") Long idPolitico, @PathParam("id") Long id) throws BusinessLogicException
        {   
            PoliticoEntity guia = polLogic.getPolitico(idPolitico);
            if(guia==null)
            {
                throw new WebApplicationException("El politico no existe", 404);
            }
            PropuestaEntity entity = logic.getPropuesta( id, idPolitico );
        
            if(entity==null)
            {
                throw new WebApplicationException("La propuesta pedida no existe",404);
            }  
            return new PropuestaDTO(entity);
        }
	
	/**
	 * Actualiza un Propuesta cuyo id es dado por parámetro
	 *
	 * @param id  Id del Propuesta a ser modificado
	 * @param dto DTO con la nueva información del Propuesta
	 * @return DTO con la nueva información del Propuesta
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
        @Path("{id: \\d+}")
        public PropuestaDTO updatePropuesta(@PathParam("idPolitico") Long idPolitico, @PathParam("id") Long id, PropuestaDTO dto) throws BusinessLogicException
        {  
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if(pol==null)
            {
                throw new WebApplicationException("El Politico no existe", 404);
            }
            PropuestaEntity entity = dto.toEntity();
            PropuestaEntity result = logic.updatePropuesta(entity, id);
            if(result==null)
            {
                throw new WebApplicationException("El Cargo no existe",404);
            }
            return new PropuestaDTO(result);
    }
	
	/**
	 * Elimina un Propuesta, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Propuesta a ser eliminado
	 */
	@DELETE
        @Path("{id: \\d+}")
        public void deletePropuesta(@PathParam("idPolitico") Long idPolitico,@PathParam("id") Long id) throws BusinessLogicException
        {  
            PropuestaEntity result = logic.getPropuesta( id, idPolitico );
            if(result==null)
            {
                 throw new WebApplicationException("La calificación no existe",404);
            }
            logic.deletePropuesta( id, idPolitico );    
        }
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<PropuestaDTO> listEntity2DTO( List<PropuestaEntity> entityList )
	{
		List<PropuestaDTO> list = new LinkedList<>( );
		
		for( PropuestaEntity entity : entityList )
		{
			list.add( new PropuestaDTO( entity ) );
		}
		return list;
	}
    
}
