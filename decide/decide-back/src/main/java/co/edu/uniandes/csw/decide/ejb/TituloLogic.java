/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.ejb;


import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.entities.TituloEntity;
import co.edu.uniandes.csw.decide.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.decide.persistence.TituloPersistence;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 *
 * @author mdr.leon10
 */
public class TituloLogic {
    
    @Inject
    private TituloPersistence persistence;
    
    @Inject private PoliticoLogic pol;

    
   public List<TituloEntity> getTitulos(Long politicoId) throws BusinessLogicException
    {
            PoliticoEntity politico = pol.getPolitico(politicoId);
            return politico.getTitulos();    
    }
    
    public TituloEntity createTitulo(TituloEntity entity) throws BusinessLogicException {
        
        if (persistence.findByNameAndUniversidad(entity) == null)
        {
            persistence.create(entity);
        }
        else
            throw new BusinessLogicException("No se puede crear el Titulo " + entity.getName() + "en la universidad " + entity.getUniversidad() + " pues este ya existe");
        return entity;
    }
    
     public TituloEntity updateTitulo (TituloEntity entity, Long id) throws BusinessLogicException
    {
        TituloEntity TituloActual = persistence.find(id);
        
        if (!entity.getName().equals(TituloActual.getName()))
        {
            throw new BusinessLogicException("No se puede cambiar el nombre de un Titulo");
        }
        else
            entity.setId(id);
            return persistence.update(entity);
    }
     
    public TituloEntity getTitulo(Long politicoId, Long id) {
        try
        {
            return persistence.find( politicoId, id );
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException("El Titulo no existe");
        }
        
    }
    
    public void deleteTitulo (Long Titulo, Long idPolitico) throws BusinessLogicException
    {
        TituloEntity viejo = getTitulo(idPolitico, Titulo);
        persistence.delete(Titulo);
    }
}
