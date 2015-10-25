package com.jdbc.demo;

import com.jdbc.demo.domain.FreightTransport;

import java.util.List;

/**
 * Created by Mateusz on 23-Oct-15.
 */
public interface FreightTransportDAO {
    List<FreightTransport> getAll();
    FreightTransport add(FreightTransport freightTransport);
    void update(FreightTransport freightTransport);
    void delete(FreightTransport freightTransport);
    FreightTransport get(int id);
    //FreightTransport getLatestStarted();
    //FreightTransport getLatestFinished();
}
