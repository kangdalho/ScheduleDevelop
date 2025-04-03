package com.example.scheduledevelop.ScheduleService;

import com.example.scheduledevelop.ScheduleRepository.ScheduleRepository;
import com.example.scheduledevelop.UserRepository.UserRepository;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String todoTitle, String contents, String userName){

        User findUser = userRepository.findUsersByUserNameOrElseThrow(userName);

        Schedule schedule = new Schedule(todoTitle,contents,userName);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTodoTitle(),schedule.getContents());

    }


    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();

    }

    public ScheduleResponseDto findById(Long id) {

        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        Schedule findSchedule = optionalSchedule.get();

        return new ScheduleResponseDto(findSchedule.getId(),findSchedule.getTodoTitle(),findSchedule.getContents());

    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, String userName, String todoTitle, String contents){

       Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다."));

       User user= userRepository.findUsersByUserNameOrElseThrow(userName);

       if(!schedule.getUserName().equals(user.getUserName())){
           throw new IllegalArgumentException("일정을 수정할 권한이 없습니다.");
       }

       schedule.update(todoTitle,contents);

       return new ScheduleResponseDto(schedule.getId(),schedule.getTodoTitle(),schedule.getContents());

    }

    public void delete(Long id) {

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);

    }
}
