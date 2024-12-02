package mk.finki.ukim.mk.demo.service;

import mk.finki.ukim.mk.demo.model.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<Location> findAll();
     List<Location> find_by_ID(long id);
}
