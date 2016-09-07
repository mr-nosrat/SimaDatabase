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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "personnelafyshes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnelafyshes.findAll", query = "SELECT p FROM Personnelafyshes p"),
    @NamedQuery(name = "Personnelafyshes.findByPersonnelAfyshID", query = "SELECT p FROM Personnelafyshes p WHERE p.personnelAfyshID = :personnelAfyshID"),
    @NamedQuery(name = "Personnelafyshes.findByAfyshDate", query = "SELECT p FROM Personnelafyshes p WHERE p.afyshDate = :afyshDate"),
    @NamedQuery(name = "Personnelafyshes.findByStartTime", query = "SELECT p FROM Personnelafyshes p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Personnelafyshes.findByEndTime", query = "SELECT p FROM Personnelafyshes p WHERE p.endTime = :endTime")})
public class Personnelafyshes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personnelAfyshID")
    private Integer personnelAfyshID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "afyshDate")
    @Temporal(TemporalType.DATE)
    private Date afyshDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
    @ManyToOne(optional = false)
    private Locations locationID;
    @JoinColumn(name = "calendartypeID", referencedColumnName = "calendartypeID")
    @ManyToOne(optional = false)
    private Calendartypes calendartypeID;
    @JoinColumn(name = "programID", referencedColumnName = "programID")
    @ManyToOne(optional = false)
    private Programs programID;
    @JoinColumn(name = "personnelID", referencedColumnName = "personnelID")
    @ManyToOne(optional = false)
    private Personnels personnelID;

    public Personnelafyshes() {
    }

    public Personnelafyshes(Integer personnelAfyshID) {
        this.personnelAfyshID = personnelAfyshID;
    }

    public Personnelafyshes(Integer personnelAfyshID, Date afyshDate, Date startTime, Date endTime) {
        this.personnelAfyshID = personnelAfyshID;
        this.afyshDate = afyshDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getPersonnelAfyshID() {
        return personnelAfyshID;
    }

    public void setPersonnelAfyshID(Integer personnelAfyshID) {
        this.personnelAfyshID = personnelAfyshID;
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

    public Locations getLocationID() {
        return locationID;
    }

    public void setLocationID(Locations locationID) {
        this.locationID = locationID;
    }

    public Calendartypes getCalendartypeID() {
        return calendartypeID;
    }

    public void setCalendartypeID(Calendartypes calendartypeID) {
        this.calendartypeID = calendartypeID;
    }

    public Programs getProgramID() {
        return programID;
    }

    public void setProgramID(Programs programID) {
        this.programID = programID;
    }

    public Personnels getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(Personnels personnelID) {
        this.personnelID = personnelID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personnelAfyshID != null ? personnelAfyshID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnelafyshes)) {
            return false;
        }
        Personnelafyshes other = (Personnelafyshes) object;
        if ((this.personnelAfyshID == null && other.personnelAfyshID != null) || (this.personnelAfyshID != null && !this.personnelAfyshID.equals(other.personnelAfyshID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Personnelafyshes[ personnelAfyshID=" + personnelAfyshID + " ]";
    }
    
}
