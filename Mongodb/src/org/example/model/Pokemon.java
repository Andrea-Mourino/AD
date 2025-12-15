package org.example.model;

@Document(collection = "Pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "Nome", length = 50, nullable = false)
    private String nome;

    private String tipo;

    private int nivel;

    private String habilidades;

    private String adestradorId;
}
