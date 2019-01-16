package com.yitian.ldh.service.Impl;

import com.yitian.ldh.dao.NoticeMapper;
import com.yitian.ldh.model.Notice;
import com.yitian.ldh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNotice() {
        return noticeMapper.findNotice();
    }
}
