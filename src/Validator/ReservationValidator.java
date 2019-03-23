package Validator;

import Domain.Reservation;
import Exception.InvalidDateFormatException;
import Exception.InvalidTimeFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReservationValidator implements Validator<Reservation> {

    public void validate(Reservation reservation) {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(reservation.getDate());
        } catch (ParseException e) {
            throw new InvalidDateFormatException("Wrong reservation date format!");
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        try {
            timeFormat.parse(reservation.getTime());
        } catch (ParseException e) {
            throw new InvalidTimeFormatException("Wrong reservation time format!");
        }
    }
}