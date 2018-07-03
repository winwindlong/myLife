package com.dream.myLife.common.service;

import com.dream.myLife.cache.util.MemcachedUtil;
import net.rubyeye.xmemcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by zhang on 2018/1/18.
 */
@Service
public class CommonService implements ICommonService {
    private static Logger log = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    private MemcachedClient memcachedClient;

    @PostConstruct
    public void init() throws Exception {
        try {
            MemcachedUtil.setMemcachedClient(this.memcachedClient);
        } catch (Exception e) {
            log.error("系统初始化出错!!!!{}", e);
            throw e;
        }
    }
}
