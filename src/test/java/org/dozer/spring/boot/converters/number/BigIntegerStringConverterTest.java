/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dozer.spring.boot.converters.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for {{ @link BigIntegerStringConverter }}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@DisplayName("BigIntegerStringConverter Tests")
class BigIntegerStringConverterTest {

    @Test
    @DisplayName("Instance can be created via constructor")
    void testInstantiation() {
        BigIntegerStringConverter instance = new BigIntegerStringConverter();
        assertThat(instance).isNotNull();
    }
    @Test
    void convertsBetweenBigIntegerAndString() {
        BigIntegerStringConverter converter = new BigIntegerStringConverter();
        java.math.BigInteger value = new java.math.BigInteger("12345678901234567890");
        assertThat(converter.convert(null, "12345678901234567890", java.math.BigInteger.class, String.class)).isEqualTo(value);
        assertThat(converter.convert(null, value, String.class, java.math.BigInteger.class)).isEqualTo("12345678901234567890");
        assertThat(converter.convert(null, null, java.math.BigInteger.class, String.class)).isNull();
        org.assertj.core.api.Assertions.assertThatThrownBy(() ->
                converter.convert(null, 1, java.math.BigInteger.class, Integer.class))
                .isInstanceOf(org.dozer.MappingException.class);
    }

}
