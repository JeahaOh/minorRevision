package summary.java.cms.Dao;

import java.util.ArrayList;
import java.util.List;

import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Teacher;

@Component
public class TeacherDao {
    private List<Teacher> list = new ArrayList<>();

    public int insert(Teacher teacher) {
        for (Teacher item : list) {
            if (item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
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
                return 1;
            }
        }
        return 0;
    }
}
