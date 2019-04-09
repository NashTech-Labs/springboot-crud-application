package com.knoldus.user.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User {
    
    String id;
    
    String name;
    
    String age;
    
}
