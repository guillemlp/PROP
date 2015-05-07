package Domini;


import Persistencia.ControladorPersistencia;

import java.util.Iterator;
import java.util.List;

public class ControladorCjtEvento {
    private static final String E1 = "Tipo de evento incorrecto: ";

    private static final int max_lineas_guardar = 300;
    private static final int max_lineas_cargar = 300;

    private CjtEvento ce;

    public ControladorCjtEvento() {
        ce = new CjtEvento();
    }

    public void EliminarEvento(String nombre, String fecha, ControladorRelaciones cr) throws Exception{
        if(cr.tieneRelaciones(nombre, fecha)) cr.eliminarRelaciones(nombre, fecha);
        ce.EliminarEvento(nombre, fecha);
    }

    public void EliminarCjtEvento(ControladorRelaciones cr) throws Exception {
        ce.EliminarCjtEvento();
        cr.eliminarRelaciones();
    }

    public void AgregarVotacion(String nombre, String fecha, int importancia) throws Exception{
        Votacion v = new Votacion(nombre, fecha, importancia);
        ce.AgregarEvento(v);
    }

    public void AgregarReunionPersonal(String nombre, String fecha, int importancia) throws Exception{
        Personal per = new Personal(nombre, fecha, importancia);
        ce.AgregarEvento(per);
    }

    public void AgregarReunionProfesional(String nombre, String fecha, int importancia) throws Exception{
        Profesional pro = new Profesional(nombre, fecha, importancia);
        ce.AgregarEvento(pro);
    }

    public void AgregarActoOficial(String nombre, String fecha, int importancia) throws Exception{
        Oficial o = new Oficial(nombre, fecha, importancia);
        ce.AgregarEvento(o);
    }

    public void AgregarActoNoOficial(String nombre, String fecha, int importancia) throws Exception{
        NoOficial n = new NoOficial(nombre, fecha, importancia);
        ce.AgregarEvento(n);
    }

    public void AgregarEventoRandom() throws Exception {
        ce.AgregarEventoRandom();
    }

    public void ModificarNombreEvento(String nomViejo, String fecha, String nomNuevo, ControladorRelaciones cr) throws Exception{
        if(cr.tieneRelaciones(nomViejo, fecha)) {
            String id = ConsultarEvento(nomViejo,fecha).ID();
            ce.ModificarNombreEvento(nomViejo, fecha, nomNuevo);
            String new_id = ConsultarEvento(nomNuevo, fecha).ID();
            cr.modEvento(id,new_id);
        }
        else ce.ModificarNombreEvento(nomViejo, fecha, nomNuevo);
    }

    public void ModificarFechaEvento(String nombre, String fechaVieja, String fechaNueva, ControladorRelaciones cr) throws Exception {
        if(cr.tieneRelaciones(nombre, fechaVieja)){
            String id = ConsultarEvento(nombre,fechaVieja).ID();
            ce.ModificarFechaEvento(nombre, fechaVieja, fechaNueva);
            String new_id = ConsultarEvento(nombre,fechaNueva).ID();
            cr.modEvento(id, new_id);
        }
        else ce.ModificarFechaEvento(nombre, fechaVieja, fechaNueva);
    }

    public void ModificarImpEvento(String nombre, String fecha, int importance) throws Exception {
        ce.ModificarImpEvento(nombre, fecha, importance);
    }

    public List<Evento> ConsultarTodosEventos() {
        return ce.ConsultarTodosEventos();
    }

    public Evento ConsultarEvento(String nombre, String fecha) throws Exception{
        return ce.ConsultarEvento(nombre, fecha);
    }

    public boolean ExisteEvento(String nombre, String fecha) throws NoValido {
        return ce.ExisteEvento(nombre, fecha);
    }

    public int size(){
        return ce.size();
    }

    public void guardar(String ruta) throws Exception {
        if (ce.size() > 0) {
            ControladorPersistencia cp = new ControladorPersistencia(ruta);
            List<Evento> es = ce.ConsultarTodosEventos();
            Iterator<Evento> it = es.iterator();
            cp.abrirEscritura();
            while (it.hasNext()){
                String datos = "";
                int j = 0;
                while (j < max_lineas_guardar && it.hasNext()){
                    datos += it.next().toString()+"\n";
                    ++j;
                }
                cp.escribir(datos);
            }
            cp.cerrarFichero();
        }
    }

    public void cargar(String ruta, ControladorRelaciones cr) throws Exception {
        ControladorPersistencia cp = new ControladorPersistencia(ruta);
        cp.abrirLectura();
        EliminarCjtEvento(cr);
        String r = cp.leer(max_lineas_cargar);
        while (!r.equals("")){
            String[] aux = r.split("\n");
            for(String con : aux){
                String[] prm = con.split("\\s");
                if(prm[0].equals("Votacion")) AgregarVotacion(prm[1], prm[2], Integer.parseInt(prm[3]));
                else if(prm[0].equals("ReunionPersonal")) AgregarReunionPersonal(prm[1], prm[2], Integer.parseInt(prm[3]));
                else if(prm[0].equals("ReunionProfesional")) AgregarReunionProfesional(prm[1],prm[2],Integer.parseInt(prm[3]));
                else if(prm[0].equals("ActoOficial")) AgregarActoOficial(prm[1], prm[2], Integer.parseInt(prm[3]));
                else if(prm[0].equals("ActoNoOficial")) AgregarActoNoOficial(prm[1], prm[2], Integer.parseInt(prm[3]));
                else throw new Exception(E1+prm[0]);
            }
            r = cp.leer(max_lineas_cargar);
        }
        cp.cerrarFichero();
    }

}