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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "useraccess")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useraccess.findAll", query = "SELECT u FROM Useraccess u"),
    @NamedQuery(name = "Useraccess.findByUserAccessID", query = "SELECT u FROM Useraccess u WHERE u.userAccessID = :userAccessID"),
    @NamedQuery(name = "Useraccess.findByActive", query = "SELECT u FROM Useraccess u WHERE u.active = :active")})
public class Useraccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userAccessID")
    private Integer userAccessID;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private Users userID;
    @JoinColumn(name = "accessID", referencedColumnName = "accessID")
    @ManyToOne(optional = false)
    private Access accessID;

    public Useraccess() {
    }

    public Useraccess(Integer userAccessID) {
        this.userAccessID = userAccessID;
    }

    public Integer getUserAccessID() {
        return userAccessID;
    }

    public void setUserAccessID(Integer userAccessID) {
        this.userAccessID = userAccessID;
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

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Access getAccessID() {
        return accessID;
    }

    public void setAccessID(Access accessID) {
        this.accessID = accessID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAccessID != null ? userAccessID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useraccess)) {
            return false;
        }
        Useraccess other = (Useraccess) object;
        if ((this.userAccessID == null && other.userAccessID != null) || (this.userAccessID != null && !this.userAccessID.equals(other.userAccessID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Useraccess[ userAccessID=" + userAccessID + " ]";
    }
    
}
