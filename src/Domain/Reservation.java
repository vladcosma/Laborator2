package Domain;

public class Reservation extends Entity {

    private Long idMovie;

    private Long idClientCard;

    private String date;

    private String time;

    public Reservation(Long id, Long idMovie, Long idClientCard, String date, String time) {
        super(id);
        this.idMovie = idMovie;
        this.idClientCard = idClientCard;
        this.date = date;
        this.time = time;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public Long getIdClientCard() {
        return idClientCard;
    }

    public void setIdClientCard(Long idClientCard) {
        this.idClientCard = idClientCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + getId() +
                ", idMovie=" + idMovie +
                ", idClientCard=" + idClientCard +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}