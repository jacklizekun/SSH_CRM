package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Customer;
import domain.PageBean;

/**
 * 业务层接口
 * @author 李泽坤
 *
 */
public interface CustomerService {

	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Customer customer);
	
	Customer findById(Long id);

	List<Customer> findAll();

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);
}
