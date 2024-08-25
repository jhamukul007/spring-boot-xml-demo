package com.xml.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Inventory")
public class XMLFile {

    @XmlElement(name = "Books")
    private Books books;
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "Books")
    public static class Books {
        @XmlElement(name = "Book")
        private List<Book> bookList;
    }

}
