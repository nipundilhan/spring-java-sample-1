package com.example.kyclck.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class UserUtil {
	
    @Autowired
    UserStore requestUserStore;
	
    public Long getUserId(String jwtToken) {
        return getUserId();
    }

    public static ThreadLocal<ThreadUserStore> threadUserStore = new ThreadLocal<>();


    public Long getUserId() {
        if (null != RequestContextHolder.getRequestAttributes()) {
            System.out.println("*************************** Request User found *******************************");
            return requestUserStore.getUserId();
        } else {
            try {
                return threadUserStore.get().getUserId();
            } catch (Exception e) {
                return 1l;
            }
        }
    }


    public Long getOrgId() {
        if (null != RequestContextHolder.getRequestAttributes()) {
            return requestUserStore.getOrgId();
        } else {
            try {
                return threadUserStore.get().getOrgId();
            } catch (Exception e) {
                return 1l;
            }
        }
    }

}
