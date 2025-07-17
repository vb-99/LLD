package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final int id;
    private final String name;
    private final List<Screen> screens;

    public Theatre(int id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public List<Screen> getScreens() {
        return screens;
    }
    public void addScreen(Screen screen){
        screens.add(screen);
    }
    public Screen getScreen(int id){
       return screens.stream().filter(screen -> screen.getId() == id).findFirst().orElse(null);
    }
}

