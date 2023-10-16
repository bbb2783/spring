package com.example.p1;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Member {
@Id public String id;
public String pw;
public String pw2;
public String email;
public Integer balance; 
@CreationTimestamp public LocalDateTime rdate;

public String getId() {
    return id;
}

public String getPw() {
    return pw;
}
}