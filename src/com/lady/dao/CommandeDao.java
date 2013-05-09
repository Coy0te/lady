package com.lady.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lady.entities.Commande;

@Stateless
public class CommandeDao {
    private static final String JPQL_LISTE_COMMANDES              = "SELECT c FROM Commande c ORDER BY c.datePaiement DESC";
    private static final String JPQL_LISTE_COMMANDES_POUR_PERIODE = "SELECT c FROM Commande c WHERE c.datePaiement>:dateDebut AND c.datePaiement<:dateFin ORDER BY c.datePaiement";
    private static final String PARAM_DEBUT                       = "dateDebut";
    private static final String PARAM_FIN                         = "dateFin";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_lady_PU" )
    private EntityManager       em;

    /* Enregistrement d'une nouvelle commande */
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

    /* Récupération de la liste des commandes pour une période donnée */
    public List<Commande> lister( Date debut, Date fin ) throws DAOException {
        try {
            TypedQuery<Commande> query = em.createQuery( JPQL_LISTE_COMMANDES_POUR_PERIODE, Commande.class );
            query.setParameter( PARAM_DEBUT, debut );
            query.setParameter( PARAM_FIN, fin );
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

    /* Mise à jour d'une commande existante */
    public Commande mettreAJour( Commande commande ) throws DAOException {
        try {
            commande = em.merge( commande );
            return commande;
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Rafraichissement d'une commande */
    public Commande rafraichir( Commande commande ) throws DAOException {
        try {
            Commande managedCommande = em.find( Commande.class, commande.getId() );
            em.refresh( managedCommande );
            return managedCommande;
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
