package com.f.test.models;

import com.f.pojo.Employee;
import com.f.pojo.Voucher;
import com.f.pojo.VoucherCheckResult;
import com.f.pojo.VoucherDetail;
import com.f.services.VoucherDetailService;
import com.f.services.VoucherService;
import com.f.test.TestHelper;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VoucherTest {
    private VoucherService voucherService = (VoucherService) TestHelper.getInstance().getBean("voucherServiceImpl");
    private VoucherDetailService voucherDetailService = (VoucherDetailService) TestHelper.getInstance().getBean("voucherDetailServiceImpl");

    @Test
    public void getVouchersList() {
        assert voucherService != null;
        assert voucherService.getAllVouchers().size() > 0;
    }

    @Test
    public void getVoucherById() {
        voucherService.getVoucherById(1);
    }

    @Test
    public void getSize() {
        assert voucherService.size() > 0;
    }

    @Test
    public void addVoucher() {
        Voucher voucher = new Voucher("jany get a car" + Objects.toString(System.currentTimeMillis()), (float) 0.00, 1);
        VoucherDetail voucherDetail = new VoucherDetail("get a car by 500$");
        voucher.setVoucherDetail(voucherDetail);
        voucherService.saveVoucher(voucher);
    }

    @Test
    public void deleteVoucher() {
        List<Voucher> employeeList = voucherService.getAllVouchers();
//        assert voucherService.deleteVoucherById(employeeList.get(0).getId());
    }

    @Test
    public void updateVoucher() {
        List<Voucher> vouchers = voucherService.getAllVouchers();
        assert voucherService.updateVoucher(vouchers.get(0));
        voucherService.getVoucherById(1);
    }

    @Test
    public void getVoucherByOaPositionId() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", 1);
        assert voucherService.getVoucherByCondition(map).size() > 0;
    }
}