package modelos.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Archivo {

    public ArrayList<String> leeArchivo(String url) throws FileNotFoundException, IOException {
        ArrayList<String> archivo = new ArrayList<>();
        BufferedReader lector = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(url)));
        while (lector.ready()) {
            archivo.add(lector.readLine());
        }
        lector.close();
        return archivo;
    }
    
    public ArrayList<String> leeArchivo(InputStreamReader input) throws FileNotFoundException, IOException {
        ArrayList<String> archivo = new ArrayList<>();
        BufferedReader lector = new BufferedReader(input);
        while (lector.ready()) {
            archivo.add(lector.readLine());
        }
        lector.close();
        return archivo;
    }
}
