package example.testspringboot;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    private BoardRepository boardRepository;

    public AppController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

   @GetMapping("health")
   public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok().body("success check");
   }

   @GetMapping("boards")
    public ResponseEntity<List<Board>> getBoards(){
        Board board = new Board("test title", "test content");
        boardRepository.save(board);

        //조회
       List<Board> boards = boardRepository.findAll();
       return ResponseEntity.ok().body(boards);
   }

}
