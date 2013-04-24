package com.lady.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "produit" )
public class Produit {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long      id;
    private String    nom;
    private String    taille;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinTable( name = "produits_commande" )
    private Commande  commande;
    private Timestamp dateCreation;

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

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation( Timestamp dateCreation ) {
        this.dateCreation = dateCreation;
    }
}