package web.mvc.Been;

import java.sql.Timestamp;
import java.util.Comparator;

public class ActFinishBeen implements Comparator<ActFinishBeen> {

    private int id;//id
    private String keyid;//唯一表示id
    private String activekeyid;//活动唯一标识
    private String name;//用户名
    private String sex;//用户性别
    private String activename;//活动名称
    private String stukeyid;//学生唯一标识
    private String finishtime; //结束时间
    private double activegrade;//活动学分
    private int status;//活动状态 0：学生可拿到该学分 1：学生拿不到该学分
    private int info01;//参加的人数
    private String jointime;//加入时间
    private String info02;//第几雪期
    private String info03;
    private String info04;
    private String info05;

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

    public String getActivekeyid() {
        return activekeyid;
    }

    public void setActivekeyid(String activekeyid) {
        this.activekeyid = activekeyid;
    }

    public String getActivename() {
        return activename;
    }

    public void setActivename(String activename) {
        this.activename = activename;
    }

    public String getStukeyid() {
        return stukeyid;
    }

    public void setStukeyid(String stukeyid) {
        this.stukeyid = stukeyid;
    }

    public double getActivegrade() {
        return activegrade;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime;
    }

    public void setActivegrade(double activegrade) {
        this.activegrade = activegrade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getInfo01() {
        return info01;
    }

    public void setInfo01(int info01) {
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

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
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

    @Override
    public int compare(ActFinishBeen o1, ActFinishBeen o2) {
        if(o1.getActivegrade()<o2.getActivegrade()){
            return 1;
        }else{
            return -1;
        }
    }
}
