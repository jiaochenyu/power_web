package com.coding.monitor.power.service;


/**
 * @author guanweiming
 */
public interface PowerService {
    /**
     *
     * @param orgNo
     * @param provinceNo
     * @param startTime
     * @param endTime
     * @return
     */
    String check(String orgNo, String provinceNo, String startTime, String endTime);
}
