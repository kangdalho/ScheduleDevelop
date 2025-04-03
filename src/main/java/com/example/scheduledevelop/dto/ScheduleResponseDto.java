package com.example.scheduledevelop.dto;

import com.example.scheduledevelop.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String todoTitle;

    private final String contents;

    public ScheduleResponseDto(Long id, String todoTitle, String contents) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.contents = contents;
    }

    public static ScheduleResponseDto toDto(Schedule schedule){

        return new ScheduleResponseDto(schedule.getId(),schedule.getTodoTitle(),schedule.getContents());
    }


}
