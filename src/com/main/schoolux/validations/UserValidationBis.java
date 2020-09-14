package com.main.schoolux.validations;

import com.main.schoolux.utilitaries.MyIntUtil;
import com.main.schoolux.utilitaries.MyValidationUtil;
import com.persistence.entities.RoleEntity;
import com.persistence.entities.UserEntity;
import com.persistence.entityFinderImplementation.EntityFinderImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





public class UserValidationBis {

    private final static Logger LOG = Logger.getLogger(UserValidationBis.class);


    /**
     * Validations liées à la connexion d'un utilisateur
     **/
    public static UserEntity ToSignIn(HttpServletRequest request) {


        LOG.info("=== START - ToSignIn() in UserValidation ===");

        Map<String, String> myValidAttributes = new HashMap<String, String>();
        Map<String, String> myErrors = new HashMap<String, String>();

        UserEntity myUser = new UserEntity();


        //////////
        /// APPELS AUX METHODES DE VALIDATION POUR CHAQUE PARAMETRE
        //////////


        MyValidationUtil.CheckEmptyAndLength(
                request.getParameter("usernameFromForm"),
                "usernameFromForm",
                5,
                50,
                myErrors,
                myValidAttributes
        );


        MyValidationUtil.CheckEmptyAndLength(
                request.getParameter("passwordFromForm"),
                "passwordFromForm",
                5,
                50,
                myErrors,
                myValidAttributes
        );


        if (myErrors.size() != 0) {

            // Stockage des inputs valides et des messages d'erreur dans l'objet request ou session  (choisir) : on prend request vu que les errors et valids ne servent ici que dans la jsp de réponse
            // Voir notes.txt => DIFFERENCE ATTRIBUTS ET PARAMETRES DANS LA REQUETE
            request.setAttribute("myErrorsRequestKey", myErrors);
            request.setAttribute("myValidAttributesRequestKey", myValidAttributes);
            //request.getSession().setAttribute("myErrorsSessionKey", myErrors);
            //request.getSession().setAttribute("myValidAttributesSessionKey", myValidAttributes);

            // Mise à null de l'objet qui sert de retour à la méthode
            myUser = null;

        } else {
            myUser.setUsername(request.getParameter("usernameFromForm"));
            myUser.setPassword(request.getParameter("usernameFromForm"));
        }

        LOG.info("=== END -  ToSignIn() in UserValidation ===");
        return myUser;


    }


    /////////
    /// METHODES DE VALIDATION DES PARAMETRES DE LA REQUETE
    //////////


    private String validationPassword(String password, String confirmationPassword) throws Exception {


        if (password == null || password.isEmpty()) {
            throw new Exception("Un mot de passe est requis");
        }

        if (!password.equals(confirmationPassword)) {
            throw new Exception("Les mots de passe ne sont pas identiques ");
        }

        return password;

    }


    /**
     * Validations liées à la création d'un utilisateur
     **/
    public UserEntity UserValidation_Create(HttpServletRequest request) {

        LOG.info("=== START - createValidation() in UserValidation ===");


        Map<String, String> myValidAttributes = new HashMap<String, String>();
        Map<String, String> myErrors = new HashMap<String, String>();

        UserEntity myUser = new UserEntity();


        MyValidationUtil.CheckEmpty(
                request.getParameter("firstNameFromForm"),
                "firstNameFromForm",
                myErrors,
                myValidAttributes);


        //////////
        /// RECUPERATION DES PARAMETRES DE LA REQUETE
        //////////

        // Amelioration : on pourrait directement passer le request.getParameter("Nomparam") en paramètre de la méthode de validation correspondante
        // exemple :  this.validationFirstName(request.getParameter("firstNameFromForm"));
        // ici on fait en 2 étapes, mais ça permet de peupler la myValidAttributes avec un nom de variable et pas un retour encore une fois

        String firstNameRequest = request.getParameter("firstNameFromForm");
        String lastNameRequest = request.getParameter("lastNameFromForm");
        String usernameRequest = request.getParameter("usernameFromForm");
        String passwordRequest = request.getParameter("passwordFromForm");
        String confirmationPasswordRequest = request.getParameter("confirmationPasswordFromForm");

        String phoneNumberRequest = request.getParameter("phoneNumberFromForm");
        String birthdateRequest = request.getParameter("birthdateFromForm");
        String genderRequest = request.getParameter("genderFromForm");
        String emailAddressRequest = request.getParameter("emailAddressFromForm");

        String titleRequest = request.getParameter("titleFromForm");
        String photoRequest = request.getParameter("photoFromForm");
        String roleRequest = request.getParameter("roleFromForm");
        String parentRequest = request.getParameter("parentFromForm");


        /////
        // APPELS AUX METHODES DE VALIDATION POUR CHAQUE PARAMETRE
        /////







        /* Stockage du résultat et des messages d'erreur dans l'objet request ou session  (choisir)*/
        // Voir notes.txt => DIFFERENCE ATTRIBUTS ET PARAMETRES DANS LA REQUETE
        //request.setAttribute("myErrorsRequestKey", myErrors);
        //request.setAttribute("myValidAttributesRequestKey", myValidAttributes);
        request.setAttribute("myErrorsSessionKey", myErrors);
        request.setAttribute("myValidAttributesSessionKey", myValidAttributes);



        /* A mettre dans le controller
        // Transmission de la paire d'objets request/response à la JSP adaptée
        if (myErrors.size() != 0) {
            request.getRequestDispatcher(VUE_FORM).forward(request, response);
        }
        else {
            this.getServletContext().getRequestDispatcher(VUE_SUCCESS).forward(request, response);
        }
        */


        // mise à null de l'objet userEntity au cas où il y aurait eu une erreur
        // on teste ensuite dans le contrôleur si ce retour est null pour savoir vers quoi dispatcher
        if (myErrors.size() != 0) {
            myUser = null;
        }

        LOG.info("=== END - createValidation() in UserValidation ===");
        return myUser;


    }// END createValidation()


    ////////
    // METHODES DE VALIDATION DES PARAMETRES DE LA REQUETE
    ////////
}
