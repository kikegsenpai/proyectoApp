/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendaee.controladores;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

import es.uma.informatica.sii.agendaee.entidades.ONG;
import es.uma.informatica.sii.agendaee.entidades.UsuarioAgenda;
import es.uma.informatica.sii.agendaee.negocio.AgendaException;
import es.uma.informatica.sii.agendaee.negocio.CuentaRepetidaException;
import es.uma.informatica.sii.agendaee.negocio.Negocio;

/**
 *
 * @author francis
 */
@Named(value = "registroOng")
@RequestScoped
public class RegistroOng {
	
	
	private static final String PARAM_CUENTA = "ong";

    //@Inject
    @EJB
    private Negocio negocio;

    private ONG ong;
    
    private boolean registroOK;

    public boolean isRegistroOK() {
        return registroOK;
    }

    public RegistroOng() {
        ong = new ONG();
    }

 
	public String registrarOng() {
		 HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
         		.getExternalContext()
         		.getRequest();
         
         String thisUri = request.getRequestURL().toString();
        
         int ultimaBarra = thisUri.lastIndexOf('/');
         if (ultimaBarra < 0) {
         	FacesMessage fm = new FacesMessage("Error interno de URL");
             FacesContext.getCurrentInstance().addMessage(null, fm);
             return null;
         }
         
         UriBuilder uriBuilder = UriBuilder.fromUri(thisUri.substring(0, ultimaBarra))
        		.queryParam(PARAM_CUENTA, "{ong}");
         try {
			negocio.registrarOng(ong, uriBuilder);
		} catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe una ONG con el mismo nombre");
            
        }catch (AgendaException e) {
			
		}
         registroOK = true;
         return "mainBueno.xhtml";
    }
	
	public ONG getOng() {
		return ong;
	}

	public void setOng(ONG ong) {
		this.ong = ong;
	}
}
