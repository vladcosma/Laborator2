package Test;

import Domain.Entity;
import org.junit.jupiter.api.Test;
import Domain.Movie;
import Repository.BaseRepository;
import Repository.InMemoryRepository;
import Validator.MovieValidator;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {

    @Test
    void findByIdWithExistingIdShouldReturnCorrectMovie() {
        BaseRepository<Movie> repository = new InMemoryRepository<Movie>(new MovieValidator());
        Movie added = new Movie(1L, "Movie", 2018, 22.33, true);
        repository.add(added);
        Movie found = repository.findById(1L);
        assertNotNull(found);
        assertEquals(1L, found.getId());
        assertEquals("Movie", found.getTitle());
        assertEquals(2018, found.getYear());
        assertEquals(22.33, found.getTicketPrice());
        assertTrue(found.isAvailable());
    }

    @Test
    void addShouldReturnCorrectMovie() {
        BaseRepository<Movie> repository = new InMemoryRepository<Movie>(new MovieValidator());
        Movie added = new Movie(1L, "Movie", 2018, 22.33, true);
        Movie test = repository.add(added);
        assertNotNull(test);
        assertEquals(1L, test.getId());
        assertEquals("Movie", test.getTitle());
        assertEquals(2018, test.getYear());
        assertEquals(22.33, test.getTicketPrice());
        assertTrue(test.isAvailable());
    }

    @Test
    void remove() {

    }

    @Test
    void update() {
        BaseRepository<Movie> repository = new InMemoryRepository<Movie>(new MovieValidator());
        Movie added = new Movie(1L, "test", 2018, 22.33, true);
        repository.add(added);
        Movie updated = new Movie(1L, "testUpdate", 2018, 22.33, true);
        Movie test = repository.update(updated);
        assertNotNull(test);
        assertEquals(1L, test.getId());
        assertEquals("test", test.getTitle());
        assertEquals(2018, test.getYear());
        assertEquals(22.33, test.getTicketPrice());
        assertTrue(test.isAvailable());
    }

    @Test
    void getAll() {
        BaseRepository<Movie> repository = new InMemoryRepository<Movie>(new MovieValidator());
        Movie movie1 = new Movie(1L, "test", 2018, 22.33, true);
        Movie movie2 = new Movie(2L, "test2", 2017, 33.44, false);

    }
}
