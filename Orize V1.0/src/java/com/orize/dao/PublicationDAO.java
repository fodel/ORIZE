package com.orize.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.Publication;
import com.orize.entity.Publication1;

/**
 * A data access object (DAO) providing persistence and search support for
 * Publication entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.orize.dao.Publication
 * @author MyEclipse Persistence Tools
 */
public class PublicationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PublicationDAO.class);
	// property constants
	public static final String PUBLICATION = "publication";

	public void save(Publication transientInstance) {
		log.debug("saving Publication instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Publication persistentInstance) {
		log.debug("deleting Publication instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Publication findById(java.lang.Integer id) {
		log.debug("getting Publication instance with id: " + id);
		try {
			Publication instance = (Publication) getSession().get(
					"com.orize.dao.Publication", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Publication> findByExample(Publication instance) {
		log.debug("finding Publication instance by example");
		try {
			List<Publication> results = (List<Publication>) getSession()
					.createCriteria("com.orize.dao.Publication")
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
		log.debug("finding Publication instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Publication as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Publication> findByPublication(Object publication) {
		return findByProperty(PUBLICATION, publication);
	}

	public List findAll() {
		log.debug("finding all Publication instances");
		try {
			String queryString = "from Publication";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Publication merge(Publication detachedInstance) {
		log.debug("merging Publication instance");
		try {
			Publication result = (Publication) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Publication instance) {
		log.debug("attaching dirty Publication instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Publication instance) {
		log.debug("attaching clean Publication instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

    public void delete(Publication1 publication1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}