package com.yj.wl.dao;


import com.yj.wl.entity.Journalism;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class JournalismDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Journalism> allJournalism(){
        return (List<Journalism>) jdbcTemplate.query("select * from journalism", new BeanPropertyRowMapper(Journalism.class));
    }

    public void saveJournalism(Journalism journalism){
        jdbcTemplate.update("insert into Journalism (userId,content,title) value (?, ?, ?)",
                journalism.getUserId(),
                journalism.getContent(),
                journalism.getTitle());
    }

    public void updataJournalism(Journalism journalism){
        jdbcTemplate.update("UPDATE journalism set  content = ?, title = ? where id = ?",
                journalism.getContent(),
                journalism.getTitle(),
                journalism.getId());
    }

    public void deleteJournalism(int id){
        jdbcTemplate.update("DELETE FROM journalism WHERE id = ?",new Object[]{id});
    }

}
