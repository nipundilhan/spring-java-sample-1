package com.example.kyclck.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;

public class TestGrantedAuthorityMapper implements GrantedAuthoritiesMapper, InitializingBean {
//	private static final String PARAM_USER_ID = "userId";

	
	public void afterPropertiesSet() throws Exception {
		//Nothing to do at the moment
	}

	@Override
	public List<GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> setAuthoritiesList = null;
		try {
			//AccessToken accessToken = SpringContext.getBean(AccessToken.class);
			setAuthoritiesList = setAuthoritiesList(null);
		} catch (Exception e) {
			System.out.println("INFO: No AccessToken in the context. This usually happens when you have disabled the security.)");
		}
		return setAuthoritiesList;
	}
	
	
	private List<GrantedAuthority> setAuthoritiesList(AccessToken accessToken) {
		/*We cannot use AccessToken object in this class. It is not yet constructed.*/
		/*Should get authorities from DB and return*/
		String userId = getUserIdFromToken();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" start ");
		System.out.println(" ");
		System.out.println(" ---------------- ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("user id is - "+ userId);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ---------------- ");
		System.out.println(" ");
		System.out.println(" end  ");
		System.out.println(" ");
		System.out.println(" ");
		//return AuthorityUtils.createAuthorityList(createAuthoritiesFromDatabase(userId));
		return AuthorityUtils.createAuthorityList(createTempAuthorities());
	}
	
	
		
		
	private String[] createTempAuthorities () {
		
		String[] permissionsFromDatabase = {"ACTION_1_PERMISSION", "ACTION_2_PERMISSION", "ACTION_3_PERMISSION"};
		String[] prefixedPermissions = new String[permissionsFromDatabase.length];
		for (int i = 0; i < permissionsFromDatabase.length; i++) {
			prefixedPermissions[i] = permissionsFromDatabase[i];
		}
		return prefixedPermissions;
	}
	

	
	@SuppressWarnings("unchecked")
	private String getUserIdFromToken() {
		KeycloakPrincipal<KeycloakSecurityContext> kcPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>)((SecurityContextHolder.getContext().getAuthentication()).getPrincipal());
		Map<String, Object> otherClaims = kcPrincipal.getKeycloakSecurityContext().getToken().getOtherClaims();
		return  otherClaims.get("etfbUserId").toString();
	}


}
