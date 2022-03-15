package top.donble.springcloud.service;

import org.apache.ibatis.annotations.Param;
import top.donble.springcloud.entities.Payment;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: donble
 * Date: 2022/3/8 2:07 上午
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
