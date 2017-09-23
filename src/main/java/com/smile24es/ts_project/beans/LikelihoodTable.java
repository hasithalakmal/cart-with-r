/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smile24es.ts_project.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author hasithagamage
 */
@Entity
@Table(name = "LIKELIHOOD_TABLE", catalog = "NAIVE_BAYERS", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikelihoodTable.findAll", query = "SELECT l FROM LikelihoodTable l")
    , @NamedQuery(name = "LikelihoodTable.findByLikelihoodTableId", query = "SELECT l FROM LikelihoodTable l WHERE l.likelihoodTableId = :likelihoodTableId")
    , @NamedQuery(name = "LikelihoodTable.findByCriteria", query = "SELECT l FROM LikelihoodTable l WHERE l.criteria = :criteria")
    , @NamedQuery(name = "LikelihoodTable.findByTotalPositive", query = "SELECT l FROM LikelihoodTable l WHERE l.totalPositive = :totalPositive")
    , @NamedQuery(name = "LikelihoodTable.findByTotalNegative", query = "SELECT l FROM LikelihoodTable l WHERE l.totalNegative = :totalNegative")
    , @NamedQuery(name = "LikelihoodTable.findByPositiveProbability", query = "SELECT l FROM LikelihoodTable l WHERE l.positiveProbability = :positiveProbability")
    , @NamedQuery(name = "LikelihoodTable.findByNegativeProbability", query = "SELECT l FROM LikelihoodTable l WHERE l.negativeProbability = :negativeProbability")})
public class LikelihoodTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LIKELIHOOD_TABLE_ID", nullable = false)
    private Integer likelihoodTableId;
    @Size(max = 45)
    @Column(length = 45)
    private String criteria;
    @Column(name = "TOTAL_POSITIVE")
    private Integer totalPositive;
    @Column(name = "TOTAL_NEGATIVE")
    private Integer totalNegative;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "POSITIVE_PROBABILITY", precision = 22)
    private Double positiveProbability;
    @Column(name = "NEGATIVE_PROBABILITY", precision = 22)
    private Double negativeProbability;
//    @OneToMany(mappedBy = "likelihoodTableId")
//    private Collection<LikelihoodRecode> likelihoodRecodeCollection;

    public LikelihoodTable() {
    }

    public LikelihoodTable(Integer likelihoodTableId) {
        this.likelihoodTableId = likelihoodTableId;
    }

    public Integer getLikelihoodTableId() {
        return likelihoodTableId;
    }

    public void setLikelihoodTableId(Integer likelihoodTableId) {
        this.likelihoodTableId = likelihoodTableId;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Integer getTotalPositive() {
        return totalPositive;
    }

    public void setTotalPositive(Integer totalPositive) {
        this.totalPositive = totalPositive;
    }

    public Integer getTotalNegative() {
        return totalNegative;
    }

    public void setTotalNegative(Integer totalNegative) {
        this.totalNegative = totalNegative;
    }

    public Double getPositiveProbability() {
        return positiveProbability;
    }

    public void setPositiveProbability(Double positiveProbability) {
        this.positiveProbability = positiveProbability;
    }

    public Double getNegativeProbability() {
        return negativeProbability;
    }

    public void setNegativeProbability(Double negativeProbability) {
        this.negativeProbability = negativeProbability;
    }

//    @XmlTransient
//    @JsonIgnore
//    public Collection<LikelihoodRecode> getLikelihoodRecodeCollection() {
//        return likelihoodRecodeCollection;
//    }
//
//    public void setLikelihoodRecodeCollection(Collection<LikelihoodRecode> likelihoodRecodeCollection) {
//        this.likelihoodRecodeCollection = likelihoodRecodeCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (likelihoodTableId != null ? likelihoodTableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikelihoodTable)) {
            return false;
        }
        LikelihoodTable other = (LikelihoodTable) object;
        if ((this.likelihoodTableId == null && other.likelihoodTableId != null) || (this.likelihoodTableId != null && !this.likelihoodTableId.equals(other.likelihoodTableId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smile24es.ts_project.beans.LikelihoodTable[ likelihoodTableId=" + likelihoodTableId + " ]";
    }
    
}
