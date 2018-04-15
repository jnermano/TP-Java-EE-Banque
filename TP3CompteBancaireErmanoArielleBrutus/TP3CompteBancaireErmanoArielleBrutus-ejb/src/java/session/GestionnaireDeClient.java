/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entities.Client;
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
public class GestionnaireDeClient implements Serializable {

    @PersistenceContext(unitName = "TP3CompteBancaireErmanoArielleBrutus-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void creerClient(Client c) {
        em.persist(c);
    }

    public List<Client> getAllClient() {
        Query query = em.createNamedQuery("Client.findAll");
        return query.getResultList();
    }
    
    public Client update(Client c){
        return em.merge(c);
    }

    public Client getClient(long id) {
        return em.find(Client.class, id);
    }
    
    public long getCount() {
        Query query = em.createNamedQuery("Client.count");
        return (Long) query.getSingleResult();
    }
}
