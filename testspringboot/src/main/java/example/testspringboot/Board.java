package example.testspringboot;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="boards")
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public Board(){}

    public Board(String title, String content){
        this.title = title;
        this.content=content;
    }
}
