package summary.java.cms.Dao.imple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import summary.java.cms.Dao.ManagerDao;
import summary.java.cms.domain.Manager;
//  comma seperate 저장법.
//@Component
public class ManagerFileDao implements ManagerDao {
    private List<Manager> list = new ArrayList<>();

    public ManagerFileDao() {
        try(
                BufferedReader in
                = new BufferedReader(
                        new FileReader("data/manager.dat"))
                ){
            while(true) {
                String line = in.readLine();
                if(line == null)
                    break;
                String[] values = line.split(",");

                Manager m = new Manager();
                m.setEmail(values[0]);
                m.setName(values[1]);
                m.setPassword(values[2]);
                m.setTel(values[3]);
                m.setPosition(values[4]);

                list.add(m);
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try(
                BufferedWriter out =
                new BufferedWriter(new FileWriter("data/manager.dat"))
                ){
            for(Manager m : list) {
                out.write(
                        String.format("%s,%s,%s,%s,%s",
                                m.getEmail(),
                                m.getName(),
                                m.getPassword(),
                                m.getTel(),
                                m.getPosition()
                                ));
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Manager manager) {
        for (Manager item : list) {
            if (item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        save();
        return 1;
    }

    public List<Manager> findAll() {
        return list;
    }

    public Manager findByEmail(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}
