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
@Table(name = "productpersonnelafyshes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productpersonnelafyshes.findAll", query = "SELECT p FROM Productpersonnelafyshes p"),
    @NamedQuery(name = "Productpersonnelafyshes.findByProductpersonnelafyshID", query = "SELECT p FROM Productpersonnelafyshes p WHERE p.productpersonnelafyshID = :productpersonnelafyshID"),
    @NamedQuery(name = "Productpersonnelafyshes.findByStartDate", query = "SELECT p FROM Productpersonnelafyshes p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Productpersonnelafyshes.findByEndDate", query = "SELECT p FROM Productpersonnelafyshes p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Productpersonnelafyshes.findByStartTime", query = "SELECT p FROM Productpersonnelafyshes p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Productpersonnelafyshes.findByEndTime", query = "SELECT p FROM Productpersonnelafyshes p WHERE p.endTime = :endTime")})
public class Productpersonnelafyshes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productpersonnelafyshID")
    private Integer productpersonnelafyshID;
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
    @JoinColumn(name = "personnelID", referencedColumnName = "personnelID")
    @ManyToOne
    private Personnels personnelID;

    public Productpersonnelafyshes() {
    }

    public Productpersonnelafyshes(Integer productpersonnelafyshID) {
        this.productpersonnelafyshID = productpersonnelafyshID;
    }

    public Integer getProductpersonnelafyshID() {
        return productpersonnelafyshID;
    }

    public void setProductpersonnelafyshID(Integer productpersonnelafyshID) {
        this.productpersonnelafyshID = productpersonnelafyshID;
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

    public Personnels getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(Personnels personnelID) {
        this.personnelID = personnelID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productpersonnelafyshID != null ? productpersonnelafyshID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productpersonnelafyshes)) {
            return false;
        }
        Productpersonnelafyshes other = (Productpersonnelafyshes) object;
        if ((this.productpersonnelafyshID == null && other.productpersonnelafyshID != null) || (this.productpersonnelafyshID != null && !this.productpersonnelafyshID.equals(other.productpersonnelafyshID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Productpersonnelafyshes[ productpersonnelafyshID=" + productpersonnelafyshID + " ]";
    }
    
}
