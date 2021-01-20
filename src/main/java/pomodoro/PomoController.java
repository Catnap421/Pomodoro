package pomodoro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/pomo")
public class PomoController {
    private PomoTimer pomoTimer; // 싱글톤 패턴 적용해야함

    @PostMapping
    @ResponseBody
    public void startPomo(Model model){ // 사용자의 pomo 정보를 받아와야 함

        long time = 1000 * 60 * 25; // 25분 - 이후 사용자에게 받아와야 할 값

        pomoTimer = new PomoTimer();
        pomoTimer.setTimer(25); // 몇 분 뒤 실행?

        log.info("make pomo");
        log.info("mek");
        return ;
    }

    @GetMapping
    @ResponseBody
    public void pausePomo(){
        pomoTimer.pauseTimer();
        return;
    }
}
