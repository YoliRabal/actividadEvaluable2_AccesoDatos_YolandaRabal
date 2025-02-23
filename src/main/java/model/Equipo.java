package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @Column(name = "ciudad")
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Liga liga;  // ✅ Usa un objeto Liga, NO un int

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Jugador> jugadores;

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Entrenador entrenador;

    public Equipo() {}

    public Equipo(String nombreEquipo, String ciudad, Liga liga) {  // ✅ Usa un objeto Liga
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
        this.liga = liga;
    }

    public int getId() { return id; }
    public String getNombreEquipo() { return nombreEquipo; }
    public void setNombreEquipo(String nombreEquipo) { this.nombreEquipo = nombreEquipo; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Liga getLiga() { return liga; }  // ✅ Devuelve un objeto Liga, no un int
    public void setLiga(Liga liga) { this.liga = liga; }
    public List<Jugador> getJugadores() { return jugadores; }
    public Entrenador getEntrenador() { return entrenador; }
}
