package inje.web.openApi;

import inje.openApi.model.OpenApiRequestVO;
import inje.openApi.model.OpenApiResponseVO;
import inje.openApi.service.OpenApiService;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.PublicInterfaceNotFoundException;
import org.bimserver.shared.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * OpenApiController
 *
 * @author  유신일
 * @since	2019. 10. 19.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *      수정일        수정자    수정내용
 *  -------------  ------   ------
 *  2019. 10. 19.   유신일    최초 생성
 *  </pre>
 */
@Controller
public class OpenApiController {
    @Autowired
    private OpenApiService openApiService;

    /**
     * 계약현황에 대한 물품 조회
     *
     * @param model
     * @param openApiRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/openapi/cntrctInfo/cntrctInfoListThng.do")
    public String cntrctInfoListThng(ModelMap model, @ModelAttribute OpenApiRequestVO openApiRequestVO) throws ServiceException, PublicInterfaceNotFoundException {
        OpenApiResponseVO result = openApiService.get(openApiRequestVO, "getCntrctInfoListThng");

        model.addAttribute("result", result);
        model.addAttribute("openApiRequestVO", openApiRequestVO);

        return "openapi/cntrctInfo/cntrctInfoListThng";
    }

    /**
     * 나라장터 계약현황에 대한 물품 조회
     *
     * @param model
     * @param openApiRequestVO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/openapi/cntrctInfo/cntrctInfoListThngPPSSrch.do")
    public String cntrctInfoListThngPPSSrch(ModelMap model, @ModelAttribute OpenApiRequestVO openApiRequestVO) throws ServiceException, PublicInterfaceNotFoundException {
        OpenApiResponseVO result = openApiService.get(openApiRequestVO, "getCntrctInfoListThngPPSSrch");

        model.addAttribute("result", result);
        model.addAttribute("openApiRequestVO", openApiRequestVO);

        return "openapi/cntrctInfo/cntrctInfoListThngPPSSrch";
    }
}