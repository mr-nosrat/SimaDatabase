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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "equipmentusages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipmentusages.findAll", query = "SELECT e FROM Equipmentusages e"),
    @NamedQuery(name = "Equipmentusages.findByEquipmentusageID", query = "SELECT e FROM Equipmentusages e WHERE e.equipmentusageID = :equipmentusageID"),
    @NamedQuery(name = "Equipmentusages.findByEquipmentID", query = "SELECT e FROM Equipmentusages e WHERE e.equipmentID = :equipmentID"),
    @NamedQuery(name = "Equipmentusages.findByEstateNumber", query = "SELECT e FROM Equipmentusages e WHERE e.estateNumber = :estateNumber"),
    @NamedQuery(name = "Equipmentusages.findByTechnicalNumber", query = "SELECT e FROM Equipmentusages e WHERE e.technicalNumber = :technicalNumber")})
public class Equipmentusages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equipmentusageID")
    private Integer equipmentusageID;
    @Column(name = "equipmentID")
    private Integer equipmentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estateNumber")
    private String estateNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "technicalNumber")
    private String technicalNumber;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "unitlID", referencedColumnName = "unitID")
    @ManyToOne
    private Units unitlID;

    public Equipmentusages() {
    }

    public Equipmentusages(Integer equipmentusageID) {
        this.equipmentusageID = equipmentusageID;
    }

    public Equipmentusages(Integer equipmentusageID, String estateNumber, String technicalNumber) {
        this.equipmentusageID = equipmentusageID;
        this.estateNumber = estateNumber;
        this.technicalNumber = technicalNumber;
    }

    public Integer getEquipmentusageID() {
        return equipmentusageID;
    }

    public void setEquipmentusageID(Integer equipmentusageID) {
        this.equipmentusageID = equipmentusageID;
    }

    public Integer getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Integer equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEstateNumber() {
        return estateNumber;
    }

    public void setEstateNumber(String estateNumber) {
        this.estateNumber = estateNumber;
    }

    public String getTechnicalNumber() {
        return technicalNumber;
    }

    public void setTechnicalNumber(String technicalNumber) {
        this.technicalNumber = technicalNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Units getUnitlID() {
        return unitlID;
    }

    public void setUnitlID(Units unitlID) {
        this.unitlID = unitlID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentusageID != null ? equipmentusageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipmentusages)) {
            return false;
        }
        Equipmentusages other = (Equipmentusages) object;
        if ((this.equipmentusageID == null && other.equipmentusageID != null) || (this.equipmentusageID != null && !this.equipmentusageID.equals(other.equipmentusageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Equipmentusages[ equipmentusageID=" + equipmentusageID + " ]";
    }
    
}
