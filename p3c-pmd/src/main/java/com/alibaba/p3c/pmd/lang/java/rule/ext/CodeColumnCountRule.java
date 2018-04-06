package com.alibaba.p3c.pmd.lang.java.rule.ext;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import net.sourceforge.pmd.lang.java.ast.*;
import org.javacc.jjtree.ASTJavacodeBody;

public class CodeColumnCountRule extends AbstractAliRule {
    private static final Integer CODE_COUNT_LIMIT = 120;

    @Override
    public Object visit(JavaNode node, Object data) {
        if(!isBodyNode(node)){
            int endColumn = node.getEndColumn();
            if (endColumn > CODE_COUNT_LIMIT) {
                addViolationWithMessage(data, node, "java.oop.CodeColumnCountRule.violation.msg");
            }
        }
        return super.visit(node, data);
    }

    private boolean isBodyNode(JavaNode node) {
        return node instanceof ASTClassOrInterfaceBodyDeclaration ||
                node instanceof ASTClassOrInterfaceBody ||
                node instanceof ASTAnnotationTypeBody ||
                node instanceof ASTEnumBody ||
                node instanceof ASTJavacodeBody||
                node instanceof ASTConstructorDeclaration ||
                node instanceof ASTVariableDeclarator ||
                node instanceof ASTVariableDeclaratorId ||
                node instanceof ASTMethodDeclaration
                ;
    }
}
