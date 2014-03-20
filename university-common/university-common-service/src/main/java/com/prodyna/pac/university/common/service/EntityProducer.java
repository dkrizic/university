package com.prodyna.pac.university.common.service;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dkrizic on 2014-03-20.
 */
public class EntityProducer {

    @PersistenceContext
    private EntityManager em;

    @Produces
    public EntityManager produceEntityManager() {
        return em;
    }
}
