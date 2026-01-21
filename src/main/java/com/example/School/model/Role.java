    package com.example.School.model;

    import jakarta.persistence.*;

    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "roles")
    public class Role{
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @ManyToMany(mappedBy = "roles")
        private List<User> users = new ArrayList<>();

        protected Role(){}
        public Role(String name){
            this.name = name;
        }

        // Business logic
        public void addUser(User user){
            if (!users.contains(user)){
                users.add(user);
                if (!user.getRoles().contains(this)){
                    user.addRole(this);
                }
            }
        }

        // Getters
        public Long getId( ){
            return id;
        }

        public String getName( ){
            return name;
        }

        public List<User> getUsers( ){
            return users;
        }
    }
