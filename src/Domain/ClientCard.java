package Domain;

public class ClientCard extends Entity {

    private String firstName;

    private String lastName;

    private String cnp;

    private String birthDate;

    private String registrationDate;

    private Double points;

    public ClientCard(Long id, String firstName, String lastName, String cnp, String birthDate,
                      String registrationDate, Double points) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.points = points;
    }

    public ClientCard(Long id, String firstName, String lastName, String cnp, String birthDate, String registrationDate) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "ClientCard{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", points=" + points +
                '}';
    }
}