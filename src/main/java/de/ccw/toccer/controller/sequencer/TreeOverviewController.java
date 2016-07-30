package de.ccw.toccer.controller.sequencer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tree;
import org.zkoss.zul.TreeModel;

public class TreeOverviewController extends SelectorComposer<Tabpanel> {

	private static final long serialVersionUID = 5176076983834953710L;

	@Wire
	private Tree tree;

	private Label urlLabel;

	@Override
	public void doAfterCompose(Tabpanel comp) throws Exception {
		super.doAfterCompose(comp);
		urlLabel = (Label) comp.getFellow("bandUrl", true);
		
		final Document document = Jsoup.connect(getUrl()).get();
		TreeModel<String> model = tree.getModel();
	}
	
	
	private String getUrl() {
		return urlLabel.getValue();
	}
}
