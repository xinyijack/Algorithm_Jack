package FourthWeek_Work.DesignTwitter;


/**
 * 第四周作业：355. 设计推特
 */
public class Twitter {
    private static int timestamp;
    private HashMap<Integer, User> userMap;

    /** Initialize your data structure here. */
    public Twitter() {
        timestamp = 0;
        userMap = new HashMap<>();
    }

    private static class User{
        private int id;
        public Set<Integer> followed;

        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;

            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollow(int userId) {
            if (this.id != userId)
                followed.remove(userId);
        }

        public void post(int tweetId) {
            Tweet twt = new Tweet(tweetId, timestamp);
            timestamp++;

            twt.next = head;
            head = twt;
        }
    }

    private static class Tweet{
        private int id;
        private int time;
        private Tweet next;

        public Tweet (int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User u = userMap.get(userId);
        u.post(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        Set<Integer> users = userMap.get(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a,b) -> (b.time - a.time));
        for (int id : users) {
            Tweet twt = userMap.get(id).head;
            if (twt == null) continue;
            pq.add(twt);
        }

        while (!pq.isEmpty()) {

            if (res.size() == 10) break;
            Tweet twt = pq.poll();
            res.add(twt.id);

            if (twt.next != null) {
                pq.add(twt.next);
            }
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }

        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
