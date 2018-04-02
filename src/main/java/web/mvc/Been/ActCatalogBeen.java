package web.mvc.Been;

public class ActCatalogBeen {
    private int id;//id
    private String keyid;//唯一表示keyid
    private String userKeyid;//用户唯一标识
    private String name;//活动名称
    private String slogan;//标语
    private String creattime;//创建活动时间
    private String holdtime;//举办时间
    private String finishtime;//筹备结束时间
    private int member;//成员数量
    private String status;//活动状态 0:已提交 1：已审核 2：已结束 3:驳回
    private String acttype;//活动类型
    private String place;//地点
    private double actgrade;//活动分数
    private String info01;//预备字段
    private String info02;
    private String info03;
    private String info04;
    private String info05;//驳回理由

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

    public String getUserKeyid() {
        return userKeyid;
    }

    public void setUserKeyid(String userKeyid) {
        this.userKeyid = userKeyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getHoldtime() {
        return holdtime;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public void setHoldtime(String holdtime) {
        this.holdtime = holdtime;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActtype() {
        return acttype;
    }

    public void setActtype(String acttype) {
        this.acttype = acttype;
    }

    public String getInfo01() {
        return info01;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getActgrade() {
        return actgrade;
    }

    public void setActgrade(double actgrade) {
        this.actgrade = actgrade;
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

    //补充字段
    private String username;
    private String usertel;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }
}
