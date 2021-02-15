package ru.hostco.archivarius.soap_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import lombok.RequiredArgsConstructor;
import ru.hostco.archivarius.config.ApplicationConfig;

@Configuration
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class Config {

    private final ApplicationConfig applicationConfig;
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ru.hostco.reguser.types");
        return marshaller;
    }

    @Bean
    public SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
        SOAPConnector client = new SOAPConnector();
        client.setDefaultUri(applicationConfig.getSoapUrl());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
