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
    <title>Ogani | Template</title>

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
<style>
    .name-product {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        width: 150px;
        display: inline-block;
    }
    .checkout__input select {
        width: 100%;
        height: 46px;
        border: 1px solid #ebebeb;
        padding-left: 20px;
        font-size: 16px;
        color: #b2b2b2;
        border-radius: 4px;
    }
</style>
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

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Checkout</h2>
                    <div class="breadcrumb__option">
                        <a href="home.jsp">Home</a>
                        <span>Checkout</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Checkout Section Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <h4>Billing Details</h4>
            <form action="/payment" method="post">
                <div class="row">
                    <div class="col-lg-8 col-md-6">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Fist Name<span>*</span></p>
                                    <input type="text" value="${user.getFullName()}">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Identity Card<span>*</span></p>
                                    <input type="text" value="${user.getIdentityCard()}">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Default address<span>*</span></p>
                            <input type="text" value="${user.getAddress()}">
                        </div>
                        <div class="checkout__input">
                            <p>Town/City<span>*</span></p>
                            <select id="city" name="city" onclick="selectDistrict()"></select>
                        </div>
                        <div class="checkout__input">
                            <p>District<span>*</span></p>
                            <select id="district" name="district" onclick="selectTown()"></select>
                        </div>
                        <div class="checkout__input">
                            <p>Commune/Ward<span>*</span></p>
                            <select id="town" name="town"></select>
                        </div>
                        <div class="checkout__input">
                            <p>Address<span>*</span></p>
                            <input type="text" placeholder="Street Address" class="checkout__input__add" id="address">
                            <input type="text" placeholder="Apartment, suite, unite ect (optinal)">
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Phone<span>*</span></p>
                                    <input type="text" value="${user.getPhoneNumber()}">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input type="text" value="${user.getEmail()}">
                                </div>
                            </div>
                        </div>
                        <div class="checkout__input">
                            <p>Order notes<span>*</span></p>
                            <input type="text"
                                   placeholder="Notes about your order, e.g. special notes for delivery.">
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="checkout__order">
                            <h4>Your Order</h4>
                            <div class="checkout__order__products">Products <span>Total</span></div>
                            <table>
                                <c:forEach items="${sessionScope.cart}" var="product">
                                    <tr>
                                        <td class="name-product">${product.key.name}</td>
                                        <td class="text-right w-100">
                                            <span>
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber value="${product.key.price * product.value}" type="currency"
                                                                  currencySymbol="VND"/>
                                            </span>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <div class="checkout__order__subtotal">Subtotal <span id="sub-total">$750.99</span></div>
                            <div class="checkout__order__total">Total <span id="total">$750.99</span></div>
                            <input type="hidden" name="total_price" id="total-price-hidden">
                            <div class="checkout__input__checkbox">
                                    <input type="radio" name="payment_method" value="1"> Pay after recieve
                            </div>
                            <div class="checkout__input__checkbox">
                                <input type="radio" name="payment_method" value="2"> Payment online(VNPay)
                            </div>
                            <button type="submit" class="site-btn">PLACE ORDER</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</section>
<!-- Checkout Section End -->

<!-- Footer Section Begin -->
<jsp:include page="./common/footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        calculateTotalMoneyInCart();
        selectCity();
        selectDistrict();
        selectTown();
    });

    async function selectCity() {
        try {
            const response = await fetch("https://vapi.vnappmob.com/api/province/");
            const jsonData = await response.json();
            const data = jsonData.results;
            let cityElm = document.getElementById("city");
            cityElm.innerHTML = data.map((city) => {
                return '<option value='+ city.province_id+'>'+city.province_name+'</option>';
            }).join('');
        } catch (error) {
            console.error('Error fetching the provinces:', error);
        }
    }

    async function selectDistrict() {
        let idCity = document.getElementById("city").value;
        console.log(idCity);
        const response = await fetch("https://vapi.vnappmob.com/api/province/district/" + idCity);
        const jsonData = await response.json();
        const data = jsonData.results;
        document.getElementById("district").innerHTML = data.map(distinct => {
            return '<option value='+distinct.district_id+'>'+distinct.district_name+'</option>'
        }).join('')
    }

    async function selectTown() {
        let idDistrict = document.getElementById("district").value;
        console.log(idDistrict);
        const response = await fetch("https://vapi.vnappmob.com/api/province/ward/" + idDistrict);
        const jsonData = await response.json();
        const data = jsonData.results;
        document.getElementById("town").innerHTML = data.map(ward => {
            return '<option value='+ward.ward_id+'>'+ward.ward_name+'</option>'
        }).join('')
    }

    document.getElementById("town").onchange = () => {
        console.log("change")
        let townElm = document.getElementById("town")
        let districtElm = document.getElementById("district")
        let cityElm = document.getElementById("city")
        document.getElementById("address").value
            = townElm.options[townElm.selectedIndex].text + ", " + districtElm.options[districtElm.selectedIndex].text + ", " + cityElm.options[cityElm.selectedIndex].text;
        console.log(document.getElementById("address").value);
    }
    function calculateTotalMoneyInCart() {
        $.ajax({
                type: "GET",
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: '/cart?action=get-total-money',
                success: (data) => {
                    let totalMoney = parseInt(data)
                    document.getElementById("sub-total").innerText =
                        totalMoney.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
                    document.getElementById("total").innerText =
                        totalMoney.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
                    document.getElementById("total-price-hidden").value = totalMoney
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