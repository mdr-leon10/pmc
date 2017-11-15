/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.PoliticoEntity;

/**
 *
 * @author mdr.leon10
 */
public class PoliticoDTO {
    
    private Long id;
    private String name;
    private Long cedula;
    private String ciudadNacimiento;
    private Integer anoNacimiento;
    private String partido;

    public PoliticoDTO() {
    }
    
    public PoliticoDTO(PoliticoEntity e) {
        
        this.id = e.getId();
        this.name = e.getName();
        this.cedula = e.getCedula();
        this.ciudadNacimiento = e.getCiudadNacimiento();
        this.anoNacimiento = e.getAnoNacimiento();
        this.partido = e.getPartido();
    }
    
    public PoliticoEntity toEntity()
    {
        PoliticoEntity e = new PoliticoEntity();
        e.setId(this.id);
        e.setCedula(this.cedula);
        e.setName(this.name);
        e.setAnoNacimiento(this.anoNacimiento);
        e.setCiudadNacimiento(this.ciudadNacimiento);
        e.setPartido(this.partido);
        
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

    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(Integer anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }
    
    
}
