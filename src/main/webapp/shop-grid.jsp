<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Category</title>

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
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Humberger Begin -->
<div class="humberger__menu__overlay"></div>
<jsp:include page="./common/header.jsp"></jsp:include>
<!-- Header Section End -->

<!-- Hero Section Begin -->
<jsp:include page="./common/section.jsp"></jsp:include>
<!-- Hero Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/assets/img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>ALEX.HD Shop</h2>
                    <div class="breadcrumb__option">
                        <a href="/">Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Section Begin -->
<section class="product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-5">
                <form action="/category" method="get">
                    <input type="hidden" name="action" value="filter">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Product brand</h4>
                            <ul>
                                <li><input type="checkbox" name="brands" value="0"/> Vintage</li>
                                <li><input type="checkbox" name="brands" value="1"/> Olug</li>
                                <li><input type="checkbox" name="brands" value="2"/> Cincinati</li>
                                <li><input type="checkbox" name="brands" value="3"/> Neyuh leather</li>
                                <li><input type="checkbox" name="brands" value="4"/> Desino</li>
                                <li><input type="checkbox" name="brands" value="5"/> Ponagar</li>
                                <li><input type="checkbox" name="brands" value="6"/> Leonardo</li>
                            </ul>
                        </div>
                        <div class="sidebar__item">
                            <h4>Product type</h4>
                            <ul>
                                <li><input type="checkbox" name="types" value="0"/> Decoration</li>
                                <li><input type="checkbox" name="types" value="1"/> Leather</li>
                                <li><input type="checkbox" name="types" value="2"/> Fabric</li>
                                <li><input type="checkbox" name="types" value="3"/> Daily supplies</li>
                                <li><input type="checkbox" name="types" value="4"/> Jewelry</li>
                                <li><input type="checkbox" name="types" value="5"/> Cosmetic</li>
                                <li><input type="checkbox" name="types" value="6"/> Gift</li>
                            </ul>
                        </div>
                        <div class="sidebar__item">
                            <h4>Price</h4>
                            <div class="price-range-wrap">
                                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                     data-min="0" data-max="5000000">
                                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                </div>
                                <div class="range-slider">
                                    <div class="price-input">
                                        <input type="text" name="min-price" id="minamount">
                                        <input type="text" name="max-price" class="text-right" id="maxamount">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="sidebar__item">
                            <button type="submit" class="btn btn-danger font-weight-bold m-auto">Filter product</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-9 col-md-7">
                <div class="filter__item">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">
                            <div class="filter__sort">
                                <span>Sort By</span>
                                <select>
                                    <option value="0">Default</option>
                                    <option value="0">Default</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-3">
                            <div class="filter__option">
                                <span class="icon_grid-2x2"></span>
                                <span class="icon_ul"></span>
                            </div>
                        </div>
                    </div>
                </div>
                <c:if test="${informationProduct.get('products').size() == 0}">
                    <h4 class="text-center">Không tìm thấy sản phẩm nào.</h4>
                    <p class="text-center">Quay lại <a href="/category">danh mục</a> ban đầu</p>
                </c:if>
                <c:if test="${informationProduct.get('products').size() > 0}">
                    <div class="row">
                        <c:forEach items="${informationProduct.get('products')}" var="product">
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg"
                                         data-setbg="${product.image}">
                                        <ul class="product__item__pic__hover">
                                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <h6><a href="/product?id=${product.id}">${product.name}</a></h6>
                                        <h5>
                                            <fmt:setLocale value="vi_VN"/>
                                            <fmt:formatNumber value="${product.price}" type="currency"
                                                              currencySymbol="VND"/>
                                        </h5>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="product__pagination d-flex justify-content-start align-items-center">
                        <c:if test="${informationProduct.get('queryURL') == null}">
                            <c:if test="${informationProduct.get('currentPage') > 1 }">
                                <a class="d-flex justify-content-center align-items-center"
                                   href="?search=${informationProduct.get('valueSearch')}&page=${informationProduct.get('currentPage') - 1}">
                                    <i class="fa fa-long-arrow-left"></i>
                                </a>
                            </c:if>
                            <c:forEach begin="1" end="${informationProduct.get('totalPage')}" var="i">
                                <a style="${i == informationProduct.get('currentPage') ? 'background-color: #7fad39' : ''}"
                                   href="?search=${informationProduct.get('valueSearch')}&page=${i}">${i}</a>
                            </c:forEach>
                            <c:if test="${informationProduct.get('currentPage') < informationProduct.get('totalPage') }">
                                <a class="d-flex justify-content-center align-items-center"
                                   href="?search=${informationProduct.get('valueSearch')}&page=${informationProduct.get('currentPage') + 1}">
                                    <i class="fa fa-long-arrow-right"></i>
                                </a>
                            </c:if>
                        </c:if>
                        <c:if test="${informationProduct.get('queryURL') != null}">
                            <c:if test="${informationProduct.get('currentPage') > 1 }">
                                <a class="d-flex justify-content-center align-items-center"
                                   href="?${informationProduct.get('queryURL')}&page=${informationProduct.get('currentPage') - 1}">
                                    <i class="fa fa-long-arrow-left"></i>
                                </a>
                            </c:if>
                            <c:forEach begin="1" end="${informationProduct.get('totalPage')}" var="i">
                                <a style="${i == informationProduct.get('currentPage') ? 'background-color: #7fad39' : ''}"
                                   href="?${informationProduct.get('queryURL')}&page=${i}">${i}</a>
                            </c:forEach>
                            <c:if test="${informationProduct.get('currentPage') < informationProduct.get('totalPage') }">
                                <a class="d-flex justify-content-center align-items-center"
                                   href="?${informationProduct.get('queryURL')}&page=${informationProduct.get('currentPage') + 1}">
                                    <i class="fa fa-long-arrow-right"></i>
                                </a>
                            </c:if>
                        </c:if>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</section>
<!-- Product Section End -->

<!-- Footer Section Begin -->
<jsp:include page="./common/footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script>
    $(function () {
        // Hàm định dạng số với dấu phân cách hàng nghìn và thêm ' VND'
        function formatCurrency(amount) {
            return new Intl.NumberFormat('vi-VN').format(amount) + " VND";
        }

        // Cài đặt giá trị ban đầu cho các trường đầu vào
        $("#minamount").val(formatCurrency(0));
        $("#maxamount").val(formatCurrency(5000000));

        // Thiết lập slider
        $(".price-range").slider({
            range: true,
            min: 0,
            max: 5000000,
            values: [0, 5000000],
            slide: function (event, ui) {
                $("#minamount").val(formatCurrency(ui.values[0]));
                $("#maxamount").val(formatCurrency(ui.values[1]));
            }
        });
    });
</script>
</body>

</html>