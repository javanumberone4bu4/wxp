package com.rimi.item.entity;

/**
 * 角色
 *
 * @author Wang Xiaoping
 * @date 2019/9/24 21:49
 */
public class Role {
    private Integer id;
    private String roleName;
    private String roleRule;
    private String roleDescription;

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
        this.roleName = roleName;
    }

    public String getRoleRule() {
        return roleRule;
    }

    public void setRoleRule(String roleRule) {
        this.roleRule = roleRule;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleRule='" + roleRule + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}
