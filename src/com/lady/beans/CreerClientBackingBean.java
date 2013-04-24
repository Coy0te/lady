package com.lady.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

    public Map<String, ModePaiement> getModesPaiement() {
        Map<String, ModePaiement> map = new HashMap<String, ModePaiement>();
        for ( ModePaiement modePaiement : modePaiementDao.lister() ) {
            map.put( modePaiement.getModePaiement(), modePaiement );
        }
        return map;
    }

    public void creer() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        initialiserDateCreation();
        clientDao.creer( client );
        externalContext.redirect( externalContext.getRequestContextPath() + URL_PAGE_SUJET + String.valueOf( client.getId() ) );
    }

    private void initialiserDateCreation() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        client.setDateCreation( date );
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }
}