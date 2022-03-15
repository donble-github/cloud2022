package top.donble.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: donble
 * Date: 2022/3/12 12:53 上午
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_Timeout(Integer id);

    String paymentCircuitBreaker(Integer id);
}
