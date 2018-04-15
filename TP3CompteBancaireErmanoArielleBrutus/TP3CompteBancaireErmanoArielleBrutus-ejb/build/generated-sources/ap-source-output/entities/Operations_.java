package entities;

import entities.CompteBancaire;
import entities.TypeOperation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-08T00:19:55")
@StaticMetamodel(Operations.class)
public class Operations_ { 

    public static volatile SingularAttribute<Operations, TypeOperation> typeTransaction;
    public static volatile SingularAttribute<Operations, CompteBancaire> compteCrediteur;
    public static volatile SingularAttribute<Operations, String> createdby;
    public static volatile SingularAttribute<Operations, Integer> montant;
    public static volatile SingularAttribute<Operations, Long> id;
    public static volatile SingularAttribute<Operations, String> datecreated;
    public static volatile SingularAttribute<Operations, CompteBancaire> compteDebiteur;

}