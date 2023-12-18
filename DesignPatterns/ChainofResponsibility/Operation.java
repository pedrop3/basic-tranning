package DesignPatterns.ChainofResponsibility;

public class Operation {

    private Cost cost;
    private LevelAprroveHandler aprroveHandler;

    public void setLevelAprroveHandler(LevelAprroveHandler aprroveHandler) {
        this.aprroveHandler = aprroveHandler;
    }
    
    public boolean approved(Cost cost) {

        if(aprroveHandler.isApprove(cost)) {
            return true;
        }
        return false;
    }



}
