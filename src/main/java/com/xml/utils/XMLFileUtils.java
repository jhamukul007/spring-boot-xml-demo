package com.xml.utils;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.experimental.UtilityClass;

import java.io.StringWriter;

@UtilityClass
public class XMLFileUtils {
    public <E> String convert(E xmlObject) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(xmlObject.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(xmlObject, stringWriter);
        return stringWriter.toString();
    }

}
