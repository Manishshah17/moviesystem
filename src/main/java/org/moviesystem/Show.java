package org.moviesystem;

class Show {
    private String showTime;
    private int totalSeats;
    private int availableSeats;

    public Show(String showTime, int totalSeats) {
        this.showTime = showTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially, all seats are available
    }

    public String getShowTime() {
        return showTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
    public int getTotalSeats()
    {
        return totalSeats;
    }
    public int getBookedSeats()
    {
        return totalSeats-availableSeats;
    }

    public int bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return totalSeats - availableSeats;
        } else {
            throw new IllegalArgumentException("No available seats for this show.");
        }
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        } else {
            throw new IllegalArgumentException("All seats are already available.");
        }
    }

    @Override
    public String toString() {
        return "ShowTime: " + showTime + ", Available Seats: " + availableSeats;
    }
}

