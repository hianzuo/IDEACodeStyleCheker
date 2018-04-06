package com.alibaba.p3c.pmd.lang.java.rule.ext;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import net.sourceforge.pmd.lang.java.ast.ASTConstructorDeclaration;

public class ConstructorLineCountRule extends AbstractAliRule {
    private static final Integer CODE_LINE_COUNT_LIMIT = 30;

    @Override
    public Object visit(ASTConstructorDeclaration node, Object data) {
        int lineCount = node.getEndLine() - node.getBeginLine();
        if (lineCount >= CODE_LINE_COUNT_LIMIT) {
            addViolationWithMessage(data, node,
                    "java.oop.ConstructorLineCountRule.violation.msg",
                    new Object[]{"Constructor"});
        }
        return super.visit(node, data);
    }

}
