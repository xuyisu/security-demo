package com.yisu.oauth2.db.service;

import com.yisu.oauth2.db.constant.FwAuthConstant;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;
import javax.validation.constraints.Size;

/**
 * @author xuyisu
 * @data 2019/12/1
 */
@Slf4j
public class FwClientDetailsService extends JdbcClientDetailsService {

    public FwClientDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * 重写原生方法支持redis缓存
     *
     * @param clientId
     * @return
     */
    @Override
    @Cacheable(value = FwAuthConstant.CLIENT_DETAILS_KEY, key = "#clientId", unless = "#result == null")
    public ClientDetails loadClientByClientId(String clientId) {
        log.info(clientId);
        return super.loadClientByClientId(clientId);
    }
}