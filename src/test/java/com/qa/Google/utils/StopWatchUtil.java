package com.qa.Google.utils;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * @author jitin.doriya
 */
public class StopWatchUtil {

    StopWatch pageLoad = new StopWatch();

    public void startStopWatch() {
        if (pageLoad.isStopped()) {
            pageLoad.reset();
            pageLoad.start();
        }
    }

    public void pauseStopWatch() {
        pageLoad.suspend();
    }

    public void stopStopWatch() {
        pageLoad.stop();
    }

    public void getStopWatch() {
        pageLoad.getTime(TimeUnit.MILLISECONDS);
    }

    public long getStopWatchTime() {
        return pageLoad.getTime(TimeUnit.MILLISECONDS);
    }
}
