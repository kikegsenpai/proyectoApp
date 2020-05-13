/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendaee.vista;

import es.uma.informatica.sii.agendaee.entidades.Contacto;
import es.uma.informatica.sii.agendaee.entidades.ONG;
import es.uma.informatica.sii.agendaee.negocio.AgendaException;
import es.uma.informatica.sii.agendaee.negocio.Negocio;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author francis
 */
@Named(value = "ongs")
@RequestScoped
public class ONGs {

    public static enum Modo {
        MODIFICAR, 
        INSERTAR,
        NOACCION
    };

    @Inject
    private InfoSesion sesion;
    @Inject
    private Negocio negocio;

    private ONG ong;
    private Modo modo;

    public ONGs() {
        ong = new ONG();
        modo = Modo.NOACCION;
    }

    public Modo getModo() {
        return modo;
    }

    public void setModo(Modo modo) {
        this.modo = modo;
    }

    public String getAccion() {
        switch (modo) {
            case MODIFICAR:
                return "Modificar";
            case INSERTAR:
                return "Insertar";

        }
        return null;
    }

    public ONG getONG() {
        return ong;
    }

    public void setONG(ONG ong) {
        this.ong = ong;
    }

    public String modificar(ONG c) {
        ong = c;
        setModo(Modo.MODIFICAR);
        return "edicionContacto.xhtml";
    }

    public String eliminar(Contacto c) {
        try {
            negocio.eliminarContacto(c);
            // Refrescar el usuario
            sesion.refrescarUsuario();
        } catch (AgendaException e) {
            return "login.xhtml";
        }
        return null;
    }

    public String insertarContacto() {
        setModo(Modo.INSERTAR);
        return "edicionContacto.xhtml";
    }
    
    public String refrescar()
    {
        sesion.refrescarUsuario();
        return null;
    }

    public String ejecutarAccion() {
            switch (modo) {
                case MODIFICAR:
                    
                    break;
                case INSERTAR:
                   
                    break;
            }
            sesion.refrescarUsuario();
            return "mainBueno.xhtml";
        
    }
    
    public boolean isAutorizadoParaEdicion()
    {
        return sesion.getUsuario() != null;
    }

}
