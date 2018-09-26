package summary.java.cms.Dao;

import java.util.List;

import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Teacher;

@Component
public interface TeacherDao {
    int insert(Teacher teacher)
            throws MandatoryValueDaoException, DuplicationDaoException;
    List<Teacher> findAll();
    Teacher findByEmail(String email);
    int delete(String email);
}
