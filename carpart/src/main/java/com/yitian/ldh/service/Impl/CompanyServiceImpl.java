package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.CompanyMapper;
import com.yitian.ldh.model.User;
import com.yitian.ldh.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public User findCompanyname(String companyname) {
        return companyMapper.findCompanyname(companyname);
    }
}
