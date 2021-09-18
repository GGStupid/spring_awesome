package com.example.spring_awesome.realm;

import com.example.spring_awesome.entity.Role;
import com.example.spring_awesome.entity.User;
import com.example.spring_awesome.service.PermissionService;
import com.example.spring_awesome.service.RoleService;
import com.example.spring_awesome.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date: 2021/9/14 15:33
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		User user = (User) principalCollection.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		List<Role> roleList = roleService.findRoleByUserId(user.getId());
		Set<String> roleSet = new HashSet<>();
		List<Integer> roleIds = new ArrayList<>();

		for (Role role : roleList) {
			roleSet.add(role.getRole());
			roleIds.add(role.getId());
		}

		authorizationInfo.setRoles(roleSet);

		List<String> permissionList = permissionService.findByRoleId(roleIds);
		authorizationInfo.setStringPermissions(new HashSet<>(permissionList));

		log.info("authorizationInfo:{}",roleList);

		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws
			AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		User user = userService.findByAccount(token.getUsername());
		if (user == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
	}
}
