package mk.finki.ukim.mk.demo.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.model.EventBooking;
import mk.finki.ukim.mk.demo.model.Location;
import mk.finki.ukim.mk.demo.model.User;
import mk.finki.ukim.mk.demo.repository.jpa.EventRepository;
import mk.finki.ukim.mk.demo.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.demo.repository.jpa.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import mk.finki.ukim.mk.demo.model.enumerations.Role;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<User> users = null;
    public static List<Location> locations=null;

    public static List<Event> events;

    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final PasswordEncoder passwordEncoder;
    public DataHolder(UserRepository userRepository,PasswordEncoder passwordEncoder,LocationRepository locationRepository,EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.locationRepository=locationRepository;
        this.eventRepository = eventRepository;
    }

    @PostConstruct
    public void init() {

        users = new ArrayList<>();
        locations= new ArrayList<>();
        events=new ArrayList<>();
        if (this.userRepository.count() == 0) {
            users.add(new User("viki", passwordEncoder.encode("vz"), "Viki", "Zmejkoska", Role.ROLE_USER));
            users.add(new User("kiki", passwordEncoder.encode("kj"), "Kiki", "Jakovceska", Role.ROLE_USER));
            users.add(new User("admin", passwordEncoder.encode("admin"), "admin", "admin", Role.ROLE_ADMIN));
            this.userRepository.saveAll(users);
        }
        if(locationRepository.count()==0){
            locations.add(new Location("ohrid","123","50","novaGodina"));
            locations.add(new Location("skopje","456","20","prviMaj"));
            locationRepository.saveAll(locations);
        }

        if(eventRepository.count()==0){
            Event tmp= new Event("zabava","luda zurka",50);
            tmp.setLocation(locations.get(0));
            events.add(tmp);
            eventRepository.saveAll(events);
        }


    }
}
