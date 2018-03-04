package com.josephmate.compositestr;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

interface MemoryReuseString extends Serializable, Comparable<String>, CharSequence {

	/**
	 * This is the primary usecase of this library. We will tackle the other more challenging use cases later.
	 * 
	 * Use CompositeString(this, other) to re-use existing strings
	 * 
	 * @see String#concat(String)
	 */
	MemoryReuseString concat(MemoryReuseString otherStr);
	
	/**
	 * This is the primary usecase of this library. We will tackle the other more challenging use cases later.
	 * 
	 * Use CompositeString(this, other) to re-use existing strings
	 * 
	 * @see String#concat(String)
	 */
	MemoryReuseString concat(String otherStr);

	/**
	 * If we keep track of the indices in a wrapping object, we can re-use existing CompositeString.
	 * 
	 * @see String#substring(String)
	 */
	String substring(int beginIndex);

	/**
	 * Keep track of the indices in a wrapping object, to re-use existing CompositeStrings.
	 * 
	 * @see String#substring(String, int)
	 */
	String substring(int beginIndex, int endIndex);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#replace(char, char)
	 */
	String replace(char oldChar, char newChar);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#replaceFirst(String, String)
	 */
	String replaceFirst(String regex, String replacement);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#replaceAll(String, String)
	 */
	String replaceAll(String regex, String replacement);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#replace(CharSequence, CharSequence)
	 */
	String replace(CharSequence target, CharSequence replacement);

	/**
	 * maintain pointers to the substrings
	 * @see String#split(String, int)
	 */
	String[] split(String regex, int limit);

	/**
	 * @see String#split(String)
	 */
	String[] split(String regex);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#toLowerCase(Locale)
	 */
	String toLowerCase(Locale locale);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#toLowerCase()
	 */
	String toLowerCase();

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#toUpperCase(Locale)
	 */
	String toUpperCase(Locale locale);

	/**
	 * Use a wrapping object that re-computes the characters replaced every time toString() is called.
	 * 
	 * @see String#toUpperCase()
	 */
	String toUpperCase();

	/**
	 * Use a wrapping the uses start-end pointers to trim.
	 * 
	 * @see String#trim()
	 */
	String trim();

	/**
	 * @see String#length()
	 */
	int length();

	/**
	 * @see String#isEmpty()
	 */
	boolean isEmpty();

	/**
	 * @see String#charAt(int)
	 */
	char charAt(int index);

	/**
	 * @see String#codePointAt(int)
	 */
	int codePointAt(int index);

	/**
	 * @see String#codePointBefore(int)
	 */
	int codePointBefore(int index);

	/**
	 * @see String#codePointCount(int, int)
	 */
	int codePointCount(int beginIndex, int endIndex);

	/**
	 * @see String#codePointCount(int, int)
	 */
	int offsetByCodePoints(int index, int codePointOffset);

	/**
	 * @see String#getChars(int, int, char[], int)
	 */
	void getChars(int srcBegin, int srcEnd, char dst[], int dstBegin);

	/**
	 * @see String#getBytes(int, int, byte[], int)
	 */
	void getBytes(int srcBegin, int srcEnd, byte dst[], int dstBegin);

	/**
	 * @see String#getBytes(String)
	 */
	byte[] getBytes(String charsetName) throws UnsupportedEncodingException;

	/**
	 * @see String#getBytes(charset)
	 */
	byte[] getBytes(Charset charset);

	/**
	 * @see String#getBytes()
	 */
	byte[] getBytes();

	/**
	 * @see String#equals(Object)
	 */
	boolean equals(Object anObject);

	/**
	 * @see String#contentEquals(StringBuffer)
	 */
	boolean contentEquals(StringBuffer sb);

	/**
	 * @see String#contentEquals(CharSequence)
	 */
	boolean contentEquals(CharSequence cs);

	/**
	 * @see String#equalsIgnoreCase(String)
	 */
	boolean equalsIgnoreCase(String anotherString);

	/**
	 * @see String#compareTo(String)
	 */
	int compareTo(String anotherString);

	/**
	 * @see String#compareToIgnoreCase(String)
	 */
	int compareToIgnoreCase(String otherStr);

	/**
	 * @see String#regionMatches(int, String, int, int)
	 */
	boolean regionMatches(int toffset, String other, int ooffset, int len);

	/**
	 * @see String#regionMatches(boolean, int, String, int, int)
	 */
	boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len);

	/**
	 * @see String#startsWith(String, int)
	 */
	boolean startsWith(String prefix, int toffset);

	/**
	 * @see String#startsWith(String)
	 */
	boolean startsWith(String prefix);

	/**
	 * @see String#endsWith(String)
	 */
	boolean endsWith(String suffix);

	/**
	 * @see String#hashCode()
	 */
	int hashCode();

	/**
	 * @see String#indexOf(int)
	 */
	int indexOf(int ch);

	/**
	 * @see String#indexOf(int, int)
	 */
	int indexOf(int ch, int fromIndex);

	/**
	 * @see String#lastIndexOf(int)
	 */
	int lastIndexOf(int ch);

	/**
	 * @see String#lastIndexOf(int, int)
	 */
	int lastIndexOf(int ch, int fromIndex);

	/**
	 * @see String#indexOf(String)
	 */
	int indexOf(String otherStr);

	/**
	 * @see String#indexOf(String, int)
	 */
	int indexOf(String otherStr, int fromIndex);

	/**
	 * @see String#lastIndexOf(String)
	 */
	int lastIndexOf(String otherStr);

	/**
	 * @see String#lastIndexOf(String, int)
	 */
	int lastIndexOf(String otherStr, int fromIndex);

	/**
	 * @see String#subSequence(int, int)
	 */
	CharSequence subSequence(int beginIndex, int endIndex);

	/**
	 * @see String#matches(String)
	 */
	boolean matches(String regex);

	/**
	 * @see String#contains(CharSequence)
	 */
	boolean contains(CharSequence s);

	/**
	 * @see String#toString()
	 */
	String toString();

	/**
	 * @see String#toCharArray()
	 */
	char[] toCharArray();

}