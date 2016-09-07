/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.iribsima.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "programproducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programproducts.findAll", query = "SELECT p FROM Programproducts p"),
    @NamedQuery(name = "Programproducts.findByProgramproductID", query = "SELECT p FROM Programproducts p WHERE p.programproductID = :programproductID"),
    @NamedQuery(name = "Programproducts.findByProgramproductsName", query = "SELECT p FROM Programproducts p WHERE p.programproductsName = :programproductsName"),
    @NamedQuery(name = "Programproducts.findByStartDate", query = "SELECT p FROM Programproducts p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Programproducts.findByEndDate", query = "SELECT p FROM Programproducts p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Programproducts.findByStartTime", query = "SELECT p FROM Programproducts p WHERE p.startTime = :startTime"),
    @NamedQuery(name = "Programproducts.findByEndTime", query = "SELECT p FROM Programproducts p WHERE p.endTime = :endTime")})
public class Programproducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "programproductID")
    private Integer programproductID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "programproductsName")
    private String programproductsName;
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
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "programproductID")
    private List<Productequipmetafyshes> productequipmetafyshesList;
    @JoinColumn(name = "unitID", referencedColumnName = "unitID")
    @ManyToOne
    private Units unitID;
    @JoinColumn(name = "programID", referencedColumnName = "programID")
    @ManyToOne
    private Programs programID;
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
    @ManyToOne
    private Locations locationID;
    @JoinColumn(name = "calendartypeID", referencedColumnName = "calendartypeID")
    @ManyToOne
    private Calendartypes calendartypeID;
    @OneToMany(mappedBy = "programproductID")
    private List<Productpersonnelafyshes> productpersonnelafyshesList;

    public Programproducts() {
    }

    public Programproducts(Integer programproductID) {
        this.programproductID = programproductID;
    }

    public Programproducts(Integer programproductID, String programproductsName) {
        this.programproductID = programproductID;
        this.programproductsName = programproductsName;
    }

    public Integer getProgramproductID() {
        return programproductID;
    }

    public void setProgramproductID(Integer programproductID) {
        this.programproductID = programproductID;
    }

    public String getProgramproductsName() {
        return programproductsName;
    }

    public void setProgramproductsName(String programproductsName) {
        this.programproductsName = programproductsName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Productequipmetafyshes> getProductequipmetafyshesList() {
        return productequipmetafyshesList;
    }

    public void setProductequipmetafyshesList(List<Productequipmetafyshes> productequipmetafyshesList) {
        this.productequipmetafyshesList = productequipmetafyshesList;
    }

    public Units getUnitID() {
        return unitID;
    }

    public void setUnitID(Units unitID) {
        this.unitID = unitID;
    }

    public Programs getProgramID() {
        return programID;
    }

    public void setProgramID(Programs programID) {
        this.programID = programID;
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

    @XmlTransient
    public List<Productpersonnelafyshes> getProductpersonnelafyshesList() {
        return productpersonnelafyshesList;
    }

    public void setProductpersonnelafyshesList(List<Productpersonnelafyshes> productpersonnelafyshesList) {
        this.productpersonnelafyshesList = productpersonnelafyshesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programproductID != null ? programproductID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programproducts)) {
            return false;
        }
        Programproducts other = (Programproducts) object;
        if ((this.programproductID == null && other.programproductID != null) || (this.programproductID != null && !this.programproductID.equals(other.programproductID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Programproducts[ programproductID=" + programproductID + " ]";
    }
    
}
