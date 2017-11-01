package com.fh.controller.column;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fh.controller.base.BaseController;
import com.fh.entity.column.Column;
import com.fh.service.column.impl.ColumnService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
@RequestMapping("/column")
public class columnController extends BaseController {
	@Resource(name="columnService")
	ColumnService columnService;

	@RequestMapping(value= {"/list", ""})
	public String list(HttpServletRequest request) {
		PageData pd = new PageData();
		String MENU_ID = (null == pd.get("MENU_ID") || "".equals(pd.get("MENU_ID").toString()))?"0":pd.get("MENU_ID").toString();
		pd = this.getPageData();
		List<Column> columnList = columnService.findList(new Column());
		request.setAttribute("columnList", columnList);
		request.setAttribute("MENU_ID", MENU_ID);
		request.setAttribute("QX", Jurisdiction.getHC());
		request.setAttribute("MSG", null == pd.get("MSG")?"list":pd.get("MSG").toString());
				
		return "column/columnList";
	}
	
	@RequestMapping("/form")
	public String add(@RequestParam(required = false) String id, HttpServletRequest request) {
		PageData pd = new PageData();
		String MENU_ID = (null == pd.get("MENU_ID") || "".equals(pd.get("MENU_ID").toString()))?"0":pd.get("MENU_ID").toString();
		pd = this.getPageData();
		if (id != null || id != "") {
			Column column = columnService.findColumn(id);
			request.setAttribute("column", column);
		}
		return "column/columnForm";
	}
	
	@RequestMapping("/save")
	public String save(HttpServletRequest request) {
		Column column = new Column();
		column.setCOLUMN_ID(request.getParameter("COLUMN_ID"));
		column.setNAME(request.getParameter("NAME"));
		column.setWEIGHT(request.getParameter("WEIGHT"));
		if (column.getCOLUMN_ID() == null || column.getCOLUMN_ID() == "") {  
			//保存数据
			//保存当前时间
			Date date = new Date();
			column.setCOLUMN_ID(this.get32UUID());
			column.setCREATE_DATE(date);
			columnService.addColumn(column);
		} else {
			//修改数据
			columnService.updateColumn(column);
		}

		return "redirect:/column/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		columnService.deleteColumn(id);
		return "redirect:/column/list";
	}
}
