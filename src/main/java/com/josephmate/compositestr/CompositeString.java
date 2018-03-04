package com.josephmate.compositestr;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
public class CompositeString extends StringWrapper {

	private static final long serialVersionUID = 1749824619922965149L;
	
	public CompositeString(@Nonnull String ... concatenatedStrings) {
		super(null);
		// TODO Auto-generated constructor stub
	}
	
	public CompositeString(@Nonnull CompositeString ... concatenatedStrings) {
		super(null);
		// TODO Auto-generated constructor stub
	}
	
}
