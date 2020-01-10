package inje.web.join;

import inje.model.PortalUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController {
    @RequestMapping("/join/joinForm.do")
    public String joinForm() {
        return "/join/joinForm";
    }

    @RequestMapping("/join/join.do")
    public String join(@ModelAttribute PortalUser portalUser) {
        return "redirect:/main.do";
    }
}