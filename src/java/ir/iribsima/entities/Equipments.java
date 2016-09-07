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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "equipments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipments.findAll", query = "SELECT e FROM Equipments e"),
    @NamedQuery(name = "Equipments.findByEquipmenID", query = "SELECT e FROM Equipments e WHERE e.equipmenID = :equipmenID"),
    @NamedQuery(name = "Equipments.findByEquipmentName", query = "SELECT e FROM Equipments e WHERE e.equipmentName = :equipmentName"),
    @NamedQuery(name = "Equipments.findByModel", query = "SELECT e FROM Equipments e WHERE e.model = :model"),
    @NamedQuery(name = "Equipments.findByProductor", query = "SELECT e FROM Equipments e WHERE e.productor = :productor"),
    @NamedQuery(name = "Equipments.findByEstatNumber", query = "SELECT e FROM Equipments e WHERE e.estatNumber = :estatNumber"),
    @NamedQuery(name = "Equipments.findBySerialNumber", query = "SELECT e FROM Equipments e WHERE e.serialNumber = :serialNumber"),
    @NamedQuery(name = "Equipments.findByOwner", query = "SELECT e FROM Equipments e WHERE e.owner = :owner"),
    @NamedQuery(name = "Equipments.findByUnit", query = "SELECT e FROM Equipments e WHERE e.unit = :unit"),
    @NamedQuery(name = "Equipments.findByLocation", query = "SELECT e FROM Equipments e WHERE e.location = :location"),
    @NamedQuery(name = "Equipments.findByBuilding", query = "SELECT e FROM Equipments e WHERE e.building = :building"),
    @NamedQuery(name = "Equipments.findByStatus", query = "SELECT e FROM Equipments e WHERE e.status = :status"),
    @NamedQuery(name = "Equipments.findByReserv", query = "SELECT e FROM Equipments e WHERE e.reserv = :reserv"),
    @NamedQuery(name = "Equipments.findByActive", query = "SELECT e FROM Equipments e WHERE e.active = :active")})
public class Equipments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "equipmenID")
    private Integer equipmenID;
    @Size(max = 100)
    @Column(name = "equipmentName")
    private String equipmentName;
    @Size(max = 50)
    @Column(name = "model")
    private String model;
    @Size(max = 50)
    @Column(name = "productor")
    private String productor;
    @Size(max = 50)
    @Column(name = "estatNumber")
    private String estatNumber;
    @Size(max = 50)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Size(max = 50)
    @Column(name = "owner")
    private String owner;
    @Size(max = 50)
    @Column(name = "unit")
    private String unit;
    @Size(max = 50)
    @Column(name = "location")
    private String location;
    @Size(max = 50)
    @Column(name = "building")
    private String building;
    @Size(max = 50)
    @Column(name = "status")
    private String status;
    @Column(name = "reserv")
    private Boolean reserv;
    @Lob
    @Size(max = 16777215)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipmentID")
    private List<Equipmentafyshes> equipmentafyshesList;
    @OneToMany(mappedBy = "equipmentID")
    private List<Productequipmetafyshes> productequipmetafyshesList;

    public Equipments() {
    }

    public Equipments(Integer equipmenID) {
        this.equipmenID = equipmenID;
    }

    public Integer getEquipmenID() {
        return equipmenID;
    }

    public void setEquipmenID(Integer equipmenID) {
        this.equipmenID = equipmenID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getEstatNumber() {
        return estatNumber;
    }

    public void setEstatNumber(String estatNumber) {
        this.estatNumber = estatNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getReserv() {
        return reserv;
    }

    public void setReserv(Boolean reserv) {
        this.reserv = reserv;
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
    public List<Equipmentafyshes> getEquipmentafyshesList() {
        return equipmentafyshesList;
    }

    public void setEquipmentafyshesList(List<Equipmentafyshes> equipmentafyshesList) {
        this.equipmentafyshesList = equipmentafyshesList;
    }

    @XmlTransient
    public List<Productequipmetafyshes> getProductequipmetafyshesList() {
        return productequipmetafyshesList;
    }

    public void setProductequipmetafyshesList(List<Productequipmetafyshes> productequipmetafyshesList) {
        this.productequipmetafyshesList = productequipmetafyshesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (equipmenID != null ? equipmenID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipments)) {
            return false;
        }
        Equipments other = (Equipments) object;
        if ((this.equipmenID == null && other.equipmenID != null) || (this.equipmenID != null && !this.equipmenID.equals(other.equipmenID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Equipments[ equipmenID=" + equipmenID + " ]";
    }
    
}
