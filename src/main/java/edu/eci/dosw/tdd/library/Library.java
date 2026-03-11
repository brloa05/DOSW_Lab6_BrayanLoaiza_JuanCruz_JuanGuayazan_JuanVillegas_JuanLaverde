package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.loan.LoanStatus;
import edu.eci.dosw.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    // ================= addBook =================

    public boolean addBook(Book book) {
        if (book == null) return false;

        books.put(book, books.getOrDefault(book, 0) + 1);
        return true;
    }

    // ================= loanABook =================

    public Loan loanABook(String userId, String isbn) {

        // buscar usuario
        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);

        if (user == null) return null;

        // buscar libro
        Book book = books.keySet().stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);

        if (book == null) return null;

        // validar disponibilidad
        Integer amount = books.get(book);
        if (amount == null || amount <= 0) return null;

        // validar préstamo activo existente
        boolean hasActiveLoan = loans.stream()
                .anyMatch(l ->
                        l.getUser().getId().equals(userId) &&
                                l.getBook().getIsbn().equals(isbn) &&
                                l.getStatus() == LoanStatus.ACTIVE
                );

        if (hasActiveLoan) return null;

        // crear préstamo
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setStatus(LoanStatus.ACTIVE);
        loan.setLoanDate(LocalDateTime.now());

        loans.add(loan);

        // disminuir cantidad
        books.put(book, amount - 1);

        return loan;
    }

    // ================= returnLoan =================

    public Loan returnLoan(Loan loan) {

        if (loan == null || !loans.contains(loan)) {
            return null;
        }

        if (loan.getStatus() == LoanStatus.RETURNED) {
            return loan;
        }

        // aumentar cantidad libro
        Book book = loan.getBook();
        books.put(book, books.getOrDefault(book, 0) + 1);

        // actualizar préstamo
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());

        return loan;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }
}