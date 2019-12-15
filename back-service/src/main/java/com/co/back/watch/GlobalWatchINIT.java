package com.co.back.watch;

import com.co.back.config.PublishCenter;
import com.co.back.vo.CallingMobileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther skg
 * @Date: 2019/12/11
 *
 */
@Component
public class GlobalWatchINIT implements CommandLineRunner {

    @Autowired
    private CopyOnWriteArrayList<CallingMobileVo> timeOutWatcherList;

    @Autowired
    private PublishCenter publishCenter;


    @Override
    public void run(String... args) throws Exception {



    }
}
