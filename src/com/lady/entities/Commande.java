package com.lady.entities;

import java.sql.Timestamp;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table( name = "commande" )
public class Commande {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long          id;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "id_client" )
    @NotNull( message = "{clientCommande.requis}" )
    private Client        client;
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "commande" )
    @NotNull( message = "{produitsCommande.requis}" )
    private List<Produit> produits;
    @NotNull( message = "{prixCoutantCommande.requis}" )
    @Pattern( regexp = "^\\d+$", message = "{prixCoutantCommande.format}" )
    private Integer       prixCoutant;
    @NotNull( message = "{prixFactureCommande.requis}" )
    @Pattern( regexp = "^\\d+$", message = "{prixFactureCommande.format}" )
    private Integer       prixFacture;
    @NotNull( message = "{modePaiementCommande.requis}" )
    private String        modePaiement;
    private Timestamp     datePaiement;
    private Timestamp     dateCommandeProduits;
    private Timestamp     dateReceptionProduits;
    private Timestamp     dateExpeditionProduits;
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

    public Timestamp getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement( Timestamp datePaiement ) {
        this.datePaiement = datePaiement;
    }

    public Timestamp getDateCommandeProduits() {
        return dateCommandeProduits;
    }

    public void setDateCommandeProduits( Timestamp dateCommandeProduits ) {
        this.dateCommandeProduits = dateCommandeProduits;
    }

    public Timestamp getDateReceptionProduits() {
        return dateReceptionProduits;
    }

    public void setDateReceptionProduits( Timestamp dateReceptionProduits ) {
        this.dateReceptionProduits = dateReceptionProduits;
    }

    public Timestamp getDateExpeditionProduits() {
        return dateExpeditionProduits;
    }

    public void setDateExpeditionProduits( Timestamp dateExpeditionProduits ) {
        this.dateExpeditionProduits = dateExpeditionProduits;
    }

    public String getModeExpedition() {
        return modeExpedition;
    }

    public void setModeExpedition( String modeExpedition ) {
        this.modeExpedition = modeExpedition;
    }
}