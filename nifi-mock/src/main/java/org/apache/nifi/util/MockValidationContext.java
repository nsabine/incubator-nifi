/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.util;

import java.util.Map;
import java.util.Set;

import org.apache.nifi.attribute.expression.language.StandardExpressionLanguageCompiler;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.components.PropertyValue;
import org.apache.nifi.components.ValidationContext;
import org.apache.nifi.controller.ControllerService;
import org.apache.nifi.controller.ControllerServiceLookup;
import org.apache.nifi.expression.ExpressionLanguageCompiler;

public class MockValidationContext implements ValidationContext, ControllerServiceLookup {

    private final MockProcessContext context;

    public MockValidationContext(final MockProcessContext processContext) {
        this.context = processContext;
    }

    @Override
    public ControllerService getControllerService(final String identifier) {
        return context.getControllerService(identifier);
    }

    @Override
    public PropertyValue newPropertyValue(final String rawValue) {
        return new MockPropertyValue(rawValue, this);
    }

    @Override
    public ExpressionLanguageCompiler newExpressionLanguageCompiler() {
        return new StandardExpressionLanguageCompiler();
    }

    @Override
    public ValidationContext getControllerServiceValidationContext(final ControllerService controllerService) {
        final MockProcessContext serviceProcessContext = new MockProcessContext(controllerService, context);
        return new MockValidationContext(serviceProcessContext);
    }

    @Override
    public PropertyValue getProperty(final PropertyDescriptor property) {
        return context.getProperty(property);
    }

    @Override
    public Map<PropertyDescriptor, String> getProperties() {
        return context.getProperties();
    }

    @Override
    public String getAnnotationData() {
        return context.getAnnotationData();
    }

    @Override
    public Set<String> getControllerServiceIdentifiers(Class<? extends ControllerService> serviceType) {
        return context.getControllerServiceIdentifiers(serviceType);
    }

    @Override
    public ControllerServiceLookup getControllerServiceLookup() {
        return this;
    }

    @Override
    public boolean isControllerServiceEnabled(final String serviceIdentifier) {
        return context.isControllerServiceEnabled(serviceIdentifier);
    }

    @Override
    public boolean isControllerServiceEnabled(final ControllerService service) {
        return context.isControllerServiceEnabled(service);
    }
}
