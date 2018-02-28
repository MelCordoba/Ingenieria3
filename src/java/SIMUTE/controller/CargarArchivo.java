package SIMUTE.controller;

import SIMUTE.model.Model;
import com.linuxense.javadbf.DBFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.xml.sax.SAXException;

/**
 *
 * @author jefferson
 * @author Mariana
 * @author Melany
 * @author Lisseth
 *
 */
@WebServlet(name = "CargarArchivo", urlPatterns = {"/CargarArchivo"})
@MultipartConfig
public class CargarArchivo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/xml");
            FileItemFactory lo_factory = new DiskFileItemFactory();
            ServletFileUpload lo_upload = new ServletFileUpload(lo_factory);
            List ls_items = lo_upload.parseRequest(request);
            Iterator lo_iter = ls_items.iterator();
            File lo_archivoNuevo = null;
            FileItem lo_item = null;
            InputStream lo_inputStream = null;
            FileOutputStream lo_outputStream = null;
            String ls_fileName = "";
            int li_dato = 0;
            int li_contador = 0;
            String ls_action = request.getParameter("action");
            switch (ls_action) {
                case "baseVacia":
                    if (Model.getPoblacion().size() > 0)
                        out.write("0");
                    else
                        out.write("1");
                    break;
                case "cargarArchivo":
                    Model.limpiaPoblacion();
                    lo_item = (FileItem) lo_iter.next();
                    ls_fileName = lo_item.getName();
                    lo_inputStream = lo_item.getInputStream();
                    lo_archivoNuevo = new File("..\\" + ls_fileName);
                    lo_outputStream = new FileOutputStream(lo_archivoNuevo);
                    li_dato = lo_inputStream.read();
                    while (li_dato != -1) {
                        li_contador++;
                        lo_outputStream.write(li_dato);
                        li_dato = lo_inputStream.read();
                    }
                    lo_outputStream.close();
                    lo_inputStream.close();
                    if (li_contador > 0) {
                        LeerArchivo.lectura(lo_archivoNuevo.getPath());
                        Model.nombreDeArchivoCargado = ls_fileName;
                        lo_archivoNuevo.delete();
                        out.write("1");
                    } else {
                        lo_archivoNuevo.delete();
                        out.write("-1");
                    }
                    break;
            }
        } catch (FileUploadException ex) {
        } catch (SQLException | ParserConfigurationException | SAXException | FileNotFoundException | DBFException | NumberFormatException ex) {
        } catch (Exception e) {
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
