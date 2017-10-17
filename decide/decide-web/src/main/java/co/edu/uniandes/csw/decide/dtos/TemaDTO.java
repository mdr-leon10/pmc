/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.TemaEntity;

/**
 *
 * @author mdr.leon10
 */
public class TemaDTO {
    
    private Long id;
    private String name;
    private String descripcion;

    public TemaDTO() {
    }
    
     public TemaDTO(TemaEntity e) {
         
         this.id = e.getId();
         this.name = e.getName();
         this.descripcion = e.getDescripcion();
    }
     
     public TemaEntity toEntity ()
     {
         TemaEntity e = new TemaEntity();
         e.setId(this.id);
         e.setName(this.name);
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
