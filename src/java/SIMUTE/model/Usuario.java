package SIMUTE.model;

/**
 *
 * @author jeff
 */
public class Usuario implements Jsonable
{
    String as_cedula;
    String as_nombre;
    String as_apellido1;
    String as_apellido2;
    String as_correo;
    String as_clave;
    String as_numeroCelular;
    int ai_rol;

    public Usuario()
    {
        this.as_nombre = "";
        this.as_apellido1 = "";
        this.as_apellido2 = "";
        this.as_correo = "";
        this.as_clave = "";
        this.as_cedula = "";
        this.as_numeroCelular = "";
        this.ai_rol = 0;
    }

    public Usuario(String as_cedula, String as_clave, int ai_rol) {
        this.as_cedula = as_cedula;
        this.as_clave = as_clave;
        this.ai_rol = ai_rol;
    }
   
    public Usuario(String ps_nombre, String ps_apellido1, String ps_apellido2, String ps_correo, String ps_clave, String ps_cedula, String ps_celular, int pi_rol) 
    {
        this.as_nombre = ps_nombre;
        this.as_apellido1 = ps_apellido1;
        this.as_apellido2 = ps_apellido2;
        this.as_correo = ps_correo;
        this.as_clave = ps_clave;
        this.as_cedula = ps_cedula;
        this.as_numeroCelular = ps_celular;
        this.ai_rol = pi_rol;
    }
    public String getNombre()
    {
        return as_nombre;
    }
    public void setNombre(String ps_nombre)
    {
        this.as_nombre = ps_nombre;
    }
    public void setApellido1(String ps_apellido1)
    {
        this.as_apellido1 = ps_apellido1;
    }
    public void setApellido2(String ps_apellido2)
    {
        this.as_apellido2 = ps_apellido2;
    }
    public void setCorreo(String ps_correo) 
    {
        this.as_correo = ps_correo;
    }
    public void setClave(String ps_clave)
    {
        this.as_clave = ps_clave;
    }
    public void setCedula(String ps_cedula)
    {
        this.as_cedula = ps_cedula;
    }
    public void setNumeroCelular(String ps_numeroCelular)
    {
        this.as_numeroCelular = ps_numeroCelular;
    }
    public void setRol(int pi_rol)
    {
        this.ai_rol = pi_rol;
    }
    public String getApellido1()
    {
        return as_apellido1;
    }
    public String getApellido2() 
    {
        return as_apellido2;
    }
    public String getCorreo()
    {
        return as_correo;
    }
    public String getClave() 
    {
        return as_clave;
    }
    public String getCedula()
    {
        return as_cedula;
    }
    public String getNumeroCelular() 
    {
        return as_numeroCelular;
    }
    public int getRol()
    {
        return ai_rol;
    }
}
