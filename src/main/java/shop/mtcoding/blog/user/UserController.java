package shop.mtcoding.blog.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final HttpSession session;

    //    조인
    @PostMapping("/join")
    public String join(UserRequest.JoinDTO requestDTO) {
        log.info("{}", requestDTO);

        userRepository.save(requestDTO);
        return "redirect:/loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }


//    로그인

    @PostMapping("/login")
    public String login(UserRequest.LoginDTO requestDTO) {
        log.info("{}", requestDTO);

        if (requestDTO.getUsername().length() < 3) {
            return "error/400";
        }

        User user = userRepository.findByUsernameAndPassword(requestDTO);
        if (user == null) {
            return "error/401";
        }
        session.setAttribute("sessionUser", user);

        return "redirect:/";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
