/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.PartidoEntity;

/**
 *
 * @author mdr.leon10
 */
public class PartidoDTO {
        
        private Long id;
    private String name;
    private String descripcion;
    
    public PartidoDTO()
    {
        
    }
    
    public PartidoDTO (PartidoEntity entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.descripcion = entity.getDescripcion();
    }
    
    public PartidoEntity toEntity ()
    {
        PartidoEntity e = new PartidoEntity();
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
