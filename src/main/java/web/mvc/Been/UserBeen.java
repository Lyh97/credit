package web.mvc.Been;

public class UserBeen {
    private int id;//id
    private String keyid;//唯一表示id
    private String username;//用户名，用户名即账号即学号
    private String password;//密码
    private String name;//姓名
    private String telephone;//电话
    private int grade;//学分
    private String sex;//性别
    private String role;//权限
    private String enrollmentTime;//入学时间
    private String info01;//学生是否被删除 0；未删除 1：已删除
    private String info02;//预备字段
    private String info03;
    private String info04;
    private String info05;
    private String info06;
    private String info07;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEnrollmentTime() {
        return enrollmentTime;
    }

    public void setEnrollmentTime(String enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }

    public String getInfo01() {
        return info01;
    }

    public void setInfo01(String info01) {
        this.info01 = info01;
    }

    public String getInfo02() {
        return info02;
    }

    public void setInfo02(String info02) {
        this.info02 = info02;
    }

    public String getInfo03() {
        return info03;
    }

    public void setInfo03(String info03) {
        this.info03 = info03;
    }

    public String getInfo04() {
        return info04;
    }

    public void setInfo04(String info04) {
        this.info04 = info04;
    }

    public String getInfo05() {
        return info05;
    }

    public void setInfo05(String info05) {
        this.info05 = info05;
    }

    public String getInfo06() {
        return info06;
    }

    public void setInfo06(String info06) {
        this.info06 = info06;
    }

    public String getInfo07() {
        return info07;
    }

    public void setInfo07(String info07) {
        this.info07 = info07;
    }
}
