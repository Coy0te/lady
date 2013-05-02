package com.lady.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lady.dao.ClientDao;
import com.lady.entities.Client;

@ManagedBean( name = "listerClientsBean" )
@ViewScoped
public class ListerClientsBackingBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Client>      clients;

    @EJB
    private ClientDao         clientDao;

    @PostConstruct
    public void init() {
        clients = clientDao.lister();
    }

    public List<Client> getClients() {
        return clients;
    }
}