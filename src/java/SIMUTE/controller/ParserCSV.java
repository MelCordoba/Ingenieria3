package SIMUTE.controller;

import SIMUTE.model.Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author jefferson
 * @author Mariana
 * @author Melany
 * @author Lisseth
 * 
 */
public class ParserCSV 
{    
    static void parse(String ps_direccionFichero) throws IOException, SQLException
    {
        BufferedReader lo_bufferLectura = null;
        lo_bufferLectura = new BufferedReader(new FileReader(ps_direccionFichero));
        String ls_linea = lo_bufferLectura.readLine();
        String ls_numero = "";
        int li_provincia = 0;
        int li_canton = 0;
        int li_distrito = 0;
        int li_zona = 0;
        int li_region = 0;
        while (ls_linea != null) {
            String[] campos = ls_linea.split(",");
            ls_numero = campos[0];
            li_provincia = Integer.parseInt(campos[1]);
            li_canton = Integer.parseInt(campos[2]);
            li_distrito = Integer.parseInt(campos[3]);
            Model.agregaNumeros(ls_numero, li_provincia, li_canton, li_distrito, li_zona, li_region);
            ls_linea = lo_bufferLectura.readLine();
        }
        lo_bufferLectura.close();
    }
}
