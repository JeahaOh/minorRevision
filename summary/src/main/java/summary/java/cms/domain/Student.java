package summary.java.cms.domain;

public class Student extends Member{
    private static final long serialVersionUID = 1L;
    protected String tel;
    protected String school;
    protected String major;
    protected Boolean graduate;
    
    public String getTel() {
        return tel;
    }
    public String getSchool() {
        return school;
    }
    public String getMajor() {
        return major;
    }
    public Boolean isGraduate() {
        return graduate;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setSchool(String school) {
        this.school = school;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setGraduate(Boolean graduate) {
        this.graduate = graduate;
    }
}
