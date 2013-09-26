/*
 * Copyright (c) 2009, 2010, 2011, 2012, 2013, B3log Team
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
 */

/*
 * This file is part of the URI Template library.
 *
 * For licensing information please see the file license.txt included in the release.
 * A copy of this licence can also be found at 
 *   http://www.opensource.org/licenses/artistic-license-2.0.php
 */
package org.weborganic.furi;


import java.util.Map;
import java.util.regex.Pattern;


/**
 * A URI token corresponding to the literal text part of the URI template.
 * 
 * <p>Literal text remains identical during the expansion process (parameters are ignored).
 * 
 * <p>Literal text tokens only match text that is equal.
 * 
 * <p>The expression for a literal token does contain curly brackets.
 * 
 * @author Christophe Lauret
 * @version 9 February 2009
 */
public class TokenLiteral extends TokenBase implements Token, Matchable {

    /**
     * Creates a new literal text token.
     * 
     * @param text The text corresponding to this URI token.
     * 
     * @throws NullPointerException If the specified text is <code>null</code>.
     */
    public TokenLiteral(String text) throws NullPointerException {
        super(text);
    }

    /**
     * {@inheritDoc}
     */
    public String expand(Parameters parameters) {
        return this.expression();
    }

    /**
     * {@inheritDoc}
     */
    public boolean match(String part) {
        return this.expression().equals(part);
    }

    /**
     * {@inheritDoc}
     */
    public Pattern pattern() {
        return Pattern.compile(Pattern.quote(expression()));
    }

    /**
     * {@inheritDoc}
     * 
     * By definition, no variable in this token. This method does nothing and always
     * returns <code>true</code>.
     */
    public boolean resolve(String expanded, Map<Variable, Object> values) {
        // nothing to resolve - the operation is always successful.
        return true;
    }

}
