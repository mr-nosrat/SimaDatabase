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
@Table(name = "personnels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnels.findAll", query = "SELECT p FROM Personnels p"),
    @NamedQuery(name = "Personnels.findByPersonnelID", query = "SELECT p FROM Personnels p WHERE p.personnelID = :personnelID"),
    @NamedQuery(name = "Personnels.findByPersonnelFamily", query = "SELECT p FROM Personnels p WHERE p.personnelFamily = :personnelFamily"),
    @NamedQuery(name = "Personnels.findByPersonnelName", query = "SELECT p FROM Personnels p WHERE p.personnelName = :personnelName"),
    @NamedQuery(name = "Personnels.findByInjuryRate", query = "SELECT p FROM Personnels p WHERE p.injuryRate = :injuryRate"),
    @NamedQuery(name = "Personnels.findByPersonnelCode", query = "SELECT p FROM Personnels p WHERE p.personnelCode = :personnelCode"),
    @NamedQuery(name = "Personnels.findByUnit", query = "SELECT p FROM Personnels p WHERE p.unit = :unit"),
    @NamedQuery(name = "Personnels.findByBirthDate", query = "SELECT p FROM Personnels p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Personnels.findByBirthLocation", query = "SELECT p FROM Personnels p WHERE p.birthLocation = :birthLocation"),
    @NamedQuery(name = "Personnels.findByEmployeeDate", query = "SELECT p FROM Personnels p WHERE p.employeeDate = :employeeDate"),
    @NamedQuery(name = "Personnels.findByEmployeeStatus", query = "SELECT p FROM Personnels p WHERE p.employeeStatus = :employeeStatus"),
    @NamedQuery(name = "Personnels.findByEducationLevel", query = "SELECT p FROM Personnels p WHERE p.educationLevel = :educationLevel"),
    @NamedQuery(name = "Personnels.findByEducationDate", query = "SELECT p FROM Personnels p WHERE p.educationDate = :educationDate"),
    @NamedQuery(name = "Personnels.findByEducationLocation", query = "SELECT p FROM Personnels p WHERE p.educationLocation = :educationLocation"),
    @NamedQuery(name = "Personnels.findByEducationCourse", query = "SELECT p FROM Personnels p WHERE p.educationCourse = :educationCourse"),
    @NamedQuery(name = "Personnels.findByActionID", query = "SELECT p FROM Personnels p WHERE p.actionID = :actionID"),
    @NamedQuery(name = "Personnels.findByReserve", query = "SELECT p FROM Personnels p WHERE p.reserve = :reserve"),
    @NamedQuery(name = "Personnels.findByPhone", query = "SELECT p FROM Personnels p WHERE p.phone = :phone"),
    @NamedQuery(name = "Personnels.findByAddress", query = "SELECT p FROM Personnels p WHERE p.address = :address"),
    @NamedQuery(name = "Personnels.findByConfirm", query = "SELECT p FROM Personnels p WHERE p.confirm = :confirm"),
    @NamedQuery(name = "Personnels.findByActive", query = "SELECT p FROM Personnels p WHERE p.active = :active")})
public class Personnels implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "personnelID")
    private Integer personnelID;
    @Size(max = 50)
    @Column(name = "personnelFamily")
    private String personnelFamily;
    @Size(max = 50)
    @Column(name = "personnelName")
    private String personnelName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "InjuryRate")
    private Float injuryRate;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 6)
    @Column(name = "personnelCode")
    private String personnelCode;
    @Size(max = 100)
    @Column(name = "unit")
    private String unit;
    @Size(max = 10)
    @Column(name = "birthDate")
    private String birthDate;
    @Size(max = 50)
    @Column(name = "birthLocation")
    private String birthLocation;
    @Size(max = 100)
    @Column(name = "employeeDate")
    private String employeeDate;
    @Column(name = "employeeStatus")
    private Integer employeeStatus;
    @Size(max = 50)
    @Column(name = "educationLevel")
    private String educationLevel;
    @Size(max = 100)
    @Column(name = "educationDate")
    private String educationDate;
    @Size(max = 100)
    @Column(name = "educationLocation")
    private String educationLocation;
    @Size(max = 100)
    @Column(name = "educationCourse")
    private String educationCourse;
    @Column(name = "actionID")
    private Integer actionID;
    @Column(name = "reserve")
    private Boolean reserve;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 80)
    @Column(name = "phone")
    private String phone;
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    @Column(name = "confirm")
    private Boolean confirm;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "producerID")
    private List<Programs> programsList;
    @OneToMany(mappedBy = "directorID")
    private List<Programs> programsList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personnelID")
    private List<Personnelafyshes> personnelafyshesList;
    @OneToMany(mappedBy = "personnelID")
    private List<Productpersonnelafyshes> productpersonnelafyshesList;

    public Personnels() {
    }

    public Personnels(Integer personnelID) {
        this.personnelID = personnelID;
    }

    public Integer getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(Integer personnelID) {
        this.personnelID = personnelID;
    }

    public String getPersonnelFamily() {
        return personnelFamily;
    }

    public void setPersonnelFamily(String personnelFamily) {
        this.personnelFamily = personnelFamily;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public Float getInjuryRate() {
        return injuryRate;
    }

    public void setInjuryRate(Float injuryRate) {
        this.injuryRate = injuryRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthLocation() {
        return birthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        this.birthLocation = birthLocation;
    }

    public String getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(String employeeDate) {
        this.employeeDate = employeeDate;
    }

    public Integer getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Integer employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getEducationDate() {
        return educationDate;
    }

    public void setEducationDate(String educationDate) {
        this.educationDate = educationDate;
    }

    public String getEducationLocation() {
        return educationLocation;
    }

    public void setEducationLocation(String educationLocation) {
        this.educationLocation = educationLocation;
    }

    public String getEducationCourse() {
        return educationCourse;
    }

    public void setEducationCourse(String educationCourse) {
        this.educationCourse = educationCourse;
    }

    public Integer getActionID() {
        return actionID;
    }

    public void setActionID(Integer actionID) {
        this.actionID = actionID;
    }

    public Boolean getReserve() {
        return reserve;
    }

    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getConfirm() {
        return confirm;
    }

    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
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

    @XmlTransient
    public List<Programs> getProgramsList1() {
        return programsList1;
    }

    public void setProgramsList1(List<Programs> programsList1) {
        this.programsList1 = programsList1;
    }

    @XmlTransient
    public List<Personnelafyshes> getPersonnelafyshesList() {
        return personnelafyshesList;
    }

    public void setPersonnelafyshesList(List<Personnelafyshes> personnelafyshesList) {
        this.personnelafyshesList = personnelafyshesList;
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
        hash += (personnelID != null ? personnelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnels)) {
            return false;
        }
        Personnels other = (Personnels) object;
        if ((this.personnelID == null && other.personnelID != null) || (this.personnelID != null && !this.personnelID.equals(other.personnelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Personnels[ personnelID=" + personnelID + " ]";
    }
    
}
