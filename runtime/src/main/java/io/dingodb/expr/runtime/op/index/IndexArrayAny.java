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

package io.dingodb.expr.runtime.op.index;

import io.dingodb.expr.runtime.ExprConfig;
import io.dingodb.expr.runtime.type.Type;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.reflect.Array;

public final class IndexArrayAny extends IndexOp {
    private static final long serialVersionUID = 368593503014605079L;

    IndexArrayAny(Type type) {
        super(type);
    }

    @Override
    protected Object evalNonNullValue(@NonNull Object value0, @NonNull Object value1, ExprConfig config) {
        return Array.get(value0, (int) value1);
    }
}
