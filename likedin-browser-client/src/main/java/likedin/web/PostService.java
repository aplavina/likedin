package likedin.web;

import likedin.Post;

public interface PostService {
  Iterable<Post> findRecent();
}
