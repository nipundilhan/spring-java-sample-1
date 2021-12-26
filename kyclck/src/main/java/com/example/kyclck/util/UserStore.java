package com.example.kyclck.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class UserStore {
	
    @Autowired(required = false)
    AccessToken accessToken;
    public static final String PARAM_USER_ID = "etfbUserId";//"userId";
    private Long userId;
    private Long orgId;
    private List<String> permissions = new ArrayList<String>();
    
    @SuppressWarnings("unchecked")
    @PostConstruct
    public void setUserData() {
        System.out.println("setUserData()...................." + accessToken);

        if (accessToken != null) {//Happens only when security is disabled
            //setting userId
            this.userId = ((Number) accessToken.getOtherClaims().get(PARAM_USER_ID)).longValue();
            this.orgId = 1l;
            /* Page<OrganizationUser> orgUser = organizationUserRepository.findByUserId_IdAndActive(userId, true, null);
            if (!orgUser.isEmpty()) {
                this.orgId = orgUser.getContent().get(0).getOrganizationId().getId();
            }
            //setting permissions
            Collection<SimpleGrantedAuthority> authentication = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            authentication.stream().forEach(role -> {
                System.out.println(">> " + role.getAuthority());
                this.permissions.add(role.getAuthority());
            });*/
        } else {
            userId = 21l;
            orgId = 4L;
        }
    }
    
	public Long getUserId() {
        if (userId == null) {
            System.out.println("userId was not found in token. Setting the default value 12l");
            userId = 21l;
        }
        return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

}
