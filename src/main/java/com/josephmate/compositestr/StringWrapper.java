package com.josephmate.compositestr;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * Unfortunately, {@link String} is a final class so we cannot extends. As a result, we re-implement the API, and forward all calls from Str to String.
 * @author Joseph
 */
@Immutable
class StringWrapper implements MemoryReuseString {
	
	private static final long serialVersionUID = -6708472144954405289L;
	
	private final @Nonnull String str;
	
	public StringWrapper(@Nonnull String str) {
		this.str = str;
	}

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#concat(java.lang.String)
	 */
    @Override
	public CompositeString concat(MemoryReuseString otherStr) {
        return new CompositeString(this, otherStr);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#concat(java.lang.String)
	 */
    @Override
	public CompositeString concat(String otherStr) {
        return new CompositeString(this, new StringWrapper(otherStr));
    }

	///////////////////////////////////////////////////////////////////////////////////////
	// Methods to consider not wrapping because we really want to return CompositeString
	// so that we can efficiently re-use existing memory rather than allocating new arrays.
	///////////////////////////////////////////////////////////////////////////////////////

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#substring(int)
	 */
    @Override
	public String substring(int beginIndex) {
    	// TODO
        return str.substring(beginIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#substring(int, int)
	 */
    @Override
	public String substring(int beginIndex, int endIndex) {
    	// TODO
        return str.substring(beginIndex, endIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#replace(char, char)
	 */
    @Override
	public String replace(char oldChar, char newChar) {
    	// TODO
        return str.replace(oldChar, newChar);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#replaceFirst(java.lang.String, java.lang.String)
	 */
    @Override
	public String replaceFirst(String regex, String replacement) {
    	// TODO
        return str.replaceFirst(regex, replacement);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#replaceAll(java.lang.String, java.lang.String)
	 */
    @Override
	public String replaceAll(String regex, String replacement) {
    	// TODO
        return str.replaceFirst(regex, replacement);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#replace(java.lang.CharSequence, java.lang.CharSequence)
	 */
    @Override
	public String replace(CharSequence target, CharSequence replacement) {
    	// TODO
        return str.replace(target, replacement);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#split(java.lang.String, int)
	 */
    @Override
	public String[] split(String regex, int limit) {
    	// TODO
        return str.split(regex, limit);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#split(java.lang.String)
	 */
    @Override
	public String[] split(String regex) {
    	// TODO
        return str.split(regex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#toLowerCase(java.util.Locale)
	 */
    @Override
	public String toLowerCase(Locale locale) {
    	// TODO
        return str.toLowerCase(locale);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#toLowerCase()
	 */
    @Override
	public String toLowerCase() {
    	// TODO
        return str.toLowerCase();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#toUpperCase(java.util.Locale)
	 */
    @Override
	public String toUpperCase(Locale locale) {
    	// TODO
        return str.toUpperCase(locale);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#toUpperCase()
	 */
    @Override
	public String toUpperCase() {
    	// TODO
        return str.toUpperCase();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#trim()
	 */
    @Override
	public String trim() {
    	// TODO
        return str.trim();
    }

	///////////////////////////////////////////////////////////////////////////////////////
	// Methods that do not need to return CompositeString
	///////////////////////////////////////////////////////////////////////////////////////
    
    
    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#length()
	 */
    @Override
	public int length() {
        return str.length();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#isEmpty()
	 */
    @Override
	public boolean isEmpty() {
        return str.isEmpty();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#charAt(int)
	 */
    @Override
	public char charAt(int index) {
    	return str.charAt(index);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#codePointAt(int)
	 */
    @Override
	public int codePointAt(int index) {
    	return str.codePointAt(index);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#codePointBefore(int)
	 */
    @Override
	public int codePointBefore(int index) {
    	return str.codePointBefore(index);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#codePointCount(int, int)
	 */
    @Override
	public int codePointCount(int beginIndex, int endIndex) {
    	return str.codePointCount(beginIndex, endIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#offsetByCodePoints(int, int)
	 */
    @Override
	public int offsetByCodePoints(int index, int codePointOffset) {
    	return str.codePointCount(index, codePointOffset);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#getChars(int, int, char[], int)
	 */
    @Override
	public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
    	str.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#getBytes(int, int, byte[], int)
	 */
    @Override
	@Deprecated
    public void getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin) {
    	str.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#getBytes(java.lang.String)
	 */
    @Override
	public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return str.getBytes(charsetName);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#getBytes(java.nio.charset.Charset)
	 */
    @Override
	public byte[] getBytes(Charset charset) {
        return str.getBytes(charset);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#getBytes()
	 */
    @Override
	public byte[] getBytes() {
        return str.getBytes();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#equals(java.lang.Object)
	 */
    @Override
	public boolean equals(Object anObject) {
        return str.equals(anObject);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#contentEquals(java.lang.StringBuffer)
	 */
    @Override
	public boolean contentEquals(StringBuffer sb) {
        return str.contentEquals(sb);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#contentEquals(java.lang.CharSequence)
	 */
    @Override
	public boolean contentEquals(CharSequence cs) {
        return str.contentEquals(cs);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#equalsIgnoreCase(java.lang.String)
	 */
    @Override
	public boolean equalsIgnoreCase(String anotherString) {
        return str.equalsIgnoreCase(anotherString);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#compareTo(java.lang.String)
	 */
    @Override
	public int compareTo(String anotherString) {
        return str.compareTo(anotherString);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#compareToIgnoreCase(java.lang.String)
	 */
    @Override
	public int compareToIgnoreCase(String otherStr) {
        return str.compareToIgnoreCase(otherStr);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#regionMatches(int, java.lang.String, int, int)
	 */
    @Override
	public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return str.regionMatches(toffset, other, ooffset, len);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#regionMatches(boolean, int, java.lang.String, int, int)
	 */
    @Override
	public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return str.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#startsWith(java.lang.String, int)
	 */
    @Override
	public boolean startsWith(String prefix, int toffset) {
    	return str.startsWith(prefix, toffset);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#startsWith(java.lang.String)
	 */
    @Override
	public boolean startsWith(String prefix) {
        return str.startsWith(prefix);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#endsWith(java.lang.String)
	 */
    @Override
	public boolean endsWith(String suffix) {
        return str.endsWith(suffix);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#hashCode()
	 */
    @Override
	public int hashCode() {
        return str.hashCode();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#indexOf(int)
	 */
    @Override
	public int indexOf(int ch) {
        return str.indexOf(ch);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#indexOf(int, int)
	 */
    @Override
	public int indexOf(int ch, int fromIndex) {
        return str.indexOf(ch, fromIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#lastIndexOf(int)
	 */
    @Override
	public int lastIndexOf(int ch) {
        return str.lastIndexOf(ch);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#lastIndexOf(int, int)
	 */
    @Override
	public int lastIndexOf(int ch, int fromIndex) {
    	return str.lastIndexOf(ch, fromIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#indexOf(java.lang.String)
	 */
    @Override
	public int indexOf(String otherStr) {
        return str.indexOf(otherStr);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#indexOf(java.lang.String, int)
	 */
    @Override
	public int indexOf(String otherStr, int fromIndex) {
        return str.indexOf(otherStr, fromIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#lastIndexOf(java.lang.String)
	 */
    @Override
	public int lastIndexOf(String otherStr) {
        return str.lastIndexOf(otherStr);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#lastIndexOf(java.lang.String, int)
	 */
    @Override
	public int lastIndexOf(String otherStr, int fromIndex) {
        return str.lastIndexOf(otherStr);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#subSequence(int, int)
	 */
    @Override
	public CharSequence subSequence(int beginIndex, int endIndex) {
        return str.subSequence(beginIndex, endIndex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#matches(java.lang.String)
	 */
    @Override
	public boolean matches(String regex) {
        return str.matches(regex);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#contains(java.lang.CharSequence)
	 */
    @Override
	public boolean contains(CharSequence s) {
        return str.contains(s);
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#toString()
	 */
    @Override
	public String toString() {
        return str.toString();
    }

    /* (non-Javadoc)
	 * @see com.josephmate.compositestr.MemoryReuseString#toCharArray()
	 */
    @Override
	public char[] toCharArray() {
        return str.toCharArray();
    }
	
}
