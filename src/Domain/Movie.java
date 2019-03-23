package Domain;

public class Movie extends Entity {

    private String title;

    private Integer year;

    private Double ticketPrice;

    private Boolean available;

    public Movie(Long id, String title, Integer year, Double ticketPrice, boolean available) {
        super(id);
        this.title = title;
        this.year = year;
        this.ticketPrice = ticketPrice;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", ticketPrice=" + ticketPrice +
                ", available=" + available +
                '}';
    }
}
