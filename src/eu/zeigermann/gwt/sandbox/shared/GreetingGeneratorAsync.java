package eu.zeigermann.gwt.sandbox.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingGeneratorAsync {

	void generateGreeting(GreetingDto dto, AsyncCallback<String> callback);

}
