/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;

/**
 *
 * @author mdr.leon10
 */
public class InvestigacionDTO {
    
    private Long id;
    private String name;
    private String enteInvestigador;
    private String descripcion;
    private PoliticoDTO politico;

    public InvestigacionDTO() {
    }
    
     public InvestigacionDTO(InvestigacionEntity e) {
         this.id = e.getId();
         this.name = e.getName();
         this.enteInvestigador = e.getEnteInvestigador();
         this.descripcion = e.getDescripcion();
         this.politico = politicoEtoDTO(e.getPolitico());
    }
     
     public InvestigacionEntity toEntity()
     {
         InvestigacionEntity e = new InvestigacionEntity();
         e.setId(this.id);
         e.setName(this.name);
         e.setEnteInvestigador(this.enteInvestigador);
         e.setDescripcion(this.descripcion);
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

    public String getEnteInvestigador() {
        return enteInvestigador;
    }

    public void setEnteInvestigador(String enteInvestigador) {
        this.enteInvestigador = enteInvestigador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
