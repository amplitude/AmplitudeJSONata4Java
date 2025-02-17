/**
 * (c) Copyright 2018, 2019 IBM Corporation
 * 1 New Orchard Road, 
 * Armonk, New York, 10504-1722
 * United States
 * +1 914 499 1900
 * support: Nathaniel Mills wnm3@us.ibm.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.api.jsonata4java.expressions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.api.jsonata4java.expressions.RegularExpression;

/**
 * Some unit tests for helper class RegularExpression.
 *
 * @author Martin Bluemel
 */
public class RegularExpressionTest {

    @Test
    public void testToString() {
        assertEquals("c.*f", new RegularExpression("/c.*f/").toString());
        assertEquals("^.*$", new RegularExpression("/^.*$/").toString());
    }

    @Test
    public void find() {
        assertTrue(new RegularExpression("/^.*$/").getPattern().matcher("asdfgh").find());
        assertTrue(new RegularExpression("/^ab.*ef$/").getPattern().matcher("abcdef").find());
        assertTrue(new RegularExpression("/c.*f/").getPattern().matcher("abcdefgh").find());
    }

    @Test
    public void findCaseInsensitive() {
        assertFalse(new RegularExpression("/^ab.*ef$/").getPattern().matcher("ABCdef").find());
        assertTrue(new RegularExpression(RegularExpression.Type.CASEINSENSITIVE, "/^ab.*ef$/")
            .getPattern().matcher("ABCdef").find());
    }
}
