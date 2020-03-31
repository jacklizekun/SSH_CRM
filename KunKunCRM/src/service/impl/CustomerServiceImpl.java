package service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import domain.Customer;
import domain.PageBean;
import service.CustomerService;
/**
 * 业务层实现类
 * @author 李泽坤
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void save(Customer customer) {
		System.out.println("Service save");
		customerDao.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	@Override

	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage,Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		// 设置当前页数:
		pageBean.setCurrPage(currPage);
		// 设置每页显示记录数：
		pageBean.setPageSize(pageSize);
		// 设置总记录数:
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		// 设置总页数：
		double tc = totalCount;
		Double num = Math.ceil(tc /pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示数据的集合:
		Integer begin = (currPage - 1) * pageSize;
		List<Customer> list = customerDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
}
