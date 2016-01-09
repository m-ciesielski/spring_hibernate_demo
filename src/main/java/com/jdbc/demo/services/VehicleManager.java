package com.jdbc.demo.services;

import com.jdbc.demo.VehicleDAO;
import com.jdbc.demo.domain.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by mciesielski on 2015-10-23.
 */

@Component
@Transactional
public class VehicleManager implements VehicleDAO {

    private final static Logger LOGGER = LoggerFactory.getLogger(VehicleManager.class);

    @PersistenceContext
    EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Vehicle> getAll() {
        return em.createNamedQuery("vehicle.all").getResultList();
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        em.merge(vehicle);
        return em.find(Vehicle.class, vehicle.getId());
    }

    @Override
    public Vehicle get(long id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public Vehicle add(Vehicle vehicle) {
        em.persist(vehicle);
        em.flush();
        return vehicle;
    }

    @Override
    public void delete(Vehicle vehicle) {
        em.remove(em.getReference(Vehicle.class, vehicle.getId()));
    }

    @Override
    public void delete(long id) {
        em.remove(em.getReference(Vehicle.class, id));
    }
}
