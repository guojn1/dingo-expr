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

package io.dingodb.expr.runtime.op;

import io.dingodb.expr.runtime.ExprConfig;
import io.dingodb.expr.runtime.compiler.CastingFactory;
import io.dingodb.expr.runtime.expr.Expr;
import io.dingodb.expr.runtime.type.Type;
import io.dingodb.expr.runtime.type.Types;
import org.checkerframework.checker.nullness.qual.NonNull;

public abstract class AbstractOp<E extends Op> implements Op, OpFactory<E> {
    private static final long serialVersionUID = -2046211912438996616L;

    protected AbstractOp() {
    }

    @NonNull
    protected static Expr doCast(@NonNull Expr expr, Type type, @NonNull ExprConfig config) {
        Type fromType = expr.getType();
        if (!fromType.equals(type) && !type.equals(Types.ANY)) {
            UnaryOp op = CastingFactory.get(type, config);
            return op.compile(expr, config);
        }
        return expr;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public @NonNull OpType getOpType() {
        return OpType.FUN;
    }

    @Override
    public @NonNull String getName() {
        return getOpType().name();
    }

    /**
     * Get the key of op.
     *
     * @return null for an {@link OpFactory}, non-null value for a compiled {@link Op}
     */
    public Object getKey() {
        return null;
    }
}
