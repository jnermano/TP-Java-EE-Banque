/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ermano
 */
@Entity
@Table(name = "Operations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT t FROM Operations t order by t.id desc"),
    @NamedQuery(name = "Operations.findById", query = "SELECT t FROM Operations t WHERE t.id = :transId"),
    @NamedQuery(name = "Operations.count", query = "SELECT COUNT(o) FROM Operations o")
   
})
public class Operations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
  
    @ManyToOne
    private TypeOperation typeTransaction;
    
    @OneToOne
    @JoinColumn(nullable = true)
    private CompteBancaire compteDebiteur;
    
    @OneToOne
    private CompteBancaire compteCrediteur;
    
    private String datecreated;
    private String createdby;
    
    private int montant;

    public Operations() {
    }

    public Operations(CompteBancaire compteDebiteur, CompteBancaire compteCrediteur, String datecreated, String createdby, int montant) {
        this.compteDebiteur = compteDebiteur;
        this.compteCrediteur = compteCrediteur;
        this.datecreated = datecreated;
        this.createdby = createdby;
        this.montant = montant;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOperation getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeOperation typeTransaction) {
        this.typeTransaction = typeTransaction;
    }
    
    

  

    public CompteBancaire getCompteDebiteur() {
        return compteDebiteur;
    }

    public void setCompteDebiteur(CompteBancaire compteDebiteur) {
        this.compteDebiteur = compteDebiteur;
    }

    public CompteBancaire getCompteCrediteur() {
        return compteCrediteur;
    }

    public void setCompteCrediteur(CompteBancaire compteCrediteur) {
        this.compteCrediteur = compteCrediteur;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Transaction[ id=" + id + " ]";
    }
    
}
