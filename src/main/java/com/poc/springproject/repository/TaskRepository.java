package com.poc.springproject.repository;

import com.poc.springproject.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
