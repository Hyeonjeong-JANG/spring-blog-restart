package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.mtcoding.blog.user.User;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final HttpSession session;
    private final BoardRepository boardRepository;

    @GetMapping({"/", "/board"})
    public String index(HttpServletRequest request) {
        List<Board> boardList = boardRepository.findAll();
       request.setAttribute("boardList", boardList);

        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}") // 1이 프라이머리키 -> 뭐든 넣어도 실행시키려면 변수화시켜서 {}
    public String detail(@PathVariable int id, HttpServletRequest request) {
//        System.out.println("id : "+id);
//        // body 데이터가 없으면 유효성 검사할 필요 없음
//        BoardResponse.DetailDTO reponseDTO = boardRepository.findById(id);
//
//        request.setAttribute("board", responseDTO);
        return "board/detail";
    }
}
