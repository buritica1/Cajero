package co.edu.uniajc.cajero.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import co.edu.uniajc.cajero.dao.ImpTipoIdentificacionDao;
import co.edu.uniajc.cajero.model.TipoIdentificacion;
import co.edu.uniajc.cajero.util.HibernateUtil;


public class Test {

	public static void main(String[] args) {

		// ****************************************** INSERT A CLASE DIRECTA *******************		
		
//		Session session = TipoIdentificacionDao.getSessionFactory().openSession();
//		session.beginTransaction();
		
		//Crear Instancia de tramite
		
//		TipoIdentificacion TI = new TipoIdentificacion("Pasaporte",null);
		
		//Salvar registro
//		session.save(TI);
				
		
//		session.getTransaction().commit();
//		session.close();
		
		
	// ****************************************** CONSULTAS CON CRITERIA (criterios) sencillo*******************	
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		

		// Fábrica para las piezas individuales de la criteria
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<TipoIdentificacion> criteria = builder.createQuery(TipoIdentificacion.class);
		
		// Definir el tipo de entidad que retorna la consulta
		Root<TipoIdentificacion> root = criteria.from(TipoIdentificacion.class);
		
		// Construyendo la consulta sencilla select * from 
		//criteria.select(root);

	
		
		List<TipoIdentificacion> TI = session.createQuery(criteria).getResultList();
		
		System.out.println(TI.toString());
		
		session.getTransaction().commit();
		session.close();
		
				
		
	}

}
