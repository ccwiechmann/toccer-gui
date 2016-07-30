package de.ccw.toccer.shared.object;

public enum Labels {

	NAVBAR_HOMEPAGE("navbar.homepage"),
	
	NAVBAR_SECOND("navbar.second"),
	
	NAVBAR_ETC("navbar.etc"),
	
	NAVBAR_SEQUENCER("navbar.sequencer"),
	
	SEQUENCER_WEBPAGE_BUTTON("sequencer.webpage.save"),
	
	SEQUENCER_WEBPAGE_TITLE("sequencer.webpage.title"),
	
	SEQUENCER_URL("sequencer.url"),
	
	SEQUENCER_SELECTION_TITLE("sequencer.selection.title");

	private final String labelPath;

	private Labels(String labelPath) {
		this.labelPath = labelPath;
	}

	public String getLabelPath() {
		return labelPath;
	}
	
	public String getLabel() {
		return org.zkoss.util.resource.Labels.getLabel(getLabelPath());
	}
}
