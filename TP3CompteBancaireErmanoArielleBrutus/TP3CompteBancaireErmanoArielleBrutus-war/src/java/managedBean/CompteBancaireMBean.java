/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.CompteBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeCompteBancaire;

/**
 *
 * @author Ermano
 */
@Named(value = "compteBancaireMBean")
@ViewScoped
public class CompteBancaireMBean implements Serializable {

    /**
     * Creates a new instance of CompteBancaireMBean
     */
    public CompteBancaireMBean() {
    }
    
    @EJB
    private GestionnaireDeCompteBancaire  gestionnaireDeCompteBancaire;
    
    public List<CompteBancaire> getAllComptesBancaire(){
        return gestionnaireDeCompteBancaire.getAllComptes();
    }
    
    
    
    public String showDetails(int idCompteBancaire) {  
        return "newcompte?idCompteBancaire=" + idCompteBancaire;  
    } 
    
}
