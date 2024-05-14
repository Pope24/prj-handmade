package com.querySQL;

public class ProductQuery {
    public static String GET_TOP_LATEST_PRODUCT = "select top 8 p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user where p.isActived = 1 order by create_on desc";
    public static String GET_TOP_REVIEW_PRODUCT = "select top 8 p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image, COUNT(r.id_product) AS review_count\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user left join reviews r on r.id_product = p.id \n" +
            "where p.isActived = 1 \n" +
            "group by p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image\n" +
            "order by review_count desc";
    public static String GET_TOP_BEST_SELLER_PRODUCT = "select top 8 p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image, sum(od.quantity) quantity_product\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user left join order_detail od on od.id_product = p.id\n" +
            "where p.isActived = 1 \n" +
            "group by p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image order by quantity_product desc";
    public static String GET_PRODUCT_BY_ID = "select p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user where p.isActived = 1 and p.id = ?";
    public static String GET_IMAGE_PRODUCT_BY_ID = "select * from image_product where id_product = ?";
    public static String GET_TOP_RELATED_PRODUCT = "select top 4 p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id full join products p on ii.id_product = p.id join users u on u.id_user = p.id_user where p.isActived = 1 and (p.p_type = ? or p.p_brand = ?) order by p.create_on desc";
    public static String GET_PRODUCT_FILTER = "select p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user \n" +
            "where p.isActived = 1 and p.p_brand in ? and p.p_type in ? and p.price between ? and ?";
    public static String COUNT_PRODUCT_FILTER = "select count(p.id) from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user \n" +
            "where p.isActived = 1 and p.p_brand in ? and p.p_type in ? and p.price between ? and ?";
    public static String GET_PRODUCT_SEARCH = "with x as(select ROW_NUMBER() over (order by p.create_on desc) as r, p.id, p.name, p.price, p.amount, p.description, p.p_type, p.p_brand, p.create_on, u.full_name, ii.link_image\n" +
            "from (select id_product, MIN(id) as id_image from image_product group by id_product) i\n" +
            "join image_product ii on i.id_image = ii.id join products p on ii.id_product = p.id join users u on u.id_user = p.id_user \n" +
            "where p.isActived = 1 and p.name like ?) select * from x where r between (? - 1) * 6 + 1 and ? * 6";
    public static String COUNT_PRODUCT_SEARCH = "select count(p.id) total from products p where p.isActived = 1 and p.name like ?";
}
