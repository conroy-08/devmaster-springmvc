<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<c:url value="//shoppingCartConfirm" var="saveCustomer"/>
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
				<div class="page-title"> Danh sách giỏ hảng  </div>	
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			
				<div class="table-responsive">
				<form action='<c:url  value="/updateCart"/>'>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Tên sản shẩm</th>
								<th>Mô tả ngắn</th>
								<th>Hình ảnh</th>
								<th>Số lượng</th>
								<th>Giá sản phẩm</th>
								<th>Tổng giá sản phẩm</th>
								<th>Thao tác</th>
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
									<td>     
									          <input class="btn btn-primary" style="padding: .165rem .25rem; "  type="submit" value="update"/>
									   
									          <c:url var="deleteLink" value="/deleteCart">
                                                        <c:param name="id" value="${cart.product.id}" />
                                              </c:url>
							                <a class="btn btn-sm btn-primary" data-toggle="tooltip"  onclick="if (!(confirm('Bạn chắc chắn muốn xóa sản phẩm này  ?'))) return false"
                                                 title='Xóa ' href='${deleteLink}'>Delete</i>
                                           </a> 
									</td>
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
		<!-- /.row -->
		<div class="row">
		      <c:if test="${ empty listCart}">
            
		             <div class="col-md-3 mb-4">
						<a class="btn btn-primary"  role="button" data-toggle="tooltip" title='Mua hàng ' href='<c:url value="/trang-chu" />' >Mua hàng</a>
					</div>
             </c:if>
              <c:if test="${not empty listCart }">
                    <div class="col-md-3 mb-4">
				       <a class="btn btn-primary"  role="button" data-toggle="tooltip" title='Mua tiếp ' href='<c:url value="/trang-chu" />' > Mua tiếp </a>
			         </div>
              </c:if>
			
			<div class="col-md-6 mb-7">
			    
			</div>
			
             <c:if test="${ empty listCart}">
                 <div class="col-md-3 mb-4"></div> 
             
             </c:if>
              <c:if test="${not empty listCart }">
                    <div class="col-md-3 mb-4">
			           
			           <a class="btn btn-primary"  role="button" data-toggle="tooltip" 
			           title='Nhập thông thanh toán' href='<c:url value="/cartConfirm" />' >Nhập thông thanh toán</a>
			        </div> 
              </c:if>
		</div>
	</div>
	<!-- /.container -->


</body>
<
</html>