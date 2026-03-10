package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }
/**
 * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the
book is store in a Map that contains
 * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books
available, if the book already exist the
 * amount should increase by 1 and if the book is new the amount should be 1,
this method returns true if the
 * operation is successful false otherwise.
 *
 * @param book The book to store in the map.
 *
 * @return true if the book was stored false otherwise.
 */
    public boolean addBook(Book book) {
    if (book == null) return false;
    Optional<Book> existing = books.keySet().stream()
            .filter(b -> b.getIsbn().equals(book.getIsbn()))
            .findFirst();
    if (existing.isPresent()) {
        Book key = existing.get();
        books.put(key, books.getOrDefault(key, 0) + 1);
    } else {
        books.put(book, 1);
    }
    return true;
}
    /**
    * This method creates a new loan with for the User identify by the userId and
the book identify by the isbn,
    * the loan should be store in the list of loans, to successfully create a
loan is required to validate that the
    * book is available, that the user exist and the same user could not have a
loan for the same book
    * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these
requirements are meet the amount of books is
    * decreased and the loan should be created with {@link
    edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
    * the loan date should be the current date.
    *
    * @param userId id of the user.
    * @param isbn book identification.
    *
    * @return The new created loan.
    */
    public Loan loanABook(String userId, String isbn) {
        //TODO Implement the logic of loan a book to a user based on the UserId and the isbn.
        return null;
    }
    
    /**
    * This method return a loan, meaning that the amount of books should be
increased by 1, the status of the Loan
    * in the loan list should be {@link
edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
    * date should be the current date, validate that the loan exist.
    *
    * @param loan loan to return.
    *
    * @return the loan with the RETURNED status.
    */
    public Loan returnLoan(Loan loan) {
    if (loan == null) throw new IllegalArgumentException("Loan is null");

    Optional<Loan> stored = loans.stream()
            .filter(l -> (l == loan)
                    || (l.getUser() != null && loan.getUser() != null
                        && l.getBook() != null && loan.getBook() != null
                        && l.getUser().getId().equals(loan.getUser().getId())
                        && l.getBook().getIsbn().equals(loan.getBook().getIsbn())
                        && l.getStatus() == LoanStatus.ACTIVE))
            .findFirst();

    if (!stored.isPresent()) throw new IllegalArgumentException("Loan not found or not active");

    Loan found = stored.get();
    found.setStatus(LoanStatus.RETURNED);
    found.setReturnDate(LocalDateTime.now());

    Book book = found.getBook();
    Optional<Book> bookKey = books.keySet().stream()
            .filter(b -> b.getIsbn().equals(book.getIsbn()))
            .findFirst();
    if (bookKey.isPresent()) {
        books.put(bookKey.get(), books.getOrDefault(bookKey.get(), 0) + 1);
    } else {
        books.put(book, 1);
    }

    return found;
}

    public boolean addUser(User user) {
        return users.add(user);
    }

}
