/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author mdr.leon10
 */
@Entity
public class CargoEntity extends BaseEntity implements Serializable {
    
    public static final Integer PRIVADO = 1;
    public static final Integer JUDICIAL = 2;
    public static final Integer LEGISLATIVO = 3;
    public static final Integer EJECUTIVO = 4;
    
    //Nombre de la entidad en la que obtuvo la experiencia.
    private String entidad;
    
    //Descripción del cargo en el que obtuvo la experiencia.
    private String descripción;
   
    //Atributo para el tipo de experiencia, publica o privada.
    private Integer tipo;

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
}
