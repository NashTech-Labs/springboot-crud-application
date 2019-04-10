package com.knoldus.user.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Builder
@Table(value = "user")
public class User {
    
    @PrimaryKey
    private @NonNull String id;
    
    private @NonNull String name;
    
    private @NonNull String age;
    
    /*User(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/
    
}
