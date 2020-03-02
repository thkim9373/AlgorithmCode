package baekjoon;

import java.util.*;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    private HashSet<Friend> visitedFriendSet = new HashSet<>();

    public boolean canBeConnected(Friend friend) {
        Queue<Friend> friends = new PriorityQueue<>();



        for (Friend target : this.getFriends()) {
            if (!this.visitedFriendSet.contains(target)) {
                if (target == friend) {
                    return true;
                }
                target.visitedFriendSet.add(this);
                return target.canBeConnected(friend);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");
        Friend e = new Friend("E");

        a.addFriendship(b);
        b.addFriendship(c);
        c.addFriendship(d);
        d.addFriendship(e);

        System.out.println(a.canBeConnected(e));
    }
}