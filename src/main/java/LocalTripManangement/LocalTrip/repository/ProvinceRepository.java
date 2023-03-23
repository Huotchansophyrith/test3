package LocalTripManangement.LocalTrip.repository;

import LocalTripManangement.LocalTrip.entiry.Provinces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProvinceRepository extends CrudRepository<Provinces,Long> {

    Provinces findById (long id);
    Iterable<Provinces> findAllByStatus(boolean status);
    Optional<Provinces> findAllByProvinceName(String provinceName);
    Provinces findByIdAndStatus(long id,boolean status);
}
