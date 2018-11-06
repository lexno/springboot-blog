package tk.lexno.blog.service.impl;

import org.springframework.stereotype.Service;
import tk.lexno.blog.dao.CommentMapper;
import tk.lexno.blog.entity.Comment;
import tk.lexno.blog.entity.CommentExample;
import tk.lexno.blog.service.CommentService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setDelete(Boolean.TRUE);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public void deleteCommentByArticleId(Long id) {
        commentMapper.deleteByArticleId(id);
    }

    @Override
    public List<Comment> listByArticleId(Long id) {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteEqualTo(Boolean.FALSE);
        criteria.andArticleIdEqualTo(id);
        return commentMapper.selectByExample(example);
    }

    @Override
    public List<Comment> listAllComments() {
        CommentExample example = new CommentExample();
        CommentExample.Criteria criteria = example.createCriteria();
        criteria.andDeleteEqualTo(Boolean.FALSE);
        return commentMapper.selectByExample(example);
    }
}
