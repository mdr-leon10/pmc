/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.CargoEntity;

/**
 *
 * @author mdr.leon10
 */
public class CargoDTO {
    
    private Long id;
    private String name;
    private String entidad;
    private Integer tipo;
    
    public CargoDTO()
    {
        
    }
    
    public CargoDTO(CargoEntity cargo)
    {
        if (cargo != null)
        {
            this.id = cargo.getId();
            this.entidad = cargo.getEntidad();
            this.name = cargo.getName();
            this.tipo = cargo.getTipo();
        }
    }
    
    public CargoEntity toEntity()
    {
        CargoEntity entity = new CargoEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setEntidad(this.entidad);
        entity.setTipo(this.tipo);
        
        return entity;
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

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
