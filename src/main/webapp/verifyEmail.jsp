<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/1/2024
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Verify email</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/elegant-icons.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/nice-select.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/slicknav.min.css"
          type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css"
          type="text/css">
</head>
<body>
<div>
    <jsp:include page="./common/header.jsp"></jsp:include>
    <section class="login_box_area section_gap">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login_box_img">
                        <img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/login.jpg" alt="">
                        <div class="hover">
                            <h4>Bạn là người mới ?</h4>
                            <p>Để có thể mua bán giày dép và có một trải nghiệm tốt, vui lòng tạo tài khoản mới ở phía dưới đây.</p>
                            <a class="primary-btn" href="/register">Tạo tài khoản</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login_form_inner">
                        <h3>Quên mật khẩu</h3>
                        <form class="row login_form" action="/login?action=verify-email" method="post" id="contactForm">
                            <div class="col-md-12 form-group">
                                <input type="text" class="form-control" name="email" placeholder="Email đã đăng ký" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email đã đăng ký'">
                            </div>
                            <c:if test="${errorEmail != null}">
                                <p class="col-md-12 form-group" style="color: red; text-align: left">${errorEmail}</p>
                            </c:if>
                            <p class="col-md-12 form-group" style="text-align: left">Sau khi xác nhận email, vui lòng kiểm tra hộp thư email để lấy mã code được gửi đến.</p>
                            <div class="col-md-12 mt-3 form-group">
                                <button type="submit" value="submit" class="primary-btn">Xác nhận</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Login Box Area =================-->

    <!-- start footer Area -->
    <jsp:include page="./common/footer.jsp"></jsp:include>
</div>
</body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
</html>
