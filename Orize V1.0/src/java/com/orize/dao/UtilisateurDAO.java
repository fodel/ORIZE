package com.orize.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orize.entity.Utilisateur;

/**
 * A data access object (DAO) providing persistence and search support for
 * Utilisateur entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.orize.dao.Utilisateur
 * @author MyEclipse Persistence Tools
 */
public class UtilisateurDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UtilisateurDAO.class);
	// property constants
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String LOGIN = "login";
	public static final String PASSWORD = "password";
	public static final String QUESTION_SECRETE = "questionSecrete";
	public static final String REPONSE = "reponse";
	public static final String STATU = "statu";

	public void save(Utilisateur transientInstance) {
		log.debug("saving Utilisateur instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Utilisateur persistentInstance) {
		log.debug("deleting Utilisateur instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Utilisateur findById(java.lang.Integer id) {
		log.debug("getting Utilisateur instance with id: " + id);
		try {
			Utilisateur instance = (Utilisateur) getSession().get(
					"com.orize.dao.Utilisateur", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Utilisateur> findByExample(Utilisateur instance) {
		log.debug("finding Utilisateur instance by example");
		try {
			List<Utilisateur> results = (List<Utilisateur>) getSession()
					.createCriteria("com.orize.dao.Utilisateur")
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
		log.debug("finding Utilisateur instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Utilisateur as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
        
        public List findByLoginAndPass(String login, String password) {
		log.debug("finding User instance with username and password");
		try {
			String queryString = "from Utilisateur as model where model.login= ? and model.password = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, login);
                        queryObject.setParameter(1, password);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by login and password failed", re);
			throw re;
		}
	}

	public List<Utilisateur> findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}

	public List<Utilisateur> findByPrenom(Object prenom) {
		return findByProperty(PRENOM, prenom);
	}

	public List<Utilisateur> findByLogin(Object login) {
		return findByProperty(LOGIN, login);
	}

	public List<Utilisateur> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Utilisateur> findByQuestionSecrete(Object questionSecrete) {
		return findByProperty(QUESTION_SECRETE, questionSecrete);
	}

	public List<Utilisateur> findByReponse(Object reponse) {
		return findByProperty(REPONSE, reponse);
	}

	public List<Utilisateur> findByStatu(Object statu) {
		return findByProperty(STATU, statu);
	}

	public List findAll() {
		log.debug("finding all Utilisateur instances");
		try {
			String queryString = "from Utilisateur";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Utilisateur merge(Utilisateur detachedInstance) {
		log.debug("merging Utilisateur instance");
		try {
			Utilisateur result = (Utilisateur) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Utilisateur instance) {
		log.debug("attaching dirty Utilisateur instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Utilisateur instance) {
		log.debug("attaching clean Utilisateur instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}