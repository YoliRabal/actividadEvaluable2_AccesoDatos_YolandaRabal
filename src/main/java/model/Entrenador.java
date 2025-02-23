package model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "entrenadores")
public class Entrenador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "experiencia_anios")
    private int experienciaAnios;

    @Column(name = "titulos_ganados")
    private int titulosGanados;

    @Column(name = "calificacion")
    private double calificacion;  // ✅ Nueva columna añadida

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Entrenador() {}

    public Entrenador(String nombre, int experienciaAnios, int titulosGanados, double calificacion, Equipo equipo) {
        this.nombre = nombre;
        this.experienciaAnios = experienciaAnios;
        this.titulosGanados = titulosGanados;
        this.calificacion = calificacion;
        this.equipo = equipo;
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getExperienciaAnios() { return experienciaAnios; }
    public void setExperienciaAnios(int experienciaAnios) { this.experienciaAnios = experienciaAnios; }

    public int getTitulosGanados() { return titulosGanados; }
    public void setTitulosGanados(int titulosGanados) { this.titulosGanados = titulosGanados; }

    public double getCalificacion() { return calificacion; }  // ✅ Getter y Setter de calificación
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
}
