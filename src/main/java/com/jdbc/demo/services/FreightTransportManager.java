package com.jdbc.demo.services;

import com.jdbc.demo.FreightTransportDAO;
import com.jdbc.demo.domain.FreightTransport;
import com.jdbc.demo.domain.FreightTransport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mateusz on 23-Oct-15.
 */

@Component
@Transactional
public class FreightTransportManager implements FreightTransportDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(FreightTransportManager.class);

    @PersistenceContext
    EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<FreightTransport> getAll() {
        return em.createNamedQuery("freightTransport.all").getResultList();
    }

    @Override
    public FreightTransport update(FreightTransport freightTransport) {
        em.merge(freightTransport);
        return em.find(FreightTransport.class, freightTransport.getId());
    }

    @Override
    public FreightTransport get(long id) {
        return em.find(FreightTransport.class, id);
    }

    @Override
    public FreightTransport add(FreightTransport freightTransport) {
        em.persist(freightTransport);
        em.flush();
        return freightTransport;
    }

    @Override
    public void delete(FreightTransport freightTransport) {
        em.remove(em.getReference(FreightTransport.class, freightTransport.getId()));
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(FreightTransport.class, id));
    }
}
