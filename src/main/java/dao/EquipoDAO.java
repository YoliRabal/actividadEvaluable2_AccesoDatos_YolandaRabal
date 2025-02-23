package dao;

import model.Equipo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class EquipoDAO {

    public void insertarEquipo(Equipo equipo) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(equipo);
        transaction.commit();
        session.close();
    }

    public List<Equipo> obtenerTodosEquipos() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Equipo> equipos = session.createQuery("FROM Equipo", Equipo.class).list();
        session.close();
        return equipos;
    }

    public List<Equipo> listarEquiposPorLiga(int idLiga) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Equipo> equipos = session.createQuery("FROM Equipo e WHERE e.liga.id = :idLiga", Equipo.class)
                .setParameter("idLiga", idLiga)
                .list();
        session.close();
        return equipos;
    }

    public void eliminarEquipo(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Equipo equipo = session.get(Equipo.class, id);
        if (equipo != null) {
            session.remove(equipo);
        }
        transaction.commit();
        session.close();
    }

    public Equipo obtenerEquipoPorNombre(String nombreEquipo) {  // ✅ Nuevo método
        Session session = HibernateUtils.getSessionFactory().openSession();
        Equipo equipo = session.createQuery("FROM Equipo e WHERE e.nombreEquipo = :nombre", Equipo.class)
                .setParameter("nombre", nombreEquipo)
                .uniqueResult();
        session.close();
        return equipo;
    }
}
