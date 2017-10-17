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
public class ProyectoEntity extends BaseEntity implements Serializable {
    
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
