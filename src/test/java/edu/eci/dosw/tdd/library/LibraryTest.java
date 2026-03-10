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
    public void setup() {
        library = new Library();
        User u = new User();
        u.setId("u1"); u.setName("Juan");
        library.addUser(u);
        Book b = new Book("Title","Author","isbn-123");
        library.addBook(b);
    }

    // ========== PRUEBAS PARA addBook ==========

    @Test
    public void testAddBook1() {
        // TODO: Implementar caso de prueba 1
    }

    @Test
    public void testAddBook2() {
        // TODO: Implementar caso de prueba 2
    }

    @Test
    public void testAddBook3() {
        // TODO: Implementar caso de prueba 3
    }

    @Test
    public void testAddBook4() {
        // TODO: Implementar caso de prueba 4
    }

    @Test
    public void testAddBook5() {
        // TODO: Implementar caso de prueba 5
    }

    // ========== PRUEBAS PARA loanABook ==========

   @Test
    public void loanABook_validUserAndAvailableBook_createsActiveLoan() {
        Loan loan = library.loanABook("u1","isbn-123");
        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
        assertEquals("isbn-123", loan.getBook().getIsbn());
        assertEquals("u1", loan.getUser().getId());
    }

    @Test
    public void testLoanABook2() {
        // TODO: Implementar caso de prueba 2
    }

    @Test
    public void testLoanABook3() {
        // TODO: Implementar caso de prueba 3
    }

    @Test
    public void testLoanABook4() {
        // TODO: Implementar caso de prueba 4
    }

    @Test
    public void testLoanABook5() {
        // TODO: Implementar caso de prueba 5
    }

    // ========== PRUEBAS PARA returnLoan ==========

    @Test
    public void testReturnLoan1() {
        // TODO: Implementar caso de prueba 1
    }

    @Test
    public void testReturnLoan2() {
        // TODO: Implementar caso de prueba 2
    }

    @Test
    public void testReturnLoan3() {
        // TODO: Implementar caso de prueba 3
    }

    @Test
    public void testReturnLoan4() {
        // TODO: Implementar caso de prueba 4
    }

    @Test
    public void testReturnLoan5() {
        // TODO: Implementar caso de prueba 5
    }

}
