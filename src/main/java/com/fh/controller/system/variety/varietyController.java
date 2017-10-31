package com.fh.controller.system.variety;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.specification.SpecificationMapper;
import com.fh.service.system.variety.VarietyMapper;
import com.fh.util.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 大梁
 * Created Time 2017/10/26.
 */
@Controller
@RequestMapping(value = "/variety")
public class varietyController extends BaseController{

    String menuUrl = "variety/list.do"; //菜单地址(权限用)
    @Resource(name="varietyService")
    private VarietyMapper varietyService;
    @Resource(name="SpecificationService")
    private SpecificationMapper specificationService;


    /**保存
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/save")
    public ModelAndView save() throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"新增VARIETY");
        if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
        String VARIETY_ID =this.get32UUID();
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        String str = pd.get("SPECIFICATION").toString();
        String[] strs = str.split(",");
        for(int i=0;i<strs.length;i++){
            System.out.println(strs[i]);
            i= i+1;
            PageData spd = new PageData();
            spd.put("SPECIFICATION_ID",this.get32UUID());
            spd.put("NAME",strs[i]);
            spd.put("VARIETY_ID",VARIETY_ID);
            spd.put("CREATE_TIME",new Date());
            spd.put("UPDATE_TIME",new Date());
            spd.put("PRICE",Double.valueOf(strs[i]).doubleValue());
            specificationService.save(spd);
        }
        pd.put("VARIETY_ID", VARIETY_ID);	//主键
        pd.put("CREATE_TIME",new Date());
        pd.put("UPDATE_TIME",new Date());
        varietyService.save(pd);
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }

    /**删除
     * @param out
     * @throws Exception
     */
    @RequestMapping(value="/delete")
    public void delete(PrintWriter out) throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"删除VARIETY");
        if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
        PageData pd = new PageData();
        pd = this.getPageData();
        varietyService.delete(pd);
        out.write("success");
        out.close();
    }

    /**修改
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/edit")
    public ModelAndView edit() throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"修改VARIETY");
        if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        varietyService.edit(pd);
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }

    /**列表
     * @param page
     * @throws Exception
     */
    @RequestMapping(value="/list")
    public ModelAndView list(Page page) throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"列表VARIETY");
        //if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        String keywords = pd.getString("keywords");				//关键词检索条件
        if(null != keywords && !"".equals(keywords)){
            pd.put("keywords", keywords.trim());
        }
        page.setPd(pd);
        List<PageData>	varList = varietyService.list(page);	//列出VARIETY列表
        mv.setViewName("variety/variety_list");
        mv.addObject("varList", varList);
        mv.addObject("pd", pd);
        mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
        return mv;
    }

    /**去新增页面
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/goAdd")
    public ModelAndView goAdd()throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.setViewName("variety/variety_edit");
        mv.addObject("msg", "save");
        mv.addObject("pd", pd);
        return mv;
    }

    /**去修改页面
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/goEdit")
    public ModelAndView goEdit()throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        PageData spd = new PageData();
        pd = this.getPageData();
        String VARIETY_ID = pd.get("VARIETY_ID").toString();
        spd.put("VARIETY_ID",VARIETY_ID);
        List<PageData> specifications = specificationService.findByFid(spd);
        if(specifications.size()>0){
            pd.put("specifications",specifications);
        }
        pd = varietyService.findById(pd);	//根据ID读取
        mv.setViewName("variety/variety_edit");
        mv.addObject("msg", "edit");
        mv.addObject("pd", pd);
        return mv;
    }

    /**批量删除
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/deleteAll")
    @ResponseBody
    public Object deleteAll() throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"批量删除VARIETY");
        if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
        PageData pd = new PageData();
        Map<String,Object> map = new HashMap<String,Object>();
        pd = this.getPageData();
        List<PageData> pdList = new ArrayList<PageData>();
        String DATA_IDS = pd.getString("DATA_IDS");
        if(null != DATA_IDS && !"".equals(DATA_IDS)){
            String ArrayDATA_IDS[] = DATA_IDS.split(",");
            varietyService.deleteAll(ArrayDATA_IDS);
            pd.put("msg", "ok");
        }else{
            pd.put("msg", "no");
        }
        pdList.add(pd);
        map.put("list", pdList);
        return AppUtil.returnObject(pd, map);
    }

    /**导出到excel
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/excel")
    public ModelAndView exportExcel() throws Exception{
        logBefore(logger, Jurisdiction.getUsername()+"导出VARIETY到excel");
        if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
        ModelAndView mv = new ModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        Map<String,Object> dataMap = new HashMap<String,Object>();
        List<String> titles = new ArrayList<String>();
        //1
        titles.add("姓名");	//2
        titles.add("所属类别");	//3
        titles.add("创建时间");	//4
        //5
        titles.add("价格");	//6
        titles.add("图片");	//7
        titles.add("排序");	//8
        //9
        titles.add("详情");	//10
        titles.add("规格");	//11
        dataMap.put("titles", titles);
        List<PageData> varOList = varietyService.listAll(pd);
        List<PageData> varList = new ArrayList<PageData>();
        for(int i=0;i<varOList.size();i++){
            PageData vpd = new PageData();
              //1
            vpd.put("var2", varOList.get(i).getString("NAME"));	    //2
            vpd.put("var3", varOList.get(i).getString("COLUMN_ID"));	    //3
            vpd.put("var4", varOList.get(i).getString("CREATE_TIME"));	    //4
            //5
            vpd.put("var6", varOList.get(i).get("PRICE").toString());	//6
            vpd.put("var7", varOList.get(i).getString("IMAGE"));	    //7
            vpd.put("var8", varOList.get(i).getString("SORT"));	    //8
 	    //9
            vpd.put("var10", varOList.get(i).getString("INFO"));	    //10
            vpd.put("var11", varOList.get(i).getString("SPECIFICATION"));	    //11
            varList.add(vpd);
        }
        dataMap.put("varList", varList);
        ObjectExcelView erv = new ObjectExcelView();
        mv = new ModelAndView(erv,dataMap);
        return mv;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
    }

    /**保存规格
     * @param
     * @throws Exception
     */
    @RequestMapping(value="/saveSpecification")
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

    /**
     * 图片上传
     * */
    @ResponseBody
    @RequestMapping(value = "/imageSave",method = RequestMethod.POST)
    public Map<String,String> imageSave(@RequestParam(required=false) MultipartFile file) throws Exception{
        ModelAndView mv = this.getModelAndView();
        logBefore(logger, Jurisdiction.getUsername()+"新增图片");
        Map<String,String> map = new HashMap<String,String>();
        String  ffile = DateUtil.getDays(), fileName = "";
        PageData pd = new PageData();

            if (null != file && !file.isEmpty()) {
                String filePath = PathUtil.getClasspath() + Const.FILEPATHIMG + ffile;                //文件上传路径
                fileName = FileUpload.fileUp(file, filePath, this.get32UUID());                                //执行上传
            } else {
                System.out.println("上传失败");
            }
                                                      //文件名
            pd.put("IMAGE", ffile + "/" + fileName);                                //路径
            pd.put("CREATETIME", Tools.date2Str(new Date()));        //创建时间
                                          //备注
           /* Watermark.setWatemark(PathUtil.getClasspath() + Const.FILEPATHIMG + ffile + "/" + fileName);//加水印*/

        map.put("result", "ok");
        map.put("imagePath",ffile + "/" + fileName);
        return map;
    }

    /**删除图片
     * @param PATH
     * @throws Exception
     */
    @RequestMapping(value="/deltp")
    public void deltp(String PATH) throws Exception {
        if(Tools.notEmpty(PATH.trim())){//图片路径
            DelAllFile.delFolder(PathUtil.getClasspath()+ Const.FILEPATHIMG + PATH); 	//删除图片
        }
    }

}
