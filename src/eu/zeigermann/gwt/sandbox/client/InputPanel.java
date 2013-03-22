package eu.zeigermann.gwt.sandbox.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class InputPanel extends Composite {
	private Button sendButton;
	private TextBox field;
	private CheckBox maleCheckBox;
	private Sandbox presenter;
	
	public InputPanel(Sandbox presenter) {
		this.presenter = presenter;
		init();
	}

	private void init() {
		final DemoBundle resourceBundle = GWT.create(DemoBundle.class);
		// otherwise CSS does not exist
		resourceBundle.css().ensureInjected();
		
		sendButton = new Button("Send");
		sendButton.ensureDebugId("send");
		sendButton.addStyleName(resourceBundle.css().sendButton());
		sendButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				sayHello();
			}
		});

		field = new TextBox();
		field.setText("GWT User");
		field.setFocus(true);
		field.selectAll();
		field.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					sayHello();
				}
			}

		});
		 HorizontalPanel innerPanel = new HorizontalPanel();
//		FlowPanel innerPanel = new FlowPanel();
		innerPanel.setSpacing(10);
		innerPanel.add(field);
		
		maleCheckBox = new CheckBox("New check box");
		maleCheckBox.setValue(true);
		maleCheckBox.setHTML("Male");
		innerPanel.add(maleCheckBox);
		innerPanel.add(sendButton);
		initWidget(innerPanel);
		
		String name = resourceBundle.screenShot().getName();
		Label label = new Label(name);
		innerPanel.add(label);
		
		int height /* width */ = resourceBundle.screenShot().getHeight(); // getWidth();
		Label heigtLabel = new Label(""+height);
		innerPanel.add(heigtLabel);

		SafeUri safeUri = resourceBundle.screenShot().getSafeUri();
		Image image = new Image(safeUri);
//		innerPanel.add(image);
		Anchor anchor = new Anchor(name, safeUri.asString());
		innerPanel.add(anchor);
		
		SafeUri safeUri2 = resourceBundle.vaadin7Slides().getSafeUri();
		Anchor anchor2 = new Anchor("Download Vaadin 7 Slides", safeUri2.asString());
		innerPanel.add(anchor2);

		SafeUri safeUri3 = resourceBundle.photo().getSafeUri();
		Anchor anchor3 = new Anchor("Foto", safeUri3.asString());
		innerPanel.add(anchor3);

	}

	private void sayHello() {
		presenter.display(maleCheckBox.getValue(), field.getText());
	}

}
