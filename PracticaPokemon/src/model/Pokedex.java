package model;

import service.PokedexService;

import javax.persistence.*;

@Entity
@Table(name= "Pokedex")
public class Pokedex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "Peso", precision = 10, scale = 2)
    private double peso;

    @Column(name = "Misc")
    private String misc;


    public Pokedex(int id, String nome, double peso, String misc) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }


    public Pokedex(String nome, double peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }


    public Pokedex() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }


    @Override
    public String toString() {
        return "Pokedex{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", misc='" + misc + '\'' +
                '}';
    }
}
