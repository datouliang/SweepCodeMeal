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
	<script type="text/javascript">
		//刷新ztree
		function parentReload(){
			if(null != ${MSG} && 'change' == ${MSG}){
				parent.location.href="<%=basePath%>menu/listAllMenu.do?MENU_ID="+${MENU_ID};
			}else{
				//什么也不干
			}
		}
		parentReload();
	</script>
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

							<table id="dynamic-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center">订单页</th>
										<th class='center'>订单号</th>
										<th class='center'>总价格</th>
										<th class='center'>桌号</th>
										<th class='center'>顾客姓名</th>
										<th class='center'>备注</th>
										<th class='center' style="width: 150px;">操作</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${orderList}" var="order" varStatus="vs">
									<tr>
										<td class='center'>${order.PAGE }</td>
										<td class='center'>${order.NUMBER }</td>
										<td class='center'>${order.TOTAL_PRICE }</td>
										<td class='center'>${order.TABLE_NUMBER }</td>
										<td class='center'>${order.NUMBER }</td>
										<td class='center'>${order.REMARK }</td>
										<td class='center'>
											<c:choose>
												<c:when test="${order.STATUS == '0' }">
													<a href="javascript:pay('${order.ID }')">支付</a>
												</c:when>
												<c:otherwise>
													<a href="javascript:">已支付</a>
												</c:otherwise>
											</c:choose>
											<a href="javascript:update(${order.ID })">修改</a>
										</td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							
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
	<!-- 删除时确认窗口 -->
	<script src="static/ace/js/bootbox.js"></script>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(document).ready(function(){
			top.hangge();
		});	
		
		//支付订单
		function pay(ID) {
			bootbox.confirm("确定要支付吗?", function(result) {
				if(result) {
					window.location.href="<%=basePath%>order/pay?id="+ID;
					}
				})
		}
		
		
		//修改菜单
		function update(ID){
			top.jzts();
			window.location.href="<%=basePath%>order/form?id="+ID;
		};
		
		//删除
		function delmenu(MENU_ID){
			bootbox.confirm("确定要删除此菜单吗?", function(result) {
				if(result) {
					window.location.href="<%=basePath%>column/delete?id="+MENU_ID;
				}
			});
		}
	</script>


</body>
</html>