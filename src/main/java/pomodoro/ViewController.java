package pomodoro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class ViewController {
    @GetMapping
    public String viewHome(Model model){
        List<Pomo> pomos = Arrays.asList(
                new Pomo("Todo",15),
                new Pomo("Making Pomodoro Application", 25)
        );

        model.addAttribute("pomos", pomos);
        log.info("viewHome");
        return "home";
    }

}
