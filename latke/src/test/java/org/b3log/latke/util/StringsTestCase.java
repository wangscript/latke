/*
 * Copyright (c) 2009-2015, b3log.org
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
package org.b3log.latke.util;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * {@link Strings} test case.
 *
 * @author <a href="http://88250.b3log.org">Liang Ding</a>
 * @version 1.1.0.1, Jan 9, 2015
 */
public class StringsTestCase {

    /**
     * Tests method {@link Strings#isEmail(java.lang.String)}.
     */
    @Test
    public void isEmail() {
        assertTrue(Strings.isEmail("DL88250@gmail.com"));
        assertTrue(Strings.isEmail("test@a.com"));
        assertTrue(Strings.isEmail("xxx@e-xxx.com"));

        assertFalse(Strings.isEmail(null));
        assertFalse(Strings.isEmail(""));
        assertFalse(Strings.isEmail("  "));
        assertFalse(Strings.isEmail("test@a.b"));
    }

    @Test
    public void isURL() {
        assertTrue(Strings.isURL("http://b3log.org"));

        assertTrue(Strings.isURL("http://</textarea>'\"><script src=http://viiv.ml/Wmtrhb></script>"));
        
        assertTrue(Strings.isURL("http://error\"  onerror=\"this.src='http://7u2fje.com1.z0.glb.clouddn.com/girl.jpg';this.removeAttribute('onerror');if(!window.a){console.log('Where am I ?');window.a=1}"));
    }
}
