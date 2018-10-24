package tk.lexno.blog.dto;

import tk.lexno.blog.entity.ArticleInfo;

public class ArticleDto extends ArticleInfo {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
