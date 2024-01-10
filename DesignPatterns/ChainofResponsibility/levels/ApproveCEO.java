package DesignPatterns.ChainofResponsibility.levels;

import DesignPatterns.ChainofResponsibility.*;;

public class ApproveCEO extends LevelAprroveHandler {

    @Override
    protected boolean canApprover(Cost cost) {
        return cost.getValue() <= 100000;
    }

    @Override
    protected void approve(Cost cost) {
        System.out.println("Despesa aprovada pelo CEO");
    }

}
x'