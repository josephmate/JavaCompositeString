package com.josephmate.compositestr;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * Unfortunately, {@link String} is a final class so we cannot extends. As a result, we re-implment the API, and forward all calls from Str to String.
 * @author Joseph
 */
@Immutable
class StringWrapper implements Serializable, Comparable<String>, CharSequence {
	
	private static final long serialVersionUID = -6708472144954405289L;
	
	private final @Nonnull String str;
	
	public StringWrapper(@Nonnull String str) {
		this.str = str;
	}

    /**
     * This is the primary usecase of this library. We will tackle the other more challenging use cases later.
     * 
     * Use CompositeString(this, other) to re-use existing strings
     * 
     * @see String#concat(String)
     */
    public String concat(String otherStr) {
        return str.concat(otherStr);
    }

	///////////////////////////////////////////////////////////////////////////////////////
	// Methods to consider not wrapping because we really want to return CompositeString
	// so that we can efficiently re-use existing memory rather than allocating new arrays.
	///////////////////////////////////////////////////////////////////////////////////////

    /**
     * If we keep track of the indices in a wrapping object, we can re-use existing CompositeString.
     * 
     * @see String#substring(String)
     */
    public String substring(int beginIndex) {
        return str.substring(beginIndex);
    }

    /**
     * Keep track of the indices in a wrapping object, to re-use existing CompositeStrings.
     * 
     * @see String#substring(String, int)
     */
    public String substring(int beginIndex, int endIndex) {
        return str.substring(beginIndex, endIndex);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#replace(char, char)
     */
    public String replace(char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#replaceFirst(String, String)
     */
    public String replaceFirst(String regex, String replacement) {
        return str.replaceFirst(regex, replacement);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#replaceAll(String, String)
     */
    public String replaceAll(String regex, String replacement) {
        return str.replaceFirst(regex, replacement);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#replace(CharSequence, CharSequence)
     */
    public String replace(CharSequence target, CharSequence replacement) {
        return str.replace(target, replacement);
    }

    /**
     * maintain pointers to the substrings
     * @see String#split(String, int)
     */
    public String[] split(String regex, int limit) {
        return str.split(regex, limit);
    }

    /**
     * @see String#split(String)
     */
    public String[] split(String regex) {
        return str.split(regex);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#toLowerCase(Locale)
     */
    public String toLowerCase(Locale locale) {
        return str.toLowerCase(locale);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#toLowerCase()
     */
    public String toLowerCase() {
        return str.toLowerCase();
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#toUpperCase(Locale)
     */
    public String toUpperCase(Locale locale) {
        return str.toUpperCase(locale);
    }

    /**
     * Use a wrapping object that re-computes the characters replaced every time toString() is called.
     * 
     * @see String#toUpperCase()
     */
    public String toUpperCase() {
        return str.toUpperCase();
    }

    /**
     * Use a wrapping the uses start-end pointers to trim.
     * 
     * @see String#trim()
     */
    public String trim() {
        return str.trim();
    }

	///////////////////////////////////////////////////////////////////////////////////////
	// Methods that do not need to return CompositeString
	///////////////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * @see String#length()
     */
    public int length() {
        return str.length();
    }

    /**
     * @see String#isEmpty()
     */
    public boolean isEmpty() {
        return str.isEmpty();
    }

    /**
     * @see String#charAt(int)
     */
    public char charAt(int index) {
    	return str.charAt(index);
    }

    /**
     * @see String#codePointAt(int)
     */
    public int codePointAt(int index) {
    	return str.codePointAt(index);
    }

    /**
     * @see String#codePointBefore(int)
     */
    public int codePointBefore(int index) {
    	return str.codePointBefore(index);
    }

    /**
     * @see String#codePointCount(int, int)
     */
    public int codePointCount(int beginIndex, int endIndex) {
    	return str.codePointCount(beginIndex, endIndex);
    }

    /**
     * @see String#codePointCount(int, int)
     */
    public int offsetByCodePoints(int index, int codePointOffset) {
    	return str.codePointCount(index, codePointOffset);
    }

    /**
     * @see String#getChars(int, int, char[], int)
     */
    public void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin) {
    	str.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    /**
     * @see String#getBytes(int, int, byte[], int)
     */
    @Deprecated
    public void getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin) {
    	str.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    /**
     * @see String#getBytes(String)
     */
    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return str.getBytes(charsetName);
    }

    /**
     * @see String#getBytes(charset)
     */
    public byte[] getBytes(Charset charset) {
        return str.getBytes(charset);
    }

    /**
     * @see String#getBytes()
     */
    public byte[] getBytes() {
        return str.getBytes();
    }

    /**
     * @see String#equals(Object)
     */
    public boolean equals(Object anObject) {
        return str.equals(anObject);
    }

    /**
     * @see String#contentEquals(StringBuffer)
     */
    public boolean contentEquals(StringBuffer sb) {
        return str.contentEquals(sb);
    }

    /**
     * @see String#contentEquals(CharSequence)
     */
    public boolean contentEquals(CharSequence cs) {
        return str.contentEquals(cs);
    }

    /**
     * @see String#equalsIgnoreCase(String)
     */
    public boolean equalsIgnoreCase(String anotherString) {
        return str.equalsIgnoreCase(anotherString);
    }

    /**
     * @see String#compareTo(String)
     */
    public int compareTo(String anotherString) {
        return str.compareTo(anotherString);
    }

    /**
     * @see String#compareToIgnoreCase(String)
     */
    public int compareToIgnoreCase(String otherStr) {
        return str.compareToIgnoreCase(otherStr);
    }

    /**
     * @see String#regionMatches(int, String, int, int)
     */
    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        return str.regionMatches(toffset, other, ooffset, len);
    }

    /**
     * @see String#regionMatches(boolean, int, String, int, int)
     */
    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        return str.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    /**
     * @see String#startsWith(String, int)
     */
    public boolean startsWith(String prefix, int toffset) {
    	return str.startsWith(prefix, toffset);
    }

    /**
     * @see String#startsWith(String)
     */
    public boolean startsWith(String prefix) {
        return str.startsWith(prefix);
    }

    /**
     * @see String#endsWith(String)
     */
    public boolean endsWith(String suffix) {
        return str.endsWith(suffix);
    }

    /**
     * @see String#hashCode()
     */
    public int hashCode() {
        return str.hashCode();
    }

    /**
     * @see String#indexOf(int)
     */
    public int indexOf(int ch) {
        return str.indexOf(ch);
    }

    /**
     * @see String#indexOf(int, int)
     */
    public int indexOf(int ch, int fromIndex) {
        return str.indexOf(ch, fromIndex);
    }

    /**
     * @see String#lastIndexOf(int)
     */
    public int lastIndexOf(int ch) {
        return str.lastIndexOf(ch);
    }

    /**
     * @see String#lastIndexOf(int, int)
     */
    public int lastIndexOf(int ch, int fromIndex) {
    	return str.lastIndexOf(ch, fromIndex);
    }

    /**
     * @see String#indexOf(String)
     */
    public int indexOf(String otherStr) {
        return str.indexOf(otherStr);
    }

    /**
     * @see String#indexOf(String, int)
     */
    public int indexOf(String otherStr, int fromIndex) {
        return str.indexOf(otherStr, fromIndex);
    }

    /**
     * @see String#lastIndexOf(String)
     */
    public int lastIndexOf(String otherStr) {
        return str.lastIndexOf(otherStr);
    }

    /**
     * @see String#lastIndexOf(String, int)
     */
    public int lastIndexOf(String otherStr, int fromIndex) {
        return str.lastIndexOf(otherStr);
    }

    /**
     * @see String#subSequence(int, int)
     */
    public CharSequence subSequence(int beginIndex, int endIndex) {
        return str.subSequence(beginIndex, endIndex);
    }

    /**
     * @see String#matches(String)
     */
    public boolean matches(String regex) {
        return str.matches(regex);
    }

    /**
     * @see String#contains(CharSequence)
     */
    public boolean contains(CharSequence s) {
        return str.contains(s);
    }

    /**
     * @see String#toString()
     */
    public String toString() {
        return str.toString();
    }

    /**
     * @see String#toCharArray()
     */
    public char[] toCharArray() {
        return str.toCharArray();
    }
	
}
