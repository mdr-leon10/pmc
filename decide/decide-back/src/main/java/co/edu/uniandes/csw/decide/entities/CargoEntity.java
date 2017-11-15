/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author mdr.leon10
 */
@Entity
public class CargoEntity implements Serializable {
    
    public static final Integer PRIVADO = 1;
    public static final Integer JUDICIAL = 2;
    public static final Integer LEGISLATIVO = 3;
    public static final Integer EJECUTIVO = 4;
    
    //Nombre de la entidad en la que obtuvo la experiencia.
    private String entidad;
       
    //Atributo para el tipo de experiencia, publica o privada.
    private Integer tipo;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToOne
    private PoliticoEntity politico;

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

    public PoliticoEntity getPolitico() {
        return politico;
    }

    public void setPolitico(PoliticoEntity politico) {
        this.politico = politico;
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
