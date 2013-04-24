package com.lady.converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.lady.dao.ModePaiementDao;

@ManagedBean
@RequestScoped
public class ModePaiementConverter implements Converter {

    @EJB
    private ModePaiementDao modePaiementDao;

    @Override
    public Object getAsObject( FacesContext context, UIComponent component, String value ) {
        return modePaiementDao.trouver( Long.parseLong( value ) );
    }

    @Override
    public String getAsString( FacesContext context, UIComponent component, Object value ) {
        return String.valueOf( value );
    }

}
