/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smile24es.ts_project.beans;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hasithagamage
 */
@Entity
@Table(name = "LIKELIHOOD_RECODE", catalog = "NAIVE_BAYERS", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LikelihoodRecode.findAll", query = "SELECT l FROM LikelihoodRecode l")
    , @NamedQuery(name = "LikelihoodRecode.findByLikelihoodRecodeId", query = "SELECT l FROM LikelihoodRecode l WHERE l.likelihoodRecodeId = :likelihoodRecodeId")
    , @NamedQuery(name = "LikelihoodRecode.findByPropertyName", query = "SELECT l FROM LikelihoodRecode l WHERE l.propertyName = :propertyName")
    , @NamedQuery(name = "LikelihoodRecode.findByPositiveRecodes", query = "SELECT l FROM LikelihoodRecode l WHERE l.positiveRecodes = :positiveRecodes")
    , @NamedQuery(name = "LikelihoodRecode.findByNegativeRecodes", query = "SELECT l FROM LikelihoodRecode l WHERE l.negativeRecodes = :negativeRecodes")
    , @NamedQuery(name = "LikelihoodRecode.findByCriteriaProbability", query = "SELECT l FROM LikelihoodRecode l WHERE l.criteriaProbability = :criteriaProbability")})
public class LikelihoodRecode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LIKELIHOOD_RECODE_ID", nullable = false)
    private Integer likelihoodRecodeId;
    @Size(max = 45)
    @Column(name = "PROPERTY_NAME", length = 45)
    private String propertyName;
    @Column(name = "POSITIVE_RECODES")
    private Integer positiveRecodes;
    @Column(name = "NEGATIVE_RECODES")
    private Integer negativeRecodes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CRITERIA_PROBABILITY", precision = 22)
    private Double criteriaProbability;
    @JoinColumn(name = "LIKELIHOOD_TABLE_ID", referencedColumnName = "LIKELIHOOD_TABLE_ID")
    @ManyToOne
    private LikelihoodTable likelihoodTableId;

    public LikelihoodRecode() {
    }

    public LikelihoodRecode(Integer likelihoodRecodeId) {
        this.likelihoodRecodeId = likelihoodRecodeId;
    }

    public Integer getLikelihoodRecodeId() {
        return likelihoodRecodeId;
    }

    public void setLikelihoodRecodeId(Integer likelihoodRecodeId) {
        this.likelihoodRecodeId = likelihoodRecodeId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getPositiveRecodes() {
        return positiveRecodes;
    }

    public void setPositiveRecodes(Integer positiveRecodes) {
        this.positiveRecodes = positiveRecodes;
    }

    public Integer getNegativeRecodes() {
        return negativeRecodes;
    }

    public void setNegativeRecodes(Integer negativeRecodes) {
        this.negativeRecodes = negativeRecodes;
    }

    public Double getCriteriaProbability() {
        return criteriaProbability;
    }

    public void setCriteriaProbability(Double criteriaProbability) {
        this.criteriaProbability = criteriaProbability;
    }

    public LikelihoodTable getLikelihoodTableId() {
        return likelihoodTableId;
    }

    public void setLikelihoodTableId(LikelihoodTable likelihoodTableId) {
        this.likelihoodTableId = likelihoodTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (likelihoodRecodeId != null ? likelihoodRecodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikelihoodRecode)) {
            return false;
        }
        LikelihoodRecode other = (LikelihoodRecode) object;
        if ((this.likelihoodRecodeId == null && other.likelihoodRecodeId != null) || (this.likelihoodRecodeId != null && !this.likelihoodRecodeId.equals(other.likelihoodRecodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smile24es.ts_project.beans.LikelihoodRecode[ likelihoodRecodeId=" + likelihoodRecodeId + " ]";
    }
    
}
