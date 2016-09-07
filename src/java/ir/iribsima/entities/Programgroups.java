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
@Table(name = "programgroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programgroups.findAll", query = "SELECT p FROM Programgroups p"),
    @NamedQuery(name = "Programgroups.findByProgramgroupID", query = "SELECT p FROM Programgroups p WHERE p.programgroupID = :programgroupID"),
    @NamedQuery(name = "Programgroups.findByProgramgroupName", query = "SELECT p FROM Programgroups p WHERE p.programgroupName = :programgroupName"),
    @NamedQuery(name = "Programgroups.findByActive", query = "SELECT p FROM Programgroups p WHERE p.active = :active")})
public class Programgroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "programgroupID")
    private Integer programgroupID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "programgroupName")
    private String programgroupName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "productgroupID")
    private List<Programs> programsList;

    public Programgroups() {
    }

    public Programgroups(Integer programgroupID) {
        this.programgroupID = programgroupID;
    }

    public Programgroups(Integer programgroupID, String programgroupName) {
        this.programgroupID = programgroupID;
        this.programgroupName = programgroupName;
    }

    public Integer getProgramgroupID() {
        return programgroupID;
    }

    public void setProgramgroupID(Integer programgroupID) {
        this.programgroupID = programgroupID;
    }

    public String getProgramgroupName() {
        return programgroupName;
    }

    public void setProgramgroupName(String programgroupName) {
        this.programgroupName = programgroupName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programgroupID != null ? programgroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programgroups)) {
            return false;
        }
        Programgroups other = (Programgroups) object;
        if ((this.programgroupID == null && other.programgroupID != null) || (this.programgroupID != null && !this.programgroupID.equals(other.programgroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Programgroups[ programgroupID=" + programgroupID + " ]";
    }
    
}
