package summary.java.cms.domain;

public class Manager extends Member{
    private static final long serialVersionUID = 1L;
    //  상위 클래스에서 인터페이스 상속받으면 하위클래스 역시 필수 상속.
    protected String tel;
    protected String position;
    
    public String getTel() {
        return tel;
    }
    public String getPosition() {
        return position;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}