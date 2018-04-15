package entities;

import entities.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-08T00:19:55")
@StaticMetamodel(CompteBancaire.class)
public class CompteBancaire_ { 

    public static volatile SingularAttribute<CompteBancaire, String> createdby;
    public static volatile SingularAttribute<CompteBancaire, Integer> solde;
    public static volatile SingularAttribute<CompteBancaire, Client> client;
    public static volatile SingularAttribute<CompteBancaire, Long> id;
    public static volatile SingularAttribute<CompteBancaire, String> datecreated;
    public static volatile SingularAttribute<CompteBancaire, String> nom;

}