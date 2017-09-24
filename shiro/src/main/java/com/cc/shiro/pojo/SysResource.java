package com.cc.shiro.pojo;

public class SysResource {
    private Long id;

    private String name;

    //private String type;

    private String url;

    private Long parentId;

    private String parentIds;

    private String permission;

    private Boolean available;
    
    private ResourceType type = ResourceType.menu; //��Դ����
    
    public static enum ResourceType {
        menu("�˵�"), button("��ť");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /*public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
*/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
    
    public boolean isRootNode() {
        return parentId == 0;
    }

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}
    
}