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
@Table(name = "programtypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programtypes.findAll", query = "SELECT p FROM Programtypes p"),
    @NamedQuery(name = "Programtypes.findByProgramtypeID", query = "SELECT p FROM Programtypes p WHERE p.programtypeID = :programtypeID"),
    @NamedQuery(name = "Programtypes.findByProgramtypeName", query = "SELECT p FROM Programtypes p WHERE p.programtypeName = :programtypeName"),
    @NamedQuery(name = "Programtypes.findByActive", query = "SELECT p FROM Programtypes p WHERE p.active = :active")})
public class Programtypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "programtypeID")
    private Integer programtypeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "programtypeName")
    private String programtypeName;
    @Lob
    @Size(max = 16777215)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "programtypeID")
    private List<Programs> programsList;

    public Programtypes() {
    }

    public Programtypes(Integer programtypeID) {
        this.programtypeID = programtypeID;
    }

    public Programtypes(Integer programtypeID, String programtypeName) {
        this.programtypeID = programtypeID;
        this.programtypeName = programtypeName;
    }

    public Integer getProgramtypeID() {
        return programtypeID;
    }

    public void setProgramtypeID(Integer programtypeID) {
        this.programtypeID = programtypeID;
    }

    public String getProgramtypeName() {
        return programtypeName;
    }

    public void setProgramtypeName(String programtypeName) {
        this.programtypeName = programtypeName;
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
        hash += (programtypeID != null ? programtypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programtypes)) {
            return false;
        }
        Programtypes other = (Programtypes) object;
        if ((this.programtypeID == null && other.programtypeID != null) || (this.programtypeID != null && !this.programtypeID.equals(other.programtypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Programtypes[ programtypeID=" + programtypeID + " ]";
    }
    
}
