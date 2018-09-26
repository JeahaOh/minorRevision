package summary.java.cms.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Student;
/*  DAO 분리.
    Data를 File에 저장하기 위한 DAO
*/

@Component
public class StudentFileDao implements StudentDao {
    private List<Student> list = new ArrayList<>();
    
    public StudentFileDao() {
        try(    //  autoClose.
//            File dataFile = new File("data/student.dat");
//            FileReader fr = new FileReader(dataFile);
//            BufferedReader br = new BufferedReader(fr);
//            새줄을 한줄로 줄이는것. 106기 git에 설명있음.
            BufferedReader in = new BufferedReader(
                    new FileReader("data/student.dat"))
           ){
            while(true) {
                String line = in.readLine();
                if(line == null)
                    break;
                String[] values = line.split(",");
                
                Student s = new Student();
                s.setEmail(values[0]);
                s.setName(values[1]);
                s.setPassword(values[2]);
                s.setSchool(values[3]);
                s.setTel(values[4]);
                s.setGraduate(Boolean.parseBoolean(values[5]));
                
                list.add(s);
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private void save() {
        File dataFile = new File("data/student.dat");
        try(
                BufferedWriter out = 
                new BufferedWriter(new FileWriter(dataFile))
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