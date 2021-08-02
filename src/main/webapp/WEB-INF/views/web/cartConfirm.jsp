<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<c:url value="/shoppingCartConfirm" var="saveCustomer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
         <title>Danh sách mua hàng</title>
</head>

<body>
	<!-- Page Content -->
	<div class="container">

		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				<div class="page-title">Nhập thông tin khách hàng </div>
				
	<form:form action="${saveCustomer }" modelAttribute="customer" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="customerName"/></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="customerAddress"/></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="customerEmail"/></td>
			</tr>
			<tr>
				<td>PhoneNumber :</td>
				<td><form:input path="customerPhone"/></td>
			</tr>
			<tr>
			    <td></td> 
				<td colspan="2"><input type="submit" value="Thanh Toán "/></td>				
			</tr>
			
		</table>
	</form:form>
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			
				<div class="table-responsive">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Tên sản shẩm</th>
								<th>Mô tả ngắn</th>
								<th>Hình ảnh</th>
								<th>Số lượng</th>
								<th>Giá sản phẩm</th>
								<th>Tổng giá sản phẩm</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listCart}" var="cart">
								<tr>
									<td>${cart.product.name }</td>
									<td>${cart.product.shortDescription}</td>
									<td>${cart.product.thumbnail}</td>
									<td><input type="text" value="${cart.quantity }" name="quantity"/></td>
									<td>${cart.product.price}</td>
									<td>${cart.quantity*cart.product.price }</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5">Tổng cộng :</td>
								<td>${totalAmout}</td>
							</tr>
						</tbody>
					</table>
                </form>
				</div>
		
		</div>
	</div>
	<!-- /.container -->


</body>
<
</html>