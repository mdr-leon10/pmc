/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.resources;

import co.edu.uniandes.csw.decide.dtos.PoliticoDTO;
import co.edu.uniandes.csw.decide.dtos.TituloDTO;
import co.edu.uniandes.csw.decide.ejb.PoliticoLogic;
import co.edu.uniandes.csw.decide.ejb.TituloLogic;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.entities.TituloEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author mdr.leon10
 */

@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class TituloResource {
    
    @Inject
    private TituloLogic logic;
    
    @Inject
    private PoliticoLogic polLogic;
    
    @Context
    private HttpServletResponse response;
    
    /**
	 * Crea un Titulo en el sistema, cuya información es dada por parámetro a través de un DTO
	 *
	 * @param dto DTO con la información del Titulo
	 * @return DTO con la información del Titulo
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@POST
        public TituloDTO createTitulo(@PathParam("idPolitico") Long idPolitico,TituloDTO dto) throws BusinessLogicException 
        {
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if(pol==null)
            {
                throw new WebApplicationException("El politico no existe", 404);
            }
            dto.setPolitico(new PoliticoDTO(polLogic.getPolitico(idPolitico)));
            return new TituloDTO(logic.createTitulo(dto.toEntity()));
        }
	
	/**
	 * Retorna los Titulos que hacen parte del Sistema
	 *
	 * @return Lista de DTO's con la información de los Titulos que hacen parte del sistema
	 */
	@GET
	public List<TituloDTO> getTitulos( @PathParam("idPolitico") Long idPolitico ) throws BusinessLogicException
	{
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if (pol == null)
            {
                throw new WebApplicationException("El politico no existe",404);
            }
            return listEntity2DTO( logic.getTitulos(idPolitico) );
	}
 
	
	/**
	 * Retorna un Titulo cuyo id es dado por parámetro
	 *
	 * @param id Id del Titulo en interés
	 * @return Titulo cuyo id coincide con el dado por parámetro
	 * @throws BusinessLogicException Si el Titulo con el id dado, no existe en el sistema (404 NOT FOUND)
	 */
    @GET
    @Path("{id: \\d+}")
    public TituloDTO getTitulo(@PathParam("idPolitico") Long idPolitico, @PathParam("id") Long id) throws BusinessLogicException
    {   
        PoliticoEntity guia = polLogic.getPolitico(idPolitico);
        if(guia==null)
        {
            throw new WebApplicationException("El politico no existe", 404);
        }
        TituloEntity entity = logic.getTitulo(idPolitico, id);
        if(entity==null)
        {
            throw new WebApplicationException("El titulo pedido no existe",404);
        }  
        return new TituloDTO(entity);
    }
	
	/**
	 * Actualiza un Titulo cuyo id es dado por parámetro
	 *
	 * @param id  Id del Titulo a ser modificado
	 * @param dto DTO con la nueva información del Titulo
	 * @return DTO con la nueva información del Titulo
	 * @throws BusinessLogicException Si no cumple con los requisitos mínimos para su creación. (400 BAD REQUEST)
	 */
	@PUT
        @Path("{id: \\d+}")
        public TituloDTO updateTitulo(@PathParam("idPolitico") Long idPolitico, @PathParam("id") Long id, TituloDTO dto) throws BusinessLogicException
        {  
            PoliticoEntity pol = polLogic.getPolitico(idPolitico);
            if(pol==null)
            {
                throw new WebApplicationException("El Politico no existe", 404);
            }
            TituloEntity entity = dto.toEntity();
            TituloEntity result = logic.updateTitulo(entity, id);
            if(result==null)
            {
                throw new WebApplicationException("El Titulo no existe",404);
            }
            return new TituloDTO(result);
    }
	
	/**
	 * Elimina un Titulo, del sistema, cuyo id es dado por parámetro
	 *
	 * @param id Id del Titulo a ser eliminado
	 */
	@DELETE
        @Path("{id: \\d+}")
        public void deleteTitulo(@PathParam("idPolitico") Long idPolitico,@PathParam("id") Long id) throws BusinessLogicException
        {  
            TituloEntity result = logic.getTitulo( idPolitico, id );
            if(result==null)
            {
                 throw new WebApplicationException("La calificación no existe",404);
            }
            logic.deleteTitulo( id,idPolitico );    
        }
	
	/**
	 * Método encargado de realizar la transformación de Entity a DTO
	 *
	 * @param entityList Lista a ser transformada
	 * @return Lista de elementos DTO
	 */
	private List<TituloDTO> listEntity2DTO( List<TituloEntity> entityList )
	{
		List<TituloDTO> list = new LinkedList<>( );
		
		for( TituloEntity entity : entityList )
		{
			list.add( new TituloDTO( entity ) );
		}
		return list;
	}
    
}
