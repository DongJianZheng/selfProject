package com.djz.self.config;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.djz.self.filter.ShiroLoginFilter;
import com.djz.self.security.realm.MyShiroCasRealm;
import com.djz.self.session.CasLogoutFilter;
import com.djz.self.session.ShiroSessionManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

@Configuration
@AutoConfigureAfter(ShiroLifecycleBeanPostProcessorConfig.class)
public class ShiroConfig implements ApplicationContextAware {
    private static final String casFilterUrlPattern = "/self";

    @Autowired
    private CasLogoutFilter casLogoutFilter;
    @Bean
    public SingleSignOutFilter singleSignOutFilter(){
        return new SingleSignOutFilter();
    }


    public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener(){
        return new SingleSignOutHttpSessionListener();
    }
    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> singleSignOutHttpSessionListenerBean() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listenerRegistrationBean = new ServletListenerRegistrationBean<>();
        listenerRegistrationBean.setEnabled(true);
        listenerRegistrationBean.setListener(singleSignOutHttpSessionListener());
        listenerRegistrationBean.setOrder(3);
        System.out.println("================================singleListener执行");
        return listenerRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));

        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("serverName", "http://127.0.0.1:8086");
        initParameters.put("targetFilterLifecycle", "true");
        filterRegistration.setInitParameters(initParameters);
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }



    @Bean(name = "myShiroCasRealm")
    public MyShiroCasRealm getMyShiroCasRealm(@Value("${shiro.cas}") String casServerUrlPrefix,
                                              @Value("${shiro.server}") String shiroServerUrlPrefix){
        MyShiroCasRealm casRealm = new MyShiroCasRealm();
        casRealm.setDefaultRoles("ROLE_USER");
        casRealm.setCasServerUrlPrefix(casServerUrlPrefix);
        casRealm.setCasService(shiroServerUrlPrefix + casFilterUrlPattern);
        return casRealm;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myShiroCasRealm")MyShiroCasRealm myShiroCasRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroCasRealm);
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        securityManager.setSubjectFactory(new CasSubjectFactory());
        //自定义session管理
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put(casFilterUrlPattern, "casLogoutFilter,casFilter");


        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/cas/**","anon");

        filterChainDefinitionMap.put("/self/login", "anon");
        filterChainDefinitionMap.put("/self/logout", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");

        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/self/**", "authc");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }



    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager,
                                                            CasFilter casFilter,
                                                            @Value("${shiro.cas}") String casServerUrlPrefix,
                                                            @Value("${shiro.server}") String shiroServerUrlPrefix) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + casFilterUrlPattern;
        //shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setSuccessUrl("/index");
        Map<String, Filter> filters = new HashMap<>();
        LogoutFilter logoutFilter = new LogoutFilter();
        filters.put("logout",logoutFilter);
        logoutFilter.setRedirectUrl("/login");
        filters.put("casLogoutFilter", casLogoutFilter);
        filters.put("casFilter", casFilter);
        filters.put("authc", new ShiroLoginFilter());
        shiroFilterFactoryBean.setFilters(filters);

        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }
    /**
     * CAS Filter
     */
    @Bean(name = "casFilter")
    public CasFilter getCasFilter(@Value("${shiro.cas}") String casServerUrlPrefix,
                                  @Value("${shiro.server}") String shiroServerUrlPrefix) {
        CasFilter casFilter = new CasFilter();
        casFilter.setName("casFilter");
        casFilter.setEnabled(true);
        String loginUrl = casServerUrlPrefix + "/login?service=" + shiroServerUrlPrefix + casFilterUrlPattern;
        casFilter.setFailureUrl(loginUrl);

        return casFilter;
    }

    //添加bean
    /**
     * 自定义sessionManager
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        ShiroSessionManager shiroSessionManager = new ShiroSessionManager();
        //这里可以不设置。Shiro有默认的session管理。如果缓存为Redis则需改用Redis的管理
        shiroSessionManager.setSessionDAO(new EnterpriseCacheSessionDAO());
        return shiroSessionManager;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Realm myShiroCasRealm = (Realm) applicationContext.getBean("myShiroCasRealm");
        DefaultWebSecurityManager defaultWebSecurityManager = (DefaultWebSecurityManager)applicationContext.getBean("securityManager");
        defaultWebSecurityManager.setRealm(myShiroCasRealm);

    }



}