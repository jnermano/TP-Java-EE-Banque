/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import entities.Client;
import entities.CompteBancaire;
import entities.TypeOperation;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import session.GestionnaireDeClient;
import session.GestionnaireDeCompteBancaire;
import session.GestionnaireDeTypeOperation;
import session.GestionnaireOperations;

/**
 *
 * @author Ermano
 */
public class BootListener implements javax.servlet.ServletContextListener {
    
    @EJB
    private GestionnaireDeCompteBancaire  gestionnaireDeCompteBancaire;
    
    @EJB
    private GestionnaireDeClient gestionnaireDeClient;
    
    @EJB
    private GestionnaireOperations gestionnaireOperations;
    
    @EJB
    private GestionnaireDeTypeOperation  gestionnaireDeTypeOperation;
    

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        TypeOperation tope = new TypeOperation("Depot", "Depot cash");
        gestionnaireDeTypeOperation.update(tope);
        
        tope = new TypeOperation("Virement", "Virement de oompte en compte");
        gestionnaireDeTypeOperation.update(tope);
        
        
        Client c1 = new Client("Nicolas", "Ermano", "36910311", "jnermano86@gmail.com", "Port-au-Prince, Haiti", (new Date()).toString(), "Admin");
        c1 = gestionnaireDeClient.update(c1);
        
        CompteBancaire cb =new CompteBancaire("Compte 1", 15000, (new Date()).toString(), "Admin");
        cb.setClient(c1);
        cb = gestionnaireDeCompteBancaire.update(cb);
        
        cb =new CompteBancaire("Compte 2", 17000, (new Date()).toString(), "Admin");
        cb.setClient(c1);
        cb = gestionnaireDeCompteBancaire.update(cb);
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
    
}
