package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Practica2Mongodb {

    private final Secuencia secuencia;

    public Practica2Mongodb(Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    @PostConstruct
    public void ejecutarSolucion() {
        secuencia.ejecutar();
    }

    public static void main(String[] args) {
        SpringApplication.run(Practica2Mongodb.class, args);
    }

}
