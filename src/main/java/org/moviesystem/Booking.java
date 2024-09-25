package org.moviesystem;

class Booking {
    private Movie movie;
    private String showTime;
    private int seatNumber;
    private User user;

    public Booking(Movie movie, String showTime, int seatNumber, User user) {
        this.movie = movie;
        this.showTime = showTime;
        this.seatNumber = seatNumber;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Booking [Movie: " + movie.getTitle() + ", ShowTime: " + showTime + ", Seat: " + seatNumber + ", User: " + user.getName() + "]";
    }
}
