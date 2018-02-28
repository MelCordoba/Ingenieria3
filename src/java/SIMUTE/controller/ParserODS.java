package SIMUTE.controller;

import SIMUTE.model.Model;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

/**
 *
 * @author jeff
 * @author Mariana
 * @author Lisseth
 * @author Melany
 */
public class ParserODS {
    
    public static void parse(String ps_direccionFichero) throws IOException, SQLException
    {
        Sheet lo_sheet;
        File lo_file = new File(ps_direccionFichero);
        lo_sheet = SpreadSheet.createFromFile(lo_file).getSheet(0);
        int li_nColCount = 5;
        int li_nRowCount = lo_sheet.getRowCount();
        MutableCell lo_cell = null;
        int li_nColIndex = 0;
        String ls_numero = "";
        int li_provincia = 0;
        int li_distrito = 0;
        int li_canton = 0;
        int li_zona = 0;
        int li_region = 0;
        for (int li_nRowIndex = 0; li_nRowIndex < li_nRowCount; li_nRowIndex++) {
            lo_cell = lo_sheet.getCellAt(li_nColIndex, li_nRowIndex);
            if (String.valueOf(lo_cell.getValue()) != "")
            {
                li_nColIndex = li_nColIndex + 1;
                ls_numero = String.valueOf(lo_cell.getValue());
            }
            else
                break;
            lo_cell = lo_sheet.getCellAt(li_nColIndex, li_nRowIndex);
            if (String.valueOf(lo_cell.getValue()) != "")
            {
                li_nColIndex = li_nColIndex + 1;
                li_provincia = Integer.valueOf(String.valueOf(lo_cell.getValue()));
            }
            else
                break;
            lo_cell = lo_sheet.getCellAt(li_nColIndex, li_nRowIndex);
            if (String.valueOf(lo_cell.getValue()) != "")
            {
                li_nColIndex = li_nColIndex + 1;
                li_canton = Integer.valueOf(String.valueOf(lo_cell.getValue()));
            }
            else
                break;
            lo_cell = lo_sheet.getCellAt(li_nColIndex, li_nRowIndex);
            if (String.valueOf(lo_cell.getValue()) != "")
            {
                li_nColIndex = li_nColIndex + 1;
                li_distrito = Integer.valueOf(String.valueOf(lo_cell.getValue()));
                
            }else
                break;
            lo_cell = lo_sheet.getCellAt(li_nColIndex, li_nRowIndex);
            if (String.valueOf(lo_cell.getValue()) != "")
            {
                li_zona = Integer.valueOf(String.valueOf(lo_cell.getValue()));
                Model.agregaNumeros(ls_numero, li_provincia, li_canton, li_distrito, li_zona, li_region);
            }
            li_nColIndex = 0;
        }
    }
}
