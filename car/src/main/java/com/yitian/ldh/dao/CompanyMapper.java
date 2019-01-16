package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Company;
import com.yitian.ldh.model.User;

public interface CompanyMapper extends BaseDao<Company> {

    User findCompanyname(String companyname);
}