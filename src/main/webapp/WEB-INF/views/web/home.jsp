<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>

<body>

	<!-- Page Content -->
	<div class="container">

	
		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				<p class="text-white m-0">This call to action card is a great
					place to showcase some important information or display a clever
					tagline!</p>
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
		   <c:forEach var="item" items="${product.listResult}">
			<div class="col-md-4 mb-5">
				<div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${item.name}</h5>
                                    <!-- Product Shortdescription  -->
                                    <!-- Product price-->
                                     ${item.price} $
                                </div>
                            </div>
                            <!-- Product actions-->
                             <c:url var="addCart" value="/addCart">
                                  <c:param name="id" value="${item.id}" />
                              </c:url>
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href='${addCart}'>Buy now</a></div>
                            </div>
                        </div>
			</div>
			</c:forEach>

		</div><!-- /.row -->
	</div><!-- /.container -->

</body>

</html>