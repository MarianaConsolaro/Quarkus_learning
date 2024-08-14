package br.com.marianaconsolaro;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/users")
public class UserResource {

    
    private Set<User> users = Collections.synchronizedSet(new LinkedHashSet<>());
    
    @GET()
    public Set<User> getUsers() {
        users.add(new User(UUID.randomUUID(), "Mariana"));
        users.add(new User(UUID.randomUUID(), "Daniel"));
        users.add(new User(UUID.randomUUID(), "Carol"));

        return users;

    }

    record User(UUID id, String name){}

    
}
