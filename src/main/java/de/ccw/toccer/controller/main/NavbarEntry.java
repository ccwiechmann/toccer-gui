package de.ccw.toccer.controller.main;

import de.ccw.toccer.shared.object.Icon;
import de.ccw.toccer.shared.object.Labels;

public enum NavbarEntry {

	HOMEPAGE(Labels.NAVBAR_HOMEPAGE, "/zul/main/home.zul", Icon.HOME),

	SEQUENCER(Labels.NAVBAR_SEQUENCER, "/zul/sequencer/tabs.zul", Icon.CUBES);

	private final Labels label;
	private final String target;
	private final Icon icon;

	private NavbarEntry(Labels label, String zul, Icon icon) {
		this.label = label;
		this.target = zul;
		this.icon = icon;
	}

	public Labels getLabel() {
		return label;
	}

	public String getTarget() {
		return target;
	}

	public Icon getIcon() {
		return icon;
	}
}
