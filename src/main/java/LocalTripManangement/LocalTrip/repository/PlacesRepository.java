package LocalTripManangement.LocalTrip.repository;

import LocalTripManangement.LocalTrip.entiry.Places;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlacesRepository extends CrudRepository<Places,Long> {

    Places findById (long id);
    Iterable<Places> findAllByStatus (boolean status);
    Optional<Places> findAllByPlaceName(String placeName);
    Places findByIdAndStatus(long id,boolean status);

}
