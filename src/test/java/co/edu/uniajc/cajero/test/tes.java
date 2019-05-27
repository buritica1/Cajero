package co.edu.uniajc.cajero.test;


import org.hibernate.Session;
import org.junit.Test;
import co.edu.uniajc.cajero.service.TipoIdentificacionService;
import co.edu.uniajc.cajero.util.HibernateUtil;
public class tes {

	@Test
	public void test() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		TipoIdentificacionService TipoIdentificacionService = new TipoIdentificacionService(session);
		//UsuarioService UsuarioService = new UsuarioService(session);
		
		//TipoIdentificacionService.save(new TipoIdentificacion("cedula_876",null));
	   // TipoIdentificacionService.save(new TipoIdentificacion("Pasaporte_98",null));
	   //  TipoIdentificacionService.findById(1);
	 //    TipoIdentificacionService.Update(1,"Pasaporte prue"); 
	     //TipoIdentificacionService.Delete(2); 
	   // TipoIdentificacionService.Delete(2);
	     //   System.out.println(TipoIdentificacionService.findById(1).toString());
	     
	     
	    // UsuarioService.save(new Usuario("cedula_997","steven", "lopez", "calle 23", null, null, "7458666", "steven@hotmail.com", 3));
		
		
		System.out.println(TipoIdentificacionService.findByIdall().get(3).getDescripcion().toString());
		TipoIdentificacionService.Update(3, "prueba update ty");
		TipoIdentificacionService.Delete(23);
	//	TipoIdentificacionService.findByIdall();
	    
		TipoIdentificacionService.closeSession();
				
			
	}

}
