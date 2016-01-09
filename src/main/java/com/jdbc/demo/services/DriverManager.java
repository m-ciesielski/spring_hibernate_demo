package com.jdbc.demo.services;

import com.jdbc.demo.DriverDAO;
import com.jdbc.demo.domain.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mateusz on 22-Oct-15.
 */

@Stateless
public class DriverManager implements DriverDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(DriverManager.class);

    @PersistenceContext
    EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Driver> getAll() {
        return em.createNamedQuery("driver.all").getResultList();
    }

    @Override
    public Driver update(Driver driver) {
        em.merge(driver);
        return em.find(Driver.class, driver.getId());
    }

    @Override
    public Driver get(long id) {
        return em.find(Driver.class, id);
    }

    @Override
    public Driver add(Driver driver) {
        em.persist(driver);
        em.flush();
        return driver;
    }

    @Override
    public void delete(Driver driver) {
        em.remove(em.getReference(Driver.class, driver.getId()));
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(Driver.class, id));
    }
}
