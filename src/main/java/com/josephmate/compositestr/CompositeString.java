package com.josephmate.compositestr;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
public class CompositeString implements MemoryReuseString {

	private static final long serialVersionUID = 1749824619922965149L;
	
	private final MemoryReuseString[] concatenatedStrings;
	
	public CompositeString(@Nonnull String ... concatenatedStrings) {
		this.concatenatedStrings = new StringWrapper[concatenatedStrings.length];
		for(int i = 0; i < concatenatedStrings.length; i++) {
			this.concatenatedStrings[i] = new StringWrapper(concatenatedStrings[i]);
		}
	}
	
	public CompositeString(@Nonnull MemoryReuseString ... concatenatedStrings) {
		this.concatenatedStrings = new MemoryReuseString[concatenatedStrings.length];
		for(int i = 0; i < concatenatedStrings.length; i++) {
			this.concatenatedStrings[i] = concatenatedStrings[i];
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(MemoryReuseString str : concatenatedStrings) {
			builder.append(str.toString());
		}
		return builder.toString();
	}

	@Override
	public MemoryReuseString concat(String otherStr) {
        return new CompositeString(this, new StringWrapper(otherStr));
	}

	@Override
	public MemoryReuseString concat(MemoryReuseString otherStr) {
        return new CompositeString(this, otherStr);
	}

	@Override
	public String substring(int beginIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String substring(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String replace(char oldChar, char newChar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String replaceFirst(String regex, String replacement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String replaceAll(String regex, String replacement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String replace(CharSequence target, CharSequence replacement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] split(String regex, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] split(String regex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toLowerCase(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toLowerCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toUpperCase(Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toUpperCase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String trim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codePointAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codePointBefore(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int codePointCount(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int offsetByCodePoints(int index, int codePointOffset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBytes(Charset charset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getBytes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contentEquals(StringBuffer sb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contentEquals(CharSequence cs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equalsIgnoreCase(String anotherString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(String anotherString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareToIgnoreCase(String otherStr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startsWith(String prefix, int toffset) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean startsWith(String prefix) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean endsWith(String suffix) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(int ch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(int ch, int fromIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(int ch) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(int ch, int fromIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(String otherStr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(String otherStr, int fromIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(String otherStr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(String otherStr, int fromIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(String regex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(CharSequence s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public char[] toCharArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
