package summary.java.cms.Dao;

import java.util.List;

import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Manager;

@Component
public interface ManagerDao {
    int insert(Manager manager);
    List<Manager> findAll();
    Manager findByEmail(String email);
    int delete(String email);
}
