package com.practice.multidbspringboot.Controller;

import com.practice.multidbspringboot.Repo.BlogRepository;
import com.practice.multidbspringboot.Resource.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogRepository blogRepository;

    @GetMapping("/home")
    public String greetings() {
        return "welcome to the system";
    }

    @PostMapping("/blog")
    public ResponseEntity postBlog(@RequestBody Blog blog) {
        return blogRepository.save(blog) != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> list = blogRepository.findAll();
        return list != null ? new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/blog/{name}")
    public Blog getBlogByName(@Param("name") String name)
    {
        return blogRepository.findByOwnerName(name);
        //return blogRepository.findBy(name,(x)->{return "select * from Blog b where b.owner=:x";
    }



}
