package com.yj.wl.service.serviceImp;

import com.yj.wl.dao.JournalismDao;
import com.yj.wl.entity.Journalism;
import com.yj.wl.service.JournalismService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JournalismServiceImp implements JournalismService {

    @Resource
    JournalismDao journalismDao;

    @Override
    public List<Journalism> allJournalism() {

        return journalismDao.allJournalism();
    }

    @Override
    public boolean saveJournalism(Journalism journalism) {
        journalismDao.saveJournalism(journalism);
        return true;
    }

    @Override
    public boolean updataJournalism(Journalism journalism) {
        journalismDao.updataJournalism(journalism);
        return true;
    }

    @Override
    public boolean deleteJournalism(int id) {
        journalismDao.deleteJournalism(id);
        return true;
    }
}
