package com.lady.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lady.entities.Client;

@Stateless
public class ClientDao {
    private static final String JPQL_LISTE_CLIENTS = "SELECT c FROM Client c ORDER BY c.id";

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

    /* Recherche d'un client à partir de son ID */
    public Client trouver( long id ) throws DAOException {
        try {
            return em.find( Client.class, id );
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
