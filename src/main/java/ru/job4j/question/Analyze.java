package ru.job4j.question;

import java.util.*;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> userMap = new HashMap<>();
        int counter = 0;
        for (User user : previous) {
            userMap.put(user.getId(), user.getName());
        }
        for (User user : current) {
            if (!userMap.containsKey(user.getId())) {
                info.setAdded(++counter);
            }
            if (userMap.containsKey(user.getId()) && !userMap.containsValue(user.getName())) {
                info.setChanged(++counter);
            }
            userMap.remove(user.getId());
            info.setDeleted(userMap.size());
        }
        return info;
    }
}
