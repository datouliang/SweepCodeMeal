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

						<form  action="<%=basePath%>order/save" name="Order" id="orderForm" method="post" class="form-horizontal">
							<input type="hidden" name="ID" value="${order.ID }"/>
							<input type="hidden" name="PAGE" value="${order.PAGE }">
							<input type="hidden" name="NUMBER" value="${order.NUMBER }">
							<input type="hidden" name="NAME" value="${order.NAME }">
							<input type="hidden" name="STATUS" value="${order.STATUS }">
							<input type="hidden" name="DE_FLAGE" value="${order.DE_FLAGE }">
							<input type="hidden" name="REMARK" value="${order.REMARK }">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 价格 :</label>
								<div class="col-sm-9">
									<input type="text" name="TOTAL_PRICE" id="TOTAL_PRICE" value="${order.TOTAL_PRICE }" placeholder="这里输入价格" class="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 桌号 :</label>
								<div class="col-sm-9">
									<input type="text" name="TABLE_NUMBER" id="TABLE_NUMBER" value="${order.TABLE_NUMBER }" placeholder="这里输入栏目桌号" class="col-xs-10 col-sm-5" />
								</div>
							</div>
							
							
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="goback();">取消</a>
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
		function goback(){
			top.jzts();
			window.location.href="<%=basePath%>order";
		}
		
		//保存
		function save(){
			if($("#TOTAL_PRICE").val()==""){
				$("#TOTAL_PRICE").tips({
					side:3,
		            msg:'请输入价格',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TOTAL_PRICE").focus();
				return false;
			}
			if($("#TABLE_NUMBER").val()==""){
				$("#TABLE_NUMBER").tips({
					side:3,
		            msg:'请输入桌号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TABLE_NUMBER").focus();
				return false;
			}
			$("#orderForm").submit();
		}
	</script>


</body>
</html>