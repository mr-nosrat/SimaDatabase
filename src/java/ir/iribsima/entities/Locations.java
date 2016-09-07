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
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l"),
    @NamedQuery(name = "Locations.findByLocationID", query = "SELECT l FROM Locations l WHERE l.locationID = :locationID"),
    @NamedQuery(name = "Locations.findByLocationName", query = "SELECT l FROM Locations l WHERE l.locationName = :locationName"),
    @NamedQuery(name = "Locations.findByActive", query = "SELECT l FROM Locations l WHERE l.active = :active")})
public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "locationID")
    private Integer locationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "locationName")
    private String locationName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "locationID")
    private List<Materials> materialsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationID")
    private List<Personnelafyshes> personnelafyshesList;
    @OneToMany(mappedBy = "locationID")
    private List<Programproducts> programproductsList;

    public Locations() {
    }

    public Locations(Integer locationID) {
        this.locationID = locationID;
    }

    public Locations(Integer locationID, String locationName) {
        this.locationID = locationID;
        this.locationName = locationName;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
    public List<Materials> getMaterialsList() {
        return materialsList;
    }

    public void setMaterialsList(List<Materials> materialsList) {
        this.materialsList = materialsList;
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
        hash += (locationID != null ? locationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locationID == null && other.locationID != null) || (this.locationID != null && !this.locationID.equals(other.locationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Locations[ locationID=" + locationID + " ]";
    }
    
}
