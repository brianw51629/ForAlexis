import java.util.ArrayList;

public class Post {
    private String title;
    private String content;
    private Post replyTo;
    private User author;
    private int upvoteCount;
    private int downvoteCount;


    public Post(String title, String content, User author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.upvoteCount = 1; 
        this.downvoteCount = 0; 
    }
    public Post(String content, Post replyTo, User author) {
        this.title = null; 
        this.content = content;
        this.author = author;
        this.upvoteCount = 1; 
        this.downvoteCount = 0; 
        this.replyTo = replyTo; 
    }
    public String getTitle() {
        return title;
    }
    public Post getReplyTo() {
        return replyTo;
    }
    public User getAuthor() {
        return author;
    }
    public int getUpvoteCount() {
        return upvoteCount;
    }
    public int getDownvoteCount(){
        return downvoteCount;
    }
    public void updateUpvoteCount(boolean isIncrement){
        if(isIncrement){
            upvoteCount++;
        }

        
    }
    public void updateDownvoteCount(boolean isIncrement){
        if(isIncrement){
            downvoteCount++;
        }

        
    }
    public ArrayList<Post> getThread() {
    ArrayList<Post> thread = new ArrayList<>();
    Post current = this;

    while (current != null) {
        thread.add(current);
        current = current.replyTo; 
    }

    
    ArrayList<Post> reversedThread = new ArrayList<>();
    
    
    for (int i = thread.size() - 1; i >= 0; i--) {
        reversedThread.add(thread.get(i));
    }

    return reversedThread;
}

    @Override
    public String toString() {
        String TO_STRING_POST_FORMAT = "[%d|%d]\t%s\n\t%s";
        String TO_STRING_COMMENT_FORMAT = "[%d|%d]\t%s";
        if (title != null) {
           
            return String.format(TO_STRING_POST_FORMAT, upvoteCount, downvoteCount, title, content);
        } else {
           
            return String.format(TO_STRING_COMMENT_FORMAT, upvoteCount, downvoteCount, content);
        }
    }





}
