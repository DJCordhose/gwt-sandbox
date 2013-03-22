package eu.zeigermann.gwt.sandbox.shared;

import java.io.Serializable;

public class GreetingDto implements Serializable {
	public boolean male;
	public String name;

	public GreetingDto() {
	}
	
	public GreetingDto(boolean male, String name) {
		super();
		this.male = male;
		this.name = name;
	}

}
