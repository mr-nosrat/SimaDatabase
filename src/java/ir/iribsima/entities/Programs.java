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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "programs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programs.findAll", query = "SELECT p FROM Programs p"),
    @NamedQuery(name = "Programs.findByProgramID", query = "SELECT p FROM Programs p WHERE p.programID = :programID"),
    @NamedQuery(name = "Programs.findByProgramName", query = "SELECT p FROM Programs p WHERE p.programName = :programName"),
    @NamedQuery(name = "Programs.findByProgramCount", query = "SELECT p FROM Programs p WHERE p.programCount = :programCount"),
    @NamedQuery(name = "Programs.findByProgramTime", query = "SELECT p FROM Programs p WHERE p.programTime = :programTime"),
    @NamedQuery(name = "Programs.findByEstimateNumber", query = "SELECT p FROM Programs p WHERE p.estimateNumber = :estimateNumber"),
    @NamedQuery(name = "Programs.findByArchiveNumber", query = "SELECT p FROM Programs p WHERE p.archiveNumber = :archiveNumber"),
    @NamedQuery(name = "Programs.findByProgramPrefixCode", query = "SELECT p FROM Programs p WHERE p.programPrefixCode = :programPrefixCode"),
    @NamedQuery(name = "Programs.findByProgramCode", query = "SELECT p FROM Programs p WHERE p.programCode = :programCode"),
    @NamedQuery(name = "Programs.findByAmendmentEstimate", query = "SELECT p FROM Programs p WHERE p.amendmentEstimate = :amendmentEstimate"),
    @NamedQuery(name = "Programs.findByActive", query = "SELECT p FROM Programs p WHERE p.active = :active")})
public class Programs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "programID")
    private Integer programID;
    @Size(max = 200)
    @Column(name = "programName")
    private String programName;
    @Column(name = "programCount")
    private Integer programCount;
    @Size(max = 9)
    @Column(name = "programTime")
    private String programTime;
    @Size(max = 20)
    @Column(name = "estimateNumber")
    private String estimateNumber;
    @Size(max = 20)
    @Column(name = "archiveNumber")
    private String archiveNumber;
    @Size(max = 1)
    @Column(name = "programPrefixCode")
    private String programPrefixCode;
    @Size(max = 9)
    @Column(name = "programCode")
    private String programCode;
    @Size(max = 1)
    @Column(name = "amendmentEstimate")
    private String amendmentEstimate;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "unitID", referencedColumnName = "unitID")
    @ManyToOne
    private Units unitID;
    @JoinColumn(name = "subjectID", referencedColumnName = "subjectID")
    @ManyToOne
    private Subjects subjectID;
    @JoinColumn(name = "programtypeID", referencedColumnName = "programtypeID")
    @ManyToOne
    private Programtypes programtypeID;
    @JoinColumn(name = "producerID", referencedColumnName = "personnelID")
    @ManyToOne
    private Personnels producerID;
    @JoinColumn(name = "directorID", referencedColumnName = "personnelID")
    @ManyToOne
    private Personnels directorID;
    @JoinColumn(name = "productgroupID", referencedColumnName = "programgroupID")
    @ManyToOne
    private Programgroups productgroupID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programID")
    private List<Equipmentafyshes> equipmentafyshesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programID")
    private List<Personnelafyshes> personnelafyshesList;
    @OneToMany(mappedBy = "programID")
    private List<Programproducts> programproductsList;

    public Programs() {
    }

    public Programs(Integer programID) {
        this.programID = programID;
    }

    public Integer getProgramID() {
        return programID;
    }

    public void setProgramID(Integer programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Integer getProgramCount() {
        return programCount;
    }

    public void setProgramCount(Integer programCount) {
        this.programCount = programCount;
    }

    public String getProgramTime() {
        return programTime;
    }

    public void setProgramTime(String programTime) {
        this.programTime = programTime;
    }

    public String getEstimateNumber() {
        return estimateNumber;
    }

    public void setEstimateNumber(String estimateNumber) {
        this.estimateNumber = estimateNumber;
    }

    public String getArchiveNumber() {
        return archiveNumber;
    }

    public void setArchiveNumber(String archiveNumber) {
        this.archiveNumber = archiveNumber;
    }

    public String getProgramPrefixCode() {
        return programPrefixCode;
    }

    public void setProgramPrefixCode(String programPrefixCode) {
        this.programPrefixCode = programPrefixCode;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getAmendmentEstimate() {
        return amendmentEstimate;
    }

    public void setAmendmentEstimate(String amendmentEstimate) {
        this.amendmentEstimate = amendmentEstimate;
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

    public Units getUnitID() {
        return unitID;
    }

    public void setUnitID(Units unitID) {
        this.unitID = unitID;
    }

    public Subjects getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subjects subjectID) {
        this.subjectID = subjectID;
    }

    public Programtypes getProgramtypeID() {
        return programtypeID;
    }

    public void setProgramtypeID(Programtypes programtypeID) {
        this.programtypeID = programtypeID;
    }

    public Personnels getProducerID() {
        return producerID;
    }

    public void setProducerID(Personnels producerID) {
        this.producerID = producerID;
    }

    public Personnels getDirectorID() {
        return directorID;
    }

    public void setDirectorID(Personnels directorID) {
        this.directorID = directorID;
    }

    public Programgroups getProductgroupID() {
        return productgroupID;
    }

    public void setProductgroupID(Programgroups productgroupID) {
        this.productgroupID = productgroupID;
    }

    @XmlTransient
    public List<Equipmentafyshes> getEquipmentafyshesList() {
        return equipmentafyshesList;
    }

    public void setEquipmentafyshesList(List<Equipmentafyshes> equipmentafyshesList) {
        this.equipmentafyshesList = equipmentafyshesList;
    }

    @XmlTransient
    public List<Personnelafyshes> getPersonnelafyshesList() {
        return personnelafyshesList;
    }

    public void setPersonnelafyshesList(List<Personnelafyshes> personnelafyshesList) {
        this.personnelafyshesList = personnelafyshesList;
    }

    @XmlTransient
    public List<Programproducts> getProgramproductsList() {
        return programproductsList;
    }

    public void setProgramproductsList(List<Programproducts> programproductsList) {
        this.programproductsList = programproductsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programID != null ? programID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programs)) {
            return false;
        }
        Programs other = (Programs) object;
        if ((this.programID == null && other.programID != null) || (this.programID != null && !this.programID.equals(other.programID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ir.iribsima.entities.Programs[ programID=" + programID + " ]";
    }
    
}
