package modelos.util;

import modelos.bo.Alumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class AlumnosAleatorios {

    private ArrayList<String> nombresMasculinos;
    private ArrayList<String> nombresFemeninos;
    private ArrayList<String> apellidos;

    private Random r = new Random();

    public AlumnosAleatorios() throws IOException {
        cargaArchivos();
    }

    private void cargaArchivos() throws FileNotFoundException, IOException {
        Archivo archivo = new Archivo();
//        nombresMasculinos = archivo.leeArchivo(new InputStreamReader(getClass().getResourceAsStream("/recursos/nombresMasculinos.txt")));
//        nombresFemeninos = archivo.leeArchivo(new InputStreamReader(getClass().getResourceAsStream("/recursos/nombresFemeninos.txt")));
//        apellidos = archivo.leeArchivo(new InputStreamReader(getClass().getResourceAsStream("/recursos/apellidos.txt")));
        nombresMasculinos = archivo.leeArchivo("/recursos/nombresMasculinos.txt");
        nombresFemeninos = archivo.leeArchivo("/recursos/nombresFemeninos.txt");
        apellidos = archivo.leeArchivo("/recursos/apellidos.txt");
    }

    public Alumno nextAlumno() {
        int sexo = r.nextInt(2);
        String nombre = (sexo == 0
                ? nombresMasculinos.get(r.nextInt(nombresMasculinos.size()))
                : nombresFemeninos.get(r.nextInt(nombresFemeninos.size()))).trim();
        String apPaterno = apellidos.get(r.nextInt(apellidos.size())).trim();
        String apMaterno = apellidos.get(r.nextInt(apellidos.size())).trim();
        return new Alumno(nombre, apPaterno, apMaterno, (sexo == 0) ? "M" : "F", 18 + r.nextInt(10));
    }

    public ArrayList<Alumno> listaAlumnos(int n) {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listaAlumnos.add(nextAlumno());
        }
        return listaAlumnos;
    }
}
