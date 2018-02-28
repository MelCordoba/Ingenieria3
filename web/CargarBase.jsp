<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <%@ include file="Imports.jspf"%>
        <script type="text/javascript" src="js/CargarArchivoScript.js"></script>
        <title>Importar archivo</title>
    </head>
    <body>
        <%@ include file="Header.jspf" %>
        <%@ include file="SubHeader.jspf"%>
        <div class="container" >
            <div class="row">
                <div class="col-md-12">
                    <section allign="center">      
                        <h2 class="entry-title" align="center"><span class="blue">Cargar archivo a la base de datos</span> </h2>
                        <hr>
                        <form class="col-md-offset-3" method="POST" id="f_archivo" enctype="multipart/form-data" name="f_archivo">  
                            <div class="col-xs-12 col-md-6">
                            <div class="form-group">
                                <label class="control-label col-sm-3">Seleccione el archivo</label>
                                <div class="col-xs-12 col-md-9">
                                    <div class="input-group">
                                        <label class="input-group-btn">
                                            <span class="btn btn-primary">
                                                <i class="glyphicon glyphicon-file"></i> Buscar...
                                                <input type="file" name="f_fileSelector" id="f_fileSelector">
                                            </span>
                                        </label>
                                        <input class="form-control" readonly="" type="text">
                                    </div>
                                </div>
                            </div>
                            </div>
                            <div class="col-xs-12 col-md-3">
                            <div class="form-group">
                                <input name="enviar" id="b_enviar" type="button" value="Enviar" class="btn btn-primary">
                            </div>
                            </div>
                        </form>
                    </section>
                </div>
            </div>
        </div>
        <div class="modal fade" id="error-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="display: none;" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container subheader">
                        <div class="modal-header"align="center" >
                            <h3>Ups...</h3>
                        </div>
                        <div class="modal-body" align="center">
                            <table>
                                <tr>
                                    <td><img class="img-circle" style="width:40px; height:40px;" src="img/Error.png"></td>
                                    <td><h4 id="h_errorMsj"></h4></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer" allign="center">
                            <button allign="center" id="b_entendido" type="button" class="btn btn-primary">Entendido</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-backdrop fade" id="d_modalBack" style="display: none;" aria-hidden="true"></div>
        <div class="modal fade" id="correcto-modal" tabindex="-1" role="dialog" style="display: none;" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container" style="width:90%">
                        <div class="modal-header"align="center" >
                            <h3>Aviso</h3>
                        </div>
                        <div class="modal-body" align="center">
                            <table>
                                <tr>
                                    <td><img class="img-circle info_logo" style="width:40px; height:40px;" src="img/correcto.png"></td>
                                    <td><h4 id="h_correctoMsj"></h4></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer" allign="center">
                            <a href="index.jsp" class="btn btn-primary" role="button">Continuar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="info-modal" tabindex="-1" role="dialog" style="display: none;" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container subheader">
                        <div class="modal-header"align="center" >
                            <h3>Aviso</h3>
                        </div>
                        <div class="modal-body" align="center">
                            <table>
                                <tr>
                                    <td><img class="img-circle info_logo" style="width:40px; height:40px;" src="img/info.gif"></td>
                                    <td><h4 id="h_informacion"></h4></td>
                                    <td><img class="img-rounded info_logo" style="width:40px; height:40px;" src="img/cargando.gif"></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer" allign="center">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="info-modal1" tabindex="-1" role="dialog" style="display: none;" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container subheader">
                        <div class="modal-header"align="center" >
                            <h3>Aviso</h3>
                        </div>
                        <div class="modal-body" align="center">
                            <table>
                                <tr>
                                    <td><img class="img-circle info_logo" style="width:40px; height:40px;" src="img/info.gif"></td>
                                    <td><h4 id="h_informacion1"></h4></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer" allign="center">
                            <div class="col-xs-6 col-md-6 col-lg-6">
                                <button allign="center" id="b_si" type="button" class="btn btn-primary">Sí</button>
                            </div>
                            <div class="col-xs-6 col-md-6 col-lg-6">
                                <button allign="center" id="b_no" type="button" class="btn btn-primary">No</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="info-modal2" tabindex="-1" role="dialog" style="display: none;" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="container subheader">
                        <div class="modal-header"align="center" >
                            <h3>Aviso</h3>
                        </div>
                        <div class="modal-body" align="center">
                            <table>
                                <tr>
                                    <td><img class="img-circle info_logo" style="width:40px; height:40px;" src="img/info.gif"></td>
                                    <td><h4 id="h_informacion2"></h4></td>
                                </tr>
                            </table>
                        </div>
                        <div class="modal-footer" allign="center">
                            <div class="col-xs-6 col-md-6 col-lg-6">
                                <button allign="center" id="b_si1" type="button" class="btn btn-primary">Sí</button>
                            </div>
                            <div class="col-xs-6 col-md-6 col-lg-6">
                                <button allign="center" id="b_no1" type="button" class="btn btn-primary">No</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="Footer.jspf" %>
    </body>  
</html>