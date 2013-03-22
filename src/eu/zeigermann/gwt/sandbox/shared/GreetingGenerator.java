package eu.zeigermann.gwt.sandbox.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("generator")
public interface GreetingGenerator extends RemoteService {
	String generateGreeting(GreetingDto dto);
}
