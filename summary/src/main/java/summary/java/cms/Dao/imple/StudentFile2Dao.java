package summary.java.cms.Dao.imple;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import summary.java.cms.Dao.StudentDao;
import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Student;
/*  DAO 분리.
    Data를 File에 저장하기 위한 DAO
 */

@Component
public class StudentFile2Dao implements StudentDao {
    static String defaultFileName = "data/Student2.dat";
    String fileName;
    private List<Student> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public StudentFile2Dao(String fileName) {
        this.fileName = fileName;
        File dataFile = new File(fileName);
        
        try(    
                ObjectInputStream in = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(dataFile)));
                ){
            list = (List<Student>)in.readObject();
            while(true) {
                try {
                    Student s = (Student)in.readObject();
                    list.add(s);
                }   catch(Exception e) {
                    break;
                }
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public StudentFile2Dao() {
        this(defaultFileName);
    }

    private void save() {
        try(
                BufferedWriter out = 
                new BufferedWriter(new FileWriter("data/student.dat"))
                ){
            for(Student s : list) {
                out.write(
                        String.format("%s,%s,%s,%s,%s,%b",
                                s.getEmail(),
                                s.getName(),
                                s.getPassword(),
                                s.getSchool(),
                                s.getTel(),
                                s.isGraduate()
                                ));
            }
            out.flush();    //  버퍼에서 출력시키기.
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Student student) {
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        save();
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
                save();
                return 1;
            }
        }
        return 0;
    }
}