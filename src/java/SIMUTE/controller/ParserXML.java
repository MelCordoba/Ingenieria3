package SIMUTE.controller;

import SIMUTE.model.Model;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilderFactory;
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
public class ParserXML 
{
    public static void parse(String ps_direccionFichero) throws SQLException, ParserConfigurationException, SAXException, IOException
    {
        File lo_archivo = new File(ps_direccionFichero);
        org.w3c.dom.Document lo_document = null;
        DocumentBuilderFactory lo_docBuilder = DocumentBuilderFactory.newInstance();
        lo_docBuilder.setIgnoringElementContentWhitespace(true);
        lo_document = lo_docBuilder.newDocumentBuilder().parse(lo_archivo);
        org.w3c.dom.Element lx_raiz = lo_document.getDocumentElement();
        org.w3c.dom.Node lo_index = lx_raiz.getFirstChild();
        String ls_numero = "";
        int li_provincia = 0;
        int li_canton = 0;
        int li_distrito = 0;
        int li_zona = 0;
        int li_region = 0;
        while (lo_index != null) {
            if (lo_index.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                org.w3c.dom.Node lo_datos = lo_index.getFirstChild();
                while (lo_datos != null) {
                    if (lo_datos.getNodeName().equals("numero")) 
                        ls_numero = lo_datos.getFirstChild().getNodeValue();
                    if (lo_datos.getNodeName().equals("provincia"))
                        li_provincia = Integer.parseInt(lo_datos.getFirstChild().getNodeValue());
                    if (lo_datos.getNodeName().equals("canton")) 
                        li_canton = Integer.parseInt(lo_datos.getFirstChild().getNodeValue());
                    if (lo_datos.getNodeName().equals("distrito"))
                        li_distrito = Integer.parseInt(lo_datos.getFirstChild().getNodeValue());
                    if (lo_datos.getNodeName().equals("zona")) 
                        li_zona = Integer.parseInt(lo_datos.getFirstChild().getNodeValue());
                    lo_datos = lo_datos.getNextSibling();
                }
                Model.agregaNumeros(ls_numero, li_provincia, li_canton, li_distrito, li_zona, li_region);
            }
            lo_index = lo_index.getNextSibling();
        }
    }
}
