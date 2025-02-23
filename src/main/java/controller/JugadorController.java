package controller;

import dao.JugadorDAO;
import model.Equipo;
import model.Jugador;

import java.util.List;

public class JugadorController {
    private final JugadorDAO jugadorDAO;

    public JugadorController() {
        this.jugadorDAO = new JugadorDAO();
    }

    public void registrarJugador(String nombre, String posicion, double valorMercado, int goles, String nacionalidad, Equipo equipo) {
        Jugador jugador = new Jugador(nombre, posicion, valorMercado, goles, nacionalidad, equipo);
        jugadorDAO.insertarJugador(jugador);
    }

    public Jugador obtenerJugadorPorNombre(String nombreJugador) {  // ✅ Nuevo método
        return jugadorDAO.obtenerJugadorPorNombre(nombreJugador);
    }

    public List<Jugador> listarJugadoresPorEquipo(int idEquipo) {
        return jugadorDAO.obtenerJugadoresPorEquipo(idEquipo);
    }

    public void ficharJugador(String nombreJugador, Equipo nuevoEquipo) {
        jugadorDAO.cambiarEquipoJugador(nombreJugador, nuevoEquipo);
    }
}
