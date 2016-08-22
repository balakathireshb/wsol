package model;
// Generated Aug 21, 2016 7:59:03 PM by Hibernate Tools 5.1.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Querytable.
 * @see model.Querytable
 * @author Hibernate Tools
 */
public class QuerytableHome {

	private static final Log log = LogFactory.getLog(QuerytableHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void persist(Querytable transientInstance) {
		log.debug("persisting Querytable instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Querytable instance) {
		log.debug("attaching dirty Querytable instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Querytable instance) {
		log.debug("attaching clean Querytable instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Querytable persistentInstance) {
		log.debug("deleting Querytable instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Querytable merge(Querytable detachedInstance) {
		log.debug("merging Querytable instance");
		try {
			Querytable result = (Querytable) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Querytable findById(java.lang.Integer id) {
		log.debug("getting Querytable instance with id: " + id);
		try {
			Querytable instance = (Querytable) sessionFactory.getCurrentSession().get("model.Querytable", id);
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

	public List<Querytable> findByExample(Querytable instance) {
		log.debug("finding Querytable instance by example");
		try {
			List<Querytable> results = (List<Querytable>) sessionFactory.getCurrentSession()
					.createCriteria("model.Querytable").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Querytable> findAll() {
		log.debug("finding Querytable instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			List<Querytable> results = (List<Querytable>)session.createQuery("from Querytable").list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
