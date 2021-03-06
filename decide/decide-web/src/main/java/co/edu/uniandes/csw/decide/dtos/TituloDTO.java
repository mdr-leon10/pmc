/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.entities.TituloEntity;

/**
 *
 * @author mdr.leon10
 */
public class TituloDTO 
{
    private Long id;
    private String name;
    private String universidad;
    private PoliticoDTO politico;

    public TituloDTO() {
    }
    
    public TituloDTO(TituloEntity e) {
        this.id = e.getId();
        this.name = e.getName();
        this.universidad = e.getUniversidad();
        this.politico = politicoEtoDTO(e.getPolitico());
    }
    
    public TituloEntity toEntity()
    {
        TituloEntity e = new TituloEntity();
        e.setId(this.id);
        e.setName(this.name);
        e.setUniversidad(this.universidad);
        e.setPolitico(this.politico.toEntity());
                
        
        return e;
    }
    
    public PoliticoDTO politicoEtoDTO (PoliticoEntity entity)
    {
        PoliticoDTO pol = new PoliticoDTO(entity);
        return pol;
    }

    public PoliticoDTO getPolitico() {
        return politico;
    }

    public void setPolitico(PoliticoDTO politico) {
        this.politico = politico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }


    
    
}
