package org.moviesystem;

import java.util.Arrays;

public class MovieApp {
    public static void main(String[] args) {
        // Create movie booking system
        MovieBookingSystem system = new MovieBookingSystem();

        // Create shows for a movie
        Show show1 = new Show("10:00 AM", 5);
        Show show2 = new Show("2:00 PM", 5);

        // Create a Movie with shows
        Movie inception = new Movie("Tumbbad", "Horror", Arrays.asList(show1, show2));
        system.addMovie(inception);

        // Create User
        User manish = new User("Manish", "Manish@gmail.com");

        // Book a ticket
        system.bookTicket(manish, "Tumbbad", "10:00 AM");

        // Display all movies
        system.displayMovies();

        // Cancel the ticket
        system.cancelTicket(manish, "Tumbbad", "10:00 AM");
        system.displaySeatStatus();
        //system will behave as user
    }
}


