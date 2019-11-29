package com.yisu.server.config;

import com.yisu.server.properties.OAuth2ClientProperties;
import com.yisu.server.properties.SecurityProperties;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    @Autowired(required = false)
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
//
//    @Autowired(required = false)
//    private TokenEnhancer jwtTokenEnhancer;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore)
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService);
//        //扩展token返回结果
//        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
//            TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//            List<TokenEnhancer> enhancerList = new ArrayList();
//            enhancerList.add(jwtTokenEnhancer);
//            enhancerList.add(jwtAccessTokenConverter);
//            tokenEnhancerChain.setTokenEnhancers(enhancerList);
//            //jwt
//            endpoints.tokenEnhancer(tokenEnhancerChain)
//                    .accessTokenConverter(jwtAccessTokenConverter);
//        }
        endpoints.tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .userDetailsService(userDetailsService);
    }

    /**
     * 配置客户端一些信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        InMemoryClientDetailsServiceBuilder build = clients.inMemory();
//        if (ArrayUtils.isNotEmpty(securityProperties.getOauth().getClients())) {
//            for (OAuth2ClientProperties config : securityProperties.getOauth().getClients()) {
//                build.withClient(config.getClientId())
//                        .secret(passwordEncoder.encode(config.getClientSecret()))
//                        .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
//                        .refreshTokenValiditySeconds(config.getRefreshTokenValiditySecond())
//                        .authorizedGrantTypes("refresh_token", "password", "authorization_code")//OAuth2支持的验证模式
//                        .redirectUris(config.getRedirectUri())
//                        .autoApprove(config.getAutoApprove())//设置自动认证
//                        .scopes(config.getScope());
//            }
//        }
        clients.inMemory()
                .withClient("test1")
                .secret(passwordEncoder.encode("test1"))
                .authorizedGrantTypes("refresh_token","authorization_code")
                .accessTokenValiditySeconds(3600)
                .scopes("all")
                .autoApprove(true)
                .redirectUris("http://127.0.0.1:8081/client1/login")
                .and()
                .withClient("test2")
                .secret(passwordEncoder.encode("test2"))
                .authorizedGrantTypes("refresh_token","authorization_code")
                .accessTokenValiditySeconds(7200)
                .scopes("all")
                .autoApprove(true)
                .redirectUris("http://127.0.0.1:8082/client2/login");
    }


    /**
     * springSecurity 授权表达式，
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()");
    }


    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey(securityProperties.getOauth().getJwtSigningKey());
        return accessTokenConverter;
    }
}
