package com.fasterxml.jackson.databind.deser.creators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.BaseMapTest;

public class DelegatingCreatorAnnotationsStringTest extends BaseMapTest
{

    public static class DelegatingToFactoryMethod {

        String valueField;

        private DelegatingToFactoryMethod(String ctorValue) {
            valueField = ctorValue;
        }

        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        public static DelegatingToFactoryMethod fromJson(String jsonValue) {
            return new DelegatingToFactoryMethod(jsonValue);
        }
    }

    /*
    /**********************************************************************
    /* Test methods
    /**********************************************************************
     */

    public void testCustomDeserForDelegating() throws Exception
    {
        DelegatingToFactoryMethod actual = objectMapper().readValue(a2q("'string'"), DelegatingToFactoryMethod.class);
        assertEquals("string", actual.valueField);
    }
}
