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

package com.martiansoftware.jsap.ant;

import java.io.PrintStream;

import com.martiansoftware.jsap.Parameter;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.Switch;

/**
 * Stores/provides configuration data for switches nested inside a jsap ant
 * task.
 * For detailed information on using the jsap task, see the documentation for
 * JSAPAntTask.
 *
 * @author <a href="http://www.martiansoftware.com/contact.html">Marty Lamb</a>
 * @see JSAPAntTask
 * @see com.martiansoftware.jsap.Switch
 */

public class SwitchConfiguration extends ParameterConfiguration {

    /**
     * The short flag for this switch.
     */
    private char shortFlag = JSAP.NO_SHORTFLAG;

    /**
     * The long flag for this switch.
     */
    private String longFlag = JSAP.NO_LONGFLAG;

    /**
     * Creates a new SwitchConfiguration.
     */
    public SwitchConfiguration() {
        super();
    }

    /**
     * Sets the short flag for this switch.
     * @param shortFlag the short flag for this switch.
     */
    public void setShortflag(char shortFlag) {
        this.shortFlag = shortFlag;
    }

    /**
     * Returns the short flag for this switch.
     * @return the short flag for this switch.
     */
    public char getShortflag() {
        return (shortFlag);
    }

    /**
     * Sets the long flag for this switch.
     * @param longFlag the long flag for this switch.
     */
    public void setLongflag(String longFlag) {
        this.longFlag = longFlag;
    }

    /**
     * Returns the long flag for this switch.
     * @return the long flag for this switch.
     */
    public String getLongflag() {
        return (longFlag);
    }

    /**
     * Returns a Switch configured according to this configuration.
     * @return a Switch configured according to this configuration.
     */
    public Parameter getParameter() {
        Switch result = new Switch(this.getId());
        result.setShortFlag(this.getShortflag());
        result.setLongFlag(this.getLongflag());
        result.setDefault(this.getDefaults());
        return (result);
    }

    /**
     * Creates java source code for a method that will instantiate and configure
     * a Switch
     * according to this configuration.
     * @param methodName the name of the method to generate
     * @param out the PrintStream to which the generated java will be written
     */
    public void createMethod(String methodName, PrintStream out) {

        out.println("    private Switch " + methodName + "() {");
        out.println(
            "        Switch result = new Switch(\"" + this.getId() + "\");");

        if (getShortflag() != JSAP.NO_SHORTFLAG) {
            out.println(
                "        result.setShortFlag('" + getShortflag() + "');");
        }

        if (getLongflag() != JSAP.NO_LONGFLAG) {
            out.println(
                "        result.setLongFlag(\"" + getLongflag() + "\");");
        }

        super.createParentStatements("result", out);
        out.println("        return (result);");
        out.println("    }");
    }

}
