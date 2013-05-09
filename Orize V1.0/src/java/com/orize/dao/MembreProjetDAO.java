package com.orize.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.MembreProjet;

/**
 * A data access object (DAO) providing persistence and search support for
 * MembreProjet entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.orize.dao.MembreProjet
 * @author MyEclipse Persistence Tools
 */
public class MembreProjetDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MembreProjetDAO.class);
	// property constants
	public static final String ROLE = "role";

	public void save(MembreProjet transientInstance) {
		log.debug("saving MembreProjet instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MembreProjet persistentInstance) {
		log.debug("deleting MembreProjet instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MembreProjet findById(java.lang.Integer id) {
		log.debug("getting MembreProjet instance with id: " + id);
		try {
			MembreProjet instance = (MembreProjet) getSession().get(
					"com.orize.dao.MembreProjet", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<MembreProjet> findByExample(MembreProjet instance) {
		log.debug("finding MembreProjet instance by example");
		try {
			List<MembreProjet> results = (List<MembreProjet>) getSession()
					.createCriteria("com.orize.dao.MembreProjet")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding MembreProjet instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MembreProjet as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<MembreProjet> findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findAll() {
		log.debug("finding all MembreProjet instances");
		try {
			String queryString = "from MembreProjet";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MembreProjet merge(MembreProjet detachedInstance) {
		log.debug("merging MembreProjet instance");
		try {
			MembreProjet result = (MembreProjet) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MembreProjet instance) {
		log.debug("attaching dirty MembreProjet instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MembreProjet instance) {
		log.debug("attaching clean MembreProjet instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}