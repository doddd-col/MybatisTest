package entity;

//业务扩展类  将另一个表的信息建在这里  同时接受两个表的信息  适合小型的
public class StudentBusiness extends Student {
    private int cardid;
    private String cardinfo;

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public String getCardinfo() {
        return cardinfo;
    }

    public void setCardinfo(String cardinfo) {
        this.cardinfo = cardinfo;
    }

    @Override
    public String toString() {
        return "StudentBusiness{"+super.toString() +
                "cardid=" + cardid +
                ", cardinfo='" + cardinfo + '\'' +
                '}';
    }
}
