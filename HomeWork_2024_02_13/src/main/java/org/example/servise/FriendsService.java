package org.example.servise;

import org.example.pojo.Friend;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FriendsService {
    private List<Friend> friends;

    public FriendsService() {
        this.friends = new ArrayList<>();
    }

    public void addNewRecord(Friend friend) {
        friends.add(friend);
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public List<Friend> getTodayBirthdayFriend() {
        LocalDate today = LocalDate.now();
        return friends.stream()
                .filter(f ->
                        f.birthday().getMonth() == today.getMonth() &&
                                f.birthday().getDayOfMonth() == today.getDayOfMonth()
                ).toList();
    }

    public List<Friend> getFriendsByDate(LocalDate date) {
        return friends.stream()
                .filter(f -> f.birthday().getMonth() == date.getMonth() &&
                        f.birthday().getDayOfMonth() == date.getDayOfMonth()).toList();
    }

    public LocalDate getDate(String firstName, String lastName) {
        Friend friend = friends.stream()
                .filter(f -> Objects.equals(f.firstName(), firstName) && Objects.equals(f.lastName(), lastName))
                .findFirst().orElseThrow();
        return LocalDate.of(LocalDate.now().getYear(), friend.birthday().getMonth(), friend.birthday().getDayOfMonth());
    }

    public boolean isAbsentFriend(String firstName, String lastName) {
        return friends.stream()
                .noneMatch(friend -> friend.firstName().equals(firstName) && friend.lastName().equals(lastName));

    }

}
