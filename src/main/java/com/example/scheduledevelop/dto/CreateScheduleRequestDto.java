package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final String todoTitle;

    private final String contents;

    private final String userName;

    public CreateScheduleRequestDto(String todoTitle, String contents, String userName) {
        this.todoTitle = todoTitle;
        this.contents = contents;
        this.userName = userName;
    }
}
