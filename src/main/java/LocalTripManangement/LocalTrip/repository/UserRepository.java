package LocalTripManangement.LocalTrip.repository;

import LocalTripManangement.LocalTrip.entiry.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    Iterable<User> findAllByStatus(boolean status);
    Iterable<User> findByUsernameStartsWith(String username);
    User findByIdAndStatus(int id, boolean status);
}
