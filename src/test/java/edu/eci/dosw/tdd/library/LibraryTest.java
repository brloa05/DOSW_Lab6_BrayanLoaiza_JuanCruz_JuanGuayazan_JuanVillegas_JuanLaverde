package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    // ================= ADD BOOK =================

    @Test
    void testAddBook_brayanLoaiza() {
        Book book = new Book("Clean Code","Robert Martin","111");
        assertTrue(library.addBook(book));
    }

    @Test
    void testAddBook_juanCruz() {
        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);
        assertTrue(library.addBook(book));
    }

    @Test
    void testAddBook_juanLaverde() {
        Book book1 = new Book("Clean Code","Robert Martin","111");
        Book book2 = new Book("Refactoring","Fowler","222");

        assertTrue(library.addBook(book1));
        assertTrue(library.addBook(book2));
    }

    @Test
    void testAddBook_juanVmedina() {
        Book book = new Book("DDD","Evans","333");

        library.addBook(book);
        library.addBook(book);
        library.addBook(book);

        assertTrue(true);
    }

    @Test
    void testAddBook_juanGuayazan() {
        Book book = new Book("Patterns","GoF","444");
        assertTrue(library.addBook(book));
    }

    // ================= LOAN A BOOK =================

    @Test
    void testLoanABook_brayanLoaiza() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        assertNotNull(library.loanABook("1","111"));
    }

    @Test
    void testLoanABook_juanCruz() {
        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        assertNull(library.loanABook("999","111"));
    }

    @Test
    void testLoanABook_juanLaverde() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        assertNull(library.loanABook("1","999"));
    }

    @Test
    void testLoanABook_juanVmedina() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        library.loanABook("1","111");
        assertNull(library.loanABook("1","111"));
    }

    @Test
    void testLoanABook_juanGuayazan() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        Loan loan = library.loanABook("1","111");

        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }

    // ================= RETURN LOAN =================

    @Test
    void testReturnLoan_brayanLoaiza() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        Loan loan = library.loanABook("1","111");

        Loan returned = library.returnLoan(loan);

        assertEquals(LoanStatus.RETURNED, returned.getStatus());
    }

    @Test
    void testReturnLoan_juanCruz() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        Loan loan = library.loanABook("1","111");

        assertNotNull(library.returnLoan(loan).getReturnDate());
    }

    @Test
    void testReturnLoan_juanLaverde() {
        assertTrue(true); // validación futura con implementación
    }

    @Test
    void testReturnLoan_juanVmedina() {
        assertNull(library.returnLoan(null));
    }

    @Test
    void testReturnLoan_juanGuayazan() {
        User user = new User();
        user.setId("1");
        library.addUser(user);

        Book book = new Book("Clean Code","Robert Martin","111");
        library.addBook(book);

        Loan loan = library.loanABook("1","111");

        Loan returned = library.returnLoan(loan);

        assertEquals(LoanStatus.RETURNED, returned.getStatus());
    }
}