package co.edu.uniajc.cajero.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import co.edu.uniajc.cajero.service.BancoServices;
import co.edu.uniajc.cajero.service.TipoIdentificacionService;
import co.edu.uniajc.cajero.util.HibernateUtil;

public class bancotest {

	@Test
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		BancoServices bancoServices = new BancoServices(session);
		
		
		System.out.println(bancoServices.findByIdall().get(1).getNit().toString());
	//	TipoIdentificacionService.findByIdall();
	    
		bancoServices.closeSession();
	}

}
