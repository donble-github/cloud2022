package top.donble.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.donble.springcloud.entities.CommonResult;
import top.donble.springcloud.entities.Payment;
import top.donble.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: donble
 * Date: 2022/3/8 2:11 上午
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Object> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0){
            return new CommonResult<>(200,"插入数据库成功,serverPort: " + serverPort,result);
        }else {
            return new CommonResult<>(400,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById( @PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment);
        log.info(new CommonResult<Payment>().toString());
        if (payment != null){
            return new CommonResult<>(200,"查询成功,serverPort: " + serverPort,payment);
        }else {
            return new CommonResult<>(400,"插没有对应记录。查询ID：" + id);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{ TimeUnit.SECONDS.sleep(3); }catch(InterruptedException e){ e.printStackTrace(); }
        return serverPort;
    }
}
