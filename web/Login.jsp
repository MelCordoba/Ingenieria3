<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="Imports.jspf"%>
        <script type="text/javascript" src="js/LoginScript.js"></script>
        <title>Iniciar sesión</title>
    </head>
    <body>
        <%@ include file="Header.jspf" %>
        <%@ include file="SubHeader.jspf"%>
        <div class="container" >
            <div class="row">
                <div class="col-md-offset-3 col-md-9">
                    <div class="modal-dialog" style="margin:0;">
                        <div class="modal-content">
                            <div class="modal-header"align="center" >
                                <img class="img-circle" id="img_logo" src="img/user.png" style="height: 60px; width: 60px;">
                            </div>
                            <div id="div-forms">
                                <form id="login-form">
                                    <div class="modal-body" align="center">
                                        <div id="div-login-msg">
                                            <div id="icon-login-msg" ></div>
                                            <span id="text-login-msg">Acceder al sistema</span>
                                        </div>
                                        <br>
                                        <input id="t_username" class="form-control" type="text" placeholder="Usuario " required style="width: 85%;">
                                        <div class="form-group has-feedback">
                                            <input id="t_password" class="form-control" type="password" placeholder="Contraseña" required style="width: 85%;">
                                            <span id="a_muestraPass" class="glyphicon glyphicon-eye-open form-control-feedback col-md-offset-3"></span>
                                        </div>
                                        <div class="checkbox">
                                            <label><input type="checkbox">Recordar nombre de usuario</label>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <div>
                                            <input name="enviar" id="b_enviar" type="button" value="Iniciar Sesión" class="btn btn-primary">
                                        </div>
                                        <div>
                                            <br>
                                            <button id="b_lostPass" type="button" class="btn btn-link">¿Olvidó su nombre de usuario o contraseña? </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-backdrop fade" id="d_modalBack" style="display: none;" aria-hidden="true"></div>
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
        <%@ include file="Footer.jspf" %>
    </body>
</html>
