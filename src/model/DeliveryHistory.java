package model;

public class DeliveryHistory {
    String FIO;
    String nameOfPublication;
    String estimatedDeliveryDate;
    Boolean statusOfDelivery;
    String typeOfDelivery;

    public DeliveryHistory(String FIO, String nameOfPublication, String estimatedDeliveryDate, Boolean statusOfDelivery, String typeOfDelivery) {
        this.FIO = FIO;
        this.nameOfPublication = nameOfPublication;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.statusOfDelivery = statusOfDelivery;
        this.typeOfDelivery = typeOfDelivery;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getNameOfPublication() {
        return nameOfPublication;
    }

    public void setNameOfPublication(String nameOfPublication) {
        this.nameOfPublication = nameOfPublication;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Boolean getStatusOfDelivery() {
        return statusOfDelivery;
    }

    public void setStatusOfDelivery(Boolean statusOfDelivery) {
        this.statusOfDelivery = statusOfDelivery;
    }

    public String getTypeOfDelivery() {
        return typeOfDelivery;
    }

    public void setTypeOfDelivery(String typeOfDelivery) {
        this.typeOfDelivery = typeOfDelivery;
    }
}
