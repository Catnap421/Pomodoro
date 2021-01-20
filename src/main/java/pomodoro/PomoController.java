package pomodoro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/pomo")
public class PomoController {

    @PostMapping
    public String startPomo(Model model){ // 사용자의 pomo 정보를 받아와야 함
        // 시시각각 변하는 데이터를 보내줄 수 없으므로, 사용자가 일시정지를 클릭하면 스레드를 잠시 중지시키자.

        long time = 1000 * 60 * 25; // 25분 - 이후 사용자에게 받아와야 할 값

        PomoTimer pomoTimer = new PomoTimer();
        pomoTimer.setTimer(25); // 몇 분 뒤 실행?

        log.info("make pomo");
        log.info("mek");
        return "home";
    }
}
