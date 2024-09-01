import java.util.ArrayList;

public class User {
    private String username;
    private ArrayList<Post> posts;
    private ArrayList<Post> upvoted;
    private ArrayList<Post> downvoted;
    private int karma;

    public User(String username) {
        this.username = username;
        this.posts = new ArrayList<>();
        this.upvoted = new ArrayList<>();
        this.downvoted = new ArrayList<>();
        this.karma = 0;
    }

    public void addPost(Post post) {
        if (post == null) return;
        posts.add(post);
        updateKarma();
    }

    public void updateKarma() {
        karma = 0;
        for (Post post : posts) {
            karma += post.getUpvoteCount() - post.getDownvoteCount();
        }
    }

    public int getKarma() {
        return karma;
    }

    public void upvote(Post post) {
        if (post == null || post.getAuthor() == this) return;
        
        if (downvoted.contains(post)) {
            downvoted.remove(post);
            post.updateDownvoteCount(false);
        }
        
        if (!upvoted.contains(post)) {
            upvoted.add(post);
            post.updateUpvoteCount(true);
            updateKarma();
            post.getAuthor().updateKarma();
        }
    }

    public void downvote(Post post) {
        if (post == null || post.getAuthor() == this) return;
        
        if (upvoted.contains(post)) {
            upvoted.remove(post);
            post.updateUpvoteCount(false);
        }
        
        if (!downvoted.contains(post)) {
            downvoted.add(post);
            post.updateDownvoteCount(true);
            updateKarma();
            post.getAuthor().updateKarma();
        }
    }

    public Post getTopPost() {
        Post topPost = null;
        int maxScore = Integer.MIN_VALUE;

        for (Post post : posts) {
            int score = post.getUpvoteCount() - post.getDownvoteCount();
            if (score > maxScore) {
                maxScore = score;
                topPost = post;
            }
        }

        return topPost;
    }

    public Post getTopComment() {
        Post topComment = null;
        int maxScore = Integer.MIN_VALUE;

        for (Post post : posts) {
            if (post.getReplyTo() != null) { 
                int score = post.getUpvoteCount() - post.getDownvoteCount();
                if (score > maxScore) {
                    maxScore = score;
                    topComment = post;
                }
            }
        }

        return topComment;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return String.format("u/%s Karma: %d", username, karma);
    }
}