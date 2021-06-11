package com.poc.springproject.service;


import com.poc.springproject.entity.TaskEntity;
import com.poc.springproject.entity.UserEntity;
import com.poc.springproject.repository.TaskRepository;
import com.poc.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository  userRepository;

    public TaskEntity createTask(TaskEntity task, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        task.setUser(user);
        return taskRepository.save(task);
    }

    public TaskEntity complete(Long id) {
        TaskEntity task = taskRepository.findById(id).get();
        task.setCompleted(!task.getCompleted());
        return taskRepository.save(task);
    }
}
