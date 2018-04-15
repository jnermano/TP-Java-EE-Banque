/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entities.Client;
import entities.CompteBancaire;
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

/**
 *
 * @author Ermano
 */
@Named(value = "compteBancaireDetailsMBean")
@ViewScoped
public class CompteBancaireDetailsMBean implements Serializable {

    /**
     * Creates a new instance of CompteBancaireDetailsMBean
     */
    private long idCompteBancaire;
    private CompteBancaire compteBancaire;

    @EJB
    private GestionnaireDeCompteBancaire gestionnaireDeCompteBancaire;

    @EJB
    private GestionnaireDeClient gestionnaireDeClient;

    public CompteBancaireDetailsMBean() {
    }

    public void loadCompteBancaire() {
        compteBancaire = gestionnaireDeCompteBancaire.getCompteBancaire(idCompteBancaire);
    }

    public CompteBancaire getDetails() {
        if(compteBancaire == null)
            compteBancaire = new CompteBancaire();
        
        return compteBancaire;
    }

    public String list() {
        System.out.println("###LIST###");
        return "comptes";
    }

    public String update() {
        System.out.println("###UPDATE###");
        compteBancaire.setDatecreated((new Date()).toString());
        compteBancaire = gestionnaireDeCompteBancaire.update(compteBancaire);
        return "comptes";
    }

    public long getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(long idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }

    /**
     * COnverter
     */
    private Converter clientConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Client c = gestionnaireDeClient.getClient(Long.valueOf(value));
            return c;
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Client c = (Client) value;
            return String.valueOf(c.getId());
        }

    };
    
    public Converter getClientConverter(){
        return clientConverter;
    }
    
    public List<Client> getClients(){
        return gestionnaireDeClient.getAllClient();
    }

}
