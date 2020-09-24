package sample;

public class CurrentSubscriptions {
    String FIO;
    String post;
    String nameOfPublication;
    String periodOfSubscriptionFrom;
    String periodOfSubscriptionTo;

    public CurrentSubscriptions(String FIO, String post, String nameOfPublication,
                                String periodOfSubscriptionFrom, String periodOfSubscriptionTo) {
        this.FIO = FIO;
        this.post = post;
        this.nameOfPublication = nameOfPublication;
        this.periodOfSubscriptionFrom = periodOfSubscriptionFrom;
        this.periodOfSubscriptionTo = periodOfSubscriptionTo;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getNameOfPublication() {
        return nameOfPublication;
    }

    public void setNameOfPublication(String nameOfPublication) {
        this.nameOfPublication = nameOfPublication;
    }

    public String getPeriodOfSubscriptionFrom() {
        return periodOfSubscriptionFrom;
    }

    public void setPeriodOfSubscriptionFrom(String periodOfSubscriptionFrom) {
        this.periodOfSubscriptionFrom = periodOfSubscriptionFrom;
    }

    public String getPeriodOfSubscriptionTo() {
        return periodOfSubscriptionTo;
    }

    public void setPeriodOfSubscriptionTo(String periodOfSubscriptionTo) {
        this.periodOfSubscriptionTo = periodOfSubscriptionTo;
    }
}
