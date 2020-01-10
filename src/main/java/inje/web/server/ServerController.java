package inje.web.server;

import inje.bim.other.client.service.model.SUserSearch;
import inje.bim.other.client.service.service.ServiceInterface;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

/**
 * ServerController
 *
 * @author  유신일
 * @since	2019. 09. 19.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *      수정일        수정자    수정내용
 *  -------------  ------   ------
 *  2019. 09. 19.   유신일    최초 생성
 *  </pre>
 */
@Controller
public class ServerController {
    @Autowired
    private ServiceInterface serviceInterfaceService;

    /**
     * 모든 사용자 조회
     * bimviews -> Server -> List Users
     *
     * @param model
     * @param searchSUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/server/serviceInterface/getAllUsers.do")
    public String getAllUsers(ModelMap model, SUserSearch searchSUser) throws ServiceException, PublicInterfaceNotFoundException {
        List<SUser> result = serviceInterfaceService.getAllUsers(searchSUser);

        model.addAttribute("result", result);
        model.addAttribute("searchSUser", searchSUser);
        return "server/serviceInterface/getAllUsers";
    }

    /**
     * 사용자 상세 조회
     * bimviews -> Server -> List Users -> Name 클릭
     *
     * @param model
     * @param searchSUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/server/serviceInterface/userDetail.do")
    public String userDetail(ModelMap model, SUserSearch searchSUser) throws ServiceException, PublicInterfaceNotFoundException {
        Optional<SUser> result = serviceInterfaceService.userDetail(searchSUser.getOid());

        //model.addAttribute("result", result);
        model.addAttribute("searchSUser", searchSUser);
        return "server/serviceInterface/userDetailView";
    }

    /**
     * 사용자 추가 화면
     * bimviews -> Server -> List Users -> Add user 클릭
     *
     * @param model
     * @param searchSUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/server/serviceInterface/addUserView.do")
    public String addUserView(ModelMap model, SUser sUser, SUserSearch searchSUser) throws ServiceException, PublicInterfaceNotFoundException {
        model.addAttribute("sUser", sUser);
        model.addAttribute("searchSUser", searchSUser);
        return "server/serviceInterface/addUserView";
    }

    /**
     * 사용자 상세 화면
     * bimviews -> Server -> List Users -> Name 클릭
     *
     * @param model
     * @param searchSUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/server/serviceInterface/userDetailView.do")
    public String userDetailView(ModelMap model, SUserSearch searchSUser) throws ServiceException, PublicInterfaceNotFoundException {
        model.addAttribute("searchSUser", searchSUser);
        Optional<SUser> result = serviceInterfaceService.userDetail(searchSUser.getOid());

        if(!result.isPresent()) {
            return "redirect:server/serviceInterface/getAllUsers";
        } else {
            model.addAttribute("sUser", result.get());
            return "server/serviceInterface/userDetailView";
        }
    }

}