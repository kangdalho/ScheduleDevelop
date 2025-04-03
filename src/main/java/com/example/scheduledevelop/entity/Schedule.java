package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String todoTitle;

    @Column(columnDefinition = "longtext")
    private String Contents;

    @Column(nullable = false)
    private String userName;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Schedule(){
    }

    public Schedule(String todoTitle,String contents,String userName){
        this.todoTitle = todoTitle;
        this.Contents = contents;
        this.userName = userName;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void update(String newTodoTitle, String newContents){
        this.todoTitle = newTodoTitle;
        this.Contents = newContents;
    }
}
