package FashionBlog.Repository;

import FashionBlog.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    User user = User.builder()
            .lastName("Tiamiyu")
            .firstName("Kehinde")
            .email("admin@gmail.com")
            .password("1234").build();
    entityManager.persist(user);
    }


    @Test
    void findUserByEmail() {
       Optional<User> user = userRepository.findUserByEmail("admin@gmail.com");
        assertEquals("Kehinde",user.get().getFirstName());

    }
}