/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.Client;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeClient;

/**
 *
 * @author Ermano
 */
@Named(value = "clientDetailsMBean")
@ViewScoped
public class ClientDetailsMBean implements Serializable {

    /**
     * Creates a new instance of ClientDetailsMBean
     */
    private int idClient;
    private Client client;

    @EJB
    private GestionnaireDeClient gestionnaireDeClient;

    public ClientDetailsMBean() {
    }

    public void loadClient() {
        client = gestionnaireDeClient.getClient(idClient);
        
    }

    public Client getDetails() {
        if(client == null)
            client = new Client();
        return client;
    }

    public String list() {
        System.out.println("###LIST###");
        return "clients";
    }

    public int getIdClient() {
        return idClient;
    }
    
    public String update() {  
    System.out.println("###UPDATE###");
    client.setDatecreated((new Date()).toString());
    client = gestionnaireDeClient.update(client);  
    return "clients";  
  } 

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

}
