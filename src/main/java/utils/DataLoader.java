package utils;

import controller.EquipoController;
import controller.JugadorController;
import controller.LigaController;
import controller.EntrenadorController;
import model.Equipo;
import model.Liga;
import model.Jugador;
import model.Entrenador;

import java.util.List;

public class DataLoader {
    public static void cargarDatos() {
        LigaController ligaController = new LigaController();
        EquipoController equipoController = new EquipoController();
        JugadorController jugadorController = new JugadorController();
        EntrenadorController entrenadorController = new EntrenadorController();

        // ✅ 1️⃣ Crear una liga si no existe
        Liga liga = ligaController.consultarLiga(1);
        if (liga == null) {
            ligaController.crearLiga("LaLiga", "2024-08-01", "2025-05-31");
            liga = ligaController.consultarLiga(1);
        }

        // ✅ 2️⃣ Crear equipos si no existen
        if (equipoController.obtenerEquipoPorNombre("Real Madrid") == null) {
            equipoController.registrarEquipo("Real Madrid", "Madrid", liga);
        }
        if (equipoController.obtenerEquipoPorNombre("FC Barcelona") == null) {
            equipoController.registrarEquipo("FC Barcelona", "Barcelona", liga);
        }
        if (equipoController.obtenerEquipoPorNombre("Atlético de Madrid") == null) {
            equipoController.registrarEquipo("Atlético de Madrid", "Madrid", liga);
        }

        // ⏳ Esperar a que los equipos se creen
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        // ✅ Obtener equipos
        Equipo realMadrid = equipoController.obtenerEquipoPorNombre("Real Madrid");
        Equipo barcelona = equipoController.obtenerEquipoPorNombre("FC Barcelona");
        Equipo atletico = equipoController.obtenerEquipoPorNombre("Atlético de Madrid");

        // ✅ 3️⃣ Crear jugadores si no existen
        if (jugadorController.obtenerJugadorPorNombre("Karim Benzema") == null) {
            jugadorController.registrarJugador("Karim Benzema", "Delantero", 100, 30, "Francia", realMadrid);
        }
        if (jugadorController.obtenerJugadorPorNombre("Luka Modric") == null) {
            jugadorController.registrarJugador("Luka Modric", "Centrocampista", 20, 15, "Croacia", realMadrid);
        }
        if (jugadorController.obtenerJugadorPorNombre("Pedri") == null) {
            jugadorController.registrarJugador("Pedri", "Centrocampista", 70, 10, "España", barcelona);
        }
        if (jugadorController.obtenerJugadorPorNombre("Robert Lewandowski") == null) {
            jugadorController.registrarJugador("Robert Lewandowski", "Delantero", 120, 35, "Polonia", barcelona);
        }
        if (jugadorController.obtenerJugadorPorNombre("Antoine Griezmann") == null) {
            jugadorController.registrarJugador("Antoine Griezmann", "Delantero", 80, 25, "Francia", atletico);
        }
        if (jugadorController.obtenerJugadorPorNombre("Koke") == null) {
            jugadorController.registrarJugador("Koke", "Centrocampista", 40, 5, "España", atletico);
        }

        // ✅ 4️⃣ Fichar jugadores si aún no han sido fichados
        jugadorController.ficharJugador("Karim Benzema", atletico);
        jugadorController.ficharJugador("Pedri", realMadrid);

        // ✅ 5️⃣ Crear entrenadores si no existen
        if (entrenadorController.obtenerEntrenadorPorNombre("Carlo Ancelotti") == null) {
            entrenadorController.registrarEntrenador("Carlo Ancelotti", 25, 20, 8.5, realMadrid);
        }
        if (entrenadorController.obtenerEntrenadorPorNombre("Xavi Hernández") == null) {
            entrenadorController.registrarEntrenador("Xavi Hernández", 5, 3, 7.0, barcelona);
        }
        if (entrenadorController.obtenerEntrenadorPorNombre("Diego Simeone") == null) {
            entrenadorController.registrarEntrenador("Diego Simeone", 15, 10, 9.0, atletico);
        }

        // ✅ 6️⃣ Mostrar todos los equipos
        System.out.println("\n📌 Equipos en LaLiga:");
        List<Equipo> equipos = equipoController.listarEquipos();
        for (Equipo equipo : equipos) {
            System.out.println("- " + equipo.getNombreEquipo() + " (" + equipo.getCiudad() + ")");
        }

        // ✅ 7️⃣ Mostrar los jugadores de un equipo
        System.out.println("\n📌 Jugadores del FC Barcelona:");
        List<Jugador> jugadoresBarcelona = jugadorController.listarJugadoresPorEquipo(barcelona.getId());
        for (Jugador jugador : jugadoresBarcelona) {
            System.out.println("- " + jugador.getNombre() + " (" + jugador.getPosicion() + ")");
        }

        // ✅ 8️⃣ Mostrar equipos de la liga
        System.out.println("\n📌 Equipos en " + liga.getNombreLiga() + ":");
        List<Equipo> equiposLiga = equipoController.listarEquiposPorLiga(liga.getId());
        for (Equipo equipo : equiposLiga) {
            System.out.println("- " + equipo.getNombreEquipo());
        }

        // ✅ 9️⃣ Mostrar entrenadores de los equipos de la liga
        System.out.println("\n📌 Entrenadores de los equipos en LaLiga:");
        List<Entrenador> entrenadoresLiga = entrenadorController.listarEntrenadoresPorLiga(liga.getId());
        for (Entrenador entrenador : entrenadoresLiga) {
            System.out.println("- " + entrenador.getNombre() + " (Equipo: " + entrenador.getEquipo().getNombreEquipo() + ")");
        }

        System.out.println("\n✅ Datos iniciales cargados y mostrados correctamente.");
    }
}
