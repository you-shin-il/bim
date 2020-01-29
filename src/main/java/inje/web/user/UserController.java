package inje.web.user;

import inje.bim.administrator.client.auth.client.AdminAuthInterfaceClient;
import inje.bim.administrator.client.service.AdminServiceInterface;
import inje.bim.administrator.client.service.client.AdminServiceInterfaceClient;
import inje.bim.dto.SUserDTO;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private AdminAuthInterfaceClient adminAuthInterfaceClient;

//    @Autowired
//    private AdminServiceInterfaceClient adminServiceInterfaceClient;

    @Autowired
    private AdminServiceInterface adminServiceInterface;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/user/passwordResetPopup.do")
    public String passwordResetPopup() {
        return "user/passwordResetPopup";
    }

    @RequestMapping("/user/joinPopup.do")
    public String joinPopup() {
        return "user/joinPopup";
    }

    @RequestMapping("/user/addUserPopup.do")
    public String addUserPopup(Model model) {
        List<SUserType> sUserTypes = Arrays.asList(SUserType.ADMIN, SUserType.USER, SUserType.READ_ONLY);
        model.addAttribute("sUserTypes", sUserTypes);
        return "user/addUserPopup";
    }

    @RequestMapping("/user/addUserWithPassword.do")
    @ResponseBody
    public SUserDTO addUserWithPassword(@RequestBody @Valid SUserDTO sUserDTO)  throws ServiceException {
        SUser addSUser = new SUser();
        addSUser.setUsername(sUserDTO.getUsername());
        addSUser.setName(sUserDTO.getName());
        addSUser.setUserType(SUserType.valueOf(sUserDTO.getsUserType()));

        SUser createSUser = adminServiceInterface.addUserWithPassword(addSUser, sUserDTO.getPassword(), false, "");
        SUserDTO result = modelMapper.map(createSUser, SUserDTO.class);

        return result;
    }

    @RequestMapping("/user/passwordReset.do")
    @ResponseBody
    public String passwordReset(@RequestParam("username") String username) {
        adminAuthInterfaceClient.requestPasswordChange(username, "localhost:8888", false);
        return "비밀번호 변경";
    }

    @RequestMapping("/user/resetUrl.do")
    public void resetUrl(RequestParam requestParam) {
        System.out.println("/user/resetUrl.do");
    }
}