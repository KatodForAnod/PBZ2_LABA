package sample;

public class CurrentSubscriptions {
    String FIO;
    String post;
    String nameOfPublication;
    String periodOfSubscription;

    public CurrentSubscriptions(String FIO, String post, String nameOfPublication, String periodOfSubscription) {
        this.FIO = FIO;
        this.post = post;
        this.nameOfPublication = nameOfPublication;
        this.periodOfSubscription = periodOfSubscription;
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

    public String getPeriodOfSubscription() {
        return periodOfSubscription;
    }

    public void setPeriodOfSubscription(String periodOfSubscription) {
        this.periodOfSubscription = periodOfSubscription;
    }
}
