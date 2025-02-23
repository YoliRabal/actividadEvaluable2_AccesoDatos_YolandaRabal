package controller;

import dao.EquipoDAO;
import model.Equipo;
import model.Liga;

import java.util.List;

public class EquipoController {
    private final EquipoDAO equipoDAO;

    public EquipoController() {
        this.equipoDAO = new EquipoDAO();
    }

    public void registrarEquipo(String nombreEquipo, String ciudad, Liga liga) {
        Equipo equipo = new Equipo(nombreEquipo, ciudad, liga);
        equipoDAO.insertarEquipo(equipo);
    }

    public List<Equipo> listarEquipos() {
        return equipoDAO.obtenerTodosEquipos();
    }

    public List<Equipo> listarEquiposPorLiga(int idLiga) {
        return equipoDAO.listarEquiposPorLiga(idLiga);
    }

    public Equipo obtenerEquipoPorNombre(String nombreEquipo) {  // ✅ Nuevo método
        return equipoDAO.obtenerEquipoPorNombre(nombreEquipo);
    }
}
