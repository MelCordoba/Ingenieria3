package SIMUTE.model;

/**
 *
 * @author jefferson
 * @author Mariana
 * @author Melany
 * @author Lisseth
 * 
 */
public class NumeroTelefonico implements Jsonable
{
    int ai_numero;
    int ai_provincia;
    int ai_canton;
    int ai_distrito;
    int ai_zona;
    int ai_region;
    
    public NumeroTelefonico()
    { 
        ai_numero = 0;
        ai_provincia = 0;
        ai_canton = 0;
        ai_distrito = 0;
        ai_zona = 0;
        ai_region = 0;
    }
    
    public NumeroTelefonico(int pi_numero, int pi_provincia, int pi_canton, int pi_distrito, int pi_zona, int pi_region)
    {
        ai_numero = pi_numero;
        ai_provincia = pi_provincia;
        ai_canton = pi_canton;
        ai_distrito = pi_distrito;
        ai_zona = pi_zona;
        ai_region = pi_region;
    }
    
    public int getNumero()
    {
        return ai_numero;
    }
    
    public int getProvincia()
    {
        return ai_provincia;
    }
    
    public int getCanton()
    {
        return ai_canton;
    }
    
    public int getDistrito()
    {
        return ai_distrito;
    }
    
    public int getZona()
    {
        return ai_zona;
    }
    
    public void setNumero(int pi_numero)
    {
        ai_numero = pi_numero;
    }
    
    public void setProvincia(int pi_provincia)
    {
        ai_provincia = pi_provincia;
    }
    
    public void setCanton(int pi_canton)
    {
        ai_canton = pi_canton;
    }
    
    public void setDistrito(int pi_distrito)
    {
        ai_distrito = pi_distrito;
    }
    
    public void setZona(int pi_zona)
    {
        ai_zona = pi_zona;
    }

    public int getRegion() {
        return ai_region;
    }

    public void setRegion(int pi_region) {
        this.ai_region = pi_region;
    }
    
}
