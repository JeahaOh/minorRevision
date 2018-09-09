package summary.java.cms.domain;

public class Manager extends Member{
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