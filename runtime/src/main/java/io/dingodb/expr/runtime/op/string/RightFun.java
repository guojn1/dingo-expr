/*
 * Copyright 2021 DataCanvas
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

package io.dingodb.expr.runtime.op.string;

import io.dingodb.expr.annotations.Operators;
import org.checkerframework.checker.nullness.qual.NonNull;

@Operators(nullable = true)
abstract class RightFun extends BinaryStringIntFun {
    public static final String NAME = "RIGHT";

    private static final long serialVersionUID = 786880304255979673L;

    static String right(String value, Integer count) {
        if (count != null) {
            if (value != null && count > 0) {
                return count < value.length() ? value.substring(value.length() - count) : value;
            }
            return "";
        }
        return null;
    }

    @Override
    public @NonNull String getName() {
        return NAME;
    }
}
