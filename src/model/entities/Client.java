package model.entities;

import model.exceptions.ClientException;

public class Client {
	private String name;
	private Character classification;
	private String code;
	
	
	public Client(String name, Character classification, String code) {
		super();
		this.name = name;
		this.classification = classification;
		this.code = code;
		if (classification != 'V' && classification != 'S') {
			throw new ClientException("INVALID OPTION TRY AGAIN");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getClassification() {
		return classification;
	}

	public void setClassification(Character classification) {
		this.classification = classification;
	}
	
	public String getCode() {
		return code;
	}

}
