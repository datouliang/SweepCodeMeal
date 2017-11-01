<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../system/index/top.jsp"%>

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

						<form  action="<%=basePath%>column/save" name="Column" id="columnForm" method="post" class="form-horizontal">
							<input type="hidden" name="COLUMN_ID" value="${column.COLUMN_ID }"/>
							<input type="hidden" name="CREATE_DATE" value="${column.CREATE_DATE }">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 名称 :</label>
								<div class="col-sm-9">
									<input type="text" name="NAME" id="name" value="${column.NAME }" placeholder="这里输入栏目名称" class="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 权重 :</label>
								<div class="col-sm-9">
									<input type="text" name="WEIGHT" id="weight" value="${column.WEIGHT }" placeholder="这里输入栏目权重" class="col-xs-10 col-sm-5" />
								</div>
							</div>
							
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="goback('${MENU_ID}');">取消</a>
								</div>
							</div>
							<div class="hr hr-18 dotted hr-double"></div>
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


		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(top.hangge());
		
		//返回
		function goback(MENU_ID){
			top.jzts();
			window.location.href="<%=basePath%>column/list";
		}
		
		//保存
		function save(){
			if($("#name").val()==""){
				$("#name").tips({
					side:3,
		            msg:'请输入栏目名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#name").focus();
				return false;
			}
			if($("#weight").val()==""){
				$("#weight").tips({
					side:3,
		            msg:'请输入栏目权重',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#weight").focus();
				return false;
			}
			$("#columnForm").submit();
		}
	</script>


</body>
</html>