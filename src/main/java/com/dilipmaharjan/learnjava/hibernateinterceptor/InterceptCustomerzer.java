package com.dilipmaharjan.learnjava.hibernateinterceptor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import com.dilipmaharjan.learnjava.hibernateinterceptor.interceptor.HibernateInterceptor;

@Component
public class InterceptCustomerzer implements HibernatePropertiesCustomizer {

	@Autowired
	private HibernateInterceptor hibernateInterceptor;

	@Override
	public void customize(Map<String, Object> hibernateProperties) {
		hibernateProperties.put("hibernate.session_factory.interceptor", hibernateInterceptor);
	}

}
