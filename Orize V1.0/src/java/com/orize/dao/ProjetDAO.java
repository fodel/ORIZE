package com.orize.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.Projet;

/**
 * A data access object (DAO) providing persistence and search support for
 * Projet entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.orize.dao.Projet
 * @author MyEclipse Persistence Tools
 */
public class ProjetDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProjetDAO.class);
	// property constants
	public static final String NOM = "nom";
	public static final String DESCRIPTION = "description";
	public static final String DT_CREATION = "dtCreation";
	public static final String DT_MODIFICATION = "dtModification";
	public static final String STATU = "statu";

	public void save(Projet transientInstance) {
		log.debug("saving Projet instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Projet persistentInstance) {
		log.debug("deleting Projet instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Projet findById(java.lang.Integer id) {
		log.debug("getting Projet instance with id: " + id);
		try {
			Projet instance = (Projet) getSession().get("com.orize.dao.Projet",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Projet> findByExample(Projet instance) {
		log.debug("finding Projet instance by example");
		try {
			List<Projet> results = (List<Projet>) getSession()
					.createCriteria("com.orize.dao.Projet")
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
		log.debug("finding Projet instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Projet as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Projet> findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}

	public List<Projet> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<Projet> findByDtCreation(Object dtCreation) {
		return findByProperty(DT_CREATION, dtCreation);
	}

	public List<Projet> findByDtModification(Object dtModification) {
		return findByProperty(DT_MODIFICATION, dtModification);
	}

	public List<Projet> findByStatu(Object statu) {
		return findByProperty(STATU, statu);
	}

	public List findAll() {
		log.debug("finding all Projet instances");
		try {
			String queryString = "from Projet";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Projet merge(Projet detachedInstance) {
		log.debug("merging Projet instance");
		try {
			Projet result = (Projet) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Projet instance) {
		log.debug("attaching dirty Projet instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Projet instance) {
		log.debug("attaching clean Projet instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}