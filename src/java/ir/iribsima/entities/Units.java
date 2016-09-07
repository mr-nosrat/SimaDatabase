/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "units")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Units.findAll", query = "SELECT u FROM Units u"),
    @NamedQuery(name = "Units.findByUnitID", query = "SELECT u FROM Units u WHERE u.unitID = :unitID"),
    @NamedQuery(name = "Units.findByUnitName", query = "SELECT u FROM Units u WHERE u.unitName = :unitName"),
    @NamedQuery(name = "Units.findByActive", query = "SELECT u FROM Units u WHERE u.active = :active")})
public class Units implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unitID")
    private Integer unitID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "unitName")
    private String unitName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "unitID")
    private List<Programs> programsList;
    @OneToMany(mappedBy = "unitlID")
    private List<Equipmentusages> equipmentusagesList;
    @OneToMany(mappedBy = "unitID")
    private List<Personnelpattern> personnelpatternList;
    @OneToMany(mappedBy = "unitID")
    private List<Programproducts> programproductsList;

    public Units() {
    }

    public Units(Integer unitID) {
        this.unitID = unitID;
    }

    public Units(Integer unitID, String unitName) {
        this.unitID = unitID;
        this.unitName = unitName;
    }

    public Integer getUnitID() {
        return unitID;
    }

    public void setUnitID(Integer unitID) {
        this.unitID = unitID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
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
    public List<Programs> getProgramsList() {
        return programsList;
    }

    public void setProgramsList(List<Programs> programsList) {
        this.programsList = programsList;
    }

    @XmlTransient
    public List<Equipmentusages> getEquipmentusagesList() {
        return equipmentusagesList;
    }

    public void setEquipmentusagesList(List<Equipmentusages> equipmentusagesList) {
        this.equipmentusagesList = equipmentusagesList;
    }

    @XmlTransient
    public List<Personnelpattern> getPersonnelpatternList() {
        return personnelpatternList;
    }

    public void setPersonnelpatternList(List<Personnelpattern> personnelpatternList) {
        this.personnelpatternList = personnelpatternList;
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
        hash += (unitID != null ? unitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Units)) {
            return false;
        }
        Units other = (Units) object;
        if ((this.unitID == null && other.unitID != null) || (this.unitID != null && !this.unitID.equals(other.unitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Units[ unitID=" + unitID + " ]";
    }
    
}
