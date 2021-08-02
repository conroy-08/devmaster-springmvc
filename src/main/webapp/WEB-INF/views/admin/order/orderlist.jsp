<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách mua hàng</title>
</head>

<body>
	<div class="main-content">



		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href='<c:url  value="/quan-tri/trang-chu" />'>Trang chủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group"></div>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>Họ và tên</th>
												<th>Địa chỉ</th>
												<th>Số điện thoại</th>
												<th>Email</th>
												<th>Ngày mua</th>
												
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${order.listResult }" var="item">
												<tr>
													<td>${item.customerName}</td>
													<td>${item.customerAddress}</td>
													<td>${item.customerPhone}</td>
													<td>${item.customerEmail}</td>
                                                    <td>${item.orderDate }</td>
                                                   
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.main-content -->



</body>
</html>