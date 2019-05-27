package co.edu.uniajc.cajero.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import co.edu.uniajc.cajero.model.Producto;
import co.edu.uniajc.cajero.service.ProductoService;
import co.edu.uniajc.cajero.util.HibernateUtil;

public class testProducto {

	@Test
	public void test() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ProductoService ProductoService = new ProductoService(session);
		
		System.out.println(ProductoService.findByIdall());
		
		//ProductoService.save(new Producto("Productos"));
		//ProductoService.update();
		//ProductoService.delete(5);
		
		ProductoService.closeSession();
	}

}
