package DesignPatterns.ChainofResponsibility.levels;

import DesignPatterns.ChainofResponsibility.*;;

public class ApproveManager extends LevelAprroveHandler {

    @Override
    protected boolean canApprover(Cost cost) {
        return cost.getValue() <= 1000;
    }

    @Override
    protected void approve(Cost cost) {
        System.out.println("Despesa aprovada pelo Gerente");
    }

}
