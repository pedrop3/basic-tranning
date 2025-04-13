package DesignPatterns.ChainofResponsibility;

import DesignPatterns.ChainofResponsibility.levels.ApproveCEO;
import DesignPatterns.ChainofResponsibility.levels.ApproveCFO;
import DesignPatterns.ChainofResponsibility.levels.ApproveEmployment;
import DesignPatterns.ChainofResponsibility.levels.ApproveManager;

/*
 * 
Problema: Sistema de Aprovação de Despesas

Imagine que você está trabalhando em um sistema que gerencia despesas dentro de uma empresa. 
Cada despesa precisa passar por uma série de níveis de aprovação antes de ser finalmente aprovada para pagamento.
Os níveis de aprovação são os seguintes:

Nível 1 - Aprovação do Funcionário:
Despesas de até $100 podem ser aprovadas por qualquer funcionário.

Nível 2 - Aprovação do Gerente:
Despesas de até $1.000 podem ser aprovadas pelo gerente.

Nível 3 - Aprovação do Diretor Financeiro:
Despesas de até $10.000 podem ser aprovadas pelo diretor financeiro.

Nível 4 - Aprovação do CEO:
Despesas acima de $10.000 requerem a aprovação do CEO.

 */
public class Application {

    public static void main(String[] args) {


        LevelAprroveHandler levelAprroveHandler = LevelAprroveHandler.link(
            new ApproveEmployment(),
            new ApproveManager(),
            new ApproveCFO(),
            new ApproveCEO()
        );
        Cost cost = new Cost(1000);

        do {
            levelAprroveHandler.approveCost(cost);
        }while(!cost.getApprove());

    }

}
