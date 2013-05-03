package com.lady.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.lady.dao.ProduitDao;
import com.lady.entities.Produit;

@ManagedBean( name = "listerProduitsBean" )
@RequestScoped
public class ListerProduitsBackingBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Produit>     produits;

    @EJB
    private ProduitDao        produitDao;

    @PostConstruct
    public void init() {
        produits = produitDao.lister();
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void supprimer( Produit produit ) {
        produitDao.supprimer( produit );
        produits.remove( produit );
    }
}