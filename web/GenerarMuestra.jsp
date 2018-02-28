<%@page import="SIMUTE.model.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
  
<%
   Date lo_fecha = new Date();
   SimpleDateFormat lo_format = new SimpleDateFormat ("dd/MM/yyyy");
   String ls_fechaActual = lo_format.format(lo_fecha);
   String nombreArchivo = Model.nombreDeArchivoCargado;
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="Imports.jspf"%>
        <title>Generar Muestra</title>
    </head>
    <body>
        <%@ include file="Header.jspf" %>
        <%@ include file="SubHeader.jspf"%>
        <div class="container" >
            <div class="row">
                <div class="col-md-12">
                    <section allign="center">  
                        <%if (nombreArchivo == ""){%>
                        <h2 class="entry-title" align="center"><span class="blue">Generar Muestra Sobre: <span style="color:red;">Ningún archivo ha sido cargado.</span></span> </h2>
                        <%}else{%>
                            <h2 class="entry-title" align="center"><span class="blue">Generar Muestra Sobre: <%=nombreArchivo%>.</span> </h2>
                        <%}%>
                        <hr>
                        <form class="form-horizontal" method="post" enctype="multipart/form-data" >        
                            <div class="form-group">
                                <label class="control-label col-sm-3">Nombre<span class="text-danger">*</span></label>
                                <div class="col-md-4 col-sm-6">
                                    <input type="text" class="form-control" name="i_nombre" id="t_nombre" placeholder="Digite el nombre de la muestra" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-3">Tamaño de la muestra<span class="text-danger">*</span></label>
                                <div class="col-md-4 col-sm-6">
                                    <input type="text" class="form-control" name="i_tamanio" id="t_tamanio" placeholder="Digite el tamaño de la muestra" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-3">Fecha de Inicio<span class="text-danger">*</span></label>
                                <div class="col-md-4 col-sm-6">
                                    <input class="form-control" name="nacionalidad" readonly="" id="t_inicio" value="<%=ls_fechaActual%>">
                                </div>
                            </div>
  
                            <div class="form-group">
                                <label class="control-label col-sm-3">Fecha de cierre<span class="text-danger">*</span></label>
                                <div class="col-md-4 col-sm-6">
                                    <input type="text" class="form-control" name="t_cierre" id="t_cierre" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-offset-3 col-xs-10">
                                    <input name="Submit" type="submit" value="Generar" class="btn btn-primary  black-background white">
                                </div>
                            </div>
                        </form>
                    </section>
                </div>
            </div>
        </div>
        <%@ include file="Footer.jspf" %>
    </body>  
    <script>
        function Model() {
            this.Model();
        }
        Model.prototype={
            Model: function(){}
        };
    </script>
    <script>
        function Controller(model,view) {
            this.Controller(model,view);
        }
        Controller.prototype={
            Controller: function(model,view){
                this.model=model;			
                this.view=view;
            }
        };
    </script>
    <script>
        var model;
        var controller;
        function pageLoad(event){
            model=new Model();
            var view = window;
            controller = new Controller(model,view);
        }
    </script>
</html>
