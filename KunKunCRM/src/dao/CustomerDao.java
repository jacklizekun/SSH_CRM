package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;

/**
 * 持久层接口
 * @author 李泽坤
 *
 */
public interface CustomerDao {

	void save(Customer customer);

	void update(Customer customer);

	void delete(Customer customer);

	Customer findById(Long id);

	List<Customer> findAll();

	Integer findCount(DetachedCriteria detachedCriteria);

	List<Customer> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);

}
