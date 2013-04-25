package com.lady.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lady.dao.ClientDao;
import com.lady.dao.DAOException;

@ManagedBean
@RequestScoped
public class ExistencePortableValidator implements Validator {

    private static final String PORTABLE_EXISTE_DEJA = "Ce numéro de portable existe déjà.";

    @EJB
    private ClientDao           clientDao;

    @Override
    public void validate( FacesContext context, UIComponent component, Object value ) throws ValidatorException {
        /* Récupération de la valeur à traiter depuis le paramètre value */
        String portable = (String) value;
        try {
            if ( clientDao.trouver( portable ) != null ) {
                /*
                 * Si une adresse est retournée, alors on envoie une exception propre à JSF, qu'on initialise avec un FacesMessage de
                 * gravité "Erreur" et contenant le message d'explication. Le framework va alors gérer lui-même cette exception et s'en
                 * servir pour afficher le message d'erreur à l'utilisateur.
                 */
                throw new ValidatorException(
                        new FacesMessage( FacesMessage.SEVERITY_ERROR, PORTABLE_EXISTE_DEJA, portable ) );
            }
        } catch ( DAOException e ) {
            /*
             * En cas d'erreur imprévue émanant de la BDD, on prépare un message d'erreur contenant l'exception retournée, pour l'afficher à
             * l'utilisateur ensuite.
             */
            FacesMessage message = new FacesMessage( FacesMessage.SEVERITY_ERROR, e.getMessage(), null );
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage( component.getClientId( facesContext ), message );
        }
    }
}