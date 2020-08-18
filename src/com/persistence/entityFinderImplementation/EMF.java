package com.persistence.entityFinderImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** 
 * Class to get a connection to the database
 * 
 * @author Renaud DIANA
 */
public final class EMF {

    /* Initialement :
	private static EntityManagerFactory emfInstance =
	        Persistence.createEntityManagerFactory("your_unit_persistence_name");
     */

    // Pour projet schoolUX  => la persistence unit à passer en paramètre ci-dessous est dans le persistence.xml
    private static EntityManagerFactory emfInstance =
            Persistence.createEntityManagerFactory("PersistUnit_schoolUX");

    private EMF() {}

    public static EntityManagerFactory getEMF() {
        return emfInstance;
    }
    
    public static EntityManager getEM() {
        return emfInstance.createEntityManager();
    }
 
 /*	Create EntityManager in others classes
  * EntityManager em = EMF.getEM();
  * try {
  *     // ... do stuff with em ...
  * } finally {
  *     em.close();
  * }
  */
}
