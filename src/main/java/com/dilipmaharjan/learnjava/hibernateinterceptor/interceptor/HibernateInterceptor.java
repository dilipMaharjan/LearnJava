package com.dilipmaharjan.learnjava.hibernateinterceptor.interceptor;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.Customer;
import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.CustomerHist;
import com.dilipmaharjan.learnjava.hibernateinterceptor.repository.CustomerHistRepository;

@Component
public class HibernateInterceptor extends EmptyInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerHistRepository customerHistRepository;

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		if (entity instanceof Customer) {
			Customer customer = (Customer) entity;
			CustomerHist customerHist = new CustomerHist();
			customerHist.setCustomer(customer);
			customerHist.setCreateAt(new Date());
			customerHist.setUpdatedAt(new Date());
			customerHist.setEmail(customer.getEmail());
			customerHist.setName(customer.getName());
			customerHistRepository.save(customerHist);
		}
		return super.onSave(entity, id, state, propertyNames, types);
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if (entity instanceof Customer) {
			Customer customer = (Customer) entity;
			CustomerHist customerHist = new CustomerHist();
			customerHist.setCustomer(customer);
			customerHist.setCreateAt(new Date());
			customerHist.setUpdatedAt(new Date());
			customerHist.setEmail(customer.getEmail());
			customerHist.setName(customer.getName());
			customerHistRepository.save(customerHist);
		}
		return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);
	}
}
