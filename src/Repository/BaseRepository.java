package Repository;

import Domain.Entity;

import java.util.List;

public interface BaseRepository<T extends Entity> {

    T findById(Long id);

    T add(T t);

    void remove(Long id);

    T update(T t);

    List<T> getAll();

}
