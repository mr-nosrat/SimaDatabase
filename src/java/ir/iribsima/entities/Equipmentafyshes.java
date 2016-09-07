/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "equipmentafyshes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipmentafyshes.findAll", query = "SELECT e FROM Equipmentafyshes e"),
    @NamedQuery(name = "Equipmentafyshes.findByEquipmentAfyshID", query = "SELECT e FROM Equipmentafyshes e WHERE e.equipmentAfyshID = :equipmentAfyshID"),
    @NamedQuery(name = "Equipmentafyshes.findByAfyshDate", query = "SELECT e FROM Equipmentafyshes e WHERE e.afyshDate = :afyshDate"),
    @NamedQuery(name = "Equipmentafyshes.findByStartTime", query = "SELECT e FROM Equipmentafyshes e WHERE e.startTime = :startTime"),
    @NamedQuery(name = "Equipmentafyshes.findByEndTime", query = "SELECT e FROM Equipmentafyshes e WHERE e.endTime = :endTime")})
public class Equipmentafyshes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equipmentAfyshID")
    private Integer equipmentAfyshID;
    @Column(name = "afyshDate")
    @Temporal(TemporalType.DATE)
    private Date afyshDate;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "programID", referencedColumnName = "programID")
    @ManyToOne(optional = false)
    private Programs programID;
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmenID")
    @ManyToOne(optional = false)
    private Equipments equipmentID;
    @JoinColumn(name = "calendartypeID", referencedColumnName = "calendartypeID")
    @ManyToOne(optional = false)
    private Calendartypes calendartypeID;

    public Equipmentafyshes() {
    }

    public Equipmentafyshes(Integer equipmentAfyshID) {
        this.equipmentAfyshID = equipmentAfyshID;
    }

    public Integer getEquipmentAfyshID() {
        return equipmentAfyshID;
    }

    public void setEquipmentAfyshID(Integer equipmentAfyshID) {
        this.equipmentAfyshID = equipmentAfyshID;
    }

    public Date getAfyshDate() {
        return afyshDate;
    }

    public void setAfyshDate(Date afyshDate) {
        this.afyshDate = afyshDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Programs getProgramID() {
        return programID;
    }

    public void setProgramID(Programs programID) {
        this.programID = programID;
    }

    public Equipments getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Equipments equipmentID) {
        this.equipmentID = equipmentID;
    }

    public Calendartypes getCalendartypeID() {
        return calendartypeID;
    }

    public void setCalendartypeID(Calendartypes calendartypeID) {
        this.calendartypeID = calendartypeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmentAfyshID != null ? equipmentAfyshID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipmentafyshes)) {
            return false;
        }
        Equipmentafyshes other = (Equipmentafyshes) object;
        if ((this.equipmentAfyshID == null && other.equipmentAfyshID != null) || (this.equipmentAfyshID != null && !this.equipmentAfyshID.equals(other.equipmentAfyshID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Equipmentafyshes[ equipmentAfyshID=" + equipmentAfyshID + " ]";
    }
    
}
