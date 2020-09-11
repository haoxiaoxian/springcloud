package com.atguigu.springcloud.service;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	public int insertOne(Payment payment) {
		return paymentDao.insert(payment);
	}

	public Payment findById(Long id) {
		return paymentDao.selectById(id);
	}

}
