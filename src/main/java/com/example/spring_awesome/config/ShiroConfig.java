package com.example.spring_awesome.config;

import com.example.spring_awesome.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @date: 2021/9/14 15:59
 */
@Configuration
public class ShiroConfig {

	@Bean
	public UserRealm userRealm() {
		return new UserRealm();
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		UserRealm realm = userRealm();
		// 为realm设置凭证匹配器
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		// 设置加密算法
		credentialsMatcher.setHashAlgorithmName("md5");
		// 设置hash次数
		credentialsMatcher.setHashIterations(1024);
		realm.setCredentialsMatcher(credentialsMatcher);
		securityManager.setRealm(realm);
		// 设置安全工具类
		SecurityUtils.setSecurityManager(securityManager);
		return securityManager;
	}

	/**
	 * 路径过滤规则
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		/*
		 * Shiro 内置过滤器，可以实现权限相关的拦截器
		 *     anon:无需认证（登录）可以直接访问
		 *     authc:必须认证才能访问
		 *     user:如果使用rememberMe的功能才可以访问
		 *     perms:该资源得到资源权限才可以访问
		 *     role:该资源必须得到角色权限才可以访问
		 */
		shiroFilterFactoryBean.setLoginUrl("/login");
		shiroFilterFactoryBean.setSuccessUrl("/");
		Map<String, String> map = new LinkedHashMap<>();

		// 有先后顺序
		// 允许匿名访问
		map.put("/login", "anon");
		// 进行身份认证后才能访问
		map.put("/**", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}

	/**
	 * 开启Shiro注解模式，可以在Controller中的方法上添加注解
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
			@Qualifier("securityManager") DefaultSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
				new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
}
