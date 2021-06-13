package com.abu.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abu.sms.entity.Student;

//Note-dont have to add @reposioty for JPA as JPA repo and @Transactional has simpleJPA repo imple..

public interface StudentRepository extends JpaRepository<Student, Long> {

}
