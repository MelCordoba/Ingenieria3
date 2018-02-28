package SIMUTE.controller;

import com.linuxense.javadbf.DBFException;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author jefferson
 * @author Mariana
 * @author Melany
 * @author Lisseth
 * 
 */
public class LeerArchivo {
    
    public static void lectura(String ps_direccionFichero) throws SQLException, ParserConfigurationException, SAXException, IOException, DBFException,
            NumberFormatException, Exception
    {
        if (ps_direccionFichero.contains(".dbf"))
            ParserDBF.parse(ps_direccionFichero);
        if (ps_direccionFichero.contains(".csv"))
            ParserCSV.parse(ps_direccionFichero);
        if (ps_direccionFichero.contains(".txt"))
            ParserTXT.parse(ps_direccionFichero);
        if (ps_direccionFichero.contains(".ods"))
            ParserODS.parse(ps_direccionFichero);
        if (ps_direccionFichero.contains(".xml")) 
            ParserXML.parse(ps_direccionFichero);
        if (ps_direccionFichero.contains(".xls")) 
            ParserXLS.parse(ps_direccionFichero);
    }
}   