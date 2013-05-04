package com.lady.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.lady.dao.CommandeDao;
import com.lady.entities.Commande;

@ManagedBean( name = "statsCommandesBean" )
@ViewScoped
public class StatistiquesCommandesBackingBean implements Serializable {
    private static final long   serialVersionUID = 1L;

    private Date                dateDebut;
    private Date                dateFin;
    private int                 prixFactureTotal;
    private int                 prixCoutantTotal;

    private CartesianChartModel evolutionCommandesModel;

    @EJB
    private CommandeDao         commandeDao;

    @PostConstruct
    public void init() {
        // Création d'un graphique vide pour qu'il s'affiche et puisse être MAJ via ajax
        evolutionCommandesModel = new CartesianChartModel();
        ChartSeries dummyMonth = new ChartSeries();
        dummyMonth.setLabel( "Exemple" );
        dummyMonth.set( 0, 0 );
        evolutionCommandesModel.addSeries( dummyMonth );
    }

    /*
     * TODO : evolution nombre de commandes sur un mois / une année - evolution bénéfices sur un mois / une année - répartition commandes /
     * clients - répartition clients / bénéfices
     */

    public CartesianChartModel getEvolutionCommandesModel() {
        if ( dateDebut == null ) {
            return evolutionCommandesModel;
        }
        dateDebut = ( new DateTime( dateDebut ) ).dayOfMonth().withMinimumValue().toDate();
        dateFin = ( new DateTime( dateFin ) ).dayOfMonth().withMaximumValue().toDate();

        evolutionCommandesModel = new CartesianChartModel();
        ChartSeries currentMonth = new ChartSeries();

        List<Commande> commandes = commandeDao.lister( dateDebut, dateFin );
        Map<Object, Number> map = new TreeMap<Object, Number>();
        String date = null;
        DateTimeFormatter fmt = DateTimeFormat.forPattern( "yyyy年MM月dd日" );
        prixFactureTotal = 0;
        prixCoutantTotal = 0;
        for ( Commande commande : commandes ) {
            prixFactureTotal += commande.getPrixFacture();
            prixCoutantTotal += commande.getPrixCoutant();
            date = new DateTime( commande.getDatePaiement() ).toDateMidnight().toString( fmt );
            Number count = map.get( date );
            if ( count == null ) {
                map.put( date, 1 );
            } else {
                map.put( date, count.intValue() + 1 );
            }
        }
        currentMonth.setData( map );
        evolutionCommandesModel.addSeries( currentMonth );
        return evolutionCommandesModel;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin( Date dateFin ) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut( Date dateDebut ) {
        this.dateDebut = dateDebut;
    }

    public int getPrixFactureTotal() {
        return prixFactureTotal;
    }

    public int getPrixCoutantTotal() {
        return prixCoutantTotal;
    }
}