package edu.eci.dosw.tdd.library;

import edu.eci.dosw.tdd.library.book.Book;
import edu.eci.dosw.tdd.library.loan.Loan;
import edu.eci.dosw.tdd.library.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public boolean addBook(Book book) {
        //TODO Implement the logic to add a new book into the map.
        return false;
    }


    public Loan loanABook(String userId, String isbn) {
        //TODO Implement the logic of loan a book to a user based on the UserId and the isbn.
        return null;
    }

    public Loan returnLoan(Loan loan) {
        //TODO Implement the logic of returning a loan.
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

}