package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.HemanthStudent;
@Repository
public interface HemanthStudentRepository extends JpaRepository<HemanthStudent,Integer>{
  
    @Query(value="select s.* from student s inner join student_detail st on s.id=st.student_id",nativeQuery = true)
    List<HemanthStudent>getStudentInner();

    @Query(value="select s.* from student s left outer join student_detail st on s.id=st.student_id",nativeQuery = true)
    List<HemanthStudent> getStudentsLeftOuter();

    

    
}
