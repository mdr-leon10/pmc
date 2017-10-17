/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;

/**
 *
 * @author mdr.leon10
 */
public class InvestigacionDTO {
    
    private Long id;
    private String name;
    private String enteInvestigador;
    private String descripcion;

    public InvestigacionDTO() {
    }
    
     public InvestigacionDTO(InvestigacionEntity e) {
         this.id = e.getId();
         this.name = e.getName();
         this.enteInvestigador = e.getEnteInvestigador();
         this.descripcion = e.getDescripcion();
    }
     
     public InvestigacionEntity toEntity()
     {
         InvestigacionEntity e = new InvestigacionEntity();
         e.setId(this.id);
         e.setName(this.name);
         e.setEnteInvestigador(this.enteInvestigador);
         e.setDescripcion(this.descripcion);
         
         return e;
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
