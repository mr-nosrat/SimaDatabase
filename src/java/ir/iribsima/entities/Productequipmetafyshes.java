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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "productequipmetafyshes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productequipmetafyshes.findAll", query = "SELECT p FROM Productequipmetafyshes p"),
    @NamedQuery(name = "Productequipmetafyshes.findByProductequipmetafyshID", query = "SELECT p FROM Productequipmetafyshes p WHERE p.productequipmetafyshID = :productequipmetafyshID"),
    @NamedQuery(name = "Productequipmetafyshes.findByStartDate", query = "SELECT p FROM Productequipmetafyshes p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Productequipmetafyshes.findByEndDate", query = "SELECT p FROM Productequipmetafyshes p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Productequipmetafyshes.findByStartTime", query = "SELECT p FROM Productequipmetafyshes p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Productequipmetafyshes.findByEndTime", query = "SELECT p FROM Productequipmetafyshes p WHERE p.endTime = :endTime")})
public class Productequipmetafyshes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productequipmetafyshID")
    private Integer productequipmetafyshID;
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @JoinColumn(name = "programproductID", referencedColumnName = "programproductID")
    @ManyToOne
    private Programproducts programproductID;
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmenID")
    @ManyToOne
    private Equipments equipmentID;

    public Productequipmetafyshes() {
    }

    public Productequipmetafyshes(Integer productequipmetafyshID) {
        this.productequipmetafyshID = productequipmetafyshID;
    }

    public Integer getProductequipmetafyshID() {
        return productequipmetafyshID;
    }

    public void setProductequipmetafyshID(Integer productequipmetafyshID) {
        this.productequipmetafyshID = productequipmetafyshID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public Programproducts getProgramproductID() {
        return programproductID;
    }

    public void setProgramproductID(Programproducts programproductID) {
        this.programproductID = programproductID;
    }

    public Equipments getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(Equipments equipmentID) {
        this.equipmentID = equipmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productequipmetafyshID != null ? productequipmetafyshID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productequipmetafyshes)) {
            return false;
        }
        Productequipmetafyshes other = (Productequipmetafyshes) object;
        if ((this.productequipmetafyshID == null && other.productequipmetafyshID != null) || (this.productequipmetafyshID != null && !this.productequipmetafyshID.equals(other.productequipmetafyshID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Productequipmetafyshes[ productequipmetafyshID=" + productequipmetafyshID + " ]";
    }
    
}
