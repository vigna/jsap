/*
 * Copyright (C) 2002-2021, Martian Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.martiansoftware.jsap.stringparsers;

import com.martiansoftware.jsap.StringParser;
import com.martiansoftware.jsap.ParseException;

/**
 * A {@link com.martiansoftware.jsap.StringParser} for parsing Floats.  The <code>parse()</code> method delegates
 * the actual
 * parsing to <code>new Float(String)</code>.  If <code>new Float(String)</code>
 * throws a NumberFormatException, it
 * is encapsulated in a ParseException and re-thrown.
 *
 * @author <a href="http://www.martiansoftware.com/contact.html">Marty Lamb</a>
 * @see com.martiansoftware.jsap.StringParser
 * @see java.lang.Float
 */
public class FloatStringParser extends StringParser {

	private static final FloatStringParser INSTANCE = new FloatStringParser();	

	/** Returns a {@link FloatStringParser}.
	 * 
	 * <p>Convenient access to the only instance returned by
	 * this method is available through
	 * {@link com.martiansoftware.jsap.JSAP#FLOAT_PARSER}.
	 *  
	 * @return a {@link FloatStringParser}.
	 */

    public static FloatStringParser getParser() {
		return INSTANCE;
	}

	/**
     * Creates a new FloatStringParser.
     * @deprecated Use {@link #getParser()} or, even better, {@link com.martiansoftware.jsap.JSAP#FLOAT_PARSER}.
     */
    public FloatStringParser() {
        super();
    }

    /**
     * Parses the specified argument into a Float.  This method delegates the
     * actual
     * parsing to new Float(String).  If new Float(String) throws a
     * NumberFormatException, it
     * is encapsulated in a ParseException and re-thrown.
     *
     * @param arg the argument to parse
     * @return a Float object with the value contained in the specified
     * argument.
     * @throws ParseException if <code>new Float(arg)</code> throws a
     * NumberFormatException.
     * @see java.lang.Float
     * @see com.martiansoftware.jsap.StringParser#parse(String)
     */
    public Object parse(String arg) throws ParseException {
        Float result = null;
        try {
            result = new Float(arg);
        } catch (NumberFormatException e) {
            throw (
                new ParseException(
                    "Unable to convert '" + arg + "' to a Float.",
                    e));
        }
        return (result);
    }
}
