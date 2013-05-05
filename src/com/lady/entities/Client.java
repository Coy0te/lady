package com.lady.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table( name = "client" )
public class Client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long         id;
    @NotNull( message = "{pseudoClient.requis}" )
    private String       pseudo;
    @NotNull( message = "{portableClient.requis}" )
    @Pattern( regexp = "^\\d+$", message = "{portableClient.format}" )
    @Column( unique = true )
    private String       portable;
    @NotNull( message = "{adresseClient.requis}" )
    private String       adresse;
    @NotNull( message = "{nomClient.requis}" )
    private String       nom;
    private Integer      taille;        // cm
    private Integer      poids;         // jin
    private String       tourDePoitrine; // XiongWei, cm
    private String       tourDeTaille;  // YaoWei, cm
    private Integer      pointure;
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "modePaiement" )
    private ModePaiement modePaiement;  // nonghang, gonghang, jianhang, zhongxin, zhifubao
    @Temporal( TemporalType.TIMESTAMP )
    private Date         dateCreation;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable( String portable ) {
        this.portable = portable;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement( ModePaiement modePaiement ) {
        this.modePaiement = modePaiement;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille( Integer taille ) {
        this.taille = taille;
    }

    public Integer getPoids() {
        return poids;
    }

    public void setPoids( Integer poids ) {
        this.poids = poids;
    }

    public String getTourDePoitrine() {
        return tourDePoitrine;
    }

    public void setTourDePoitrine( String tourDePoitrine ) {
        this.tourDePoitrine = tourDePoitrine;
    }

    public String getTourDeTaille() {
        return tourDeTaille;
    }

    public void setTourDeTaille( String tourDeTaille ) {
        this.tourDeTaille = tourDeTaille;
    }

    public Integer getPointure() {
        return pointure;
    }

    public void setPointure( Integer pointure ) {
        this.pointure = pointure;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation( Date date ) {
        this.dateCreation = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }
}