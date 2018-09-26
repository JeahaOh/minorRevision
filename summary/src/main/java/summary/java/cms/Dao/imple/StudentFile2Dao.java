package summary.java.cms.Dao.imple;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import summary.java.cms.Dao.DuplicationDaoException;
import summary.java.cms.Dao.MandatoryValueDaoException;
import summary.java.cms.Dao.StudentDao;
import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Student;

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
        File dataFile = new File(fileName);
        try(
                ObjectOutputStream out = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(dataFile)));
                ){
            out.writeObject(list);
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Student student)
            throws MandatoryValueDaoException, DuplicationDaoException {
        if(student.getName().length() == 0 ||
                student.getEmail().length() == 0 ||
                student.getPassword().length() == 0) {
            throw new MandatoryValueDaoException("Missing Required Value Error");
        }
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
                throw new DuplicationDaoException("The Email is already Exist.");
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