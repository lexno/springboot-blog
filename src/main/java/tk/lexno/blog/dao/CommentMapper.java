package tk.lexno.blog.dao;

import java.util.List;
import tk.lexno.blog.entity.Comment;
import tk.lexno.blog.entity.CommentExample;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}