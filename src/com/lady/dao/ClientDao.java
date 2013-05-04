package com.lady.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lady.entities.Client;

@Stateless
public class ClientDao {
    private static final String JPQL_LISTE_CLIENTS              = "SELECT c FROM Client c ORDER BY c.dateCreation DESC";
    private static final String JPQL_LISTE_CLIENTS_POUR_PERIODE = "SELECT c FROM Client c WHERE c.dateCreation>:dateDebut AND c.dateCreation<:dateFin ORDER BY c.dateCreation";
    private static final String JPQL_CLIENT_PAR_PORTABLE        = "SELECT c FROM Client c WHERE c.portable=:portable";
    private static final String PARAM_PORTABLE                  = "portable";
    private static final String PARAM_DEBUT                     = "dateDebut";
    private static final String PARAM_FIN                       = "dateFin";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_lady_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouveau client
    public void creer( Client client ) throws DAOException {
        try {
            em.persist( client );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Récupération de la liste des clients */
    public List<Client> lister() throws DAOException {
        try {
            TypedQuery<Client> query = em.createQuery( JPQL_LISTE_CLIENTS, Client.class );
            return query.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Récupération de la liste des clients pour une période donnée */
    public List<Client> lister( Date debut, Date fin ) throws DAOException {
        try {
            TypedQuery<Client> query = em.createQuery( JPQL_LISTE_CLIENTS_POUR_PERIODE, Client.class );
            query.setParameter( PARAM_DEBUT, debut );
            query.setParameter( PARAM_FIN, fin );
            return query.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Recherche d'un client à partir de son ID */
    public Client trouver( long id ) throws DAOException {
        try {
            return em.find( Client.class, id );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Recherche d'un client via son numéro de portable */
    public Client trouver( String portable ) throws DAOException {
        try {
            Query query = em.createQuery( JPQL_CLIENT_PAR_PORTABLE );
            query.setParameter( PARAM_PORTABLE, portable );
            return (Client) query.setMaxResults( 1 ).getSingleResult();
        } catch ( NoResultException e ) {
            // Si aucun sujet dans le forum, on retourne null.
            return null;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Supprimer un client */
    public void supprimer( Client client ) throws DAOException {
        try {
            em.remove( em.merge( client ) );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
