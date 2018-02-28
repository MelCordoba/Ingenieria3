function Usuario(ps_id, ps_password, pi_rol, ps_nombre, ps_apellido1, ps_apellido2, ps_correo, ps_numeroCelular)
{
    this.Usuario(ps_id, ps_password, pi_rol, ps_nombre, ps_apellido1, ps_apellido2, ps_correo, ps_numeroCelular);
}

Usuario.prototype=
{
    Usuario: function(ps_id, ps_password, pi_rol, ps_nombre, ps_apellido1, ps_apellido2, ps_correo, ps_numeroCelular)
    {
	this.as_nombre = ps_nombre;
        this.as_apellido1 = ps_apellido1;
        this.as_apellido2 = ps_apellido2;
        this.as_correo = ps_correo;
        this.as_clave = ps_password;
        this.as_cedula = ps_id;
        this.as_numeroCelular = ps_numeroCelular;
        this.ai_rol = pi_rol;
    }
};


