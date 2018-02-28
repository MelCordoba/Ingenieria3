package SIMUTE.controller;

import SIMUTE.model.Model;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author jefferson
 * @author Mariana
 * @author Melany
 * @author Lisseth
 * 
 */
public class ParserXLS 
{
    public static void parse(String ps_direccionFichero) throws SQLException, IOException
    {
        List ls_sheetData = new ArrayList();
        FileInputStream lo_fileInputS = null;
        lo_fileInputS = new FileInputStream(ps_direccionFichero);
        HSSFWorkbook lo_workbook = new HSSFWorkbook(lo_fileInputS);
        HSSFSheet lo_sheet = lo_workbook.getSheetAt(0);
        Iterator ls_rows = lo_sheet.rowIterator();
        while (ls_rows.hasNext()) {
            HSSFRow lo_row = (HSSFRow) ls_rows.next();
            Iterator lo_cells = lo_row.cellIterator();
            List lr_data = new ArrayList();
            while (lo_cells.hasNext()) {
                HSSFCell lo_cell = (HSSFCell) lo_cells.next();
                lr_data.add(lo_cell);
            }
            ls_sheetData.add(lr_data);
        }
        lo_fileInputS.close();
        String ls_numero = "";
        String ls_auxiliar = "";
        String ls_auxiliar2 = "";
        int li_provincia = 0;
        int li_canton = 0;
        int li_distrito = 0;
        int li_zona = 0;
        int li_region = 0;
        Cell lo_cell = null;
        for (int li_index = 0; li_index < ls_sheetData.size(); li_index++) {
            List ls_list = (List) ls_sheetData.get(li_index);
            int li_auxiliar = 0;
            lo_cell = (Cell) ls_list.get(li_auxiliar);
            if (lo_cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                ls_numero = String.valueOf(lo_cell.getNumericCellValue());
                ls_auxiliar = ls_numero.substring(2, 9);
                ls_auxiliar2 = ls_numero.substring(0, 1);
                ls_numero = ls_auxiliar2.concat(ls_auxiliar);
            }
            lo_cell = (Cell) ls_list.get(li_auxiliar + 1);
            if (lo_cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                li_provincia = (int) lo_cell.getNumericCellValue();
            }
            lo_cell = (Cell) ls_list.get(li_auxiliar + 2);
            if (lo_cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                li_canton = (int) lo_cell.getNumericCellValue();
            }
            lo_cell = (Cell) ls_list.get(li_auxiliar + 3);
            if (lo_cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                li_distrito = (int) lo_cell.getNumericCellValue();
            }
            Model.agregaNumeros(ls_numero, li_provincia, li_canton, li_distrito, li_zona, li_region);
            li_auxiliar = li_auxiliar + 4;
        }
    }
}
