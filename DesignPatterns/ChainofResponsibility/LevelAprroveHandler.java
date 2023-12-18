package DesignPatterns.ChainofResponsibility;

public abstract class LevelAprroveHandler implements Approver {

    private Approver nextApprover;

    /**
     * Builds chains of middleware objects.
     */
    public static LevelAprroveHandler link(LevelAprroveHandler first, LevelAprroveHandler... chain) {
        LevelAprroveHandler head = first;

        for (LevelAprroveHandler nextInChain : chain) {
            head.nextApprover = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    @Override
    public final void approveCost(Cost cost) {
        if (canApprover(cost)) {
            cost.setApprove(true);
            approve(cost);
        } else if (nextApprover != null) {
            nextApprover.approveCost(cost);
        } else {
            System.out.println("Despesa não aprovada em nenhum nível.");
        }

    }

    public boolean isApprove(Cost cost) {
        return cost.getApprove();
    }

    // Método abstrato para verificar se o handler pode aprovar a despesa
    protected abstract boolean canApprover(Cost cost);

    // Método abstrato para aprovar a despesa
    protected abstract void approve(Cost cost);
}
