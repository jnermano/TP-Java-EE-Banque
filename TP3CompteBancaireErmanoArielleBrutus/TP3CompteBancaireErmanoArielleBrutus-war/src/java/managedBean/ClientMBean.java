/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.Client;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeClient;

/**
 *
 * @author Ermano
 */
@Named(value = "clientMBean")
@ViewScoped
public class ClientMBean implements Serializable {

    /**
     * Creates a new instance of ClientMBean
     */
    public ClientMBean() {
    }
    
     @EJB
    private GestionnaireDeClient gestionnaireDeClient;
    
    public List<Client> getAllClient(){
        return gestionnaireDeClient.getAllClient();
    }
    

    public String showDetails(int idClient) {  
        return "newclient?idClient=" + idClient;  
    } 
    
}
