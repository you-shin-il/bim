package inje.bim.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterfaceAdminController {
    @RequestMapping("/admin/index")
    public String index() {
        return "test";
    }
}