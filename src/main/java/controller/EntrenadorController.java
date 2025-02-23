package controller;

import dao.EntrenadorDAO;
import model.Entrenador;
import model.Equipo;

import java.util.List;

public class EntrenadorController {
    private final EntrenadorDAO entrenadorDAO;

    public EntrenadorController() {
        this.entrenadorDAO = new EntrenadorDAO();
    }

    public Entrenador obtenerEntrenadorPorNombre(String nombreEntrenador) {  // ✅ Nuevo método
        return entrenadorDAO.obtenerEntrenadorPorNombre(nombreEntrenador);
    }

    public List<Entrenador> listarEntrenadoresPorLiga(int idLiga) {  // ✅ Nuevo método
        return entrenadorDAO.listarEntrenadoresPorLiga(idLiga);
    }

    public void registrarEntrenador(String nombre, int experiencia, int titulos, double calificacion, Equipo equipo) {
        Entrenador entrenador = new Entrenador(nombre, experiencia, titulos, calificacion, equipo);
        entrenadorDAO.insertarEntrenador(entrenador);
    }
}
