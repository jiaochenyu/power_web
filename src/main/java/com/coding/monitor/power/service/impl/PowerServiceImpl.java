package com.coding.monitor.power.service.impl;

import com.coding.monitor.power.service.PowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guanweiming
 */
@Slf4j
@Service
public class PowerServiceImpl implements PowerService {
    private final RestTemplate restTemplate;

    public PowerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public String check(String orgNo, String provinceNo, String startTime, String endTime) {
        String url = "http://www.95598.cn/95598/outageNotice/queryOutageNoticeList?orgNo=" + orgNo +
                "&provinceNo=" + provinceNo +
                "&anHui=02" +
                "&outageStartTime=" + startTime +
                "&outageEndTime=" + endTime +
                "&scope&typeCode&lineName";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Map<String, String> map = new HashMap<>();
//        map.put("orgNo", "6640404");
//        map.put("provinceNo", "66103");
//        map.put("anHui", "02");
//        map.put("outageStartTime", "2018-08-01");
//        map.put("outageEndTime", "2018-08-30");
//        map.put("scope", "");
//        map.put("typeCode", "");
//        map.put("lineName", "");

        HttpEntity request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        String body = new String(response.getBody().getBytes(Charset.forName("iso-8859-1")));
        log.debug("body:{}", body);
        return body;
    }
}
