package com.yj.wl.controller;

import com.yj.wl.entity.Ajax;
import com.yj.wl.entity.Journalism;
import com.yj.wl.service.serviceImp.JournalismServiceImp;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/Journalisms")
public class JournalismController {


    @Resource
    JournalismServiceImp journalismServiceImp;



    @GetMapping("/getJournalism")
    public Ajax allJournalism(){
        return Ajax.success(journalismServiceImp.allJournalism());
    }

    @PostMapping("/postSaveJournalism")
    public Ajax saveJournalism(Journalism journalism){
        return Ajax.success(journalismServiceImp.saveJournalism(journalism));
    }

    @PutMapping("/updataJournalism")
    public Ajax updataJournalism(Journalism journalism){
        journalismServiceImp.updataJournalism(journalism);
        return Ajax.success();
    }

    @DeleteMapping("/deleteJournalism")
    public Ajax deleteJournalism(Journalism journalism){
        journalismServiceImp.deleteJournalism(journalism.getId());
        return Ajax.success();

    }
}
