package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository jdbcRepo;

    @Autowired
    private CourseJpaRepository jpaRepo;

    @Override
    public void run(String... args) throws Exception {
        jdbcRepo.insert(new Course(1, "Learn Spring", "in28minutes"));
        jdbcRepo.insert(new Course(2, "Learn Azure", "in28minutes"));
        jdbcRepo.insert(new Course(3, "Learn Python", "in28minutes"));
        jdbcRepo.deleteById(2);

        System.out.println(jdbcRepo.selectById(1));
        System.out.println(jdbcRepo.selectById(3));

        jpaRepo.insert(new Course(4, "Learn Scala", "udemy"));
        jpaRepo.insert(new Course(5, "Learn Ada", "udemy"));
        jpaRepo.insert(new Course(6, "Learn PHP", "udemy"));
        jpaRepo.deleteById(5);

        System.out.println(jpaRepo.selectById(1));
        System.out.println(jpaRepo.selectById(6));
    }
    
}
