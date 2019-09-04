package sevices;

public class PConfigurationSummary {
	private String name, description;
	private java.awt.Image view;
	
	public PConfigurationSummary(String name, String description, java.awt.Image view) {
		this.name = name;
		this.description = description;
		this.view = view;
	}
	
	public String toString() {
		return this.name + " \n" + this.description;
	}
}
