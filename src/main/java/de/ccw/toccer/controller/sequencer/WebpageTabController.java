package de.ccw.toccer.controller.sequencer;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Window;

import de.ccw.toccer.shared.object.Labels;

public class WebpageTabController extends SelectorComposer<Window> {

	private static final long serialVersionUID = 5176076983834953711L;

	@Wire
	private Label bandUrlLabel;

	@Wire
	private Tab tabWebpage;

	@Wire
	private Tab tabSelection;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		super.doAfterCompose(comp);

		tabWebpage.setLabel(Labels.SEQUENCER_WEBPAGE_TITLE.getLabel());
		bandUrlLabel.setValue(Labels.SEQUENCER_URL.getLabel());
		tabSelection.setLabel(Labels.SEQUENCER_SELECTION_TITLE.getLabel());
	}
}
