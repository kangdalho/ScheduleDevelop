package com.example.scheduledevelop.dto;


import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {

    private final String userName;
    private final String todoTitle;
    private final String contents;

    public UpdateScheduleRequestDto(String userName, String todoTitle, String content) {
        this.userName = userName;
        this.todoTitle = todoTitle;
        this.contents = content;
    }
}
