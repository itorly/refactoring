package org.itorly;

import org.itorly.domain.Customer;
import org.itorly.domain.Movie;
import org.itorly.domain.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.itorly.domain.Movie.CHILDRENS;
import static org.itorly.domain.Movie.REGULAR;

@SpringBootTest
public class RefactoringTest {

    @Test
    @DisplayName("Customer Test Method")
    public void customerTest() {
        Movie movie = new Movie("Leon", REGULAR);
        Rental rental = new Rental(movie, 7);

        Movie movie2 = new Movie("Flipped", CHILDRENS);
        Rental rental2 = new Rental(movie2, 10);

        Customer customer = new Customer("Tom");
        customer.addRental(rental);
        customer.addRental(rental2);

//        System.out.println("customer=" + customer.toString());
        final String expectedResultOfCustomer =
                "Customer(_name=Tom, _rentals=[Rental(_movie=Movie(_title=Leon, _priceCode=0), _daysRented=7), Rental(_movie=Movie(_title=Flipped, _priceCode=2), _daysRented=10)])";
        Assertions.assertEquals(customer.toString(), expectedResultOfCustomer);
    }
}
