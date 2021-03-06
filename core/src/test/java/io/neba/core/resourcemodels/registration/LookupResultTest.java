/**
 * Copyright 2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 the "License";
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
**/

package io.neba.core.resourcemodels.registration;

import io.neba.core.util.OsgiModelSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Olaf Otto
 */
@RunWith(MockitoJUnitRunner.class)
public class LookupResultTest {
    @Mock
    private OsgiModelSource<?> modelSource;
    private LookupResult testee;

    @Before
    public void setUp() {
        this.testee = new LookupResult(this.modelSource, "junit/test/type");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorArgumentSourceMustNotBeNull() {
        new LookupResult(null, "some/resource/type");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorArgumentResourceTypeMustNotBeNull() {
        new LookupResult(this.modelSource, null);
    }

    @Test
    public void testEqualsNull() {
        assertLookupResultIsNotEqualTo(null);
    }

    @Test
    public void testEqualToOtherType() {
        assertLookupResultIsNotEqualTo(new Object());
    }

    @Test
    public void testEqualsToResultForOtherSource() {
        OsgiModelSource<?> modelSource = mock(OsgiModelSource.class);
        LookupResult other = new LookupResult(modelSource, "junit/test/type");

        assertLookupResultIsNotEqualTo(other);
    }

    @Test
    public void testEqualsToResultForDifferentResourceType() {
        assertLookupResultIsNotEqualTo(new LookupResult(this.modelSource, "junit/other/type"));
    }

    @Test
    public void testEqualsToResultForSameSourceAndResourceType() {
        assertThat(this.testee).isEqualTo(new LookupResult(this.modelSource, "junit/test/type"));
    }

    @Test
    public void testStringRepresentation() {
        assertThat(this.testee.toString()).isEqualTo("junit/test/type -> [modelSource]");
    }

    private void assertLookupResultIsNotEqualTo(Object other) {
        assertThat(this.testee).isNotEqualTo(other);
    }
}
