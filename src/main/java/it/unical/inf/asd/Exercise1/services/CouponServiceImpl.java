package it.unical.inf.asd.Exercise1.services;

import it.unical.inf.asd.Exercise1.dao.CouponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService{
    @Autowired
    private CouponDao couponDao;
}
