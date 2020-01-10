package inje.web.user;

import inje.bim.administrator.client.auth.client.AdminAuthInterfaceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private AdminAuthInterfaceClient adminAuthInterfaceClient;

    @RequestMapping("/user/passwordResetPopup.do")
    public String passwordResetPopup() {
        return "user/passwordResetPopup";
    }

    @RequestMapping("/user/passwordReset.do")
    @ResponseBody
    public String passwordReset(@RequestParam("username") String username) {
        adminAuthInterfaceClient.requestPasswordChange(username, "localhost:8888", false);
        return "비밀번호 변경";
    }
}