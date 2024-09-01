public class Tester {
    public static void main(String[] args) {
        
        User u1 = new User("CSE11Student");
        User u2 = new User("AnotherUser");

        
        Post p1 = new Post("Title 1", "Content 1", u1);
        Post p2 = new Post("Title 2", "Content 2", u1);
        Post c1 = new Post("Comment 1", p1, u1);
        Post c2 = new Post("Comment 2", p1, u2);

        
        System.out.println("Initial States:");
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(c1);
        System.out.println(c2);

        
        u1.addPost(p1);
        u1.addPost(p2);
        u1.addPost(c1);
        u2.addPost(c2);

        
        System.out.println("\nAfter Adding Posts:");
        System.out.println(u1);
        System.out.println(u2);

        
        System.out.println("\nTesting Upvotes and Downvotes:");
        u1.upvote(p1);
        u1.downvote(p2);
        u2.upvote(c2);

        
        System.out.println("\nUser 1 Posts After Upvoting and Downvoting:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(c1);

        System.out.println("\nUser 2 Posts After Upvoting and Downvoting:");
        System.out.println(c2);

        
        System.out.println("\nTop Post for User 1:");
        System.out.println(u1.getTopPost());

        System.out.println("\nTop Comment for User 1:");
        System.out.println(u1.getTopComment());

        System.out.println("\nTop Post for User 2:");
        System.out.println(u2.getTopPost());

        System.out.println("\nTop Comment for User 2:");
        System.out.println(u2.getTopComment());
    }
}
