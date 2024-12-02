package mk.finki.ukim.mk.demo.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private double popularityScore;

    @ManyToOne()
    private Location location;

    boolean liked;

    public Event(String name, String description, double popularityScore) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.liked = true;
    }
    public boolean isLiked() {
        return liked;
    }
    public void like(){
        this.popularityScore+=5;
        liked = false;
    }

    /*public Event(String name, String description, double popularityScore) {
        this.id = (long) (Math.random() * 1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
    }*/


}
