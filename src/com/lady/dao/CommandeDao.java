package com.lady.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lady.entities.Commande;

@Stateless
public class CommandeDao {
    private static final String JPQL_LISTE_COMMANDES = "SELECT c FROM Commande c ORDER BY c.id";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_lady_PU" )
    private EntityManager       em;

    // Enregistrement d'une nouvelle commande
    public void creer( Commande commande ) throws DAOException {
        try {
            em.persist( commande );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Récupération de la liste des commandes */
    public List<Commande> lister() throws DAOException {
        try {
            TypedQuery<Commande> query = em.createQuery( JPQL_LISTE_COMMANDES, Commande.class );
            return query.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Recherche d'une commande à partir de son ID */
    public Commande trouver( long id ) throws DAOException {
        try {
            return em.find( Commande.class, id );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Supprimer une commande */
    public void supprimer( Commande commande ) throws DAOException {
        try {
            em.remove( em.merge( commande ) );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
