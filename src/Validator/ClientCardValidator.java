package Validator;

import Domain.ClientCard;
import Exception.InvalidCNPException;
import Exception.InvalidDateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientCardValidator implements Validator<ClientCard> {

    public void validate(ClientCard clientCard) {
        if (clientCard.getCnp().length() < 13) {
            throw new InvalidCNPException("CNP must be 13 characters long!");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        try {
            format.parse(clientCard.getBirthDate());
        } catch (ParseException e) {
            throw new InvalidDateFormatException("Wrong birth date format!");
        }

        try {
            format.parse(clientCard.getRegistrationDate());
        } catch (ParseException e) {
            throw new InvalidDateFormatException("Wrong registration date format!");
        }
    }

}
