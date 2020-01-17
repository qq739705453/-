package com.yj.wl.service;

import com.yj.wl.entity.Journalism;

import java.util.List;

public interface JournalismService {

    List<Journalism> allJournalism();

    boolean saveJournalism( Journalism journalism);

    boolean updataJournalism( Journalism journalism);

    boolean deleteJournalism(int id);

}
