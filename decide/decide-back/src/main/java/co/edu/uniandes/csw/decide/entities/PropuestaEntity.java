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
public class PropuestaEntity extends BaseEntity implements Serializable {
    
    private Integer numerales;

    public Integer getNumerales() {
        return numerales;
    }

    public void setNumerales(Integer numerales) {
        this.numerales = numerales;
    }
    
    
    
}
