package Domini;

/**
 * Created by falc on 20/03/15.
 * Clase Blanco
 */
public class Blanco extends Voto {

    public Blanco(String dni) {
        super(dni);
    }

    @Override
    public String obt_tipo() {
        return "Blanco";
    }
}
