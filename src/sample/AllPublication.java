package sample;

public class AllPublication {
    Integer indexOfPublication;
    String nameOfPublication;
    String periodOfPublication;
    Double costOfSubscription;

    public AllPublication(Integer indexOfPublication, String nameOfPublication, String periodOfPublication, Double costOfSubscription) {
        this.indexOfPublication = indexOfPublication;
        this.nameOfPublication = nameOfPublication;
        this.periodOfPublication = periodOfPublication;
        this.costOfSubscription = costOfSubscription;
    }

    public Integer getIndexOfPublication() {
        return indexOfPublication;
    }

    public void setIndexOfPublication(Integer indexOfPublication) {
        this.indexOfPublication = indexOfPublication;
    }

    public String getNameOfPublication() {
        return nameOfPublication;
    }

    public void setNameOfPublication(String nameOfPublication) {
        this.nameOfPublication = nameOfPublication;
    }

    public String getPeriodOfPublication() {
        return periodOfPublication;
    }

    public void setPeriodOfPublication(String periodOfPublication) {
        this.periodOfPublication = periodOfPublication;
    }

    public Double getCostOfPublication() {
        return costOfSubscription;
    }

    public void setCostOfPublication(Double costOfPublication) {
        this.costOfSubscription = costOfPublication;
    }
}
