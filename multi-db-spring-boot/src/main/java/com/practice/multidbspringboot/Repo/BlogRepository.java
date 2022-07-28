package com.practice.multidbspringboot.Repo;

import com.practice.multidbspringboot.Resource.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer>
{
@Query("select b from Blog b where b.owner=:name")
     public Blog findByOwnerName(@Param("name") String name);
}
