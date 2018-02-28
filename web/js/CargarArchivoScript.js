////////////////////////////////////////////////////////////////////////////////
function Model() {
    this.Model();
}
Model.prototype={
    Model: function(){}
};
////////////////////////////////////////////////////////////////////////////////
function Controller(model,view) {
    this.Controller(model,view);
}
Controller.prototype={
    Controller: function(model,view){
        this.model=model;			
        this.view=view;
    },
    validaSeleccionArchivo: function(event){
        var error = "";
        var extension;
        var archivo = document.getElementById('f_fileSelector').value;
        var archivosPermitidos = [".dbf",".txt", ".xls", ".csv", ".xml", ".ods"];
        if(archivo == "")
            error = "No se ha seleccionado ningún archivo";
        else
        {
            extension = archivosPermitidos.find(function(e){return e == archivo.substring(archivo.lastIndexOf("."))});
            if(!extension)
                error = " Tipo de archivo no permitido. Sólo archivos: " + archivosPermitidos.join();
        }
        if (error != "")
            this.view.muestraMensajeError(error);
        else
            this.view.muestraMensajeInfo(document.getElementById('f_fileSelector').files[0].name);
    },
    verificaBase: function(event)
    {
        this.view.eliminaMensajeInfo();
        var control = this;
        var view = this.view;
        var xhr = new XMLHttpRequest();
        xhr.open("POST","/SIMUTE/CargarArchivo?action=baseVacia", true);
        var formData = new FormData();
        xhr.send(formData);
        xhr.onload = function(e)
        {
            if (this.status == 200) 
            {
                if (this.response == "1")
                    control.enviaArchivo();
                else
                    view.muestraMensajeInfoBaseLlena();
            }
        };
    },
    enviaArchivo: function(){
        this.view.eliminaMensajeInfoBaseLlena();
        var f_fileSelector = document.getElementById("f_fileSelector");
        var formData = new FormData();
        formData.append("f_fileSelector", f_fileSelector.files[0]);
        var xhr = new XMLHttpRequest();
        xhr.open("POST","/SIMUTE/CargarArchivo?action=cargarArchivo", true);
      	xhr.send(formData);
        var view = this.view;
      	xhr.onload = function(e) {
            if (this.status == 200) {
                if (this.response == "1")
                {
                    var msj = "Archivo " + f_fileSelector.files[0].name +" cargado con éxito";
                    view.muestraMensajeCorrecto(msj);
                } 
                else
                { 
                    var msj = "No se ha podido cargar el archivo "+f_fileSelector.files[0].name+". Revise el formato e intente de nuevo";
                    view.muestraMensajeError(msj);
                }
            }
        };
        var msj = "Enviando " + f_fileSelector.files[0].name+", espere un momento...";
        this.view.muestraMensajeCargando(msj);   
    }
};
////////////////////////////////////////////////////////////////////////////////
var model;
var controller;
function pageLoad(event){
    model=new Model();
    var view = window;
    controller = new Controller(model,view);
    var b_enviar = document.getElementById("b_enviar");
    b_enviar.addEventListener("click",controller.validaSeleccionArchivo.bind(controller));    
    var b_entendido = document.getElementById("b_entendido");
    b_entendido.addEventListener("click",eliminaError.bind(this));
    
    var b_si = document.getElementById("b_si");
    b_si.addEventListener("click",controller.verificaBase.bind(controller));
    var b_no = document.getElementById("b_no");
    b_no.addEventListener("click",eliminaMensajeInfo.bind(this));
    
    var b_si = document.getElementById("b_si1");
    b_si.addEventListener("click",controller.enviaArchivo.bind(controller));
    var b_no = document.getElementById("b_no1");
    b_no.addEventListener("click",eliminaMensajeInfoBaseLlena.bind(this));
}
function muestraMensajeError(error){
    eliminaMensajeCargando();
    var h3 = document.getElementById("h_errorMsj");
    var d_modalBack = document.getElementById("d_modalBack");
    var modal_div = document.getElementById("error-modal");
    h3.innerHTML = "";
    h3.appendChild(document.createTextNode(" "+error));
    d_modalBack.style.display = "block";
    d_modalBack.setAttribute("class","modal-backdrop fade in");
    modal_div.style.display = "block";
    modal_div.setAttribute("class","modal fade in");
}
function eliminaError(event){
    var h3 = document.getElementById("h_errorMsj");
    var modal_div = document.getElementById("error-modal");
    h3.innerHTML = "";
    modal_div.setAttribute("class","modal fade");
    var d_modalBack = document.getElementById("d_modalBack");
    d_modalBack.setAttribute("class","modal-backdrop fade");
    d_modalBack.style.display = "none";
    modal_div.style.display = "none";
}
function muestraMensajeCorrecto(msj){
    eliminaMensajeCargando();
    var h3 = document.getElementById("h_correctoMsj");
    var d_modalBack = document.getElementById("d_modalBack");
    var modal_div = document.getElementById("correcto-modal");
    h3.innerHTML = "";
    h3.appendChild(document.createTextNode(msj));
    d_modalBack.style.display = "block";
    d_modalBack.setAttribute("class","modal-backdrop fade in");
    modal_div.style.display = "block";
    modal_div.setAttribute("class","modal fade in");
}
function muestraMensajeCargando(msj){
    var h3 = document.getElementById("h_informacion");
    var d_modalBack = document.getElementById("d_modalBack");
    var modal_div = document.getElementById("info-modal");
    h3.innerHTML = "";
    h3.appendChild(document.createTextNode(" "+msj));
    d_modalBack.style.display = "block";
    d_modalBack.setAttribute("class","modal-backdrop fade in");
    modal_div.style.display = "block";
    modal_div.setAttribute("class","modal fade in");
}
function eliminaMensajeCargando(){
    var h3 = document.getElementById("h_informacion");
    var modal_div = document.getElementById("info-modal");
    h3.innerHTML = "";
    modal_div.setAttribute("class","modal fade");
    var d_modalBack = document.getElementById("d_modalBack");
    d_modalBack.setAttribute("class","modal-backdrop fade");
    d_modalBack.style.display = "none";
    modal_div.style.display = "none";
}
function muestraMensajeInfo(archivo){
    var msj = "Está seguro que desea enviar el archivo " + archivo +"?";
    var h3 = document.getElementById("h_informacion1");
    var d_modalBack = document.getElementById("d_modalBack");
    var modal_div = document.getElementById("info-modal1");
    h3.innerHTML = "";
    h3.appendChild(document.createTextNode(" "+msj));
    d_modalBack.style.display = "block";
    d_modalBack.setAttribute("class","modal-backdrop fade in");
    modal_div.style.display = "block";
    modal_div.setAttribute("class","modal fade in");
}
function eliminaMensajeInfo(){
    var h3 = document.getElementById("h_informacion1");
    var modal_div = document.getElementById("info-modal1");
    h3.innerHTML = "";
    modal_div.setAttribute("class","modal fade");
    var d_modalBack = document.getElementById("d_modalBack");
    d_modalBack.setAttribute("class","modal-backdrop fade");
    d_modalBack.style.display = "none";
    modal_div.style.display = "none";
}
function muestraMensajeInfoBaseLlena(){
    var msj = "Está a punto de cargar un nuevo archivo.\n\
    La información contenida en la base se respaldará.\n\Desea Continuar?";
    var h3 = document.getElementById("h_informacion2");
    var d_modalBack = document.getElementById("d_modalBack");
    var modal_div = document.getElementById("info-modal2");
    h3.innerHTML = "";
    h3.appendChild(document.createTextNode(" "+msj));
    d_modalBack.style.display = "block";
    d_modalBack.setAttribute("class","modal-backdrop fade in");
    modal_div.style.display = "block";
    modal_div.setAttribute("class","modal fade in");
}
function eliminaMensajeInfoBaseLlena(){
    var h3 = document.getElementById("h_informacion2");
    var modal_div = document.getElementById("info-modal2");
    h3.innerHTML = "";
    modal_div.setAttribute("class","modal fade");
    var d_modalBack = document.getElementById("d_modalBack");
    d_modalBack.setAttribute("class","modal-backdrop fade");
    d_modalBack.style.display = "none";
    modal_div.style.display = "none";
}
document.addEventListener("DOMContentLoaded", pageLoad);
$(function() {
    $(document).on('change', ':file', function() {
        var input = $(this),numFiles = input.get(0).files ? input.get(0).files.length : 1,
        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
        input.trigger('fileselect', [numFiles, label]);
    });
    $(document).ready( function() {
        $(':file').on('fileselect', function(event, numFiles, label) {
            var input = $(this).parents('.input-group').find(':text'),
            log = numFiles > 1 ? numFiles + ' files selected' : label;
            if( input.length ) {
                input.val(log);
            } else {
                if( log ) alert(log);
            }
        });
    });
});