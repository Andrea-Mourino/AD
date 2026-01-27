import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbPractica2 {

    private final Secuencia secuencia;

    public MongodbPractica2(Secuencia secuencia) {
        this.secuencia = secuencia;
    }

    @PostConstruct
    public void ejecutarSolucion() {
        secuencia.ejecutar();
        // System.exit(200); // comentado para no forzar la salida del proceso durante pruebas
    }

    public static void main(String[] args) {
        SpringApplication.run(MongodbPractica2.class, args);
    }

}
