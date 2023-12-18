package DesignPatterns.ChainofResponsibility;

public class Cost {

    private double value;
    private boolean approve;

    public Cost(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public boolean getApprove() {
        return approve;
    }

}
