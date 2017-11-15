/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.decide.dtos;

import co.edu.uniandes.csw.decide.entities.CargoEntity;
import co.edu.uniandes.csw.decide.entities.InvestigacionEntity;
import co.edu.uniandes.csw.decide.entities.PoliticoEntity;
import co.edu.uniandes.csw.decide.entities.PropuestaEntity;
import co.edu.uniandes.csw.decide.entities.TituloEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mdr.leon10
 */
public class PoliticoDetailDTO extends PoliticoDTO
{
    private List<CargoDTO> cargos;
    private List<InvestigacionDTO> investigaciones;
    private List<PropuestaDTO> propuestas;
    private List <TituloDTO> titulos;
    
    public PoliticoDetailDTO ()
    {
        super();
    }
    
    public PoliticoDetailDTO(PoliticoEntity entity)
    {
        super(entity);
        if(entity != null)
        {
            
            if(entity.getCargosRealizados() != null)
            {  
                cargos = new ArrayList<>();
                for (CargoEntity cargo : entity.getCargosRealizados()) 
                {
                    cargos.add(new CargoDTO(cargo));
                }
            }
            
            if(entity.getInvestigaciones()!= null)
            {
                investigaciones = new ArrayList<>();
                for (InvestigacionEntity investigacion : entity.getInvestigaciones()) {
                    investigaciones.add(new InvestigacionDTO(investigacion));
                }
            }
            
            
            if(entity.getTitulos() != null)
            {
                titulos = new ArrayList<>();
                for (TituloEntity titulo : entity.getTitulos()) 
                {
                    titulos.add(new TituloDTO(titulo));
                }
            }
            
            if(entity.getPropuestas() != null)
            {
                propuestas = new ArrayList<>();
                for (PropuestaEntity propuesta : entity.getPropuestas()) 
                {
                    propuestas.add(new PropuestaDTO(propuesta));
                }
            }
        }
    }
    
    @Override
    public PoliticoEntity toEntity() 
    {
        PoliticoEntity entity = super.toEntity();
        
        if(this.getCargo() != null)
        {            
            List<CargoEntity> cargoE = new ArrayList<>( );
            for(CargoDTO cargo : this.getCargo())
            {
                cargoE.add(cargo.toEntity());
            }
            entity.setCargosRealizados(cargoE);
        }
        
        if(this.getInvestigaciones() != null)
        {
            List<InvestigacionEntity> investigacionesE = new ArrayList<>( );
            for(InvestigacionDTO investigacion: this.getInvestigaciones())
            {
                investigacionesE.add(investigacion.toEntity());
            }
            entity.setInvestigaciones(investigacionesE);
        }
        
        if(this.getTitulo() != null)
        {
            List<TituloEntity> titulosE = new ArrayList<>( );
            for(TituloDTO titulo: this.getTitulo())
            {
                titulosE.add(titulo.toEntity());
            }
            entity.setTitulos(titulosE);
        }
        
        if(this.getPropuestas() != null)
        {
            List<PropuestaEntity> propuestasE = new ArrayList<>( );
            for(PropuestaDTO propuesta: this.getPropuestas())
            {
                propuestasE.add(propuesta.toEntity());
            }
            entity.setPropuestas(propuestasE);
        }
        
        return entity;
        
    }

    public List<CargoDTO> getCargo() {
        return cargos;
    }

    public void setCargo(List<CargoDTO> cargo) {
        this.cargos = cargo;
    }

    public List<InvestigacionDTO> getInvestigaciones() {
        return investigaciones;
    }

    public void setInvestigaciones(List<InvestigacionDTO> investigaciones) {
        this.investigaciones = investigaciones;
    }

    public List<PropuestaDTO> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(List<PropuestaDTO> propuestas) {
        this.propuestas = propuestas;
    }

    public List<TituloDTO> getTitulo() {
        return titulos;
    }

    public void setTitulo(List<TituloDTO> titulo) {
        this.titulos = titulo;
    }
    
    
}
