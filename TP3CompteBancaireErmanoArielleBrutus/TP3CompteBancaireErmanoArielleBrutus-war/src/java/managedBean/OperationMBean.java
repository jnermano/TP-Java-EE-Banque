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
import session.GestionnaireOperations;

/**
 *
 * @author Ermano
 */
@Named(value = "operationMBean")
@ViewScoped
public class OperationMBean implements Serializable {

    /**
     * Creates a new instance of OperationMBean
     */
    public OperationMBean() {
    }
    
    @EJB
    private GestionnaireOperations gestionnaireOperations;
    
    public List<Operations> getAllOperations(){
        return gestionnaireOperations.getAllOperations();
    }
    
    public String showDetails(long idOperation){
        return "newoperation?idOperation="+idOperation;
    }
    
}
