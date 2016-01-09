package com.jdbc.demo.services;

import com.jdbc.demo.AddressDAO;
import com.jdbc.demo.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mateusz on 31-Oct-15.
 */

@Stateless
public class AddressManager implements AddressDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(AddressManager.class);

    @PersistenceContext
    EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Address> getAll() {
        return em.createNamedQuery("address.all").getResultList();
    }

    @Override
    public Address update(Address address) {
        em.merge(address);
        return em.find(Address.class, address.getId());
    }

    @Override
    public Address get(long id) {
        return em.find(Address.class, id);
    }

    @Override
    public Address add(Address address) {
        em.persist(address);
        em.flush();
        return address;
    }

    @Override
    public void delete(Address address) {
        em.remove(em.getReference(Address.class, address.getId()));
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(Address.class, id));
    }
}
