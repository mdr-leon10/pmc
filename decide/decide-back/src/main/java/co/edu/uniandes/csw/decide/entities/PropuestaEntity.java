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
import javax.persistence.OneToMany;

/**
 *
 * @author mdr.leon10
 */
@Entity
public class PropuestaEntity implements Serializable {
    
    private Integer numerales;
    
//    @OneToMany (mappedBy = "propuestas", targetEntity = PoliticoEntity.class)
//    private PoliticoEntity politico;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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

//    public PoliticoEntity getPolitico() {
//        return politico;
//    }
//
//    public void setPolitico(PoliticoEntity politico) {
//        this.politico = politico;
//    }

    public Integer getNumerales() {
        return numerales;
    }

    public void setNumerales(Integer numerales) {
        this.numerales = numerales;
    }
    
    
    
}
