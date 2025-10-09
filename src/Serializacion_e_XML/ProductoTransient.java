package Serializacion_e_XML;

import java.io.*;

public class ProductoTransient implements Serializable {

    private String nome;
    private transient int num1;
    private double num2;

    public ProductoTransient(String nome, int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "ProductoTransient {" +
                "nome='" + nome + '\'' +
                ", num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }

}

