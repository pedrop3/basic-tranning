package DesignPatterns.ChainofResponsibility.levels;

import DesignPatterns.ChainofResponsibility.*;;

public class ApproveCFO extends LevelAprroveHandler {

    @Override
    protected boolean canApprover(Cost cost) {
        return cost.getValue() <= 10000;
    }

    @Override
    protected void approve(Cost cost) {
        System.out.println("Despesa aprovada pelo CFO");
    }

}
