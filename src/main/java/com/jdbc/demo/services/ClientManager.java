package com.jdbc.demo.services;

import com.jdbc.demo.ClientDAO;
import com.jdbc.demo.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Mateusz on 02-Nov-15.
 */
@Stateless
public class ClientManager implements ClientDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(ClientManager.class);

    @PersistenceContext
    EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> getAll() {
        return em.createNamedQuery("client.all").getResultList();
    }

    @Override
    public Client update(Client client) {
        em.merge(client);
        return em.find(Client.class, client.getId());
    }

    @Override
    public Client get(long id) {
        return em.find(Client.class, id);
    }

    @Override
    public Client add(Client client) {
        em.persist(client);
        em.flush();
        return client;
    }

    @Override
    public void delete(Client client) {
        em.remove(em.getReference(Client.class, client.getId()));
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(Client.class, id));
    }
}
