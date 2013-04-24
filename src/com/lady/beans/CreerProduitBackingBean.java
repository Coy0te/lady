package com.lady.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.lady.dao.ProduitDao;
import com.lady.entities.ModePaiement;
import com.lady.entities.Produit;

@ManagedBean( name = "creerProduitBean" )
@ViewScoped
public class CreerProduitBackingBean implements Serializable {
    private static final long   serialVersionUID = 1L;
    private static final String URL_PAGE_PRODUIT = "/listerProduits.jsf?produitId=";

    private Produit             produit;
    private List<ModePaiement>  modesPaiement;

    @EJB
    private ProduitDao          produitDao;

    @PostConstruct
    public void init() {
        produit = new Produit();
    }

    public List<ModePaiement> getModesPaiement() {
        return modesPaiement;
    }

    public void creer() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        initialiserDateCreation();
        produitDao.creer( produit );
        externalContext.redirect( externalContext.getRequestContextPath() + URL_PAGE_PRODUIT
                + String.valueOf( produit.getId() ) );
    }

    private void initialiserDateCreation() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        produit.setDateCreation( date );
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit( Produit produit ) {
        this.produit = produit;
    }
}