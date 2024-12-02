package mk.finki.ukim.mk.demo.repository.jpa;

import mk.finki.ukim.mk.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findById(long id);
}

