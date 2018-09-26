package summary.java.cms.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherFileDao implements TeacherDao {
    private List<Teacher> list = new ArrayList<>();

    public TeacherFileDao() {
        try(
                BufferedReader in = new BufferedReader(
                        new FileReader("data/teacher.dat"))
                ){
            while(true) {
                String line = in.readLine();
                if(line == null)
                    break;
                String[] values = line.split(",");
                
                Teacher t = new Teacher();
                t.setEmail(values[0]);
                t.setName(values[1]);
                t.setPassword(values[2]);
                t.setTel(values[3]);
                t.setPay(Integer.parseInt(values[4]));
                t.setSubject(values[5]);
                
                list.add(t);
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try(
                BufferedWriter out = 
                new BufferedWriter(new FileWriter("data/teacher.dat"))
                ){
            for(Teacher t : list) {
                out.write(
                        String.format("%s,%s,%s,%s,%s,%b",
                                t.getEmail(),
                                t.getName(),
                                t.getPassword(),
                                t.getTel(),
                                t.getPay(),
                                t.getSubject()
                                ));
            }
            out.flush();
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    public int insert(Teacher teacher) {
        for (Teacher item : list) {
            if (item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        save();
        return 1;
    }

    public List<Teacher> findAll() {
        return list;
    }

    public Teacher findByEmail(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Teacher item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
