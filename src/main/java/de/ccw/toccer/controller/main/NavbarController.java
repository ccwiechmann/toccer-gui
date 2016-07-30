package de.ccw.toccer.controller.main;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Include;
import org.zkoss.zul.Vlayout;

public class NavbarController extends SelectorComposer<Vlayout> {

	private static final long serialVersionUID = -224022510898469435L;

	private static final Pattern ACTIVE_PATTERN = Pattern.compile("active");

	private NavbarEntry selectedEntry;

	private Map<NavbarEntry, Button> buttonMap = new HashMap<>();

	@Override
	public void doAfterCompose(Vlayout comp) throws Exception {
		super.doAfterCompose(comp);

		selectedEntry = NavbarEntry.values()[0];
		for (final NavbarEntry navbarEntry : NavbarEntry.values()) {
			final Button button = new Button();
			button.setLabel(navbarEntry.getLabel().getLabel());
			button.setIconSclass(navbarEntry.getIcon().getIconSclass());
			button.setHflex("1");
			button.setParent(comp);

			button.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event event) throws Exception {
					deselectAllEntries();
					selectEntry(button);

					final String target = navbarEntry.getTarget();

					if (target.startsWith("http")) {
						Executions.getCurrent().sendRedirect(target, "_blank");
					} else {
						final Center center = (Center) Selectors.iterable(getPage(), "#mainCenter").iterator().next();
						final Include include = (Include) center.getFirstChild();
						include.setSrc(target);
					}
				}
			});

			if (navbarEntry == selectedEntry) {
				selectEntry(button);
			}

			buttonMap.put(navbarEntry, button);
		}
	}

	private void deselectAllEntries() {
		for (final Button button : buttonMap.values()) {
			deselectEntry(button);
		}
	}

	private void deselectEntry(Button button) {
		final String currentSclass = button.getSclass();

		if (currentSclass != null && currentSclass.contains("active")) {
			final String newSclass = ACTIVE_PATTERN.matcher(currentSclass).replaceAll("").trim();
			button.setSclass(newSclass);
		}
	}

	private void selectEntry(Button button) {
		final String currentSclass = button.getSclass();

		if (currentSclass == null || !currentSclass.contains("active")) {
			final String newSclass = (currentSclass == null ? "" : currentSclass) + " active".trim();
			button.setSclass(newSclass);
		}
	}
}
