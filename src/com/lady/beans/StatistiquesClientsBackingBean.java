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

import com.lady.dao.ClientDao;
import com.lady.entities.Client;

@ManagedBean( name = "statsClientsBean" )
@ViewScoped
public class StatistiquesClientsBackingBean implements Serializable {
    private static final long   serialVersionUID = 1L;

    private Date                dateDebut;
    private Date                dateFin;

    private CartesianChartModel evolutionClientsModel;

    @EJB
    private ClientDao           clientDao;

    @PostConstruct
    public void init() {
        // Création d'un graphique vide pour qu'il s'affiche et puisse être MAJ via ajax
        evolutionClientsModel = new CartesianChartModel();
        ChartSeries dummyMonth = new ChartSeries();
        dummyMonth.setLabel( "Exemple" );
        dummyMonth.set( 0, 0 );
        evolutionClientsModel.addSeries( dummyMonth );
    }

    /*
     * TODO : evolution nombre de commandes sur un mois / une année - evolution bénéfices sur un mois / une année - répartition commandes /
     * clients - répartition clients / bénéfices
     */

    public CartesianChartModel getEvolutionClientsModel() {
        if ( dateDebut == null ) {
            return evolutionClientsModel;
        }
        dateDebut = ( new DateTime( dateDebut ) ).dayOfMonth().withMinimumValue().toDate();
        dateFin = ( new DateTime( dateFin ) ).dayOfMonth().withMaximumValue().toDate();

        evolutionClientsModel = new CartesianChartModel();
        ChartSeries currentMonth = new ChartSeries();

        List<Client> clients = clientDao.lister( dateDebut, dateFin );
        Map<Object, Number> map = new TreeMap<Object, Number>();
        String date = null;
        DateTimeFormatter fmt = DateTimeFormat.forPattern( "yyyy年MM月dd日" );
        for ( Client client : clients ) {
            date = new DateTime( client.getDateCreation() ).toDateMidnight().toString( fmt );
            Number count = map.get( date );
            if ( count == null ) {
                map.put( date, 1 );
            } else {
                map.put( date, count.intValue() + 1 );
            }
        }
        currentMonth.setData( map );
        evolutionClientsModel.addSeries( currentMonth );
        return evolutionClientsModel;
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
}