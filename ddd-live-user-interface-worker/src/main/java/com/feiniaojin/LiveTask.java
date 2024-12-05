package com.feiniaojin;

import com.feiniaojin.ddd.live.application.service.live.LiveCommandService;
import com.feiniaojin.ddd.live.application.service.live.dto.ForbiddenStreamCommand;
import com.feiniaojin.ddd.live.domain.LiveId;

import java.util.ArrayList;
import java.util.List;

public class LiveTask {

    private LiveCommandService commandService;

    //定义定时任务
    public  void doTask(){
        //mapper 查询出唯一标识
        List<String> list=new ArrayList<>();
        //
        for(String id :list){
            //封装成 command对象
            ForbiddenStreamCommand cmd=new ForbiddenStreamCommand();
            //commandService进行处理
            commandService.forbiddenStream(cmd);
        }
    }
}
