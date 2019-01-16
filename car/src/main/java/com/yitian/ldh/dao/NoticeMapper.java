package com.yitian.ldh.dao;

import com.yitian.ldh.base.BaseDao;
import com.yitian.ldh.model.Notice;

import java.util.List;

public interface NoticeMapper extends BaseDao<Notice> {

    List<Notice> findNotice();
}