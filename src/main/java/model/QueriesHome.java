package model;
// Generated Aug 21, 2016 7:59:03 PM by Hibernate Tools 5.1.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Queries.
 * @see model.Queries
 * @author Hibernate Tools
 */
public class QueriesHome {

	private static final Log log = LogFactory.getLog(QueriesHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public void persist(Queries transientInstance) {
		log.debug("persisting Queries instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Queries instance) {
		log.debug("attaching dirty Queries instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Queries instance) {
		log.debug("attaching clean Queries instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Queries persistentInstance) {
		log.debug("deleting Queries instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Queries merge(Queries detachedInstance) {
		log.debug("merging Queries instance");
		try {
			Queries result = (Queries) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Queries findById(java.lang.Integer id) {
		log.debug("getting Queries instance with id: " + id);
		try {
			Queries instance = (Queries) sessionFactory.getCurrentSession().get("model.Queries", id);
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

	public List<Queries> findByExample(Queries instance) {
		log.debug("finding Queries instance by example");
		try {
			List<Queries> results = (List<Queries>) sessionFactory.getCurrentSession().createCriteria("model.Queries")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<Queries> findAll() {
		log.debug("finding Queries instance by example");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction trans = session.beginTransaction();
			List<Queries> results = (List<Queries>) session.createQuery("from Queries").list();
			
			log.debug("find all, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find all", re);
			throw re;
		}
	}
}
