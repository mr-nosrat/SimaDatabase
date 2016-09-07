/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "materials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materials.findAll", query = "SELECT m FROM Materials m"),
    @NamedQuery(name = "Materials.findByMaterialID", query = "SELECT m FROM Materials m WHERE m.materialID = :materialID"),
    @NamedQuery(name = "Materials.findByMaterialName", query = "SELECT m FROM Materials m WHERE m.materialName = :materialName"),
    @NamedQuery(name = "Materials.findByCount", query = "SELECT m FROM Materials m WHERE m.count = :count")})
public class Materials implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "materialID")
    private Integer materialID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "materialName")
    private String materialName;
    @Column(name = "count")
    private Integer count;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
    @ManyToOne
    private Locations locationID;

    public Materials() {
    }

    public Materials(Integer materialID) {
        this.materialID = materialID;
    }

    public Materials(Integer materialID, String materialName) {
        this.materialID = materialID;
        this.materialName = materialName;
    }

    public Integer getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Integer materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Locations getLocationID() {
        return locationID;
    }

    public void setLocationID(Locations locationID) {
        this.locationID = locationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialID != null ? materialID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materials)) {
            return false;
        }
        Materials other = (Materials) object;
        if ((this.materialID == null && other.materialID != null) || (this.materialID != null && !this.materialID.equals(other.materialID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Materials[ materialID=" + materialID + " ]";
    }
    
}
