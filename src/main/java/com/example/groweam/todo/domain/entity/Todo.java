package com.example.groweam.todo.domain.entity;

import com.example.groweam.project.domain.entity.Project;
import com.example.groweam.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Todo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long todoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(nullable = false)
    private String todoTitle;

    @Column(nullable = false)
    private LocalDateTime todoDate;

    @Column
    private String todoContent;

    @Column(nullable = false)
    private Boolean isComplete;

    @Builder
    public Todo (Project project, User user, String todoTitle, LocalDateTime todoDate, String todoContent, Boolean isComplete) {
        this.project = project;
        this.user = user;
        this.todoTitle = todoTitle;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.isComplete = isComplete;
    }

    public void update(String todoTitle, LocalDateTime todoDate, String todoContent, Boolean isComplete) {
        this.todoTitle = todoTitle;
        this.todoDate = todoDate;
        this.todoContent = todoContent;
        this.isComplete = isComplete;
    }

}
