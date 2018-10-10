package com.example.codeclan.pirateservice.repository.pirates;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repository.pirates.PirateRepositoryCustom;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class PirateRepositoryImpl implements PirateRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Pirate> getPiratesForRaid(Raid raid) {
        List<Pirate> pirates = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Pirate.class);
            cr.createAlias("raids", "raid");
            cr.add(Restrictions.eq("raid.id", raid.getId()));
            pirates = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
        }

        return pirates;
    }
}
