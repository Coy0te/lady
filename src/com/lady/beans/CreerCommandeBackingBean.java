package com.lady.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.lady.dao.ClientDao;
import com.lady.dao.CommandeDao;
import com.lady.dao.ModeExpeditionDao;
import com.lady.dao.ModePaiementDao;
import com.lady.dao.ProduitDao;
import com.lady.entities.Client;
import com.lady.entities.Commande;
import com.lady.entities.ModeExpedition;
import com.lady.entities.ModePaiement;
import com.lady.entities.Produit;

@ManagedBean( name = "creerCommandeBean" )
@ViewScoped
public class CreerCommandeBackingBean implements Serializable {
    private static final long    serialVersionUID  = 1L;
    private static final String  URL_PAGE_COMMANDE = "/listerCommandes.jsf?commandeId=";

    private Commande             commande;
    private Produit              produit;
    private List<Produit>        produits;
    private List<ModePaiement>   modesPaiement;
    private List<Client>         clients;
    private List<ModeExpedition> modesExpedition;

    @EJB
    private CommandeDao          commandeDao;
    @EJB
    private ProduitDao           produitDao;
    @EJB
    private ClientDao            clientDao;
    @EJB
    private ModePaiementDao      modePaiementDao;
    @EJB
    private ModeExpeditionDao    modeExpeditionDao;

    @PostConstruct
    public void init() {
        commande = new Commande();
        produit = new Produit();
        produits = new ArrayList<Produit>();
        modesPaiement = modePaiementDao.lister();
        clients = clientDao.lister();
        modesExpedition = modeExpeditionDao.lister();
    }

    public List<ModePaiement> getModesPaiement() {
        return modesPaiement;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<ModeExpedition> getModesExpedition() {
        return modesExpedition;
    }

    public void ajouterProduit() throws IOException {
        produits.add( produit );
        produit = new Produit();
    }

    public void creer() throws IOException {
        commandeDao.creer( commande );
        for ( Produit produit : produits ) {
            produitDao.creer( produit );
        }
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect( externalContext.getRequestContextPath() + URL_PAGE_COMMANDE
                + String.valueOf( commande.getId() ) );
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande( Commande commande ) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit( Produit produit ) {
        this.produit = produit;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}