package com.lady.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lady.dao.CommandeDao;
import com.lady.entities.Commande;

@ManagedBean( name = "listerCommandesBean" )
@ViewScoped
public class ListerCommandesBackingBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Commande>    commandes;

    @EJB
    private CommandeDao       commandeDao;

    @PostConstruct
    public void init() {
        commandes = commandeDao.lister();
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void supprimer( Commande commande ) {
        commandeDao.supprimer( commande );
        commandes.remove( commande );
    }
}