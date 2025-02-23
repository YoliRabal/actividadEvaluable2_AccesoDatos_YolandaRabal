package dao;

import model.Jugador;
import model.Equipo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class JugadorDAO {

    public void insertarJugador(Jugador jugador) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(jugador);
        transaction.commit();
        session.close();
    }

    public Jugador obtenerJugadorPorNombre(String nombreJugador) {  // ✅ Nuevo método
        Session session = HibernateUtils.getSessionFactory().openSession();
        Jugador jugador = session.createQuery("FROM Jugador j WHERE j.nombre = :nombre", Jugador.class)
                .setParameter("nombre", nombreJugador)
                .uniqueResult();
        session.close();
        return jugador;
    }

    public List<Jugador> obtenerJugadoresPorEquipo(int idEquipo) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Jugador> jugadores = session.createQuery("FROM Jugador j WHERE j.equipo.id = :idEquipo", Jugador.class)
                .setParameter("idEquipo", idEquipo)
                .list();
        session.close();
        return jugadores;
    }

    public void cambiarEquipoJugador(String nombreJugador, Equipo nuevoEquipo) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Jugador jugador = obtenerJugadorPorNombre(nombreJugador);
        if (jugador != null) {
            jugador.setEquipo(nuevoEquipo);
            session.merge(jugador);
        }
        transaction.commit();
        session.close();
    }
}
