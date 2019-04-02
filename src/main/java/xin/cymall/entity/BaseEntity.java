package xin.cymall.entity;

import xin.cymall.common.shiro.ShiroUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 基础 entity
 * @author wcy
 * @date 2019年2月28日16:21:52
 */
public abstract class BaseEntity {
    /**
     * 主键
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private Integer createUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改人
     */
    private Integer updateUser;
    /**
     * 删除标记 1:删除 0:未删除
     */
    private Integer delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public void preSave(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.id = UUID.randomUUID().toString();
            this.createTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            this.createUser = Integer.parseInt(String.valueOf(ShiroUtils.getUserId()));
            this.updateTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            this.updateUser = Integer.parseInt(String.valueOf(ShiroUtils.getUserId()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void preUpdate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.updateTime = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            this.updateUser = Integer.parseInt(String.valueOf(ShiroUtils.getUserId()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
