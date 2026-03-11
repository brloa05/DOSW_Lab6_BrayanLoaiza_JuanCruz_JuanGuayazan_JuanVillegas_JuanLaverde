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
    public void setUp() {
        library = new Library();

        User u = new User();
        u.setId("u1");
        u.setName("Juan");
        library.addUser(u);

        Book b = new Book("Title","Author","isbn-123");
        library.addBook(b);
    }

    // ========== PRUEBAS PARA addBook ==========

    @Test
    public void testAddBook1() {
        Book newBook = new Book("Clean Code","Robert Martin","isbn-999");

        boolean result = library.addBook(newBook);

        assertTrue(result);
    }

    @Test
    public void testAddBook2() {
        Book sameBook = new Book("Title","Author","isbn-123");

        boolean result = library.addBook(sameBook);

        assertTrue(result); // según tu lógica actual
    }

    @Test
    public void testAddBook3() {
        Book book = new Book("Design Patterns","GoF","isbn-777");
        library.addBook(book);

        Loan loan = library.loanABook("u1","isbn-777");

        assertNotNull(loan);
        assertEquals("isbn-777", loan.getBook().getIsbn());
    }

    @Test
    public void testAddBook4() {
        // TODO
    }

    @Test
    public void testAddBook5() {
        // TODO
    }

    // ========== PRUEBAS PARA loanABook ==========

    @Test
    public void testLoanABook1() {
        Loan loan = library.loanABook("usuario-inexistente", "isbn-123");

        assertNull(loan);
    }

    @Test
    public void testLoanABook2() {
        Loan loan = library.loanABook("u1","isbn-123");

        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
    }

    @Test
    public void testLoanABook3() {
        Loan loan = library.loanABook("u1","isbn-no-existe");

        assertNull(loan);
    }

    @Test
    public void testLoanABook4() {
        // TODO
    }

    @Test
    public void testLoanABook5() {
        // TODO
    }

    // ========== PRUEBAS PARA returnLoan ==========

    @Test
    public void testReturnLoan1() {
        Loan loan = library.loanABook("u1","isbn-123");

        Loan returned = library.returnLoan(loan);

        assertEquals(LoanStatus.RETURNED, returned.getStatus());
        assertNotNull(returned.getReturnDate());
    }

    @Test
    public void testReturnLoan2() {
        Loan loan = library.loanABook("u1","isbn-123");

        Loan returned = library.returnLoan(loan);

        assertEquals("isbn-123", returned.getBook().getIsbn());
    }

    @Test
    public void testReturnLoan3() {
        Loan fakeLoan = new Loan();

        Loan result = library.returnLoan(fakeLoan);

        assertNull(result);
    }

    @Test
    public void testReturnLoan4() {
        // TODO
    }

    @Test
    public void testReturnLoan5() {
        // TODO
    }
}
