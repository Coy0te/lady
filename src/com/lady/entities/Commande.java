package com.lady.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table( name = "commande" )
public class Commande {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long          id;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_client" )
    private Client        client;
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "commande" )
    private List<Produit> produits;
    private Integer       prixCoutant;
    private Integer       prixFacture;
    private String        modePaiement;
    private DateTime      datePaiement;
    private DateTime      dateCommandeProduits;
    private DateTime      dateReceptionProduits;
    private DateTime      dateExpeditionProduits;
    private String        modeExpedition;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits( List<Produit> produits ) {
        this.produits = produits;
    }

    public Integer getPrixCoutant() {
        return prixCoutant;
    }

    public void setPrixCoutant( Integer prixCoutant ) {
        this.prixCoutant = prixCoutant;
    }

    public Integer getPrixFacture() {
        return prixFacture;
    }

    public void setPrixFacture( Integer prixFacture ) {
        this.prixFacture = prixFacture;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement( String modePaiement ) {
        this.modePaiement = modePaiement;
    }

    public DateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement( DateTime datePaiement ) {
        this.datePaiement = datePaiement;
    }

    public DateTime getDateCommandeProduits() {
        return dateCommandeProduits;
    }

    public void setDateCommandeProduits( DateTime dateCommandeProduits ) {
        this.dateCommandeProduits = dateCommandeProduits;
    }

    public DateTime getDateReceptionProduits() {
        return dateReceptionProduits;
    }

    public void setDateReceptionProduits( DateTime dateReceptionProduits ) {
        this.dateReceptionProduits = dateReceptionProduits;
    }

    public DateTime getDateExpeditionProduits() {
        return dateExpeditionProduits;
    }

    public void setDateExpeditionProduits( DateTime dateExpeditionProduits ) {
        this.dateExpeditionProduits = dateExpeditionProduits;
    }

    public String getModeExpedition() {
        return modeExpedition;
    }

    public void setModeExpedition( String modeExpedition ) {
        this.modeExpedition = modeExpedition;
    }
}