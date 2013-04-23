package com.lady.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "produit" )
public class Produit {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long     id;
    private String   nom;
    private String   taille;
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

    public String getTaille() {
        return taille;
    }

    public void setTaille( String taille ) {
        this.taille = taille;
    }
}