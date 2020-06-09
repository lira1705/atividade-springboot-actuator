package com.example.restservice;


public class States {

	private String sigla;
	private String casos;
    private String incidencia;
	private String mortalidade;

	public States(String sigla, String casos, String incidencia, String mortalidade) {
        super();
		this.sigla = sigla;
		this.casos = casos;
        this.incidencia = incidencia;
		this.mortalidade = mortalidade;
	}

    public String getSigla(){
        return sigla;
    }

    public String getCasos(){
        return casos;
    }

    public String getIncidencia(){
        return incidencia;
    }

    public String getMortalidade(){
        return mortalidade;
    }

}
