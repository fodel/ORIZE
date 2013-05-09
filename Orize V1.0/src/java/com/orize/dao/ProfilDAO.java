package com.orize.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.Profil;

/**
 * A data access object (DAO) providing persistence and search support for
 * Profil entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.orize.dao.Profil
 * @author MyEclipse Persistence Tools
 */
public class ProfilDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProfilDAO.class);
	// property constants
	public static final String PSEUDO = "pseudo";
	public static final String ADRESSE = "adresse";
	public static final String TEL = "tel";
	public static final String ADRMAIL = "adrmail";

	public void save(Profil transientInstance) {
		log.debug("saving Profil instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Profil persistentInstance) {
		log.debug("deleting Profil instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Profil findById(java.lang.Integer id) {
		log.debug("getting Profil instance with id: " + id);
		try {
			Profil instance = (Profil) getSession().get("com.orize.dao.Profil",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Profil> findByExample(Profil instance) {
		log.debug("finding Profil instance by example");
		try {
			List<Profil> results = (List<Profil>) getSession()
					.createCriteria("com.orize.dao.Profil")
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
		log.debug("finding Profil instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Profil as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Profil> findByPseudo(Object pseudo) {
		return findByProperty(PSEUDO, pseudo);
	}

	public List<Profil> findByAdresse(Object adresse) {
		return findByProperty(ADRESSE, adresse);
	}

	public List<Profil> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<Profil> findByAdrmail(Object adrmail) {
		return findByProperty(ADRMAIL, adrmail);
	}

	public List findAll() {
		log.debug("finding all Profil instances");
		try {
			String queryString = "from Profil";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Profil merge(Profil detachedInstance) {
		log.debug("merging Profil instance");
		try {
			Profil result = (Profil) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Profil instance) {
		log.debug("attaching dirty Profil instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Profil instance) {
		log.debug("attaching clean Profil instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}