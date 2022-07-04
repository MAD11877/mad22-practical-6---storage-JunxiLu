package sg.edu.np.mad.junxiprac2;

public class user {
    String name;
    String description;
    int id;
    boolean followed;

    public user() {}

    public user(String n, String desc, int num, boolean follow) {
        name = n;
        description = desc;
        id = num;
        followed = follow;
    }

    public void SetUserID(int id) {
        this.id = id;
    }

    public int getUserID() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDesc(String desc)
    {
        this.description = desc;
    }

    public String getDesc() {
        return this.description;
    }

    public void setFollowStatus(boolean follow){
        this.followed = follow;
    }

    public boolean getFollowStatus() {
        return this.followed;
    }
}

