package co.edu.uniajc.cajero.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.model.Usuario;
import co.edu.uniajc.cajero.service.TipoIdentificacionService;
import co.edu.uniajc.cajero.service.UsuarioService;
import co.edu.uniajc.cajero.util.HibernateUtil;


public class Test2 {

	@Test
	public void test() throws ParseException {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		// test for user
	    UsuarioService UsuarioService = new UsuarioService(session);
	    
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2019");  
	    
	    Integer identificacion = 3;
	    
	     TipoIdentificacion tipoIdentificacion = new TipoIdentificacion(identificacion);
	     
	     System.out.println(UsuarioService.findByIdall());

		   System.out.println(UsuarioService.findByIdall());
		UsuarioService.save(new Usuario(tipoIdentificacion, "98574", "prueba", "prueba", "carrera 7", "31525", "buitrago500",date1,date1));
		UsuarioService.update(new Usuario(tipoIdentificacion, "98574", "prueba", "prueba", "carrera 7", "31525", "buitrago500",date1,date1));
		UsuarioService.delete(2);
		UsuarioService.closeSession();
		 
	
		//test for tipo identificacion
		
	    TipoIdentificacionService tipoIdentificacionService = new TipoIdentificacionService(session);
	    System.out.println("Lista de tipo identificacion: " + tipoIdentificacionService.findByIdall());
	    tipoIdentificacionService.closeSession();
			
	}

}
