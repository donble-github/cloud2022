package top.donble.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.donble.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: donble
 * Date: 2022/3/12 1:01 上午
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result: " + result);
        return result;
    }

}
