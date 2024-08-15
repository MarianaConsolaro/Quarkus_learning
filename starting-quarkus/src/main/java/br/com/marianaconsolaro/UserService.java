package br.com.marianaconsolaro;

import java.util.Set;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UserService {
    Set<User> users = Collections.synchronizedSet(new LinkedHashSet<>());

    public Set<User> getUsers() {
        users.add(new User(UUID.randomUUID(), "Mariana"));
        users.add(new User(UUID.randomUUID(), "Daniel"));
        users.add(new User(UUID.randomUUID(), "Carol"));
        users.add(new User(UUID.randomUUID(), "Lindoya"));

        return users;

    }

    public Optional<User> getUserByName(String name) {
        var findUser = this.users.stream().filter(user -> user.getName().equals(name));
        return findUser.findFirst();
    }

}
