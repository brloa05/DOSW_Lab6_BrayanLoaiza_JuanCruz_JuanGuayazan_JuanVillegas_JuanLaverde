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
    }

    // ========== PRUEBAS PARA addBook ==========

    @Test
    public void addBook_newBook_returnsTrue_and_allowsOneLoan() {
        Book b = new Book("T2","A2","isbn-2");
        assertTrue(library.addBook(b)); 
        User u = new User();
        u.setId("uX"); u.setName("UsuarioX");
        library.addUser(u);
        Loan loan = library.loanABook("uX","isbn-2");
        assertNotNull(loan);
        assertEquals(LoanStatus.ACTIVE, loan.getStatus());
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
    public void testLoanABook1() {
        // TODO: Implementar caso de prueba 1
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
