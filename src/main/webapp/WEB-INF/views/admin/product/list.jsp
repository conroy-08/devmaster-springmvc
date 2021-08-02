<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/quan-tri/san-pham/chinh-sua" var="createProduct"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách sản phẩm </title>
</head>

<body>
<div class="main-content">
               <c:if test="${not empty message}">
		             <div style="text-align: center; font-weight: bold;" class="alert alert-${alert}">
		                     ${message}
		             </div>
	            </c:if> 

        <form action="<c:url value="/quan-tri/san-pham/chinh-sua" /> " id="formSubmit" method="get">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href='<c:url  value="/quan-tri/trang-chu" />'>Trang chủ</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                    <c:url value="/admin/product-edit" var="createNewURL"/>
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                           title='Thêm bài viết' href='${createProduct}'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                        </a>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>Tên sản shẩm</th>
                                            <th>Mô tả ngắn</th>
                                            <th>Hình ảnh</th>
                                            <th>Giá sản phẩm</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${product.listResult}">
                                            <tr> 
                                                <td>${item.name}</td>
                                                <td>${item.shortDescription}</td>
                                                <td>${item.thumbnail }</td>
                                                <td>${item.price}</td>
                                                <td>
                                                   <c:url value="/quan-tri/san-pham/chinh-sua" var="editProduct">
                                                             <c:param name="id" value="${item.id}"/>
                                                     </c:url>
                                          
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật bài viết" href='${editProduct }'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                  
                                                    <c:url var="deleteLink" value="/delete">
                                                        <c:param name="id" value="${item.id}" />
                                                    </c:url>
                                                   
                                                   <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"  onclick="if (!(confirm('Bạn chắc chắn muốn xóa sản phẩm này  ?'))) return false"
                                                       title='Xóa bài viết' href='${deleteLink}'><i style="color:white;" class="fa fa-trash-o bigger-110 "></i></i>
                                                    </a> 
                                                </td>
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
   </form>
</div>
<!-- /.main-content -->



</body>
</html>