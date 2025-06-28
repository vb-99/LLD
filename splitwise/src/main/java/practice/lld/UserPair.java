package practice.lld;

public class UserPair {
    private User user1;
    private User user2;
    public UserPair(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    public User getUser1() {
        return user1;
    }
    public User getUser2() {
        return user2;
    }
    @Override
    public int hashCode() {
        return user1.hashCode() + user2.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof UserPair){
            UserPair pair = (UserPair) obj;
            return pair.getUser1().equals(user1) && pair.getUser2().equals(user2);
        }
        return false;
    }
}
