package flaviodeangelis.u6w2d2.service;

import flaviodeangelis.u6w2d2.entities.Author;
import flaviodeangelis.u6w2d2.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public Author save(Author body) {
        Random rndm = new Random();
        body.setId(rndm.nextLong(1, 1000000000));
        this.authors.add(body);
        return body;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author findById(long id) throws NotFoundException {
        Author u = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                u = author;
            }
        }
        if (u == null) {
            throw new NotFoundException(id);
        } else {
            return u;
        }
    }

    public void findByIdAndDelete(long id) {
        ListIterator<Author> iterator = this.authors.listIterator();

        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Author findByIdAndUpdate(long id, Author body) throws NotFoundException {
        Author found = null;

        for (Author author : this.authors) {
            if (author.getId() == id) {
                found = author;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setBirthDate(body.getBirthDate());
                found.setAvatar(body.getAvatar());
            }
        }
        if (found == null) {
            throw new NotFoundException(id);
        } else {
            return found;
        }
    }
}
