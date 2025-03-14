package entity;

import java.io.Serializable;

public class StudentCard implements Serializable {
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
        return "StudentCard{" +
                "cardid=" + cardid +
                ", cardinfo='" + cardinfo + '\'' +
                '}';
    }
}
