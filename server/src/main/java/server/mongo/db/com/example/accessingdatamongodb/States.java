package com.example.accessingdatamongodb;


public class States {

	private String abbreviation;
	private String cases;
    private String incidence;
	private String mortality;
    private String name;

	public States(String abbreviation, String cases, String incidence, String mortality, String name) {
		this.abbreviation = abbreviation;
		this.cases = cases;
    this.incidence = incidence;
		this.mortality = mortality;
    this.name = name;
	}

    public String getAbbreviation(){
        return abbreviation;
    }

    public String getCases(){
        return cases;
    }

    public String getIncidence(){
        return incidence;
    }

    public String getMrtality(){
        return mortality;
    }

    public String getName(){
        return name;
    }

}
