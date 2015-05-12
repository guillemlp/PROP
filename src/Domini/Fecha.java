package Domini;

import java.util.regex.PatternSyntaxException;

/**
 * Created by usuario on 11/04/2015.
 */
public class Fecha {
    private int[] fecha;

    private static boolean Correcto(int dia, int mes, int any) throws NoValido{
        if (dia < 1 || dia > 31) throw new NoValido("Fecha", 1);
        if (mes <= 0 || mes >= 13) throw new NoValido("Fecha", 2);
        if (any < 1) throw new NoValido("Fecha", 3);
        if (mes == 2) {
            if ((dia == 30 || dia == 31)) throw new NoValido("Fecha", 4);
            if (dia == 29 && ((any % 4 != 0 || any % 100 == 0) && any % 400 != 0)) throw new NoValido("Fecha", 5);
        }
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia == 31 ) throw new NoValido("Fecha", 6);
        return true;
    }

    public static boolean valido(String data) throws NoValido {
        if (data.equals("")) return false;
        String[] aux = data.split("/");
        int dia = Integer.parseInt(aux[0]);
        int mes = Integer.parseInt(aux[1]);
        int any = Integer.parseInt(aux[2]);
        return aux.length == 3 && Correcto(dia, mes, any);
    }

    public Fecha(String data) throws NoValido {
        if (data.equals("")) throw new NoValido("Fecha", 7);
        String[] aux = data.split("/");
        if (aux.length != 3) throw new NoValido("Fecha", 8);
        int dia = Integer.parseInt(aux[0]);
        int mes = Integer.parseInt(aux[1]);
        int año = Integer.parseInt(aux[2]);
        Correcto(dia, mes, año);
        fecha = new int[3];
        fecha[0] = dia;
        fecha[1] = mes;
        fecha[2] = año;
    }

    //Consultora
    public String ConsultarFecha() {
        return fecha[0] + "/" + fecha[1] + "/" + fecha[2];
    }

    public String ToString() {return Integer.toString(fecha[0]) + Integer.toString(fecha[1]) + Integer.toString(fecha[2]);}

    public boolean equals(Fecha f) {
        return fecha[0] == f.fecha[0] && fecha[1] == f.fecha[1] && fecha[2] == f.fecha[2];
    }
}
