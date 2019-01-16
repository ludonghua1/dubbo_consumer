package com.yitian.ldh.model;

public class Role {
    private Integer id;

    private String roleName;

    private String roleEnglishName;

    private Integer isAvailable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleEnglishName() {
        return roleEnglishName;
    }

    public void setRoleEnglishName(String roleEnglishName) {
        this.roleEnglishName = roleEnglishName == null ? null : roleEnglishName.trim();
    }

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }
}