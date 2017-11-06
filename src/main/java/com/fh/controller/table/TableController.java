package com.fh.controller.table;

import com.fh.controller.base.BaseController;
import com.fh.entity.table.Table;
import com.fh.service.table.impl.TableService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 桌号管理controller
 *
 * @author Administrator ON 2017/11/4
 **/
@Controller
@RequestMapping("/table")
public class TableController extends BaseController{
    @Resource(name = "tableService")
    private TableService tableService;

    @RequestMapping(value= "")
    public ModelAndView table() throws Exception {
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData() ;
        pd = this.getPageData();
        List<PageData> tableList = tableService.findList(pd);
        mv.addObject("tableList", tableList);
        mv.addObject("QX", Jurisdiction.getHC());
        mv.setViewName("table/tableList");
        return mv;
    }
    @RequestMapping("/form")
    public ModelAndView form(@RequestParam String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Table table = tableService.findForId(id);
        mv.addObject("table", table);
        mv.setViewName("table/tableForm");
        return mv;
    }
    @RequestMapping(value="/save")
    public String save(Table table) throws Exception {
        if (StringUtils.isNotEmpty(table.getTABLE_ID())) {
            tableService.update(table);
        }
        return "redirect:/table";
    }
}
