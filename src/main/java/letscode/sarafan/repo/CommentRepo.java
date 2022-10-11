package letscode.sarafan.repo;

import letscode.sarafan.domain.Comment;
import letscode.sarafan.domain.Message;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
