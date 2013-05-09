package com.orize.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.Groupe;

/**
 * A data access object (DAO) providing persistence and search support for
 * Groupe entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.orize.dao.Groupe
 * @author MyEclipse Persistence Tools
 */
public class GroupeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(GroupeDAO.class);
	// property constants
	public static final String NOM = "nom";
	public static final String DT_CREATION = "dtCreation";
	public static final String DT_MODIFICATION = "dtModification";
	public static final String OBJECTIFS = "objectifs";
	public static final String STRATEGIE = "strategie";
	public static final String STATU = "statu";

	public void save(Groupe transientInstance) {
		log.debug("saving Groupe instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Groupe persistentInstance) {
		log.debug("deleting Groupe instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Groupe findById(java.lang.Integer id) {
		log.debug("getting Groupe instance with id: " + id);
		try {
			Groupe instance = (Groupe) getSession().get("com.orize.dao.Groupe",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Groupe> findByExample(Groupe instance) {
		log.debug("finding Groupe instance by example");
		try {
			List<Groupe> results = (List<Groupe>) getSession()
					.createCriteria("com.orize.dao.Groupe")
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
		log.debug("finding Groupe instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Groupe as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Groupe> findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}

	public List<Groupe> findByDtCreation(Object dtCreation) {
		return findByProperty(DT_CREATION, dtCreation);
	}

	public List<Groupe> findByDtModification(Object dtModification) {
		return findByProperty(DT_MODIFICATION, dtModification);
	}

	public List<Groupe> findByObjectifs(Object objectifs) {
		return findByProperty(OBJECTIFS, objectifs);
	}

	public List<Groupe> findByStrategie(Object strategie) {
		return findByProperty(STRATEGIE, strategie);
	}

	public List<Groupe> findByStatu(Object statu) {
		return findByProperty(STATU, statu);
	}

	public List findAll() {
		log.debug("finding all Groupe instances");
		try {
			String queryString = "from Groupe";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Groupe merge(Groupe detachedInstance) {
		log.debug("merging Groupe instance");
		try {
			Groupe result = (Groupe) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Groupe instance) {
		log.debug("attaching dirty Groupe instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Groupe instance) {
		log.debug("attaching clean Groupe instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}