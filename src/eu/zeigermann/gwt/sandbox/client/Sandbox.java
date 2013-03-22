package eu.zeigermann.gwt.sandbox.client;

import java.math.BigDecimal;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import eu.zeigermann.gwt.sandbox.shared.GreetingDto;
import eu.zeigermann.gwt.sandbox.shared.GreetingGenerator;
import eu.zeigermann.gwt.sandbox.shared.GreetingGeneratorAsync;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Sandbox implements EntryPoint {

	private Label message;

	GreetingGeneratorAsync service = GWT.create(GreetingGenerator.class);
	GreetingConstants constants = GWT.create(GreetingConstants.class);

	public void onModuleLoad() {
		message = new Label();

		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(10);
		// HorizontalPanel panel = new HorizontalPanel();

		InputPanel innerPanel = new InputPanel(this);

		panel.add(innerPanel);
		panel.add(message);

		RootPanel.get().add(panel);
	}
	
	public void display(boolean male, String name) {
		NumberFormat fmt = NumberFormat.getDecimalFormat();
		BigDecimal value = new BigDecimal("12345.6789");
		String formatted = fmt.format(value);
		double parse = fmt.parse(formatted);
		
		String greet = constants.hello() + name + (constants.inEu() ? " in Europe" : " somewhere in the world") + ": " + formatted + "/" + parse;
		message.setText(greet);
	}

	private void displayOnServer(boolean male, String name) {
		service.generateGreeting(new GreetingDto(male, name), new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				message.setText(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Hat nicht geklappt :/", caught);
			}
		});
	}
}
