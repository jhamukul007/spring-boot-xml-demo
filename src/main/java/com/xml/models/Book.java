package com.xml.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
import lombok.Data;

import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Book")
public class Book {

    @XmlElement(name = "Title")
    private Title title;

    @XmlElement(name = "Year")
    private Integer year;

    @XmlElement(name = "Price")
    private Double price;

    @XmlElement(name = "Authors")
    private Authors authors;
    @Data
    @XmlRootElement(name = "Authors")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Authors {

        @XmlElement(name = "Author")
        private List<Author> authors;
    }

    @Data
    @XmlRootElement(name = "Title")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Title {
        @XmlAttribute
        private String locale;

        @XmlValue
        private String value;
    }
}
