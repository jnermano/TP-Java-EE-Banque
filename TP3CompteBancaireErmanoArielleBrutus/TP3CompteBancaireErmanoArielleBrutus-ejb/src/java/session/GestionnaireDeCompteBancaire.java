/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.CompteBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ermano
 */
@Stateless
@LocalBean
public class GestionnaireDeCompteBancaire implements Serializable {

    @PersistenceContext(unitName = "TP3CompteBancaireErmanoArielleBrutus-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public GestionnaireDeCompteBancaire() {
        
    }
    
    
    
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }

    public CompteBancaire getCompteBancaire(long id) {
        return em.find(CompteBancaire.class, id);
    }

    public CompteBancaire update(CompteBancaire cb) {
        return em.merge(cb);
    }

    public List<CompteBancaire> getAllComptes() {

        Query q = em.createNamedQuery("CompteBancaire.findAll");
        return q.getResultList();
    }

    public void creerComptesTest() {
        creerCompte(new CompteBancaire("John Lennon", 150000));
        creerCompte(new CompteBancaire("Paul McCartney", 950000));
        creerCompte(new CompteBancaire("Ringo Starr", 20000));
        creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    public long getCount() {
        Query query = em.createNamedQuery("CompteBancaire.count");
        return (Long) query.getSingleResult();
    }
}
