BookMyShow online movie booking platform

Functional Requirments
 - Listing all the cinema halls in the current city which we are searching
 - Booking the ticket
 - Searching movie name 
 - Searching by language, genre


Hierarchy of Book My Show
- City  
    - Cinema Halls
        - Screens
            - Shows
                - Seats


class BookMyShowService {

    public List<CinemallHall> listCinemaHallsByMovieName(String movieName, String cityName);
    public BookingStatus bookTheTicket()
}

enum BookingStatus {
    SUCCESS, FAILED, PENDING_PAYMENT, ERROR
}

class City {
    Long id;
    String name;
    String taluka;
    String district;
    String state;
    List<CinemaHall> cinemaHalls;

    public List<CinemaHall> getCinemaHallsByCityName(String cityName);
}


class CinemaHall {
    Long id;
    String name;
    String description;
    List<Screen> screens;

}

class Screen {
    Long id;
    String name;
    
    Long totalSeats;
    List<Show> shows;
}

class Show {
    Long id;
    Movie movie;
    Date startTime;
    Date endTime;
    Double price;
    List<Seats> seats;

    public List<Seats> getAllAvailableSeats();
    public List<Seats> getAllBookedSeats();
}

class Seat {
    Long id;
    String seatId;
    SeatStatus status;

    public SeatStatus bookATicket();
}

enum SeatStatus {
    BOOKED, CANCELLED, PAYMENT_PENDING, ERROR;
}

class Movie {
    Long id;
    String name;
    String description;
    Date releasedDate;
}

[1,2,4,6,5], 8
public void sumOf2Numbers(int arr[], int sum) {
    Set<Integer> set = new HashSet<Integer>();
    for(int i=0;i<arr.length;i++) {
        if(set.containsKey(sum-arr[i])) {
            System.out.println(arr[i] + " " + (sum-arr[i]));
        } else {
            set.add(arr[i]);
        }
    }
}