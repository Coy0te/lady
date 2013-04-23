package com.lady.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.lady.entities.Produit;

@Stateless
public class ProduitDao {
    private static final String JPQL_LISTE_PRODUITS = "SELECT p FROM Produit p ORDER BY p.id";

    // Injection du manager, qui s'occupe de la connexion avec la BDD
    @PersistenceContext( unitName = "bdd_lady_PU" )
    private EntityManager       em;

    // Enregistrement d'un nouveau produit
    public void creer( Produit produit ) throws DAOException {
        try {
            em.persist( produit );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Récupération de la liste des produits */
    public List<Produit> lister() throws DAOException {
        try {
            TypedQuery<Produit> query = em.createQuery( JPQL_LISTE_PRODUITS, Produit.class );
            return query.getResultList();
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Recherche d'un produit à partir de son ID */
    public Produit trouver( long id ) throws DAOException {
        try {
            return em.find( Produit.class, id );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }

    /* Supprimer un produit */
    public void supprimer( Produit produit ) throws DAOException {
        try {
            em.remove( em.merge( produit ) );
        } catch ( Exception e ) {
            throw new DAOException( e );
        }
    }
}
