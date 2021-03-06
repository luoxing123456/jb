package com.f.services.impl;

import com.f.dao.VoucherCheckResultDao;
import com.f.pojo.VoucherCheckResult;
import com.f.services.VoucherCheckResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class VoucherCheckResultServiceImpl implements VoucherCheckResultService {
    @Resource(name = "voucherCheckResultDao")
    private VoucherCheckResultDao voucherCheckResultDao;

    @Transactional
    @Override
    public boolean save(VoucherCheckResult result) {
        try {
            voucherCheckResultDao.save(result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteVoucherCheckResult(Integer id) {
        try {
            if (voucherCheckResultDao.deleteVoucherCheckResultByVoucherId(id) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public boolean updateVoucherCheckResult(VoucherCheckResult voucherCheckResult) {
        voucherCheckResult.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return voucherCheckResultDao.update(voucherCheckResult) > 0;
    }
}
