package com.liverton.entity;

public enum Product {
	MAIL_ADVISER("MailAdviser"), SMART_GATE("SmartGate"), SE_EMAIL("SEEMail"), SMART_CHECK(
			"SmartCheck"), VISTA_GATE("Vistagate"), I_DATA_ROAM("iDataRoam");

	private Product(final String name) {

		this.name = name;
	}

	  public static final Product[] ALL = { MAIL_ADVISER, SMART_GATE, SE_EMAIL, SMART_CHECK,VISTA_GATE,I_DATA_ROAM};
	    
	    
	public static Product forName(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null for product");
		}
		if (name.toUpperCase().equals("MailAdviser")) {
			return MAIL_ADVISER;
		} else if (name.toUpperCase().equals("SmartGate")) {
			return SMART_GATE;
		} else if (name.toUpperCase().equals("SEEMail")) {
			return SE_EMAIL;
		} else if (name.toUpperCase().equals("SmartCheck")) {
			return SMART_CHECK;
		} else if (name.toUpperCase().equals("Vistagate")) {
			return VISTA_GATE;
		} else if (name.toUpperCase().equals("iDataRoam")) {
			return I_DATA_ROAM;
		}
		throw new IllegalArgumentException("Name \"" + name + "\" does not correspond to any product");
	}

	private final String name;

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
