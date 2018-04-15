/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.Operations;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeClient;
import session.GestionnaireDeCompteBancaire;
import session.GestionnaireOperations;

/**
 *
 * @author Ermano
 */
@Named(value = "dashboardMBean")
@ViewScoped
public class DashboardMBean implements Serializable {

    /**
     * Creates a new instance of DashboardMBean
     */
    
    @EJB
    private GestionnaireDeCompteBancaire  gestionnaireDeCompteBancaire;
    
    @EJB
    private GestionnaireDeClient gestionnaireDeClient;
    
    @EJB
    private GestionnaireOperations gestionnaireOperations;
    
    public DashboardMBean() {
    }
    
    public List<Operations> getLastTransactions(){
        List<Operations> ope = gestionnaireOperations.getAllOperations();
        if (ope.size() > 5) {
            ope = ope.subList(0, 5);
        }
        return ope;
    }
    
    public long getCountClients(){
        return gestionnaireDeClient.getCount();
    }
    
    public long getCountComptes(){
        return gestionnaireDeCompteBancaire.getCount();
    }
    
    public long getCountTransactions(){
        return gestionnaireOperations.getCount();
    }
    
}
