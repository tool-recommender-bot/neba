/*
  Copyright 2013 the original author or authors.

  Licensed under the Apache License, Version 2.0 the "License";
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package io.neba.core.resourcemodels.mapping.testmodels;

import io.neba.api.annotations.Path;
import io.neba.api.annotations.ResourceModel;

/**
 * Contains a member with an invalid {@link Path} annotation.
 * 
 * @author Olaf Otto
 */
@ResourceModel(types = "ignored/junit/test/type")
public class TestResourceModelWithInvalidPathDeclaration extends TestResourceModel {
    @Path(" ")
    private String fieldWithInvalidPathAnnotation;
}
