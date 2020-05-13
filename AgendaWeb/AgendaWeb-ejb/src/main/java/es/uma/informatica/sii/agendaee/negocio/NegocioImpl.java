/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.agendaee.negocio;

import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.UriBuilder;

import es.uma.informatica.sii.agendaee.entidades.Contacto;
import es.uma.informatica.sii.agendaee.entidades.ONG;
import es.uma.informatica.sii.agendaee.entidades.Usuario;

/**
 *
 * @author francis
 */
@Stateless
public class NegocioImpl implements Negocio {

    private static final int TAM_CADENA_VALIDACION = 20;
    private static final Logger LOGGER = Logger.getLogger(NegocioImpl.class.getCanonicalName());

    @PersistenceContext(unitName = "AgendaEE-EntidadesPU")
    private EntityManager em;

	@Override
	public void registrarOng(ONG o, UriBuilder uriBuilder) throws AgendaException {
		ONG ong = em.find(ONG.class, o.getNombre());
        if (ong != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }

        em.persist(o);
		
	}
    @Override
    public void registrarUsuario(Usuario u, UriBuilder uriBuilder) throws AgendaException {
        Usuario user = em.find(Usuario.class, u.getCuenta());
        if (user != null) {
            // El usuario ya existe
            throw new CuentaRepetidaException();
        }

        u.setCadenaValidacion(generarCadenaAleatoria());
        em.persist(u);

        URI uriValidacion = uriBuilder.build(u.getCuenta(), u.getCadenaValidacion());

        LOGGER.info(uriValidacion.toString());
    }

    private String generarCadenaAleatoria() {
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TAM_CADENA_VALIDACION; i++) {
            int v = rnd.nextInt(62);
            if (v < 26) {
                sb.append((char) ('a' + v));
            } else if (v < 52) {
                sb.append((char) ('A' + v - 26));
            } else {
                sb.append((char) ('0' + v - 52));
            }
        }

        return sb.toString();

    }

    @Override
    public void validarCuenta(String cuenta, String validacion) throws AgendaException {
        Usuario u = em.find(Usuario.class, cuenta);
        if (u == null) {
            throw new CuentaInexistenteException();
        }

        if (u.getCadenaValidacion() == null) {
            // la cuenta ya está activa
            return;
        }

        if (!u.getCadenaValidacion().equals(validacion)) {
            throw new ValidacionIncorrectaException();
        }
        // else
        // Eliminamos la cadena de validación, indicando que ya está activa la cuenta
        u.setCadenaValidacion(null);
    }
    
    @Override
    public List<ONG> getListaOng() throws AgendaException {
		return em.createNamedQuery("ONG.Todos", ONG.class).getResultList();
    }

    
    @Override
    public void compruebaLogin(Usuario u)  throws AgendaException {
    	Usuario user = em.find(Usuario.class, u.getCuenta());
    	
    	
    	if(user!=null) {
    		if(user.getContrasenia().equals(u.getContrasenia())) {
    			if(user.getCadenaValidacion()==null) {
    				throw new CuentaInactivaException();
    			}
    		}else {
    			throw new ContraseniaInvalidaException();
    		}
    	}else {
    		throw new CuentaInexistenteException();
    	}
    	

    }

    
    @Override
    public Usuario refrescarUsuario(Usuario u)  throws AgendaException {
    	compruebaLogin(u);
        Usuario user = em.find(Usuario.class, u.getCuenta());
        em.refresh(user);
        return user;

    }

    
    @Override
    public void modificar(Contacto c)  throws AgendaException {
    	Usuario user=c.getUsuario();
    	compruebaLogin(user);
    	em.merge(c);
    	
    }

    
    @Override
    public void insertar(Contacto c)  throws AgendaException {
    	Usuario user=c.getUsuario();
    	compruebaLogin(user);
    	em.persist(c);
    }

   
    public void eliminarContacto(Contacto c)  throws AgendaException {
        // TODO
    	Contacto cont = em.find(Contacto.class, c.getId());
    	comprobarContacto(cont);
    	em.remove(cont);
    }
    
    private void comprobarContacto(Contacto cont) throws AgendaException{
    	if(cont==null)
    		throw new AgendaException();
    	else if(cont.getUsuario()==null)
    		throw new CuentaInexistenteException();
    	else if(!cont.getUsuario().getContrasenia().equals(em.find(Usuario.class, cont.getUsuario().getCuenta()).getContrasenia()))
    		throw new ContraseniaInvalidaException();
    	
    }



}
