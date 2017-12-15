package com.kiranpariyar.test.api;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
    @Produces
    @PersistenceContext(unitName = "default")
    private EntityManager em;
}
