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
import com.lady.entities.Client;
import com.lady.entities.Commande;
import com.lady.entities.ModeExpedition;
import com.lady.entities.ModePaiement;

@ManagedBean( name = "creerCommandeBean" )
@ViewScoped
public class CreerCommandeBackingBean implements Serializable {
    private static final long   serialVersionUID = 1L;
    private static final String URL_PAGE_SUJET   = "/listerCommandes.jsf?commandeId=";

    private Commande            commande;

    @EJB
    private CommandeDao         commandeDao;
    @EJB
    private ClientDao           clientDao;
    @EJB
    private ModePaiementDao     modePaiementDao;
    @EJB
    private ModeExpeditionDao   modeExpeditionDao;

    @PostConstruct
    public void init() {
        commande = new Commande();
    }

    public Map<String, ModePaiement> getModesPaiement() {
        Map<String, ModePaiement> map = new HashMap<String, ModePaiement>();
        for ( ModePaiement modePaiement : modePaiementDao.lister() ) {
            map.put( modePaiement.getModePaiement(), modePaiement );
        }
        return map;
    }

    public Map<String, Client> getClients() {
        Map<String, Client> map = new HashMap<String, Client>();
        for ( Client client : clientDao.lister() ) {
            map.put( client.getPseudo(), client );
        }
        return map;
    }

    public Map<String, ModeExpedition> getModesExpedition() {
        Map<String, ModeExpedition> map = new HashMap<String, ModeExpedition>();
        for ( ModeExpedition modeExpedition : modeExpeditionDao.lister() ) {
            map.put( modeExpedition.getModeExpedition(), modeExpedition );
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