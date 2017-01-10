package com.journaldev.spring.dao;
import com.journaldev.spring.model.StrongBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pcthomas on 10/01/2017.
 */
@Repository
public class StrongBoxDAOImpl implements StrongBoxDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addStrongBox(StrongBox sb) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(sb);
        logger.info("StrongBox saved successfully, StrongBox Details="+sb);
    }

    @Override
    public void updateStrongBox(StrongBox sb) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(sb);
        logger.info("Person updated successfully, Person Details="+sb);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StrongBox> listStrongBox() {
        Session session = this.sessionFactory.getCurrentSession();
        List<StrongBox> StrongBoxList = session.createQuery("from StrongBox").list();
        for(StrongBox sb : StrongBoxList){
            logger.info("StrongBox List::"+sb);
        }
        return StrongBoxList;
    }

    @Override
    public StrongBox getStrongBoxId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        StrongBox sb = (StrongBox) session.load(StrongBox.class, new Integer(id));
        logger.info("StrongBox loaded successfully, StrongBox details="+sb);
        return sb;
    }

    @Override
    public void removeStrongBox(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        StrongBox sb = (StrongBox) session.load(StrongBox.class, new Integer(id));
        if(null != sb){
            session.delete(sb);
        }
        logger.info("StrongBox deleted successfully, StrongBox details="+sb);
    }

}