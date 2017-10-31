<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
	<link rel="stylesheet" type="text/css" href="plugins/webuploader/webuploader.css" />
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="variety/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="VARIETY_ID" id="VARIETY_ID" value="${pd.VARIETY_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注1:</td>
								<td><input type="text" name="VARIETY_ID" id="VARIETY_ID" value="${pd.VARIETY_ID}" maxlength="100" placeholder="这里输入备注1" title="备注1" style="width:98%;"/></td>
							</tr>--%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">菜品名称:</td>
								<td><input type="text" name="NAME" id="NAME" value="${pd.NAME}" maxlength="255" placeholder="请输入菜品名称" title="菜品名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">所属类别:</td>
								<td><input type="text" name="COLUMN_ID" id="COLUMN_ID" value="${pd.COLUMN_ID}" maxlength="100" placeholder="请输入所属类别" title="所属类别" style="width:98%;"/></td>
							</tr>
							<td style="width:79px;text-align: right;padding-top: 13px;">角色:</td>
							<td id="juese">
								<select class="chosen-select form-control" name="ROLE_ID" id="role_id" data-placeholder="请选择角色" style="vertical-align:top;" style="width:98%;" >
									<option value=""></option>
									<c:forEach items="${roleList}" var="role">
										<option value="${role.ROLE_ID }" <c:if test="${role.ROLE_ID == pd.ROLE_ID }">selected</c:if>>${role.ROLE_NAME }</option>
									</c:forEach>
								</select>
							</td>
							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注4:</td>
								<td><input class="span10 date-picker" name="CREATE_TIME" id="CREATE_TIME" value="${pd.CREATE_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="备注4" title="备注4" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注5:</td>
								<td><input class="span10 date-picker" name="UPDATE_TIME" id="UPDATE_TIME" value="${pd.UPDATE_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="备注5" title="备注5" style="width:98%;"/></td>
							</tr>--%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">价格:</td>
								<td><input type="number" name="PRICE" id="PRICE" value="${pd.PRICE}" maxlength="32" placeholder="请输入价格" title="价格" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">照片:</td>
								<td>
									<input type="hidden" name="IMAGE" id="IMAGE" value="${pd.IMAGE}"/>
									<div id="uploader-demo">
										<!--用来存放item-->
										<div id="fileList" class="uploader-list"></div>
										<div id="filePicker">选择图片</div><a id="delete" title="删除" class="btn btn-sm btn-danger" onclick="makeAll('确定要删除选中的数据吗?');"><i class="ace-icon fa fa-trash-o bigger-120"></i></a>
									</div>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">排序:</td>
								<td><input type="text" name="SORT" id="SORT" value="${pd.SORT}" maxlength="100" placeholder="数字越大，排名越前" title="排序" style="width:98%;"/></td>
							</tr>
						<%--	<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注9:</td>
								<td><input type="text" name="USER_ID" id="USER_ID" value="${pd.USER_ID}" maxlength="100" placeholder="这里输入备注9" title="备注9" style="width:98%;"/></td>
							</tr>--%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">详情:</td>
								<td><input type="text" name="INFO" id="INFO" value="${pd.INFO}" maxlength="1000" placeholder="请输入详情" title="详情" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">规格:</td>
								<td name="ss">
									<input type="hidden" name="SPECIFICATION" id="SPECIFICATION" value="${pd.SPECIFICATION}" maxlength="100" placeholder="请添加规格" title="规格" style="width:98%;"/>
									<a class="btn btn-xs btn-success" title="添加" onclick="addSpecification(this);" style="float:right;">
										添加
									</a>
									<c:forEach items="${pd.specifications}" var="specification">
										<div>
											规格:<input type="text" id="div_specification" class="a" placeholder="请输入规格" style="width:30%" value="${specification.NAME}">
											价格:<input type="text" id="div_price" class="b" placeholder="请输入价格" style="width:30%" value="${specification.PRICE}">
											<a style="cursor:pointer;" class="red"onclick="del(this);" title="删除">
												<i class="ace-icon fa fa-trash-o bigger-130"></i>
											</a>
										</div>
									</c:forEach>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="plugins/webuploader/webuploader.js"></script>
	<script type="text/javascript" src="plugins/variety/imagUpload.js"></script>
		<script type="text/javascript">
		$(top.hangge());

		var  specificationList = [];
		var  priceList = [];

		//保存
		function save(){
			if($("#NAME").val()==""){
				$("#NAME").tips({
					side:3,
		            msg:'请输入菜品名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#NAME").focus();
			return false;
			}
			if($("#COLUMN_ID").val()==""){
				$("#COLUMN_ID").tips({
					side:3,
		            msg:'请输入所属类别',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#COLUMN_ID").focus();
			return false;
			}
			if($("#PRICE").val()==""){
				$("#PRICE").tips({
					side:3,
		            msg:'请输入价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PRICE").focus();
			return false;
			}
			if($("#IMAGE").val()==""){
				$("#IMAGE").tips({
					side:3,
		            msg:'请插入图片',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#IMAGE").focus();
			return false;
			}
			if($("#SORT").val()==""){
				$("#SORT").tips({
					side:3,
		            msg:'请输入排序大小',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SORT").focus();
			return false;
			}

			if($("#INFO").val()==""){
				$("#INFO").tips({
					side:3,
		            msg:'请输入详情',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INFO").focus();
			return false;
			}
			forEach();
			$("#SPECIFICATION").val(specificationList);

			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			$("#delete").hide();
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});

		//批量操作
		function makeAll(msg){
			if(confirm(msg)){
				var div = document.getElementById("fileList");
				while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
				{
					div.removeChild(div.firstChild);
				}
				var PATH = $("#IMAGE").val();
				alert(PATH);
				$.ajax({
					type: "POST",
					url: '<%=basePath%>variety/deltp.do',
					data: {PATH:PATH},
					dataType:'json',
					//beforeSend: validateData,
					cache: false,
					success: function(data){
						$("#filePicker").toggle();
						$("#delete").toggle();
						alert("删除成功");
					},
					error: function(data){
						$("#filePicker").toggle();
						$("#delete").toggle();
						alert("删除成功");
					}
				});
			}
		}
		function addSpecification(add){
				var $li = $( '<div>' +
					"规格:"+
					'<input type="text" id="div_specification" class="a" placeholder="请输入规格" style="width:30%">'+
					"价格:"+
					'<input type="text" id="div_price" class="b" placeholder="请输入价格" style="width:30%">'+
					'<a style="cursor:pointer;" class="red"onclick="del(this);" title="删除">'+
				    '<i class="ace-icon fa fa-trash-o bigger-130"></i>'+
					'</a>'+
					'</div>'
			);
			$(add).parent().append($li);

		}
		//删除规格
		function del(object){
				$(object).parent().remove();
		}
		//遍历规格和价格
		function forEach(){
			var ss = $(".a"); //规格
			var pp = $(".b"); //价格
			for(var i=0;i<ss.length;i++){
				var s = $(ss[i]).val();
				var p = $(pp[i]).val();
				var specification = s+","+p;
				specificationList.push(specification);
			}
			console.log(specificationList);

		}


		</script>
</body>
</html>