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
public class ParserTXT 
{
    public static void parse(String ps_direccionFichero) throws SQLException, IOException
    {
        String ls_texto = "";
        FileReader lo_lector = new FileReader(ps_direccionFichero);
        BufferedReader lo_contenido = new BufferedReader(lo_lector);
        int li_provincia = 0;
        int li_canton = 0;
        int li_distrito = 0;
        int li_zona = 0;
        int li_region = 0;
        while ((ls_texto = lo_contenido.readLine()) != null) {
            li_provincia = Integer.parseInt(ls_texto.substring(9, 10));
            li_canton = Integer.parseInt(ls_texto.substring(11, 12));
            li_distrito = Integer.parseInt(ls_texto.substring(13, 14));
            Model.agregaNumeros(ls_texto.substring(0, 8), li_provincia, li_canton, li_distrito, li_zona, li_region);
        }
    }
}
