package model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jugadores")
public class Jugador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "valor_mercado")
    private double valorMercado;

    @Column(name = "goles")
    private int goles;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public Jugador() {}

    public Jugador(String nombre, String posicion, double valorMercado, int goles, String nacionalidad, Equipo equipo) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.valorMercado = valorMercado;
        this.goles = goles;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    public double getValorMercado() { return valorMercado; }
    public void setValorMercado(double valorMercado) { this.valorMercado = valorMercado; }

    public int getGoles() { return goles; }
    public void setGoles(int goles) { this.goles = goles; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }
}
