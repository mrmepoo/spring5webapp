package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BootStrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Kylian", "MBappe");
        Book book1 = new Book("300 bai code thieu nhi", "A0000122");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        Author author2 = new Author("Lionel", "Messi");
        Book book2 = new Book("PLBN how to", "A0000222");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        authorRepository.save(author2);
        bookRepository.save(book2);
        System.out.println("BootstrapData started......");
        System.out.println("Number of books : " + bookRepository.count());
    }
}
