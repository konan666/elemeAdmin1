package com.neusoft.view;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

/**
 * @author Eric Lee
 * @date 2020/8/7 11:34
 */
public interface AdminView {
    // 登录
    public Admin login();
    public List<Business> getselect();
    public List<Business> setchaxun(String businessName,String businessAddress);
}
