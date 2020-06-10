package server.mongo.db.com.example.accessingdatamongodb;


public class State {

	private String abbreviation;
	private String cases;
    private String incidence;
	private String mortality;
    private String name;

	public State(String abbreviation, String cases, String incidence, String mortality, String name) {
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

    public String getMortality(){
        return mortality;
    }

    public String getName(){
        return name;
    }

    public String toString() {
	    return this.abbreviation + ": [cases: " + this.cases + ", incidence: " + this.incidence + ", mortality: " + this.mortality + "]";
    }

}
