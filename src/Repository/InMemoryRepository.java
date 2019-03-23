package Repository;

import Domain.Entity;
import Exception.InvalidEntityIdException;
import Validator.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements BaseRepository<T> {

    private Map<Long, T> repository = new HashMap<>();
    private Validator<T> validator;

    public InMemoryRepository(Validator<T> validator) {
        this.validator = validator;
    }

    @Override
    public T findById(Long id) {
        return repository.get(id);
    }

    /**
     * Adds an entity
     * @param t the entity to add
     */
    @Override
    public T add(T t) {
        validator.validate(t);
        return repository.put(t.getId(), t);
    }

    /**
     * Removes a entity with a given id
     * @param id the id
     * @throws InvalidEntityIdException if there is no entity with the given id
     */
    @Override
    public void remove(Long id) {
        if (!repository.containsKey(id)) {
            throw new InvalidEntityIdException("There is no entity with this ID to remove!");
        }
        repository.remove(id);
    }

    /**
     * Updates an entity if already exists
     * @param t the entity to update
     */
    @Override
    public T update(T t) {
        if (!repository.containsKey(t.getId())) {
            throw new InvalidEntityIdException("There is no entity with this ID to update!");
        }
        validator.validate(t);
        return repository.put(t.getId(), t);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(repository.values());
    }
}
