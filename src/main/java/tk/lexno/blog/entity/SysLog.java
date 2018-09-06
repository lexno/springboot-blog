package tk.lexno.blog.entity;

import java.util.Date;

public class SysLog {
    private Long id;

    private String ip;

    private Date gmtCreate;

    private Date gmtModified;

    private String remark;

    private String operateUrl;

    private String operateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOperateUrl() {
        return operateUrl;
    }

    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl == null ? null : operateUrl.trim();
    }

    public String getOperateBy() {
        return operateBy;
    }

    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy == null ? null : operateBy.trim();
    }
}