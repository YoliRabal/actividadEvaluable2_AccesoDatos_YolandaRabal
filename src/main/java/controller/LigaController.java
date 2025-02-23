package controller;

import dao.LigaDAO;
import model.Liga;

import java.util.List;

public class LigaController {
    private final LigaDAO ligaDAO;

    public LigaController() {
        this.ligaDAO = new LigaDAO();
    }

    public void crearLiga(String nombreLiga, String fechaInicio, String fechaFin) {
        Liga liga = new Liga(nombreLiga, fechaInicio, fechaFin);
        ligaDAO.insertarLiga(liga);
    }

    public Liga consultarLiga(int id) {  // ✅ Nuevo método
        return ligaDAO.consultarLiga(id);
    }

    public List<Liga> obtenerTodasLasLigas() {
        return ligaDAO.obtenerTodasLasLigas();
    }
}
