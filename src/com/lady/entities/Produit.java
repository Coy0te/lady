package com.lady.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "produit" )
public class Produit {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long     id;
    @NotNull( message = "{nomProduit.requis}" )
    private String   nom;
    @NotNull( message = "{prixCoutantProduit.requis}" )
    private Integer  prixCoutant;
    @NotNull( message = "{prixFactureProduit.requis}" )
    private Integer  prixFacture;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "commande" )
    private Commande commande;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande( Commande commande ) {
        this.commande = commande;
    }
}