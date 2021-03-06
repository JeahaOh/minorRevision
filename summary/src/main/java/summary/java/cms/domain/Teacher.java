package summary.java.cms.domain;

public class Teacher extends Member {
    private static final long serialVersionUID = 1L;
    protected String tel;
    protected int pay;
    protected String subject;
    
    public String getTel() {
        return tel;
    }
    public int getPay() {
        return pay;
    }
    public String getSubject() {
        return subject;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setPay(int pay) {
        this.pay = pay;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}