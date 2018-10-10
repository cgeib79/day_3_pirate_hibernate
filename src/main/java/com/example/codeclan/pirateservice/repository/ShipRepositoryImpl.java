package com.example.codeclan.pirateservice.repository;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Ship;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import javax.transaction.Transactional;
import java.util.List;

public class ShipRepositoryImpl implements ShipRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Pirate> getPiratesForShip(Ship ship){
        List<Pirate> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Pirate.class);
            cr.add(Restrictions.eq("ship", ship));
            results = cr.list(); //cr.list() runs our query

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    public Ship findShipByName(String name){
        Ship foundShip = null;
        Session session = entityManager.unwrap(Session.class);


        try {
            Criteria cr =session.createCriteria(Ship.class);
            cr.add(Restrictions.eq("name", name));//want that to match name that's passed in
            foundShip = (Ship)cr.uniqueResult(); //If you only look for one thing, use unique result but remember to cast Ship.(Ship) casts the superclass to what we need
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
        }
        return foundShip;
    }
}
