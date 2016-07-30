package de.ccw.toccer.shared.object;

public enum Icon {

	HOME("z-icon-home"),
	
	ANCHOR("z-icon-anchor"),
	
	BUG("z-icon-bug"),
	
	CUBES("z-icon-cubes");

	private final String iconSclass;

	private Icon(String iconSclass) {
		this.iconSclass = iconSclass;
	}

	public String getIconSclass() {
		return iconSclass;
	}
}
