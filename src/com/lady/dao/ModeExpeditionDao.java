package com.lady.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lady.entities.ModeExpedition;

@Stateless
public class ModeExpeditionDao {
    private static final String JPQL_LISTE_MODE_EXPEDITION = "SELECT m FROM ModeExpedition m ORDER BY m.id";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_lady_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouveau mode d'expédition
    public void creer( ModeExpedition modeExpedition ) throws DAOException {
        try {
            em.persist( modeExpedition );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Récupération de la liste des modes d'expédition */
    public List<ModeExpedition> lister() throws DAOException {
        try {
            TypedQuery<ModeExpedition> query = em.createQuery( JPQL_LISTE_MODE_EXPEDITION, ModeExpedition.class );
            return query.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Recherche d'un mode d'expédition à partir de son ID */
    public ModeExpedition trouver( long id ) throws DAOException {
        try {
            return em.find( ModeExpedition.class, id );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Supprimer un mode d'expédition */
    public void supprimer( ModeExpedition modeExpedition ) throws DAOException {
        try {
            em.remove( em.merge( modeExpedition ) );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
