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
@Table(name = "access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Access.findAll", query = "SELECT a FROM Access a"),
    @NamedQuery(name = "Access.findByAccessID", query = "SELECT a FROM Access a WHERE a.accessID = :accessID"),
    @NamedQuery(name = "Access.findByAccessName", query = "SELECT a FROM Access a WHERE a.accessName = :accessName"),
    @NamedQuery(name = "Access.findByPageName", query = "SELECT a FROM Access a WHERE a.pageName = :pageName"),
    @NamedQuery(name = "Access.findByActive", query = "SELECT a FROM Access a WHERE a.active = :active")})
public class Access implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accessID")
    private Integer accessID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "accessName")
    private String accessName;
    @Size(max = 100)
    @Column(name = "pageName")
    private String pageName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accessID")
    private List<Useraccess> useraccessList;

    public Access() {
    }

    public Access(Integer accessID) {
        this.accessID = accessID;
    }

    public Access(Integer accessID, String accessName) {
        this.accessID = accessID;
        this.accessName = accessName;
    }

    public Integer getAccessID() {
        return accessID;
    }

    public void setAccessID(Integer accessID) {
        this.accessID = accessID;
    }

    public String getAccessName() {
        return accessName;
    }

    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
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
    public List<Useraccess> getUseraccessList() {
        return useraccessList;
    }

    public void setUseraccessList(List<Useraccess> useraccessList) {
        this.useraccessList = useraccessList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessID != null ? accessID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Access)) {
            return false;
        }
        Access other = (Access) object;
        if ((this.accessID == null && other.accessID != null) || (this.accessID != null && !this.accessID.equals(other.accessID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Access[ accessID=" + accessID + " ]";
    }
    
}
