/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author didas
 */
public class BookFacadeTest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private static Book book;
    private static BookFacade bf;
    
    public BookFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        bf = BookFacade.getBookFacade(emf);
        
        book = new Book("Henningsen");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        
        
    }
    
    @AfterEach
    public void tearDown() {
    }

   

    /**
     * Test of addBook method, of class BookFacade.
     */
    @Test
    public void testAddBook() {
        System.out.println("addBook");
        
        BookFacade instance = BookFacade.getBookFacade(emf);
        String expResult = book.getAuthor();
        Book result = instance.addBook(book.getAuthor());
        assertEquals(expResult, result.getAuthor());
        
    }

    /**
     * Test of findBook method, of class BookFacade.
     */
    @Test
    public void testFindBook() {
        System.out.println("findBook");
       
        BookFacade facade = BookFacade.getBookFacade(emf);
        String expResult = book.getAuthor();
        Book foundBook = facade.findBook(1);
        String result = foundBook.getAuthor();
        assertEquals(expResult, result);       
    }

    /**
     * Test of getAllBooks method, of class BookFacade.
     */
    @Test
    public void testGetAllBooks() {
        System.out.println("getAllBooks");
        BookFacade instance = null;
        List<Book> expResult = null;
        List<Book> result = instance.getAllBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
