package com.lady.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lady.dao.ClientDao;
import com.lady.dao.ModePaiementDao;
import com.lady.entities.Client;
import com.lady.entities.ModePaiement;

@ManagedBean( name = "creerClientBean" )
@ViewScoped
public class CreerClientBackingBean implements Serializable {
    private static final long   serialVersionUID = 1L;
    private static final String URL_PAGE_SUJET   = "/listerClients.jsf?clientId=";

    private Client              client;

    @EJB
    private ClientDao           clientDao;
    @EJB
    private ModePaiementDao     modePaiementDao;

    @PostConstruct
    public void init() {
        client = new Client();
    }

    public Map<String, Long> getModesPaiement() {
        Map<String, Long> map = new HashMap<String, Long>();
        for ( ModePaiement modePaiement : modePaiementDao.lister() ) {
            map.put( modePaiement.getModePaiement(), modePaiement.getId() );
        }
        return map;
    }

    public void creer() {
        clientDao.creer( client );
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }
}