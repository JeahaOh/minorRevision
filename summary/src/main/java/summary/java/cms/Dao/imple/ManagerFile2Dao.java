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
import summary.java.cms.Dao.ManagerDao;
import summary.java.cms.Dao.MandatoryValueDaoException;
import summary.java.cms.annotation.Component;
import summary.java.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao {
    static String defaultFileName = "data/manager2.dat";
    String fileName;
    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String fileName) {
        this.fileName = fileName;
        File dataFile = new File(fileName);

        try (
                ObjectInputStream in = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(dataFile)));
                ){
            list = (List<Manager>) in.readObject();
            while(true) {
                try {
                    Manager m = (Manager)in.readObject();
                    list.add(m);
                }   catch (Exception e) {
                    break;
                }
            }
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public ManagerFile2Dao() {
        //  Constructor 바로 아랫 줄은 주석 외에 다른 문장이 오면 안된다는것.
        this(defaultFileName);
    }
    
    private void save() {
        File dataFile = new File(fileName);
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(dataFile)));
                ){
            out.writeObject(list);
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Manager manager)
            throws MandatoryValueDaoException, DuplicationDaoException {
        //  필수 입력 항목이 비었을 때,
        if(manager.getName().length() == 0 ||
           manager.getEmail().length() == 0 ||
           manager.getPassword().length() == 0) {
           //   호출자에게 예외 정보를 만들어 던진다.
            throw new MandatoryValueDaoException("Missing Required Value Error");
        }
        for(Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                //  호출자에게 예외 정보를 만들어 던진다.
                throw new DuplicationDaoException("The Email is already Exist.");
                //  에러 메세지 출력은 두가지 방법이 있음.
                //  에러를 던지면서 에러 메세지를 던지거나 에러를 받는곳에서 에러메세지 출력 가능.
                //  어느 방법을 사용하던지 예외 처리는 호가실히 해줘야 함.
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
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Manager item : list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1; 
            }
        }
        return 0;
    }
}
/*  기능추가
    1. 기존 소스에 추가. -> 버그 많음.
    2. 상속과 override, overloading -> 한계 많음.
    두둥!
    Decorator DesignPattern등장.
     FileOutputStream 과 ByteOutputStream <<Concrete Class>>등의
                     공통점 abstract OutputStream
    FilterOutputStream(data 가공만 하는 녀석.)<<Decorator>>를 상속받은
            BufferedOutputStream(Buffer 기능 제공), ObjectOutputStream(byte배열 제공),
                    DataOutputStream(byte배열 제공)등등.
    직접 그림으로 그려봐야 할 듯. 회사 구조, 폴더 구조 트리구조, composite pattern.
     생성자에 인자를 요구하느냐 아니냐에 따라 filter인지 아닌지 구분함.
    FilterOutputStream계열을 Data ProcessingStreamClass라고도 함.
    ConcreteClass를 DataSnkStreamClass라고도 함.
     DecoratorPattern이 FileIO에 기본으로 깔려있고 알고 고려해서 사용하는게 존나 좋다.
    자바 기본 클래스들이 존나 고퀄리티로 만들어졌다는 반증임.
 */