/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.ProyectoEntity;

/**
 *
 * @author mdr.leon10
 */
public class ProyectoDTO {
    
    private Long id;
    private String name;
    private String descripcion;
    
    public ProyectoDTO ()
    {
        
    }
    
    public ProyectoDTO (ProyectoEntity e)
    {
        this.id = e.getId();
        this.name = e.getName();
        this.descripcion = e.getDescripcion();
    }
    
    public ProyectoEntity toEntity()
    {
        ProyectoEntity e = new ProyectoEntity();
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
