package de.ccw.toccer.controller.sequencer;

import java.net.URI;
import java.net.URISyntaxException;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;

import de.ccw.toccer.shared.object.Labels;

public class WebpageSelectionController extends SelectorComposer<Tabpanel> {

	private static final long serialVersionUID = 5176076983834953710L;

	@Wire
	private Button save;

	@Wire
	private Iframe iframe;

	@Wire
	private Textbox url;

	@Override
	public void doAfterCompose(Tabpanel comp) throws Exception {
		super.doAfterCompose(comp);

		url.setInstant(true);
		save.setLabel(Labels.SEQUENCER_WEBPAGE_BUTTON.getLabel());

		url.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>() {
			@Override
			public void onEvent(InputEvent event) throws Exception {
				setPath(event.getValue());
			}
		});

		url.addEventListener(Events.ON_OK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				setPath(url.getRawText());
			}
		});

		save.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event event) throws Exception {
				final Label label = (Label) comp.getFellow("bandUrl", true);
				label.setValue(url.getRawText());
			}
		});
	}

	private void setPath(String path) {
		try {
			new URI(path);
			iframe.setSrc(path);
		} catch (URISyntaxException e) {
			// ok
		}
	}
}
