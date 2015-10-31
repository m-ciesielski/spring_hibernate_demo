package com.jdbc.demo.services;

import com.jdbc.demo.FreightTransportDAO;
import com.jdbc.demo.domain.FreightTransport;

import java.util.ArrayList;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public class FreightTransportEntityManager extends EntityManager implements FreightTransportDAO{

    private ArrayList<FreightTransport> freightTransports;


    public FreightTransportEntityManager(){
        freightTransports = new ArrayList<FreightTransport>();
    }

    public ArrayList<FreightTransport> getAll(){
        return freightTransports;
    }

    public FreightTransport add(FreightTransport freightTransport) {
        freightTransports.add(freightTransport);
        if(freightTransports.contains(freightTransport))
            return freightTransport;
        return null;
    }

    public void update(FreightTransport freightTransport) {
        //TODO
    }

    public void delete(FreightTransport freightTransport) {
        freightTransports.remove(freightTransport);
    }

    public FreightTransport get(int id) {
        for (FreightTransport freightTransport: freightTransports){
            if(freightTransport.getId() == id)
                return freightTransport;
        }
        return null;
    }
}
