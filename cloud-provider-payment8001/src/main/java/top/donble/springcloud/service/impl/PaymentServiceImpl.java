package top.donble.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.donble.springcloud.dao.PaymentDao;
import top.donble.springcloud.entities.Payment;
import top.donble.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: donble
 * Date: 2022/3/8 2:08 上午
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
