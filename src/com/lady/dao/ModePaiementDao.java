package com.lady.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lady.entities.ModePaiement;

@Stateless
public class ModePaiementDao {
    private static final String JPQL_LISTE_MODE_PAIEMENTS = "SELECT m FROM ModePaiement m ORDER BY m.id";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_lady_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouveau mode de paiement
    public void creer( ModePaiement modePaiement ) throws DAOException {
        try {
            em.persist( modePaiement );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Récupération de la liste des modes de paiement */
    public List<ModePaiement> lister() throws DAOException {
        try {
            TypedQuery<ModePaiement> query = em.createQuery( JPQL_LISTE_MODE_PAIEMENTS, ModePaiement.class );
            return query.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Recherche d'un mode de paiement à partir de son ID */
    public ModePaiement trouver( long id ) throws DAOException {
        try {
            return em.find( ModePaiement.class, id );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Supprimer un mode de paiement */
    public void supprimer( ModePaiement modePaiement ) throws DAOException {
        try {
            em.remove( em.merge( modePaiement ) );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
