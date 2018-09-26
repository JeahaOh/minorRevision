package summary.java.cms.Dao;

import java.util.List;

import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Student;
/*  
    File_DAO와 DB_DAO를 위해 원본을 interface 로 만듦.
*/

@Component
public interface StudentDao {
    int insert(Student student);
    List<Student> findAll();
    Student findByEmail(String email);
    int delete(String email);
}