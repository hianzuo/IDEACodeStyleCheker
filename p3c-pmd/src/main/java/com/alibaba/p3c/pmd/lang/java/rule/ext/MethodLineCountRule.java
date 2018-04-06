package com.alibaba.p3c.pmd.lang.java.rule.ext;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;

public class MethodLineCountRule extends AbstractAliRule {
    private static final Integer CODE_LINE_COUNT_LIMIT = 30;

    @Override
    public Object visit(ASTMethodDeclaration node, Object data) {
        int lineCount = node.getBlock().getEndLine() - node.getBlock().getBeginLine();
        if (lineCount >= CODE_LINE_COUNT_LIMIT) {
            addViolationWithMessage(data, node,
                    "java.oop.MethodLineCountRule.violation.msg",
                    new Object[]{node.getMethodName()});
        }
        return super.visit(node, data);
    }


}
