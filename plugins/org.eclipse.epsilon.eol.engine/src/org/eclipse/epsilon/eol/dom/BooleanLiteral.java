/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;

public class BooleanLiteral extends LiteralExpression<Boolean> {
	
	public BooleanLiteral() {
		super();
	}
	
	public BooleanLiteral(Boolean value) {
		super(value);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		try {
			value = Boolean.parseBoolean(cst.getText());
		}
		catch (Exception ex) {
			value = false;
		}
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		resolvedType = EolPrimitiveType.Boolean;
	}
	
	public void accept(IEolVisitor visitor) {
		visitor.visit(this);
	}
}
