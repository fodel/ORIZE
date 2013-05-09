package com.orize.dao;

import com.orize.entity.Image;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ImageDAO extends BaseHibernateDAO {

    private static final Logger log = LoggerFactory.getLogger(ImageDAO.class);
    // property constants
    public static final String DESC = "description";

    public void save(Image transientInstance) {
        log.debug("saving Image instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(Image persistentInstance) {
        log.debug("deleting Image instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public Image findById(java.lang.Integer id) {
        log.debug("getting Image instance with id: " + id);
        try {
            Image instance = (Image) getSession().get("entity.Image", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<Image> findByExample(Image instance) {
        log.debug("finding Image instance by example");
        try {
            List<Image> results = (List<Image>) getSession()
                    .createCriteria("entity.Image").add(create(instance))
                    .list();
            log.debug("find by example successful, result size: "
                    + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByDescrep(String  value) {
        
        try {
            getSession().clear();
            String queryString = "from Image  where descreption like '"
                    + value + "'";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

 
    
    public List findAll() {
        log.debug("finding all Image instances");
        try {
            String queryString = "from Image";
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public Image merge(Image detachedInstance) {
        log.debug("merging Image instance");
        try {
            Image result = (Image) getSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Image instance) {
        log.debug("attaching dirty Image instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(Image instance) {
        log.debug("attaching clean Image instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}