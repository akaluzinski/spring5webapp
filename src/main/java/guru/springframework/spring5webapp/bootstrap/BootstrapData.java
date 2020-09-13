package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Start bootstrap");

        Author author1 = new Author("John", "Smith");
        Book book1 = new Book("Some title", "12314");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        
        authorRepository.save(author1);
        bookRepository.save(book1);

        System.out.printf("Book repository size:%d%n", bookRepository.count());

    }
}
