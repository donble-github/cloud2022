package top.donble.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.donble.springcloud.entities.Payment;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: donble
 * Date: 2022/3/8 1:40 上午
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
