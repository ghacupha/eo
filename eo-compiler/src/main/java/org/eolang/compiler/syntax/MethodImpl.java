/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 eolang.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.eolang.compiler.syntax;

import org.cactoos.text.FormattedText;
import org.cactoos.text.UncheckedText;

/**
 * Method implementation.
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @since 0.1
 *
 * @todo #105:30m Object instantiation in method body is not implemented
 *  We should be able to create new object inside methods.
 *  It may be implemented as java nested class
 *  in same object-class (just to my mind).
 */
public final class MethodImpl {

    /**
     * Method declaration.
     */
    private final Method declaration;

    /**
     * The argument.
     */
    private final Argument argument;

    /**
     * Ctor.
     *
     * @param dcr Method declaration
     * @param arg The argument
     */
    public MethodImpl(final Method dcr, final Argument arg) {
        this.declaration = dcr;
        this.argument = arg;
    }

    /**
     * Method declaration and body code.
     *
     * @return Java code.
     */
    public String java() {
        return new UncheckedText(
            new FormattedText(
                "public %s {\n  return %s;\n}",
                this.declaration.java(),
                this.argument.java()
            )
        ).asString();
    }
}
