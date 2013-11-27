/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Krarup Knudsen
 */
@Entity
@Table(name = "CREDIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credit.findAll", query = "SELECT c FROM Credit c"),
    @NamedQuery(name = "Credit.findByPersonId", query = "SELECT c FROM Credit c WHERE c.personId = :personId"),
    @NamedQuery(name = "Credit.findByAmount", query = "SELECT c FROM Credit c WHERE c.amount = :amount")})
public class Credit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSON_ID")
    private Integer personId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;

    public Credit() {
    }

    public Credit(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credit)) {
            return false;
        }
        Credit other = (Credit) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Credit[ personId=" + personId + " ]";
    }
    
}
