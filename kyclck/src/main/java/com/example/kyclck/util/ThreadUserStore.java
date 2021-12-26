package com.example.kyclck.util;

public class ThreadUserStore {
	
    private Long userId;
    public ThreadUserStore(Long userId, Long orgId) {
		super();
		this.userId = userId;
		this.orgId = orgId;
	}

	public Long getUserId() {
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

	private Long orgId;

    public void setUserData(Long userId, Long orgId) {
        this.userId = userId;
        this.orgId = orgId;
    }

    public void clear() {
        this.userId = null;
        this.orgId = null;
    }

}
