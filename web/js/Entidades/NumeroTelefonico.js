function NumeroTelefonico(pi_numero, pi_provincia, pi_canton, pi_distrito, pi_zona, pi_region)
{
    this.NumeroTelefonico(pi_numero, pi_provincia, pi_canton, pi_distrito, pi_zona, pi_region);
}

NumeroTelefonico.prototype=
{
    NumeroTelefonico: function(pi_numero, pi_provincia, pi_canton, pi_distrito, pi_zona, pi_region)
    {
	this.ai_numero = pi_numero;
        this.ai_provincia = pi_provincia;
        this.ai_canton = pi_canton;
        this.ai_distrito = pi_distrito;
        this.ai_zona = pi_zona;
        this.ai_region = pi_region;
    }
};


