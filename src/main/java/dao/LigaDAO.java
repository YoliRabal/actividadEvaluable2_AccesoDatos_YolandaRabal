package dao;

import model.Liga;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class LigaDAO {

    public void insertarLiga(Liga liga) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(liga);
        transaction.commit();
        session.close();
    }

    public Liga consultarLiga(int id) {  // ✅ Nuevo método
        Session session = HibernateUtils.getSessionFactory().openSession();
        Liga liga = session.get(Liga.class, id);
        session.close();
        return liga;
    }

    public List<Liga> obtenerTodasLasLigas() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Liga> ligas = session.createQuery("FROM Liga", Liga.class).list();
        session.close();
        return ligas;
    }
}
