package summary.java.cms.Dao;

import java.util.ArrayList;
import java.util.List;

import summary.java.cms.domain.Student;
/*  DAO 분리.
    Data저장시  ArrayList, LinkedList, File, DB 어디에 저장 하던지
    메소드를 통해서 추상적으로 접근함. 
    캡슐화 = 클래스화 시킨다. "구체적인 구현을 감춘다"
    메소드를 분리, 클래스로 만드는,
    데이터 저장 방법을 바꿔도 controller에 영향을 미치지 못함.
*/

public class StudentDao {
    private List<Student> list = new ArrayList<>();
    
    public int insert(Student student) {
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        return 1;
    }
    
    public List<Student> findAll() {
        return list;
    }
    
    public Student findByEmail(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}