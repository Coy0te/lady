package com.lady.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "commande" )
public class Commande {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long         id;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "client" )
    @NotNull( message = "{clientCommande.requis}" )
    private Client       client;
    @OneToOne( fetch = FetchType.LAZY, mappedBy = "commande" )
    @NotNull( message = "{produitsCommande.requis}" )
    private Produit      produit;
    @NotNull( message = "{prixCoutantCommande.requis}" )
    private Integer      prixCoutant;
    @NotNull( message = "{prixFactureCommande.requis}" )
    private Integer      prixFacture;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "modePaiement" )
    @NotNull( message = "{modePaiementCommande.requis}" )
    private ModePaiement modePaiement;
    @Temporal( TemporalType.TIMESTAMP )
    private Date         datePaiement;
    @Temporal( TemporalType.TIMESTAMP )
    private Date         dateCommandeProduits;
    @Temporal( TemporalType.TIMESTAMP )
    private Date         dateReceptionProduits;
    @Temporal( TemporalType.TIMESTAMP )
    private Date         dateExpeditionProduits;
    private String       modeExpedition;

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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit( Produit produit ) {
        this.produit = produit;
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

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement( ModePaiement modePaiement ) {
        this.modePaiement = modePaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement( Date datePaiement ) {
        this.datePaiement = datePaiement;
    }

    public Date getDateCommandeProduits() {
        return dateCommandeProduits;
    }

    public void setDateCommandeProduits( Date dateCommandeProduits ) {
        this.dateCommandeProduits = dateCommandeProduits;
    }

    public Date getDateReceptionProduits() {
        return dateReceptionProduits;
    }

    public void setDateReceptionProduits( Date dateReceptionProduits ) {
        this.dateReceptionProduits = dateReceptionProduits;
    }

    public Date getDateExpeditionProduits() {
        return dateExpeditionProduits;
    }

    public void setDateExpeditionProduits( Date dateExpeditionProduits ) {
        this.dateExpeditionProduits = dateExpeditionProduits;
    }

    public String getModeExpedition() {
        return modeExpedition;
    }

    public void setModeExpedition( String modeExpedition ) {
        this.modeExpedition = modeExpedition;
    }
}