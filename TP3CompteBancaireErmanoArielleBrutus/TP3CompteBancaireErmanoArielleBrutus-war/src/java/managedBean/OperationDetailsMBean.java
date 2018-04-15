/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.Client;
import entities.CompteBancaire;
import entities.Operations;
import entities.TypeOperation;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.GestionnaireDeClient;
import session.GestionnaireDeCompteBancaire;
import session.GestionnaireDeTypeOperation;
import session.GestionnaireOperations;

/**
 *
 * @author Ermano
 */
@Named(value = "OperationDetailsMBean")
@ViewScoped
public class OperationDetailsMBean implements Serializable {

    /**
     * Creates a new instance of newOperation
     */
    private long idCompte;
    private Operations operation;
    private String erreurs;

    public long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(long idCompte) {
        this.idCompte = idCompte;
    }

    public OperationDetailsMBean() {
    }

    @EJB
    private GestionnaireDeClient gestionnaireDeClient;

    @EJB
    private GestionnaireOperations gestionnaireOperations;

    @EJB
    private GestionnaireDeCompteBancaire gestionnaireDeCompteBancaire;

    @EJB
    private GestionnaireDeTypeOperation gestionnaireDeTypeOperation;

    public void loadOperation() {
        operation = gestionnaireOperations.getOperation(idCompte);
    }

    public Operations getDetails() {
        if (operation == null) {
            operation = new Operations();
        }
        return operation;
    }

    public String list() {
        System.out.println("###LIST###");
        return "operations";
    }

    public String update() {
        System.out.println("###UPDATE###");

        if (operation.getCompteDebiteur().getSolde() > operation.getMontant()) {

            if (!operation.getTypeTransaction().getType().equals("Depot")) {
                CompteBancaire debt = operation.getCompteDebiteur();
                debt.setSolde(debt.getSolde() - operation.getMontant());
                gestionnaireDeCompteBancaire.update(debt);
            }else {
                operation.setCompteDebiteur(null);
            }

            CompteBancaire cred = operation.getCompteCrediteur();
            cred.setSolde(cred.getSolde() + operation.getMontant());
            gestionnaireDeCompteBancaire.update(cred);

            operation.setDatecreated((new Date()).toString());
            operation = gestionnaireOperations.update(operation);
            return "operations";
        }

        erreurs = "Vérifiez les détails de l'opération.";

        return "#";

    }

    private Converter compteBancaireConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            CompteBancaire cb = gestionnaireDeCompteBancaire.getCompteBancaire(Long.valueOf(value));
            return cb;
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            CompteBancaire cb = (CompteBancaire) value;
            return String.valueOf(cb.getId());
        }

    };

    public Converter getCompteBancaireConverter() {
        return compteBancaireConverter;
    }

    public List<CompteBancaire> getComptesBancaire() {
        return gestionnaireDeCompteBancaire.getAllComptes();
    }

    private Converter typeOperationConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            TypeOperation t = gestionnaireDeTypeOperation.getTypeOperation(Long.valueOf(value));
            return t;
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            TypeOperation t = (TypeOperation) value;
            return String.valueOf(t.getId());
        }

    };

    public Converter getTypeOperationConverter() {
        return typeOperationConverter;
    }

    public List<TypeOperation> getAllTypeOperations() {
        return gestionnaireDeTypeOperation.getAllTypes();
    }

    public String getErreurs() {
        return erreurs;
    }

}
