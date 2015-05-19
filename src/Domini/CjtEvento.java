package Domini;

import java.util.List;
import java.util.Random;

/**
 * Created by usuario on 26/04/2015.
 */
public class CjtEvento {
    private TST<Evento> cjt;

    private static final String error1 = "El Nombre no es valido";
    private static final String error2 = "La fecha no es valida";
    private static final String error3 = "El rvento no es valido";
    private static final String error4 = "El nuevo nombre no es valido";
    private static final String error5 = "La Fecha nueva no es valida";
    private static final String error6 = "El nombre Nombre no valido";



    private void Valido(String nombre, String fecha) throws Exception {
        if (nombre.equals("")) throw new Exception(error1);
        if (!Fecha.valido(fecha)) throw new Exception(error2);
    }

    //////////////////////////////////////CREADORA////////////////////////

    public CjtEvento() {
        cjt = new TST<Evento>();
    }

    /////////////////////////////////////ELIMINADORA/////////////////////
    public void EliminarCjtEvento() {
        cjt.vaciar();
        cjt = null;
    }

    /////////////////////////////////////MODIFICADORAS////////////////////////

    public void EliminarEvento(String nombre, String fecha) throws Exception{
        Valido(nombre, fecha);
        //En caso de que la fecha tenga numeros que empiecen por 0 me aseguro
        // de quitarlos porque sino no se encontrara el objeto
        //Siempre convierto el nombre a mayusculas para evitar errores de no
        // encontrar el elemento
        String name = nombre.toUpperCase();
        String s[] = fecha.split("/");
        fecha = Integer.toString(Integer.parseInt(s[0]))+Integer.toString(Integer.parseInt(s[1]))+Integer.toString(Integer.parseInt(s[2]));
        cjt.borrar(name + fecha);
    }

    public void AgregarEvento(Evento e) throws Exception{
        if (e == null) throw new Exception(error3);
        cjt.insertar(e.ID(), e);
    }

    public void ModificarNombreEvento(String nomViejo, String fecha, String nomNuevo) throws Exception{
        Valido(nomViejo, fecha);
        if (!nomNuevo.equals("")) {
        //Siempre convierto el nombre a mayusculas para evitar errores de no encontrar el elemento
            String oldname = nomViejo.toUpperCase();
            String newname = nomNuevo.toUpperCase();
            if (!nomNuevo.equals(nomViejo)){
                //En caso de que la fecha tenga numeros que empiecen por 0 me aseguro de quitarlos porque
                // sino no se encontrara el objeto
                String s[] = fecha.split("/");
                fecha = Integer.toString(Integer.parseInt(s[0])) + Integer.toString(Integer.parseInt(s[1])) + Integer.toString(Integer.parseInt(s[2]));
                //Como obtener pasa la referencia al objeto lo modifico y lo pongo correctamente en el
                // conjunto de acuerdo a su nueva clave
                Evento aux = cjt.obtener(oldname + fecha);
                aux.ModNombre(newname);
                cjt.modificar(oldname + fecha, newname + fecha, aux);
            }
            else throw new Exception(error4);
        }
        else throw new Exception(error4);
    }

    public void ModificarFechaEvento(String nombre, String fechaVieja, String fechaNueva) throws Exception {
        Valido(nombre, fechaVieja);
        if (!Fecha.valido(fechaNueva)) throw new Exception(error5);
        //En caso de que la fecha tenga numeros que empiecen por 0 me aseguro de quitarlos porque
        // sino no se encontrara el objeto
        String f[] = fechaVieja.split("/");
        fechaVieja = Integer.toString(Integer.parseInt(f[0]))+Integer.toString(Integer.parseInt(f[1]))+Integer.toString(Integer.parseInt(f[2]));
        f = fechaNueva.split("/");
        fechaNueva = Integer.toString(Integer.parseInt(f[0]))+Integer.toString(Integer.parseInt(f[1]))+Integer.toString(Integer.parseInt(f[2]));
        if (!fechaVieja.equals(fechaNueva)) {
            //Siempre convierto el nombre a mayusculas para evitar errores de no encontrar el elemento
            String name = nombre.toUpperCase();
            //Como obtener pasa la referencia al objeto lo modifico y lo pongo correctamente en el
            // conjunto de acuerdo a su nueva clave
            Evento aux = cjt.obtener(name + fechaVieja);
            aux.ModFecha(fechaNueva);
            cjt.modificar(name+fechaVieja, name+fechaNueva, aux);
        }
        else throw new Exception(error5);
    }

    public void ModificarImpEvento(String nombre, String fecha, int importance) throws Exception {
        Valido(nombre, fecha);
        //Siempre convierto el nombre a mayusculas para evitar errores de no encontrar el elemento
        String name = nombre.toUpperCase();
        //En caso de que la fecha tenga numeros que empiecen por 0 me aseguro de quitarlos porque
        // sino no se encontrara el objeto
        String s[] = fecha.split("/");
        fecha = Integer.toString(Integer.parseInt(s[0]))+Integer.toString(Integer.parseInt(s[1]))+Integer.toString(Integer.parseInt(s[2]));
        //Como el tst devuelve la refencia al objeto directamente puedo cambiarle los atributos
        cjt.obtener(name+fecha).ModImportancia(importance);
    }

    public void AgregarEventoRandom() throws Exception {
        //Creo un nombre random concatenando letras de
        // la A-Z. 90 y 65 corresponde al codigo
        // ascii de la Z y la A respectivamente
        Random r = new Random();
        String nombre;
        Fecha f;
        do {
            nombre = "";
            f = new Fecha(r);
            for (int i = 0; i < 8; ++i) {
                int valorEntero = r.nextInt(90-65+1)+65;
                char c = (char)valorEntero;
                nombre = nombre + c;
            }
        }
        //En el remoto caso de que el random genere un evento que ya existe
        while (cjt.existe(nombre+f.toString()));
        //Uso un numero random [1,10] para importancia
        int importancia = r.nextInt(10)+1;
        //Uso un numero random [1,5] para seleccionar el tipo de evento
        int tipo = r.nextInt(5)+1;
        Evento e;
        switch (tipo) {
            case 1:
                e = new Votacion(nombre, f.toString(), importancia);
                cjt.insertar(e.ID(), e);
                break;
            case 2:
                e = new Personal(nombre, f.toString(), importancia);
                cjt.insertar(e.ID(), e);
                break;
            case 3:
                e = new Profesional(nombre, f.toString(), importancia);
                cjt.insertar(e.ID(), e);
                break;
            case 4:
                e = new Oficial(nombre, f.toString(), importancia);
                cjt.insertar(e.ID(), e);
                break;
            case 5:
                e =  new NoOficial(nombre, f.toString(), importancia);
                cjt.insertar(e.ID(), e);
                break;
            default:
        }
    }

    //Consultoras

    public List<Evento> ConsultarTodosEventos() {
        return cjt.consultarObjetos();
    }

    public Evento ConsultarEvento(String nombre, String fecha) throws Exception {
        Valido(nombre, fecha);
        //Siempre convierto el nombre a mayusculas para evitar errores de no encontrar el elemento
        String name = nombre.toUpperCase();
        //En caso de que la fecha tenga numeros que empiecen por 0 me aseguro de quitarlos porque sino no se encontrara el objeto
        String s[] = fecha.split("/");
        fecha = Integer.toString(Integer.parseInt(s[0]))+Integer.toString(Integer.parseInt(s[1]))+Integer.toString(Integer.parseInt(s[2]));
        return cjt.obtener(name+fecha);
    }

    public boolean ExisteEvento(String nombre, String fecha) throws Exception {
        Valido(nombre, fecha);
        //Siempre convierto el nombre a mayusculas para evitar errores de no encontrar el elemento
        String name = nombre.toUpperCase();
        //En caso de que la fecha tenga numeros que empiecen por 0 me aseguro de quitarlos porque sino no se encontrara el objeto
        String s[] = fecha.split("/");
        fecha = Integer.toString(Integer.parseInt(s[0]))+Integer.toString(Integer.parseInt(s[1]))+Integer.toString(Integer.parseInt(s[2]));
        return cjt.existe(name+fecha);
    }

    public int size() {
        return cjt.size();
    }
}
