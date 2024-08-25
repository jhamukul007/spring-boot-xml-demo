package com.xml;

import com.xml.models.Author;
import com.xml.models.Author.NameTag;
import com.xml.models.Book;
import com.xml.models.Book.*;
import com.xml.models.XMLFile;
import com.xml.models.XMLFile.Books;
import com.xml.services.file.FileRequest;
import com.xml.services.file.FileService;
import com.xml.utils.XMLFileUtils;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainRunner {
    private final FileService fileService;

    @PostConstruct
    public void createXML() throws JAXBException, IOException {
        XMLFile xmlFile = new XMLFile();

        Books books = new Books();

        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book();

        Title bookTitle = new Title();
        bookTitle.setLocale("en-US");
        bookTitle.setValue("Atomic Habits");
        book1.setTitle(bookTitle);

        book1.setYear(2018);
        book1.setPrice(500D);

        Author author1 = new Author();
        NameTag nameTag = new NameTag();
        nameTag.setLocale("en-US");
        nameTag.setValue("James Clear");

        author1.setName(nameTag);
        Authors authors = new Authors();
        authors.setAuthors(List.of(author1));
        book1.setAuthors(authors);
        bookList.add(book1);

        Book book2 = new Book();
        Title title = new Title();
        title.setLocale("en-US");
        title.setValue("Good Omens");
        book2.setTitle(title);

        Authors authors1 = new Authors();

        Author author = new Author();
        NameTag nameTag1 = new NameTag();
        nameTag1.setValue("Neil Gaiman");
        nameTag1.setLocale("en-US");
        author.setName(nameTag1);

        Author author2 = new Author();
        NameTag nameTag2 = new NameTag();
        nameTag2.setLocale("en-US");
        nameTag2.setValue("Terry Pratchett");
        author2.setName(nameTag2);

        authors1.setAuthors(List.of(author, author2));
        book2.setAuthors(authors1);
        bookList.add(book2);

        books.setBookList(bookList);

        xmlFile.setBooks(books);

        fileService.createFile(new FileRequest("book.xml", XMLFileUtils.convert(xmlFile)));
        log.info("Created file with name book.xml ");
    }
}
