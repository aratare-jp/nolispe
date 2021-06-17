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

public class IntegerLiteral extends LiteralExpression<Number> {
	
	protected String text = "";
	
	public IntegerLiteral() {
		super();
	}
	
	public IntegerLiteral(Number value) {
		super(value);
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		setText(cst.getText());
	}
	
	public void setText(String text) {
		this.text = text;
	
		/*
		 * int range is -2,147,483,648 to 2,147,483,647, but the INT token in
		 * EolLexerRules.g does not include the leading '-', so anything over 10
		 * characters or anything that the user has explicitly specified as such is
		 * clearly a long value.
		 */
		if (text.endsWith("l") || text.length() > 10) {
			text = text.substring(0, text.length() - 1);
			value = Long.parseLong(text);
		}
		else {
			/*
			 * If it's not clearly a long value, parse as an int (to avoid additional
			 * overheads from new comparisons), or fall back to parsing it as a long if
			 * needed.
			 */
			try {
				value = Integer.parseInt(text);
			} catch (NumberFormatException ex) {
				value = Long.parseLong(text);
			}
		}
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		resolvedType = EolPrimitiveType.Integer;
	}
	
	public void accept(IEolVisitor visitor) {
		visitor.visit(this);
	}
	
}
