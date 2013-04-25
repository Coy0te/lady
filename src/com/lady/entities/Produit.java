package com.lady.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "produit" )
public class Produit {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long     id;
    @NotNull( message = "{nomProduit.requis}" )
    private String   nom;
    private String   taille;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinTable(
            name = "produits_commandes",
            joinColumns =
            @JoinColumn( name = "produit", referencedColumnName = "id" ),
            inverseJoinColumns =
            @JoinColumn( name = "commande", referencedColumnName = "id" ) )
    private Commande commande;
    @Temporal( TemporalType.TIMESTAMP )
    private Date     dateCreation;

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

    public String getTaille() {
        return taille;
    }

    public void setTaille( String taille ) {
        this.taille = taille;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation( Date dateCreation ) {
        this.dateCreation = dateCreation;
    }
}