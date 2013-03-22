package eu.zeigermann.gwt.sandbox.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.resources.client.DataResource.MimeType;
import com.google.gwt.resources.client.ImageResource;

public interface DemoBundle extends ClientBundle {
	@MimeType("image/png")
	@Source("resources/olli.png")
	ImageResource photo();

	@Source("resources/Screen Shot 2012-12-19 at 21.03.44.png")
	ImageResource screenShot();

	@Source("resources/vaadin7.pdf")
	DataResource vaadin7Slides();
	
	@Source("style.css")
    DemoCssResource css();
}
