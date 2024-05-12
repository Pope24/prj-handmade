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
    <title>Home</title>

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

<!-- Categories Section Begin -->
<section class="categories">
    <div class="container">
        <div class="row">
            <div class="categories__slider owl-carousel">
                <div class="col-lg-3">
                    <div class="categories__item set-bg"
                         data-setbg="https://i.etsystatic.com/34568861/r/il/a65f88/4027145115/il_570xN.4027145115_7uhg.jpg">
                        <h5><a href="#">Cincinati</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg"
                         data-setbg="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpF1PZGvJuf9AKY2KbrFrbCFfiZGSbf6ykelm4exRz_g&s">
                        <h5><a href="#">Neyuh leather</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg"
                         data-setbg="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjLz4zKdUhDd5mxdPWtj6G2-HbIygxyV-nIEFD5NqIGg&s">
                        <h5><a href="#">Desino</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg"
                         data-setbg="https://i.pinimg.com/736x/f3/75/83/f375833f47fb4789081e11ca48226723.jpg">
                        <h5><a href="#">Vintage</a></h5>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="categories__item set-bg"
                         data-setbg="https://www.leonardoshoes.com/cdn/shop/files/Leonardo_Shoes-Logo.jpg?v=1682003766">
                        <h5><a href="#">Leonardo</a></h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Categories Section End -->

<!-- Featured Section Begin -->
<section class="featured spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Latest Product</h2>
                </div>
            </div>
        </div>
        <div class="row featured__filter">
            <c:forEach items="${productMap.get('latestProduct')}" var="product">
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="${product.image}">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
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
    </div>
</section>
<!-- Featured Section End -->

<!-- Banner Begin -->
<div class="banner">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img class="w-100 h-100" src="https://spacet-release.s3.ap-southeast-1.amazonaws.com/img/blog/2023-10-09/do-handmade-thu-hut-nhung-nguoi-yeu-thich-su-doc-dao-65236727d1295e11306a075e.webp"
                         alt="">
                </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
                <div class="banner__pic">
                    <img class="w-100 h-100" src="https://nenthomsco.com/wp-content/uploads/2023/10/Goi-y-nhung-mon-do-handmade-tang-ban-trai-1400x735.png" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner End -->

<!-- Latest Product Section Begin -->
<section class="latest-product spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Latest Products</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${productMap.get('latestProduct')}" var="product" begin="0" end="2">
                                <a href="/product?id=${product.id}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${product.image}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${product.name}</h6>
                                        <span>
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"
                                                          currencySymbol="VND"/>
                                    </span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${productMap.get('latestProduct')}" var="product" begin="3" end="5">
                                <a href="/product?id=${product.id}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${product.image}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${product.name}</h6>
                                        <span>
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"
                                                          currencySymbol="VND"/>
                                    </span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Top Rated Products</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${productMap.get('bestSellerProduct')}" var="product" begin="0" end="2">
                                <a href="/product?id=${product.id}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${product.image}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${product.name}</h6>
                                        <span>
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"
                                                          currencySymbol="VND"/>
                                    </span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${productMap.get('bestSellerProduct')}" var="product" begin="3" end="5">
                                <a href="/product?id=${product.id}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${product.image}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${product.name}</h6>
                                        <span>
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"
                                                          currencySymbol="VND"/>
                                    </span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="latest-product__text">
                    <h4>Review Products</h4>
                    <div class="latest-product__slider owl-carousel">
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${productMap.get('topReviewProduct')}" var="product" begin="0" end="2">
                                <a href="/product?id=${product.id}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${product.image}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${product.name}</h6>
                                        <span>
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"
                                                          currencySymbol="VND"/>
                                    </span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                        <div class="latest-prdouct__slider__item">
                            <c:forEach items="${productMap.get('topReviewProduct')}" var="product" begin="3" end="5">
                                <a href="/product?id=${product.id}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${product.image}"
                                             alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${product.name}</h6>
                                        <span>
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"
                                                          currencySymbol="VND"/>
                                    </span>
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Latest Product Section End -->

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


</body>

</html>