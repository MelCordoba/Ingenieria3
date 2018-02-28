
//Model
function Model()
{
    this.Model();
}
Model.prototype = {
    Model: function () {}
};
////////////////////////////////////////////////////////////////////////////////

//Controller
function Controller(model, view)
{
    this.Controller(model, view);
}
Controller.prototype = {
    Controller: function (model, view)
    {
        this.model = model;
        this.view = view;
    },
    iniciarSesion: function (event)
    {
        var view = this.view;
        var cedula = document.getElementById("t_username").value;
        var clave = document.getElementById("t_password").value;
        var usuario = new Usuario(cedula, clave, 0, "", "", "", "", "");
        Proxy.userLogin(usuario,
                function (usuario) {
                    if (usuario.ai_rol == 0)
                    {
                        var error = "Nombre de usuario o contraseña incorrectos";
                        view.muestraMensajeError(error);
                    } else
                        document.location = "/SIMUTE/index.jsp";
                });
    }
};
///////////////////////////////////////////////////////////////////////////////

//View
var model;
var controller;
function pageLoad(event)
{
    model = new Model();
    var view = window;
    controller = new Controller(model, view);
    var b_enviar = document.getElementById("b_enviar");
    b_enviar.addEventListener("click", controller.iniciarSesion.bind(controller));
    var a_muestraPass = document.getElementById("a_muestraPass");
    a_muestraPass.addEventListener("mousedown", muestraPassword.bind(this));
    a_muestraPass.addEventListener("mouseup", ocultaPassword.bind(this));
    var b_entendido = document.getElementById("b_entendido");
    b_entendido.addEventListener("click", eliminaError.bind(this));
}
function muestraPassword(event)
{
    var t_password = document.getElementById("t_password");
    t_password.setAttribute("type", "text");
}
function ocultaPassword(event)
{
    var t_password = document.getElementById("t_password");
    t_password.setAttribute("type", "password");
}
function eliminaError(event)
{
    var h3 = document.getElementById("h_errorMsj");
    var modal_div = document.getElementById("error-modal");
    h3.innerHTML = "";
    modal_div.setAttribute("class", "modal fade");
    var d_modalBack = document.getElementById("d_modalBack");
    d_modalBack.setAttribute("class", "modal-backdrop fade");
    d_modalBack.style.display = "none";
    modal_div.style.display = "none";
}
function muestraMensajeError(error)
{
    var h3 = document.getElementById("h_errorMsj");
    var d_modalBack = document.getElementById("d_modalBack");
    var modal_div = document.getElementById("error-modal");
    h3.innerHTML = "";
    h3.appendChild(document.createTextNode(" " + error));
    d_modalBack.style.display = "block";
    d_modalBack.setAttribute("class", "modal-backdrop fade in");
    modal_div.style.display = "block";
    modal_div.setAttribute("class", "modal fade in");
}
document.addEventListener("DOMContentLoaded", pageLoad);


