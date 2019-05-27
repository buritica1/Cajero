package co.edu.uniajc.cajero.dao;
// Generated 7/04/2019 01:08:54 PM by Hibernate Tools 5.2.12.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.edu.uniajc.cajero.model.Detalle;

/**
 * Home object for domain model class Detalle.
 * @see co.edu.uniajc.cajero.dao.Detalle
 * @author Hibernate Tools
 */
public class DetalleDao {

	private static final Log log = LogFactory.getLog(DetalleDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Detalle transientInstance) {
		log.debug("persisting Detalle instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Detalle instance) {
		log.debug("attaching dirty Detalle instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Detalle instance) {
		log.debug("attaching clean Detalle instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Detalle persistentInstance) {
		log.debug("deleting Detalle instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Detalle merge(Detalle detachedInstance) {
		log.debug("merging Detalle instance");
		try {
			Detalle result = (Detalle) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Detalle findById(java.lang.Integer id) {
		log.debug("getting Detalle instance with id: " + id);
		try {
			Detalle instance = (Detalle) sessionFactory.getCurrentSession().get("co.edu.uniajc.cajero.dao.Detalle", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Detalle instance) {
		log.debug("finding Detalle instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("co.edu.uniajc.cajero.dao.Detalle")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
