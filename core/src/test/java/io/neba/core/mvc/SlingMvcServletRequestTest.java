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

package io.neba.core.mvc;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.request.RequestPathInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

/**
 * @author Olaf Otto
 */
@RunWith(MockitoJUnitRunner.class)
public class SlingMvcServletRequestTest {
    @Mock
    private SlingHttpServletRequest request;
    @Mock
    private RequestPathInfo requestPathInfo;

    private SlingMvcServletRequest testee;

    @Before
    public void setUp() throws Exception {
        doReturn(this.requestPathInfo).when(this.request).getRequestPathInfo();
        doReturn("/bin/mvc").when(this.requestPathInfo).getResourcePath();
        doReturn("do").when(this.requestPathInfo).getExtension();

        this.testee = new SlingMvcServletRequest(this.request);
    }

    @Test
    public void testMvcRequestProvidesServletResourcePathAndExtensionAsServletPath() throws Exception {
        assertThat(this.testee.getServletPath()).isEqualTo("/bin/mvc.do");
    }
}