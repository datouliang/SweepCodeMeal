package com.fh.controller.system.Specification;

import com.fh.controller.base.BaseController;
import com.fh.service.system.specification.SpecificationMapper;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by 大梁
 * Created Time 2017/10/27.
 */
@Controller
@RequestMapping(value="specification")
public class SpecificationController extends BaseController{

    String menuUrl = "specification/list.do"; //菜单权限
    @Resource(name="SpecificationService")
    private SpecificationMapper  specificationService;

    /**保存
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/save")
    public ModelAndView saveSpecification() throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"新增SPECIFICATION");
        if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        pd.put("SPECIFICATION_ID", this.get32UUID());	//主键
        specificationService.save(pd);
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }



}
