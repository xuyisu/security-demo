package com.yisu.oauth2.db.constant;

/**
 * @author xuyisu
 * @data 2019/12/2
 */
public interface FwAuthConstant {

    /**
     * oauth 拦截
     */
    String END_POINT_OAUTH_ALL = "/token/**";

    /**
     * 认证类型参数 key
     */
    String GRANT_TYPE = "grant_type";

    /**
     * 认证模式-刷新模式
     */
    String REFRESH_TOKEN = "refresh_token";
    /**
     * 认证模式-授权码模式
     */
    String AUTHORIZATION_CODE = "authorization_code";
    /**
     * 认证模式-客户端模式
     */
    String CLIENT_CREDENTIALS = "client_credentials";
    /**
     * 认证模式-密码模式
     */
    String PASSWORD = "password";
    /**
     * 认证模式-简化模式
     */
    String IMPLICIT = "implicit";

    //改写默认JdbcClient 执行sql


    /**
     * sys_oauth_client 表的字段
     */
    String CLIENT_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     * JdbcClientDetailsService 查询语句
     */
    String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client";

    /**
     * 按条件client_id 查询
     */
    String REWRITE_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

    /**
     * 默认的查询语句
     */
    String REWRITE_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 密码处理
     */
    String  BCRYPT = "{bcrypt}";
    /**
     * 启用状态
     */
    int STATUS_ENABLE = 0;

    /**
     * 项目前缀
     */
    String PROJECT_PREFIX = "fw:";
    /**
     * 单点登录前缀
     */
    String OAUTH2_PREFIX = "oauth:";

    /**
     * oauth 客户端信息
     */
    String CLIENT_DETAILS_KEY = PROJECT_PREFIX + OAUTH2_PREFIX + "client:details";

}
