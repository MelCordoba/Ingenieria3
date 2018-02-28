var JsonUtils = JsonUtils || {};

JsonUtils.revive = function(k,v){
    if(v instanceof Object && v._class == 'NumeroTelefonico'){
        return new NumeroTelefonico(v.ai_numero, v.ai_provincia, v.ai_canton, v.ai_distrito, v.ai_zona, v.ai_region);
    }
    if(v instanceof Object && v._class == 'Usuario'){
        return new Usuario(v.as_cedula, v.as_clave, v.ai_rol, v.as_nombre, v.as_apellido1, v.as_apellido2, v.as_correo, v.as_numeroCelular);
    }
    return v;
};
JsonUtils.replacer = function(k,v){
    if(v instanceof NumeroTelefonico){
        v._class="NumeroTelefonico";
    }
    if(v instanceof Usuario){
        v._class="Usuario";
    }
    return v;
};
