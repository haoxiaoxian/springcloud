package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

  @Autowired private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping("/payment")
  public CommonResult insertOne(@RequestBody Payment payment) {
    int result = paymentService.insertOne(payment);
    if (result > 0) {
      return new CommonResult(200, "添加成功!,serverPort" + serverPort, result);
    }
    return new CommonResult(444, "操作失败!");
  }

  @GetMapping("/payment/{id}")
  public CommonResult findOne(@PathVariable("id") long id) {
    Payment payment = paymentService.findById(id);
    if (payment != null) {
      return new CommonResult(200, "查询成功!,serverPort" + serverPort, payment);
    }
    return new CommonResult(444, "没有此纪录");
  }
}
