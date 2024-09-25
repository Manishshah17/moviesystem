package org.moviesystem;

import java.util.*;

public class MovieBookingSystem {
    private List<Movie> movies;
    private Map<String, List<Booking>> bookings; // showTime -> List of bookings

    public MovieBookingSystem() {
        movies = new ArrayList<>();
        bookings = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void bookTicket(User user, String movieTitle, String showTime) {
        Movie movie = findMovieByTitle(movieTitle);
        if (movie == null) {
            System.out.println("Movie not found!");
            return;
        }

        Show show = movie.getShowByTime(showTime);
        if (show == null) {
            System.out.println("Show not found!");
            return;
        }

        if (show.getAvailableSeats() == 0) {
            System.out.println("No seats available for the show!");
            return;
        }

        int seatNumber = show.bookSeat();
        Booking booking = new Booking(movie, showTime, seatNumber, user);

        bookings.computeIfAbsent(showTime, k -> new ArrayList<>()).add(booking);

        System.out.println("Booking successful for " + user.getName() + ": " + booking);
    }

    public void cancelTicket(User user, String movieTitle, String showTime) {
        Movie movie = findMovieByTitle(movieTitle);
        if (movie == null) {
            System.out.println("Movie not found!");
            return;
        }

        Show show = movie.getShowByTime(showTime);
        if (show == null) {
            System.out.println("Show not found!");
            return;
        }

        show.cancelSeat();
        System.out.println("Booking canceled for " + user.getName());
    }

    private Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }
    public void displaySeatStatus() {
        for (Movie movie : movies) {
            System.out.println("Movie: " + movie.getTitle());
            for (Show show : movie.getShows()){
                System.out.println("  Show Time: " + show.getShowTime() +
                        " | Total Seats: " + show.getTotalSeats() +
                        " | Booked Seats: " + show.getBookedSeats() +
                        " | Available Seats: " + show.getAvailableSeats());
            }
        }
    }

    public void displayMovies() {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
