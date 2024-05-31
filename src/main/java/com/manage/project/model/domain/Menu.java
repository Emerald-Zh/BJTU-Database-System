package com.manage.project.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @TableName menu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    /**
     * 
     */
    private Integer menuId;

    /**
     * 
     */
    private String menuName;

    /**
     * 
     */
    private BigDecimal menuPrice;

    /**
     * 
     */
    private String menuClass;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 
     */
    public BigDecimal getMenuPrice() {
        return menuPrice;
    }

    /**
     * 
     */
    public void setMenuPrice(BigDecimal menuPrice) {
        this.menuPrice = menuPrice;
    }

    /**
     * 
     */
    public String getMenuClass() {
        return menuClass;
    }

    /**
     * 
     */
    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Menu other = (Menu) that;
        return (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()))
            && (this.getMenuName() == null ? other.getMenuName() == null : this.getMenuName().equals(other.getMenuName()))
            && (this.getMenuPrice() == null ? other.getMenuPrice() == null : this.getMenuPrice().equals(other.getMenuPrice()))
            && (this.getMenuClass() == null ? other.getMenuClass() == null : this.getMenuClass().equals(other.getMenuClass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        result = prime * result + ((getMenuName() == null) ? 0 : getMenuName().hashCode());
        result = prime * result + ((getMenuPrice() == null) ? 0 : getMenuPrice().hashCode());
        result = prime * result + ((getMenuClass() == null) ? 0 : getMenuClass().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", menuId=").append(menuId);
        sb.append(", menuName=").append(menuName);
        sb.append(", menuPrice=").append(menuPrice);
        sb.append(", menuClass=").append(menuClass);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}