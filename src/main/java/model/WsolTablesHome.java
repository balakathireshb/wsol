package model;
// Generated Aug 21, 2016 7:59:03 PM by Hibernate Tools 5.1.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class WsolTables.
 * @see model.WsolTables
 * @author Hibernate Tools
 */
public class WsolTablesHome {

	private static final Log log = LogFactory.getLog(WsolTablesHome.class);

	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public void persist(WsolTables transientInstance) {
		log.debug("persisting WsolTables instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WsolTables instance) {
		log.debug("attaching dirty WsolTables instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WsolTables instance) {
		log.debug("attaching clean WsolTables instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WsolTables persistentInstance) {
		log.debug("deleting WsolTables instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WsolTables merge(WsolTables detachedInstance) {
		log.debug("merging WsolTables instance");
		try {
			WsolTables result = (WsolTables) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WsolTables findById(java.lang.Integer id) {
		log.debug("getting WsolTables instance with id: " + id);
		try {
			WsolTables instance = (WsolTables) sessionFactory.getCurrentSession().get("model.WsolTables", id);
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

	public List<WsolTables> findByExample(WsolTables instance) {
		log.debug("finding WsolTables instance by example");
		try {
			List<WsolTables> results = (List<WsolTables>) sessionFactory.getCurrentSession()
					.createCriteria("model.WsolTables").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
