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
    <title>Shopping cart</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/nice-select.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/style.css" type="text/css">
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
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Shopping Cart</h2>
                        <div class="breadcrumb__option">
                            <a href="home.jsp">Home</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <c:choose>
        <c:when test="${sessionScope.cart == null || sessionScope.cart.size() == 0}">
    <section class="shoping-cart spad">
        <div class="container d-flex flex-column justify-content-center align-items-center">
            <h4>No product is added to cart. Please add more to continue.</h4>
            <a href="/category">Shopping now</a>
        </div>
    </section>
        </c:when>
        <c:otherwise>
            <section class="shoping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__table">
                                <table>
                                    <thead>
                                    <tr>
                                        <th class="shoping__product">Products</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${sessionScope.cart}" var="product">
                                        <tr>
                                            <td class="shoping__cart__item">
                                                <img style="width: 50px" src="${pageContext.request.contextPath}${product.key.image}" alt="">
                                                <h5>${product.key.name}</h5>
                                            </td>
                                            <td class="shoping__cart__price">
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber value="${product.key.price}" type="currency" currencySymbol="VND"/>
                                            </td>
                                            <td class="shoping__cart__quantity">
                                                <div class="quantity">
                                                    <div class="pro-qty">
                                                        <span class="dec qtybtn" id="dec-btn" onclick="updateCart('subtract', ${product.key.id}, ${product.key.price})">-</span>
                                                        <input type="text" value="${product.value}" id="amount-${product.key.id}">
                                                        <span class="inc qtybtn" id="inc-btn" onclick="updateCart('add', ${product.key.id}, ${product.key.price})">+</span>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="shoping__cart__total" id="product-${product.key.id}">
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber value="${product.key.price * product.value}" type="currency" currencySymbol="VND"/>
                                            </td>
                                            <td class="shoping__cart__item__close">
                                                <span class="icon_close" onclick="deleteItemInCart('delete', ${product.key.id})"></span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="shoping__continue">
                                <div class="shoping__discount">
                                    <h5>Discount Codes</h5>
                                    <form action="#">
                                        <input type="text" placeholder="Enter your coupon code">
                                        <button type="submit" class="site-btn">APPLY COUPON</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <h5>Cart Total</h5>
                                <ul>
                                    <li>Subtotal <span id="sub-total">$454.98</span></li>
                                    <li>Total <span id="total">$454.98</span></li>
                                </ul>
                                <a href="/checkout" class="primary-btn">PROCEED TO CHECKOUT</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </c:otherwise>
    </c:choose>
    <!-- Shoping Cart Section End -->

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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script>
        function calculateTotalMoneyInCart() {
            $.ajax({
                    type: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: '/cart?action=get-total-money',
                    success: (data) => {
                        console.log(data)
                        document.getElementById("sub-total").innerText =
                            (parseInt(data)).toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
                        document.getElementById("total").innerText =
                            (parseInt(data)).toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
                    },
                    error: (error) => {
                        console.log(error);
                    }
                }
            )
        }
        window.onload = function () {
            calculateTotalMoneyInCart();
            var proQty = $('.pro-qty');
            proQty.on('click', '.qtybtn', function () {
                var $button = $(this);
                var oldValue = $button.parent().find('input').val();
                if ($button.hasClass('inc')) {
                    var newVal = parseFloat(oldValue) + 1;
                } else {
                    if (oldValue > 1) {
                        var newVal = parseFloat(oldValue) - 1;
                    } else {
                        newVal = 1;
                    }
                }
                $button.parent().find('input').val(newVal);
            });
        }
        function updateCart(expression, id, price) {
            console.log('/cart?action=update-cart&expression=' + expression + "&id=" + id);
            $.ajax({
                    type: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: '/cart?action=update-cart&expression=' + expression + "&id=" + id,
                    success: (data) => {
                        document.getElementById("product-"+id).innerText =
                            (parseInt(document.getElementById("amount-"+id).value)*price).toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
                        calculateTotalMoneyInCart();
                    },
                    error: (error) => {
                        console.log(error);
                    }
                }
            )
        }
        function deleteItemInCart(expression, id) {
            $.ajax({
                    type: "GET",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: '/cart?action=update-cart&expression=' + expression + "&id=" + id,
                    success: (data) => {
                        location.reload();
                    },
                    error: (error) => {
                        console.log(error);
                    }
                }
            )
        }
    </script>
</body>

</html>