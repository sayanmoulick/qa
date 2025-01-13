package companyGraziosoSalvare;

public class Monkey{
	private String species;

	private float tailLength;

	private float height;

	private float bodyLength;

	private float torsoMeasurement;

	private float skullMeasurement;

	private float neckMeasurement;
	
	// Constructor
	public Monkey() {

	}
	
	// Accessor Method
	public String getSpecies() {
	    return species;
	}
	
	public float getTailLength() {
	    return tailLength;
	}
	
	public float getHeight() {
	    return height;
	}
	
	public float getBodyLength() {
	    return bodyLength;
	}
	
	public float getTorsoSize() {
	    return torsoMeasurement;
	}
	
	public float getSkullSize() {
	    return skullMeasurement;
	}
	
	public float getNeckSize() {
	    return neckMeasurement;
	}
	
	// Mutator Method
	public void setSpecies(String species) {
	    this.species = species;
	}
	
	public void setTailLength(float tailLength) {
	    this.tailLength = tailLength;
	}
	
	public void setHeight(float height) {
	    this.height = height;
	}
	
	public void setBodyLength(float bodyLength) {
	    this.bodyLength = bodyLength;
	}
	
	public void setTorsoMeasurement(float torsoMeasurement) {
	    this.torsoMeasurement = torsoMeasurement;
	}
	
	public void setSkullMeasurement(float skullMeasurement) {
	    this.skullMeasurement = skullMeasurement;
	}
	
	public void setNeckMeasurement(float newNeckMeasurementValue) {
	    this.neckMeasurement = newNeckMeasurementValue;
	}
}
