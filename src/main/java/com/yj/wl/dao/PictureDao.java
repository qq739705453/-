package com.yj.wl.dao;

import com.yj.wl.entity.Journalism;
import com.yj.wl.entity.Picture;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PictureDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void saveJournalism(Picture picture){
        jdbcTemplate.update("insert into picture(imgName) value (?)",
                picture.getImgName());
    }
}
