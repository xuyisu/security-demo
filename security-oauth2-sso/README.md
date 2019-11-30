 ### 本节主要是默认的security SSO 单点登录
 

 
##1.项目结构
security-oauth-sso
├── security-oauth-sso-client1 -- 客户端1
└── security-oauth-sso-client2 -- 客户端2
└── security-oauth-sso-server -- 服务端
     
##2.介绍
###2.1 项目启动
       1、先启动server端
       2.client1和client2随意

###2.2 登录
浏览器输入`http://127.0.0.1:8081/client1/index.html`会跳转到登录页
![login](images/login.png)
 密码是`123456`，账号随意，成功后会跳转到`http://127.0.0.1:8081/client1/index.html`
![client1](images/client1.png)
点击之后就会client1和client2之间互相跳转，
每次重启之后会重新登录
####2.3 server端AuthorizationServer配置
```java
/**
     * 配置客户端一些信息
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder build = clients.inMemory();
        if (ArrayUtils.isNotEmpty(securityProperties.getOauth().getClients())) {
            for (OAuth2ClientProperties config : securityProperties.getOauth().getClients()) {
                build.withClient(config.getClientId())
                        .secret(passwordEncoder.encode(config.getClientSecret()))
                        .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
                        .refreshTokenValiditySeconds(config.getRefreshTokenValiditySecond())
                        .authorizedGrantTypes("refresh_token", "password", "authorization_code")//OAuth2支持的验证模式
                        .redirectUris(config.getRedirectUri())
                        .autoApprove(config.getAutoApprove())//设置自动认证
                        .scopes(config.getScope());
            }
        }
    }
```
所需要的配置信息设置在application.yml里面
```yaml
fw:
  security:
    oauth:
      jwtSigningKey: security
      clients[0]:
        clientId: test1
        clientSecret: test1
        redirectUri: http://127.0.0.1:8081/client1/login
        autoApprove: true
      clients[1]:
        clientId: test2
        clientSecret: test2
        redirectUri: http://127.0.0.1:8082/client2/login
        autoApprove: true
```
###2.4 Server SecurityConfig的配置
对index.html页面放行
```java
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().
                and().authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .and()
                .authorizeRequests().
                anyRequest().
                authenticated();

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```
###2.5 客户端的配置
需要开启`@EnableOAuth2Sso`注解
```java
@SpringBootApplication
@EnableOAuth2Sso
public class FwSsoClient2Application {
	

	public static void main(String[] args) {
		SpringApplication.run(FwSsoClient2Application.class, args);
	}
	
}
```
###2.6 启动权限表达式的配置
开启权限表达式需要在设置Order为100之后的数字(数字越小越先加载)
```java
@Order(101)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
}
```
WebSecurityConfigurerAdapter的默认的Order
```java
@Order(100)
public abstract class WebSecurityConfigurerAdapter implements WebSecurityConfigurer<WebSecurity> {
    private final Log logger;
    private ApplicationContext context;
    private ContentNegotiationStrategy contentNegotiationStrategy;
    .....
```
###2.7 接口
1.访问业务接口 `http://127.0.0.1:8081/client1/user` ,只有用户登录成功之后才能访问。
```json
{"authorities":[{"authority":"ROLE_USER"}],"details":{"remoteAddress":"127.0.0.1","sessionId":"21A7B37ADDDC7D134BE88CA500C92A3A","tokenValue":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzUwOTI3NjYsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6Ijg3NzgwMWMwLTZhN2YtNDUzNS1iZGIwLWViZmVjYmY1NTQ0YyIsImNsaWVudF9pZCI6InRlc3QxIiwic2NvcGUiOlsiYWxsIl19.gErzPZqyOJiTzt0ZOsLDzURfSw1kXThigRFI2rMa-PI","tokenType":"bearer","decodedDetails":null},"authenticated":true,"userAuthentication":{"authorities":[{"authority":"ROLE_USER"}],"details":null,"authenticated":true,"principal":"admin","credentials":"N/A","name":"admin"},"oauth2Request":{"clientId":"test1","scope":["all"],"requestParameters":{"client_id":"test1"},"resourceIds":[],"authorities":[],"approved":true,"refresh":false,"redirectUri":null,"responseTypes":[],"extensions":{},"grantType":null,"refreshTokenRequest":null},"clientOnly":false,"principal":"admin","credentials":"","name":"admin"}
```
2.访问`http://127.0.0.1:8081/client1/normal`
```json
这是用户正常权限访问的数据
```
3.访问`http://127.0.0.1:8081/client1/admin`
```json
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sat Nov 30 11:47:54 CST 2019
There was an unexpected error (type=Forbidden, status=403).
Forbidden
```
因为权限不够