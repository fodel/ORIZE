package com.orize.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.Planning;

/**
 * A data access object (DAO) providing persistence and search support for
 * Planning entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.orize.dao.Planning
 * @author MyEclipse Persistence Tools
 */
public class PlanningDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PlanningDAO.class);
	// property constants
	public static final String DT_DEBUT = "dtDebut";
	public static final String DT_FIN = "dtFin";
	public static final String NOM_TACHE = "nomTache";
	public static final String TACHE = "tache";

	public void save(Planning transientInstance) {
		log.debug("saving Planning instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Planning persistentInstance) {
		log.debug("deleting Planning instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Planning findById(java.lang.Integer id) {
		log.debug("getting Planning instance with id: " + id);
		try {
			Planning instance = (Planning) getSession().get(
					"com.orize.dao.Planning", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Planning> findByExample(Planning instance) {
		log.debug("finding Planning instance by example");
		try {
			List<Planning> results = (List<Planning>) getSession()
					.createCriteria("com.orize.dao.Planning")
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
		log.debug("finding Planning instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Planning as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Planning> findByDtDebut(Object dtDebut) {
		return findByProperty(DT_DEBUT, dtDebut);
	}

	public List<Planning> findByDtFin(Object dtFin) {
		return findByProperty(DT_FIN, dtFin);
	}

	public List<Planning> findByNomTache(Object nomTache) {
		return findByProperty(NOM_TACHE, nomTache);
	}

	public List<Planning> findByTache(Object tache) {
		return findByProperty(TACHE, tache);
	}

	public List findAll() {
		log.debug("finding all Planning instances");
		try {
			String queryString = "from Planning";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Planning merge(Planning detachedInstance) {
		log.debug("merging Planning instance");
		try {
			Planning result = (Planning) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Planning instance) {
		log.debug("attaching dirty Planning instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Planning instance) {
		log.debug("attaching clean Planning instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}