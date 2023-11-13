package com.example.feedbackservice.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_Users")
public class User
{
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean active;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();
    public User()
    {
    }
    public User(String name, String password, Role role)
    {
        this.username = name;
        this.password = password;
        roles.add(role);
    }
    public String getFirstName()
    {
        return firstName;
    }
    public Long getId()
    {
        return id;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getPassword()
    {
        return password;
    }
    public Set<Role> getRoles()
    {
        return roles;
    }
    public String getUsername()
    {
        return username;
    }
    public boolean isActive()
    {
        return active;
    }
    public void setActive(boolean active)
    {
        this.active = active;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
}
