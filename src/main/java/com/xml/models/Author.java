package com.xml.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Author")
public class Author {

    @XmlElement(name = "Name")
    private NameTag name;
    @Data
    @XmlRootElement(name = "Name")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class NameTag{

        @XmlAttribute
        private String locale;

        @XmlValue
        private String value;
    }
}
