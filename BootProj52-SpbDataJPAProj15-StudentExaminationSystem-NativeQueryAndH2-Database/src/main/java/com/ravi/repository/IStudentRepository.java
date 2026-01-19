package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ravi.entity.Student;

import jakarta.transaction.Transactional;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

	 /* INSERT */
    @Modifying
    @Query(value =
        "INSERT INTO STUDENT VALUES (?1,?2,?3,?4,?5,?6)",
        nativeQuery = true)
    public void insertStudent(Integer rollNo,String name,String cls,Integer marks,String result,Integer year);
	
    
    /* FETCH */
    @Query(value = "SELECT * FROM Student_Examination", nativeQuery = true)
    public List<Student> findAllStudents();

    @Query(value = "SELECT * FROM Student_Examination WHERE ROLL_NO=?1", nativeQuery = true)
    public Student findByRollNo(Integer rollNo);

    /* UPDATE */
    @Modifying
    @Transactional
    @Query(value = "UPDATE Student_Examination SET MARKS=:marks WHERE ROLL_NO=:id", nativeQuery = true)
    public void updateMarks(@Param("marks") Integer marks,@Param("id") Integer rollNo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Student_Examination SET RESULT=:res WHERE ROLL_NO=:id", nativeQuery = true)
    public void updateResult(@Param("res") String result,@Param("id") Integer rollNo);

    /* FILTER */
    @Query(value = "SELECT * FROM Student_Examination WHERE RESULT='PASS'", nativeQuery = true)
    public List<Student> findPassedStudents();

    @Query(value = "SELECT * FROM Student_Examination WHERE RESULT='FAIL'", nativeQuery = true)
    public List<Student> findFailedStudents();

    @Query(value = "SELECT * FROM Student_Examination WHERE MARKS > 75", nativeQuery = true)
    public List<Student> findStudentsAbove75();

    /* COUNT */
    @Query(value = "SELECT COUNT(*) FROM Student_Examination", nativeQuery = true)
    public Integer countTotalStudents();

    @Query(value = "SELECT COUNT(*) FROM Student_Examination WHERE RESULT='PASS'", nativeQuery = true)
    public Integer countPassedStudents();

    @Query(value = "SELECT COUNT(*) FROM Student_Examination WHERE RESULT='FAIL'", nativeQuery = true)
    public Integer countFailedStudents();

    /* AGGREGATE */
    @Query(value =
      "SELECT * FROM Student_Examination WHERE MARKS=(SELECT MAX(MARKS) FROM Student_Examination)",
      nativeQuery = true)
    public Student findTopper();

    @Query(value =
      "SELECT * FROM Student_Examination WHERE MARKS=(SELECT MIN(MARKS) FROM Student_Examination)",
      nativeQuery = true)
    public Student findLowestMarks();
    
}
