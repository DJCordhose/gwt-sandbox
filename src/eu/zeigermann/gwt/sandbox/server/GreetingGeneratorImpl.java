package eu.zeigermann.gwt.sandbox.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eu.zeigermann.gwt.sandbox.shared.GreetingDto;
import eu.zeigermann.gwt.sandbox.shared.GreetingGenerator;

public class GreetingGeneratorImpl extends RemoteServiceServlet implements GreetingGenerator {

	@Override
	public String generateGreeting(GreetingDto dto) {
//		if (true) {
//			throw new RuntimeException("Kaputt!");
//		}
		return "Hallo, " + (dto.male ? "Herr " : "Frau ") + dto.name;
	}

}
