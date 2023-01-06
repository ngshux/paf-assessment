package vttp2022.paf.assessment.eshop.respositories;

import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.UUID;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class OrderRepository {
	// TODO: task 3

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createOrder(Order order) {

		String orderId = UUID.randomUUID().toString().substring(0, 8);

        return jdbcTemplate.update(SQL_INSERT_ORDER, orderId
		, order.getDeliveryId(), order.getCustomer().getName() ,order.getOrderDate(), order.getStatus());
    }
}
