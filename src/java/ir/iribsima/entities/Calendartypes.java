/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "calendartypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendartypes.findAll", query = "SELECT c FROM Calendartypes c"),
    @NamedQuery(name = "Calendartypes.findByCalendartypeID", query = "SELECT c FROM Calendartypes c WHERE c.calendartypeID = :calendartypeID"),
    @NamedQuery(name = "Calendartypes.findByCalendartypeName", query = "SELECT c FROM Calendartypes c WHERE c.calendartypeName = :calendartypeName"),
    @NamedQuery(name = "Calendartypes.findByCalendartypeRate", query = "SELECT c FROM Calendartypes c WHERE c.calendartypeRate = :calendartypeRate"),
    @NamedQuery(name = "Calendartypes.findByCalendartypeEmployee", query = "SELECT c FROM Calendartypes c WHERE c.calendartypeEmployee = :calendartypeEmployee"),
    @NamedQuery(name = "Calendartypes.findByActive", query = "SELECT c FROM Calendartypes c WHERE c.active = :active")})
public class Calendartypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "calendartypeID")
    private Integer calendartypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "calendartypeName")
    private String calendartypeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "calendartypeRate")
    private Float calendartypeRate;
    @Column(name = "calendartypeEmployee")
    private Integer calendartypeEmployee;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendartypeID")
    private List<Equipmentafyshes> equipmentafyshesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendartypeID")
    private List<Personnelafyshes> personnelafyshesList;
    @OneToMany(mappedBy = "calendartypeID")
    private List<Programproducts> programproductsList;

    public Calendartypes() {
    }

    public Calendartypes(Integer calendartypeID) {
        this.calendartypeID = calendartypeID;
    }

    public Calendartypes(Integer calendartypeID, String calendartypeName) {
        this.calendartypeID = calendartypeID;
        this.calendartypeName = calendartypeName;
    }

    public Integer getCalendartypeID() {
        return calendartypeID;
    }

    public void setCalendartypeID(Integer calendartypeID) {
        this.calendartypeID = calendartypeID;
    }

    public String getCalendartypeName() {
        return calendartypeName;
    }

    public void setCalendartypeName(String calendartypeName) {
        this.calendartypeName = calendartypeName;
    }

    public Float getCalendartypeRate() {
        return calendartypeRate;
    }

    public void setCalendartypeRate(Float calendartypeRate) {
        this.calendartypeRate = calendartypeRate;
    }

    public Integer getCalendartypeEmployee() {
        return calendartypeEmployee;
    }

    public void setCalendartypeEmployee(Integer calendartypeEmployee) {
        this.calendartypeEmployee = calendartypeEmployee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public List<Equipmentafyshes> getEquipmentafyshesList() {
        return equipmentafyshesList;
    }

    public void setEquipmentafyshesList(List<Equipmentafyshes> equipmentafyshesList) {
        this.equipmentafyshesList = equipmentafyshesList;
    }

    @XmlTransient
    public List<Personnelafyshes> getPersonnelafyshesList() {
        return personnelafyshesList;
    }

    public void setPersonnelafyshesList(List<Personnelafyshes> personnelafyshesList) {
        this.personnelafyshesList = personnelafyshesList;
    }

    @XmlTransient
    public List<Programproducts> getProgramproductsList() {
        return programproductsList;
    }

    public void setProgramproductsList(List<Programproducts> programproductsList) {
        this.programproductsList = programproductsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calendartypeID != null ? calendartypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendartypes)) {
            return false;
        }
        Calendartypes other = (Calendartypes) object;
        if ((this.calendartypeID == null && other.calendartypeID != null) || (this.calendartypeID != null && !this.calendartypeID.equals(other.calendartypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Calendartypes[ calendartypeID=" + calendartypeID + " ]";
    }
    
}
