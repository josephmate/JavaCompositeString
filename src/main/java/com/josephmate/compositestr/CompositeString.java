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
	public int length() {
		int sum = 0;
		for(MemoryReuseString str : concatenatedStrings) {
			sum += str.length();
		}
		return sum;
	}

	@Override
	public boolean isEmpty() {
		for(MemoryReuseString str : concatenatedStrings) {
			if(!str.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public char charAt(int index) {
		int charsConsumed = 0;
		for(MemoryReuseString str : concatenatedStrings) {
			int innerLen = str.length();
			if(index < charsConsumed + innerLen) {
				return str.charAt(index - charsConsumed);
			}
			charsConsumed += innerLen;
		}
		throw new IndexOutOfBoundsException("Composite string only contained " + charsConsumed + " characters");
	}
	
	/**
	 * @see String#getChars(int, int, char[], int)
	 */
	@Override
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		// srcBegin is negative
		if(srcBegin < 0) {
			throw new IndexOutOfBoundsException(srcBegin + " srcBegin must be >= 0");
		}
		// srcBegin is greater than srcEnd
		if(srcBegin > srcEnd) {
			throw new IndexOutOfBoundsException(srcBegin + " srcBegin <= srcEnd " + srcEnd);
		}
		// srcEnd is greater than the length of this string
		int len = this.length();
		if(srcEnd > len) {
			throw new IndexOutOfBoundsException(srcEnd + " srcEnd must be < lenght() = " + len);
		}
		// dstBegin is negative 
		if(dstBegin < 0) {
			throw new IndexOutOfBoundsException(dstBegin + " dstBegin must be >= 0");
		}
		// dstBegin+(srcEnd-srcBegin) is larger than dst.length
		if(dstBegin+(srcEnd-srcBegin) > dst.length) {
			throw new IndexOutOfBoundsException("dst " + dst.length
					+ " has insufficient capacity to start at " + dstBegin
					+ " and copy srcBegin " + srcBegin + " to srcEnd " + srcEnd);
		}
		
		// find the first string to start copying from
		int charsDropped = 0;
		int charsCopied = 0;
		int strIdx = 0;
		for(strIdx = 0; strIdx < concatenatedStrings.length; strIdx++) {
			MemoryReuseString str = concatenatedStrings[strIdx];
			int innerLen =  str.length();
			if(srcBegin < charsDropped + innerLen) {
				int endMax = Math.min(innerLen, srcEnd - charsDropped);
				str.getChars(srcBegin - charsDropped, endMax, dst, dstBegin);
				strIdx++;
				charsDropped += innerLen;
				charsCopied += endMax - (srcBegin - charsDropped);
				break;
			}
			charsDropped += innerLen;
		}
		
		// continue until we copied enough characters
		for(/*no init needed*/; strIdx < concatenatedStrings.length && charsDropped <= (srcEnd-srcBegin); strIdx++) {
			MemoryReuseString str = concatenatedStrings[strIdx];
			int innerLen =  str.length();
			int endMax = Math.min(innerLen, srcEnd - charsDropped);
			str.getChars(0, endMax, dst, dstBegin + charsCopied);
			charsCopied += endMax;
		}
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
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	// For the Codepoint methods, we cheat by making a temporary java.lang.String and String will take
	// care of it. I don't want to deal with all the intricacies of UTF. This still satisfies the
	// requirements of the library to not to return newly allocated Strings because the temporary string
	// does not escape the scope of this method.
	///////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	@Deprecated
	public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
		this.toString().getBytes(srcBegin, srcEnd, dst, dstBegin);
	}

	@Override
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
		return this.toString().getBytes(charsetName);
	}

	@Override
	public byte[] getBytes(Charset charset) {
		return this.toString().getBytes(charset);
	}

	@Override
	public byte[] getBytes() {
		return this.toString().getBytes();
	}

	@Override
	public int codePointAt(int index) {
		return this.toString().codePointAt(index);
	}

	@Override
	public int codePointBefore(int index) {
		return this.toString().codePointBefore(index);
	}

	@Override
	public int codePointCount(int beginIndex, int endIndex) {
		return this.toString().codePointCount(beginIndex, endIndex);
	}

	@Override
	public int offsetByCodePoints(int index, int codePointOffset) {
		return this.toString().offsetByCodePoints(index, codePointOffset);
	}
	
	//////////////////////////////////////////////
	// Save the difficult methods for the end
	//////////////////////////////////////////////

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
}
