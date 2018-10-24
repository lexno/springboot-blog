package tk.lexno.blog.service;

import tk.lexno.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 添加评论
     * @param comment 评论
     */
    void addComment(Comment comment);

    /**
     * 删除评论
     * @param id 评论id
     */
    void deleteCommentById(Long id);

    /**
     * 根据文章id删除评论
     * @param id 文章id
     */
    void deleteCommentByArticleId(Long id);

    /**
     * 根据文章id查询评论
     * @param id 文章id
     * @return 评论集合
     */
    List<Comment> listByArticleId(Long id);
}
