package inje.web.project;

import inje.bim.other.client.service.service.ServiceInterface;
import inje.security.LoginUserDetail;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ProjectController
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
public class ProjectController {
    @Autowired
    private ServiceInterface serviceInterfaceService;

    /**
     * 사용자 프로젝트 조회
     * bimviews -> Project -> Show Projects
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/project/serviceInterface/getUsersProjects.do")
    public String getUsersProjects(ModelMap model, @AuthenticationPrincipal LoginUserDetail loginUserDetail) throws ServiceException, PublicInterfaceNotFoundException {
        List<SProject> result = serviceInterfaceService.getUsersProjects(loginUserDetail.getSuser().getOid());

        model.addAttribute("result", result);
        return "project/getUsersProjects";
    }

    /**
     * 프로젝트 상세
     * bimviews -> Project -> Show Projects -> project 클릭
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/project/projectDetailView.do")
    public String projectDetailView(ModelMap model, @RequestParam("oid") Long aLong) throws ServiceException, PublicInterfaceNotFoundException {
        model.addAttribute("oid", aLong);
        return "project/projectDetailView";
    }

    /**
     * 사용자 프로젝트에 모든 revison 조회
     * bimviews -> Project -> Show Projects -> 프로젝트명 클릭 -> Revisions
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/project/serviceInterface/getAllRevisionsOfProject.do")
    public String getUsersProjects(ModelMap model, @RequestParam("oid") Long aLong) throws ServiceException, PublicInterfaceNotFoundException {
        List<SRevision> result = serviceInterfaceService.getAllRevisionsOfProject(aLong);

        model.addAttribute("result", result);
        return "project/serviceInterface/getAllRevisionsOfProject";
    }
}