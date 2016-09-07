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
import javax.persistence.Lob;
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
@Table(name = "actions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actions.findAll", query = "SELECT a FROM Actions a"),
    @NamedQuery(name = "Actions.findByActionID", query = "SELECT a FROM Actions a WHERE a.actionID = :actionID"),
    @NamedQuery(name = "Actions.findByActionName", query = "SELECT a FROM Actions a WHERE a.actionName = :actionName"),
    @NamedQuery(name = "Actions.findByActive", query = "SELECT a FROM Actions a WHERE a.active = :active")})
public class Actions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "actionID")
    private Integer actionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "actionName")
    private String actionName;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;

    public Actions() {
    }

    public Actions(Integer actionID) {
        this.actionID = actionID;
    }

    public Actions(Integer actionID, String actionName) {
        this.actionID = actionID;
        this.actionName = actionName;
    }

    public Integer getActionID() {
        return actionID;
    }

    public void setActionID(Integer actionID) {
        this.actionID = actionID;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actionID != null ? actionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actions)) {
            return false;
        }
        Actions other = (Actions) object;
        if ((this.actionID == null && other.actionID != null) || (this.actionID != null && !this.actionID.equals(other.actionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Actions[ actionID=" + actionID + " ]";
    }
    
}
