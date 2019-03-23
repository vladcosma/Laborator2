package Service;

import Domain.ClientCard;
import Exception.InvalidCNPException;
import Repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientCardService {

    private BaseRepository<ClientCard> clientCardRepository;

    public ClientCardService(BaseRepository<ClientCard> clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    /**
     * @param id client card
     * @param firstName client
     * @param lastName client
     * @param cnp client
     * @param birthDate client
     * @param registrationDate client card
     */
    public void insert(Long id, String firstName, String lastName, String cnp, String birthDate,
                       String registrationDate) {
        List<ClientCard> cards = clientCardRepository.getAll();
        for (ClientCard card : cards) {
            if (card.getCnp().equals(cnp)) {
                throw new InvalidCNPException("This CNP already exists!");
            }
        }
        ClientCard clientCard = new ClientCard(id, firstName, lastName, cnp, birthDate, registrationDate);
        clientCardRepository.add(clientCard);
    }

    /**
     * @param id client card
     * @param firstName client
     * @param lastName client
     * @param cnp client
     * @param birthDate client
     * @param registrationDate client card
     */
    public void update(Long id, String firstName, String lastName, String cnp, String birthDate,
                       String registrationDate) {
        ClientCard clientCard = new ClientCard(id, firstName, lastName, cnp, birthDate, registrationDate);
        clientCardRepository.update(clientCard);
    }

    /**
     * @param id for client card to remove
     */
    public void remove(Long id) {
        clientCardRepository.remove(id);
    }

    /**
     * @param id for client card to find
     * @return client card
     */
    public ClientCard getById(Long id) {
        return clientCardRepository.findById(id);
    }

    /**
     * @return list of client cards
     */
    public List<ClientCard> getAll() {
        return clientCardRepository.getAll();
    }

    public List<ClientCard> fullTextSearch(String text) {
        List<ClientCard> results = new ArrayList<>();
        for (ClientCard clientCard : clientCardRepository.getAll()) {
            if (clientCard.getFirstName().contains(text) ||
                    clientCard.getLastName().contains(text) ||
                    clientCard.getCnp().contains(text) ||
                    clientCard.getBirthDate().contains(text) ||
                    clientCard.getRegistrationDate().contains(text)) {
                results.add(clientCard);
            }
        }
        return results;
    }
}
