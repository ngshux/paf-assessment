package vttp2022.paf.assessment.eshop.respositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.assessment.eshop.models.Customer;

import static vttp2022.paf.assessment.eshop.respositories.Queries.*;

@Repository
public class CustomerRepository {

	@Autowired
	private JdbcTemplate template;

	// You cannot change the method's signature
	public Optional<Customer> findCustomerByName(String name) {
		// TODO: Task 3 
		
		final SqlRowSet rs = template.queryForRowSet
			(SQL_FIND_BY_NAME, name);
		Customer cust = new Customer();
		cust.setName(rs.getString("name"));
		cust.setAddress(rs.getString("address"));
		cust.setEmail(rs.getString("email"));

		return Optional.of(cust);
	}
}
