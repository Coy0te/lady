package com.lady.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import com.lady.dao.CommandeDao;
import com.lady.entities.Commande;
import com.lady.entities.Produit;

@ManagedBean( name = "listerCommandesBean" )
@ViewScoped
public class ListerCommandesBackingBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Commande>    commandes;
    private int               beneficesTotal;

    @EJB
    private CommandeDao       commandeDao;

    @PostConstruct
    public void init() {
        beneficesTotal = 0;
        commandes = commandeDao.lister();
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public int calculBenefices( Commande commande ) {
        int beneficesCommande = 0;
        for ( Produit produit : commande.getProduits() ) {
            beneficesCommande += produit.getPrixFacture() - produit.getPrixCoutant();
        }
        beneficesTotal += beneficesCommande;
        return beneficesCommande;
    }

    public void supprimer( Commande commande ) {
        commandeDao.supprimer( commande );
        commandes.remove( commande );
    }

    public int getBeneficesTotal() {
        return beneficesTotal;
    }

    public void onCancel( RowEditEvent event ) {
        // do nothing
    }

    public void onEdit( RowEditEvent event ) {
        Commande commandeEditee = (Commande) event.getObject();
        commandeDao.rafraichir( commandeEditee );
        System.out.println( ">>>>>>>> " + commandeEditee.getDatePaiement() );
    }
}