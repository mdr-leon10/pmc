/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.PropuestaEntity;

/**
 *
 * @author mdr.leon10
 */
public class PropuestaDTO {
    
    private Long id;
    
    private String name;
    
    private Integer numerales;

    public PropuestaDTO() {
        
    }
    
    public PropuestaDTO(PropuestaEntity e) {
        
        this.id = e.getId();
        this.name = e.getName();
        this.numerales = e.getNumerales();    
    }
    
    public PropuestaEntity toEntity()
    {
        PropuestaEntity e = new PropuestaEntity();
        e.setId(this.id);
        e.setName(this.name);
        e.setNumerales(this.numerales);
        
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

    public Integer getNumerales() {
        return numerales;
    }

    public void setNumerales(Integer numerales) {
        this.numerales = numerales;
    }
    
    
    
}
