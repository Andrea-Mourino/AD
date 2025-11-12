package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name= "Adestrador")
public class Adestrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "Nacemento")
    private Date nacemento;


    public Adestrador(int id, String nome, Date nacemento) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
    }


    public Adestrador(String nome, Date nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }


    public Adestrador() {
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

    public Date getNacemento() {
        return nacemento;
    }

    public void setNacemento(Date nacemento) {
        this.nacemento = nacemento;
    }


    @Override
    public String toString() {
        return "Adestrador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacemento=" + nacemento +
                '}';
    }
}
