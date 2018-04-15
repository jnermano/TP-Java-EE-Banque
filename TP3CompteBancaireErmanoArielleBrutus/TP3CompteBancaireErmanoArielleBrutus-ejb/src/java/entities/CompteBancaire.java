/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CompteBancaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteBancaire.findAll", query = "SELECT c FROM CompteBancaire c order by c.id desc"),
    @NamedQuery(name = "CompteBancaire.findById", query = "SELECT c FROM CompteBancaire c WHERE c.id = :CompteBancaireId"),
    @NamedQuery(name = "CompteBancaire.findByName", query = "SELECT c FROM CompteBancaire c WHERE c.nom = :nom"),
    @NamedQuery(name = "CompteBancaire.count", query = "SELECT COUNT(c) FROM CompteBancaire c")
})
public class CompteBancaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    private String nom;
    private int solde;
    private String datecreated;
    private String createdby;
    
   
    @ManyToOne
    private Client client;
    
    public CompteBancaire(){}

    public CompteBancaire(String nom, int solde, String datecreated, String createdby) {
        this.nom = nom;
        this.solde = solde;
        this.datecreated = datecreated;
        this.createdby = createdby;
    }
    
    
    
    public CompteBancaire(String nom, int solde) {  
    this.nom = nom;  
    this.solde = solde;  
  }  
    
  public void deposer(int montant) {  
    solde += montant;  
  }  
    
  public int retirer(int montant) {  
    if (montant > solde) {  
      solde -= montant;  
      return montant;  
    } else {  
      return 0;  
    }  
  } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(Locale.FRENCH, "%s [%d]", nom, solde);
    }
    
}
