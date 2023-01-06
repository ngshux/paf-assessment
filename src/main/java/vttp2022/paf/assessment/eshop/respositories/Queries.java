package vttp2022.paf.assessment.eshop.respositories;

public class Queries {
    public static final String SQL_FIND_BY_NAME="select * from eshop where name = ?";
    public static final String SQL_INSERT_ORDER="insert into order(order_id, delivery_id, customer_name, status, order_date) values (?,?,?,?,?)";
    public static final String SQL_INSERT_ORDERSTATUS = "insert into order_status(order_id, delivery_id, order_date, status) values (?, ?, ?, ?)";
}
