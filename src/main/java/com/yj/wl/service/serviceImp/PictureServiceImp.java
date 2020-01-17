package com.yj.wl.service.serviceImp;

import com.yj.wl.dao.PictureDao;
import com.yj.wl.entity.Picture;
import com.yj.wl.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PictureServiceImp implements PictureService {
    @Resource
    PictureDao pictureDao;

    @Override
    public boolean savePicture(Picture picture) {
        pictureDao.saveJournalism(picture);
        return true;
    }
}
