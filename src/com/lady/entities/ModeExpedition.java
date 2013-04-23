package com.lady.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "mode_expedition" )
public class ModeExpedition {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long   id;
    private String modeExpedition;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getModeExpedition() {
        return modeExpedition;
    }

    public void setModeExpedition( String modeExpedition ) {
        this.modeExpedition = modeExpedition;
    }
}