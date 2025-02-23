package dao;

import model.Entrenador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class EntrenadorDAO {

    public void insertarEntrenador(Entrenador entrenador) {  // ✅ Nuevo método
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entrenador);
        transaction.commit();
        session.close();
    }

    public Entrenador obtenerEntrenadorPorNombre(String nombreEntrenador) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Entrenador entrenador = session.createQuery("FROM Entrenador e WHERE e.nombre = :nombre", Entrenador.class)
                .setParameter("nombre", nombreEntrenador)
                .uniqueResult();
        session.close();
        return entrenador;
    }

    public List<Entrenador> listarEntrenadoresPorLiga(int idLiga) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Entrenador> entrenadores = session.createQuery(
                        "SELECT e FROM Entrenador e WHERE e.equipo.liga.id = :idLiga", Entrenador.class)
                .setParameter("idLiga", idLiga)
                .list();
        session.close();
        return entrenadores;
    }
}
