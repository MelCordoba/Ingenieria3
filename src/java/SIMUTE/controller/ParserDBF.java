package SIMUTE.controller;

import SIMUTE.model.Model;
import com.linuxense.javadbf.DBFReader;
import java.io.FileInputStream;
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
public class ParserDBF
{
    public static void parse(String ps_direccionFichero) throws IOException, SQLException{
        FileInputStream lo_fileInput;
        lo_fileInput = new FileInputStream(ps_direccionFichero);
        DBFReader lo_reader = new DBFReader(lo_fileInput);
        Object[] ls_rowObjects;
        String ls_numero = "";
        String ls_auxiliar = "";
        String ls_auxiliar2 = "";
        double ld_provincia = 0;
        double ld_canton = 0;
        double ld_distrito = 0;
        double ld_zona = 0;
        double ld_region = 0;
        while ((ls_rowObjects = lo_reader.nextRecord()) != null) {
            for (int i = 0; i < ls_rowObjects.length; i = i + 4) {
                ls_numero = ls_rowObjects[i].toString();
                ls_auxiliar = ls_numero.substring(2, 9);
                ls_auxiliar2 = ls_numero.substring(0, 1);
                ls_numero = ls_auxiliar2.concat(ls_auxiliar);
                ld_provincia = Double.parseDouble(ls_rowObjects[i + 1].toString());
                ld_canton = Double.parseDouble(ls_rowObjects[i + 2].toString());
                ld_distrito = Double.parseDouble(ls_rowObjects[i + 3].toString());
                Model.agregaNumeros(ls_numero, (int) ld_provincia, (int) ld_canton, (int) ld_distrito, (int) ld_zona, (int)ld_region);
            }
        }
        lo_fileInput.close();
    }
}
