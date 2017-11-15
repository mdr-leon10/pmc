/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.decide.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ISIS2603
 */
@Entity
public class PoliticoEntity implements Serializable 
{
    private Long cedula;
    private String ciudadNacimiento;
    private Integer anoNacimiento;
    private String partido;
    
//    @ManyToOne
//    private List<CargoEntity> cargosRealizados = new ArrayList<CargoEntity>();
    
//    @ManyToOne
//    private List<InvestigacionEntity> investigaciones = new ArrayList<InvestigacionEntity>();
//    
//    @ManyToOne
//    private List<PropuestaEntity> propuestas = new ArrayList<PropuestaEntity>();
//    
//    @ManyToOne
//    private List<TituloEntity> titulos = new ArrayList<TituloEntity>();
    
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

//    public List<CargoEntity> getCargosRealizados() {
//        return cargosRealizados;
//    }
//
//    public void setCargosRealizados(List<CargoEntity> cargosRealizados) {
//        this.cargosRealizados = cargosRealizados;
//    }

//    public List<InvestigacionEntity> getInvestigaciones() {
//        return investigaciones;
//    }
//
//    public void setInvestigaciones(List<InvestigacionEntity> investigaciones) {
//        this.investigaciones = investigaciones;
//    }
//
//    public List<PropuestaEntity> getPropuestas() {
//        return propuestas;
//    }
//
//    public void setPropuestas(List<PropuestaEntity> propuestas) {
//        this.propuestas = propuestas;
//    }
//
//    public List<TituloEntity> getTitulos() {
//        return titulos;
//    }
//
//    public void setTitulos(List<TituloEntity> titulos) {
//        this.titulos = titulos;
//    }
   
}
