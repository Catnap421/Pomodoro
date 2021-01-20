package pomodoro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class ViewController {
    @GetMapping
    public String viewHome(){
        log.info("viewHome");
        return "home";
    }
}
