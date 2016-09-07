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
@Table(name = "jobtitles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jobtitles.findAll", query = "SELECT j FROM Jobtitles j"),
    @NamedQuery(name = "Jobtitles.findByJobtitleID", query = "SELECT j FROM Jobtitles j WHERE j.jobtitleID = :jobtitleID"),
    @NamedQuery(name = "Jobtitles.findByJobtitleName", query = "SELECT j FROM Jobtitles j WHERE j.jobtitleName = :jobtitleName"),
    @NamedQuery(name = "Jobtitles.findByActive", query = "SELECT j FROM Jobtitles j WHERE j.active = :active")})
public class Jobtitles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobtitleID")
    private Integer jobtitleID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "jobtitleName")
    private String jobtitleName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "jobtitleID")
    private List<Personnelpattern> personnelpatternList;

    public Jobtitles() {
    }

    public Jobtitles(Integer jobtitleID) {
        this.jobtitleID = jobtitleID;
    }

    public Jobtitles(Integer jobtitleID, String jobtitleName) {
        this.jobtitleID = jobtitleID;
        this.jobtitleName = jobtitleName;
    }

    public Integer getJobtitleID() {
        return jobtitleID;
    }

    public void setJobtitleID(Integer jobtitleID) {
        this.jobtitleID = jobtitleID;
    }

    public String getJobtitleName() {
        return jobtitleName;
    }

    public void setJobtitleName(String jobtitleName) {
        this.jobtitleName = jobtitleName;
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
    public List<Personnelpattern> getPersonnelpatternList() {
        return personnelpatternList;
    }

    public void setPersonnelpatternList(List<Personnelpattern> personnelpatternList) {
        this.personnelpatternList = personnelpatternList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobtitleID != null ? jobtitleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jobtitles)) {
            return false;
        }
        Jobtitles other = (Jobtitles) object;
        if ((this.jobtitleID == null && other.jobtitleID != null) || (this.jobtitleID != null && !this.jobtitleID.equals(other.jobtitleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Jobtitles[ jobtitleID=" + jobtitleID + " ]";
    }
    
}
