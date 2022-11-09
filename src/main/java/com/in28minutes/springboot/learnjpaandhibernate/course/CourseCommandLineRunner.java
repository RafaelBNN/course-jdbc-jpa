package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    // @Autowired
    // private CourseJdbcRepository jdbcRepo;

    // @Autowired
    // private CourseJpaRepository jpaRepo;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // jdbcRepo.insert(new Course(1, "Learn Spring", "in28minutes"));
        // jdbcRepo.insert(new Course(2, "Learn Azure", "in28minutes"));
        // jdbcRepo.insert(new Course(3, "Learn Python", "in28minutes"));
        // jdbcRepo.deleteById(2);

        // System.out.println(jdbcRepo.selectById(1));
        // System.out.println(jdbcRepo.selectById(3));

        // jpaRepo.insert(new Course(4, "Learn Scala", "udemy"));
        // jpaRepo.insert(new Course(5, "Learn Ada", "udemy"));
        // jpaRepo.insert(new Course(6, "Learn PHP", "udemy"));
        // jpaRepo.deleteById(5);

        // System.out.println(jpaRepo.selectById(1));
        // System.out.println(jpaRepo.selectById(6));

        repository.save(new Course(5, "Learn Spring", "in28minutes")); // insert
        repository.save(new Course(3, "Learn JDBC", "in28minutes")); // insert
        repository.save(new Course(2, "Learn JPA", "in28minutes")); // insert
        repository.save(new Course(4, "Learn Github", "Nelio Alves")); // insert
        repository.save(new Course(1, "Learn Java", "Nelio Alves")); // insert

        repository.deleteById(3l);

        System.out.println(repository.findById(2l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Nelio Alves"));
        System.out.println(repository.findByName("Learn Java"));
    }
    
}
