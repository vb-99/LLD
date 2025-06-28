package practice.lld;

import java.util.Objects;

public class User {
    private String id;
    private String name;
    private String email;

    User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
       if(this == o) return true;
       if(o == null || getClass() != o.getClass()) return false;
       User user = (User) o;
       return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
