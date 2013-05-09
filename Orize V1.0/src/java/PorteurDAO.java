

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PorteurDAO  {
	/*private static final Logger log = LoggerFactory.getLogger(PorteurDAO.class);
	// property constants
	public static final String CIN = "cin";
	public static final String NOM = "nom";
	public static final String PRENOM = "prenom";
	public static final String PROFESSION = "profession";
	public static final String SEXE = "sexe";
	public static final String EMAIL = "email";
	public static final String ADRESSE = "adresse";

	public void save(Porteur transientInstance) {
		log.debug("saving Porteur instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Porteur persistentInstance) {
		log.debug("deleting Porteur instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Porteur findById(java.lang.Integer id) {
		log.debug("getting Porteur instance with id: " + id);
		try {
			Porteur instance = (Porteur) getSession().get("entity.Porteur", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Porteur> findByExample(Porteur instance) {
		log.debug("finding Porteur instance by example");
		try {
			List<Porteur> results = (List<Porteur>) getSession()
					.createCriteria("entity.Porteur").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Porteur instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Porteur as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Porteur> findByCin(Object cin) {
		return findByProperty(CIN, cin);
	}

	public List<Porteur> findByNom(Object nom) {
		return findByProperty(NOM, nom);
	}

	public List<Porteur> findByPrenom(Object prenom) {
		return findByProperty(PRENOM, prenom);
	}

	public List<Porteur> findByProfession(Object profession) {
		return findByProperty(PROFESSION, profession);
	}

	public List<Porteur> findBySexe(Object sexe) {
		return findByProperty(SEXE, sexe);
	}

	public List<Porteur> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Porteur> findByAdresse(Object adresse) {
		return findByProperty(ADRESSE, adresse);
	}

	public List findAll() {
		log.debug("finding all Porteur instances");
		try {
			String queryString = "from Porteur";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Porteur merge(Porteur detachedInstance) {
		log.debug("merging Porteur instance");
		try {
			Porteur result = (Porteur) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Porteur instance) {
		log.debug("attaching dirty Porteur instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Porteur instance) {
		log.debug("attaching clean Porteur instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
        * */
}