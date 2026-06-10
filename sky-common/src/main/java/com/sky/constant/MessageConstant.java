package com.sky.constant;

/**
 * 信息提示常量类
 */
public class MessageConstant {

    public static final String PASSWORD_ERROR = "Incorrect password";
    public static final String ACCOUNT_NOT_FOUND = "Account does not exist";
    public static final String ACCOUNT_LOCKED = "Account has been locked";
    public static final String UNKNOWN_ERROR = "Unknown error";
    public static final String USER_NOT_LOGIN = "User not logged in";
    public static final String CATEGORY_BE_RELATED_BY_SETMEAL =
            "The current category is associated with a package,Cannot delete";
    public static final String CATEGORY_BE_RELATED_BY_DISH =
            "The current category is associated with dishes,Cannot delete";
    public static final String SHOPPING_CART_IS_NULL = "The shopping cart is empty，Cannot place an order";
    public static final String ADDRESS_BOOK_IS_NULL = "User address is empty，Cannot place an order";
    public static final String LOGIN_FAILED = "Login failed";
    public static final String UPLOAD_FAILED = "File upload failed";
    public static final String SETMEAL_ENABLE_FAILED =
            "The set menu includes dishes that are not yet on sale and cannot be sold.";
    public static final String PASSWORD_EDIT_FAILED = "Password change failed";
    public static final String DISH_ON_SALE = "Dishes that are on sale cannot be deleted";
    public static final String SETMEAL_ON_SALE = "Packages that are on sale cannot be deleted";
    public static final String DISH_BE_RELATED_BY_SETMEAL =
            "The current dish is associated with a set meal and cannot be deleted.";
    public static final String ORDER_STATUS_ERROR = "Order status error";
    public static final String ORDER_NOT_FOUND = "The order does not exist";


    public static String ALREADY_EXISTS;
}
