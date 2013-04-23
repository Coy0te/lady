package com.lady.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
    private static final long   serialVersionUID = 1L;
    private static final String SEPARATEUR       = " - ";
    private static final String URL_PAGE_SUJET   = "/listerCommandes.jsf?commandeId=";

    private Commande            commande;

    @EJB
    private CommandeDao         commandeDao;
    @EJB
    private ClientDao           clientDao;
    @EJB
    private ProduitDao          produitDao;
    @EJB
    private ModePaiementDao     modePaiementDao;
    @EJB
    private ModeExpeditionDao   modeExpeditionDao;

    @PostConstruct
    public void init() {
        commande = new Commande();
    }

    public Map<String, Long> getModesPaiement() {
        Map<String, Long> map = new HashMap<String, Long>();
        for ( ModePaiement modePaiement : modePaiementDao.lister() ) {
            map.put( modePaiement.getModePaiement(), modePaiement.getId() );
        }
        return map;
    }

    public Map<String, Long> getClients() {
        Map<String, Long> map = new HashMap<String, Long>();
        for ( Client client : clientDao.lister() ) {
            map.put( client.getPseudo(), client.getId() );
        }
        return map;
    }

    public Map<String, Long> getProduits() {
        Map<String, Long> map = new HashMap<String, Long>();
        for ( Produit produit : produitDao.lister() ) {
            map.put( produit.getNom() + SEPARATEUR + produit.getTaille(), produit.getId() );
        }
        return map;
    }

    public Map<String, Long> getModesExpedition() {
        Map<String, Long> map = new HashMap<String, Long>();
        for ( ModeExpedition modeExpedition : modeExpeditionDao.lister() ) {
            map.put( modeExpedition.getModeExpedition(), modeExpedition.getId() );
        }
        return map;
    }

    public void creer() {
        commandeDao.creer( commande );
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande( Commande commande ) {
        this.commande = commande;
    }
}