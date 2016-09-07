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
@Table(name = "personnelpattern")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnelpattern.findAll", query = "SELECT p FROM Personnelpattern p"),
    @NamedQuery(name = "Personnelpattern.findByPersonnelpatternID", query = "SELECT p FROM Personnelpattern p WHERE p.personnelpatternID = :personnelpatternID"),
    @NamedQuery(name = "Personnelpattern.findByPersonnelpatternDate", query = "SELECT p FROM Personnelpattern p WHERE p.personnelpatternDate = :personnelpatternDate"),
    @NamedQuery(name = "Personnelpattern.findByCount", query = "SELECT p FROM Personnelpattern p WHERE p.count = :count")})
public class Personnelpattern implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personnelpatternID")
    private Integer personnelpatternID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "personnelpatternDate")
    @Temporal(TemporalType.DATE)
    private Date personnelpatternDate;
    @Column(name = "count")
    private Integer count;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "unitID", referencedColumnName = "unitID")
    @ManyToOne
    private Units unitID;
    @JoinColumn(name = "jobtitleID", referencedColumnName = "jobtitleID")
    @ManyToOne
    private Jobtitles jobtitleID;

    public Personnelpattern() {
    }

    public Personnelpattern(Integer personnelpatternID) {
        this.personnelpatternID = personnelpatternID;
    }

    public Personnelpattern(Integer personnelpatternID, Date personnelpatternDate) {
        this.personnelpatternID = personnelpatternID;
        this.personnelpatternDate = personnelpatternDate;
    }

    public Integer getPersonnelpatternID() {
        return personnelpatternID;
    }

    public void setPersonnelpatternID(Integer personnelpatternID) {
        this.personnelpatternID = personnelpatternID;
    }

    public Date getPersonnelpatternDate() {
        return personnelpatternDate;
    }

    public void setPersonnelpatternDate(Date personnelpatternDate) {
        this.personnelpatternDate = personnelpatternDate;
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

    public Units getUnitID() {
        return unitID;
    }

    public void setUnitID(Units unitID) {
        this.unitID = unitID;
    }

    public Jobtitles getJobtitleID() {
        return jobtitleID;
    }

    public void setJobtitleID(Jobtitles jobtitleID) {
        this.jobtitleID = jobtitleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personnelpatternID != null ? personnelpatternID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnelpattern)) {
            return false;
        }
        Personnelpattern other = (Personnelpattern) object;
        if ((this.personnelpatternID == null && other.personnelpatternID != null) || (this.personnelpatternID != null && !this.personnelpatternID.equals(other.personnelpatternID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Personnelpattern[ personnelpatternID=" + personnelpatternID + " ]";
    }
    
}
