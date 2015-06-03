package Domini;


import Persistencia.ControladorPersistencia;

import java.util.ArrayList;
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

    public int size(){
        return ce.size();
    }

    public void AgregarVotacion(String nombre, String fecha, int importancia) throws Exception{
        Fecha f = new Fecha(fecha);
        Votacion v = new Votacion(nombre, f, importancia);
        ce.AgregarEvento(v);
    }

    public void AgregarReunionPersonal(String nombre, String fecha, int importancia) throws Exception{
        Fecha f = new Fecha(fecha);
        Personal per = new Personal(nombre, f, importancia);
        ce.AgregarEvento(per);
    }

    public void AgregarReunionProfesional(String nombre, String fecha, int importancia) throws Exception{
        Fecha f = new Fecha(fecha);
        Profesional pro = new Profesional(nombre, f, importancia);
        ce.AgregarEvento(pro);
    }

    public void AgregarActoOficial(String nombre, String fecha, int importancia) throws Exception{
        Fecha f = new Fecha(fecha);
        Oficial o = new Oficial(nombre, f, importancia);
        ce.AgregarEvento(o);
    }

    public void AgregarActoNoOficial(String nombre, String fecha, int importancia) throws Exception{
        Fecha f = new Fecha(fecha);
        NoOficial n = new NoOficial(nombre, f, importancia);
        ce.AgregarEvento(n);
    }

    public void AgregarEventoRandom(int n) throws Exception {
        ce.AgregarEventoRandom(n);
    }

    public List<Evento> ConsultarTodosEventos() {
        return ce.ConsultarTodosEventos();
    }

    public boolean ExisteEvento(String nombre, String fecha) throws Exception {
        return ce.ExisteEvento(nombre, new Fecha(fecha));
    }

    public void EliminarEvento(String nombre, String fecha, ControladorRelaciones cr) throws Exception{
        if(cr.tieneRelaciones(nombre, fecha)) cr.eliminarRelaciones(nombre, fecha);
        ce.EliminarEvento(nombre, new Fecha(fecha));
    }

    /*
    public void EliminarEvento(String nombre, String fecha, int imp, ControladorRelaciones cr) throws Exception{
        if(cr.tieneRelaciones(nombre, fecha)) cr.eliminarRelaciones(nombre, fecha);
        ce.EliminarEvento(nombre, new Fecha(fecha), imp);
    }*/

    public void EliminarCjtEvento(ControladorRelaciones cr) {
        ce.EliminarCjtEvento();
        cr.eliminarRelaciones();
    }

    public void ModificarNombreEvento(String nomViejo, String fecha, String nomNuevo, ControladorRelaciones cr) throws Exception{
        if(cr.tieneRelaciones(nomViejo, fecha)) {
            //System.out.println("LLego hasta el controlador");
            String id = ConsultarEvento(nomViejo,fecha).ID();
            ce.ModificarNombreEvento(nomViejo, new Fecha(fecha), nomNuevo);
            String new_id = ConsultarEvento(nomNuevo, fecha).ID();
            cr.modEvento(id,new_id);
        }
        else ce.ModificarNombreEvento(nomViejo, new Fecha(fecha), nomNuevo);
    }

    /*
    public void ModificarNombreEvento(String nomViejo, String fecha, String nomNuevo, ControladorRelaciones cr) throws Exception{
        if(cr.tieneRelaciones(nomViejo, fecha)) {
            //System.out.println("LLego hasta el controlador");
            String id = ConsultarEvento(nomViejo,fecha).ID();
            ce.ModificarNombreEvento(nomViejo, new Fecha(fecha), int imp, nomNuevo);
            String new_id = ConsultarEvento(nomNuevo, fecha).ID();
            cr.modEvento(id,new_id);
        }
        else ce.ModificarNombreEvento(nomViejo, new Fecha(fecha),int imp, nomNuevo);
    }*/

    public void ModificarFechaEvento(String nombre, String fechaVieja, String fechaNueva, ControladorRelaciones cr) throws Exception {
        if(cr.tieneRelaciones(nombre, fechaVieja)){
            String id = ConsultarEvento(nombre,fechaVieja).ID();
            ce.ModificarFechaEvento(nombre, new Fecha(fechaVieja), new Fecha(fechaNueva));
            String new_id = ConsultarEvento(nombre,fechaNueva).ID();
            cr.modEvento(id, new_id);
        }
        else ce.ModificarFechaEvento(nombre, new Fecha(fechaVieja), new Fecha(fechaNueva));
    }

    /*
    public void ModificarFechaEvento(String nombre, String fechaVieja, String fechaNueva, ControladorRelaciones cr) throws Exception {
        if(cr.tieneRelaciones(nombre, fechaVieja)){
            String id = ConsultarEvento(nombre,fechaVieja).ID();
            ce.ModificarFechaEvento(nombre, new Fecha(fechaVieja), int imp, new Fecha(fechaNueva));
            String new_id = ConsultarEvento(nombre,fechaNueva).ID();
            cr.modEvento(id, new_id);
        }
        else ce.ModificarFechaEvento(nombre, new Fecha(fechaVieja), int imp, new Fecha(fechaNueva));
    }
    */

    public void ModificarImpEvento(String nombre, String fecha, int importance) throws Exception {
        ce.ModificarImpEvento(nombre, new Fecha(fecha), importance);
    }

    /*
    public void ModificarImpEvento(String nombre, String fecha, int imp, int imp_nueva) throws Exception {
        ce.ModificarImpEvento(nombre, new Fecha(fecha), imp, imp_nueva);
    }*/

    public Evento ConsultarEvento(String nombre, String fecha) throws Exception{
        return ce.ConsultarEvento(nombre, new Fecha(fecha));
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
                String[] prm = con.split(" ");
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

    public String obtEventosPR(){
        List<Evento> le = ce.ConsultarTodosEventos();
        String res = "";
        for(Evento e : le) res += e.tipo()+" "+e.obt_nombre()+" "+e.obt_fecha()+"\n";
        return res;
    }

    public String obtBloquePR(int bloque, int tam_bloque){
        List<Evento> ev = ce.obtEventos(bloque, tam_bloque);
        String res = "";
        for (Evento e: ev)
            res += e.tipo()+" "+e.obt_nombre()+" "+e.obt_fecha()+"\n";
        return res;
    }

    public String obtBloqueP(int bloque, int tamanio) {
        List<Evento> ev = ce.obtEventos(bloque, tamanio);
        String res = "";
        for (Evento e: ev)
            res += e.toString()+"\n";
        return res;
    }

    public List<String> ConsultarTodosEventosP() {
        List<Evento> aux = ce.ConsultarTodosEventos();
        List<String> resultado = new ArrayList<String>();
        for (Evento e : aux) resultado.add(e.toString());
        return resultado;
    }

}