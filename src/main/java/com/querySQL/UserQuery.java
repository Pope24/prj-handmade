package com.querySQL;

public class UserQuery {
    public static final String SELECT_USER_BY_ID = "select * from users where id_user = ?;";
    public static final String SELECT_USER_BY_EMAIL = "select * from users where email = ?;";
    public static final String SELECT_USER_BY_PHONE_NUMBER = "select * from users where phone_number = ?;";
    public static final String UPDATE_PASSWORD_ACCOUNT_BY_EMAIL = "update ac set ac.password = ? from account ac join users as u on u.id_user = ac.id_user where email = ?;";
    public static final String SAVE_NEW_USER = "insert into users(full_name, phone_number, email, identity_card, address, gender, avatar)" +
            "values(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SAVE_NEW_ACCOUNT = "insert into account(id_user, username, password, is_actived, id_role)" +
            "values(?, ?, ?, ?, ?)";
    public static final String UPDATE_USER = "update users set full_name = ?, phone_number = ?, email = ?, identity_card = ?, address = ?, gender = ?, avatar = ? where id_user =?";
    public static final String SELECT_ALL_ACCOUNT = "select * from account as a join users as u on a.id_user = u.id_user";
    public static final String SELECT_ACCOUNT_BY_ID = "select *\n" +
            "from account as a\n" +
            "join users as u on a.id_user = u.id_user\n" +
            "where a.id_user = ?";
    public static final String INACTIVE_ACCOUNT = "update account set is_actived = 0 where id_user = ?";
    public static final String ACTIVE_ACCOUNT = "update account set is_actived = 1 where id_user = ?";
}
