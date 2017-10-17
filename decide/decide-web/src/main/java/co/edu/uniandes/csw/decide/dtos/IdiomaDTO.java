/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.IdiomaEntity;

/**
 *
 * @author mdr.leon10
 */
public class IdiomaDTO 
{
    private Long id;
    private String name;
    private String nivel;
    
    public IdiomaDTO()
    {
        
    }
    
    public IdiomaDTO (IdiomaEntity entity)
    {
        this.id = entity.getId();
        this.name = entity.getName();
        this.nivel = entity.getNivel();
    }
    
    public IdiomaEntity toEntity ()
    {
        IdiomaEntity e = new IdiomaEntity();
        e.setId(this.id);
        e.setName(this.name);
        e.setNivel(this.nivel);
        
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
