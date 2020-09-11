package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

  private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

  private static final String PAYMENT_INSERTONE_URL = "/payment";

  @Autowired private RestTemplate restTemplate;

  @GetMapping("/consumer/payment")
  public CommonResult<Payment> insertOne(@RequestBody Payment payment) {
    log.info("Get payment ==> " + payment);
    return restTemplate.postForObject(
        PAYMENT_URL + PAYMENT_INSERTONE_URL, payment, CommonResult.class);
  }

  @GetMapping("/consumer/payment/{id}")
  public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
    return restTemplate.getForObject(
        PAYMENT_URL + PAYMENT_INSERTONE_URL + "/" + id, CommonResult.class);
  }
}
