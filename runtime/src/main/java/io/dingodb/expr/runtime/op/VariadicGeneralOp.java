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

import io.dingodb.expr.runtime.ExprCompiler;
import io.dingodb.expr.runtime.ExprConfig;
import io.dingodb.expr.runtime.exception.FailEvaluatingValues;
import io.dingodb.expr.runtime.expr.Expr;
import io.dingodb.expr.runtime.expr.Exprs;
import io.dingodb.expr.runtime.expr.VariadicOpExpr;
import io.dingodb.expr.runtime.type.Type;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class VariadicGeneralOp extends VariadicOp {
    private static final long serialVersionUID = -1023165365948123356L;

    private final VariadicOp op;

    @Override
    public Object keyOf(@NonNull Type @NonNull ... types) {
        return null;
    }

    @Override
    public Object evalValue(Object @NonNull [] values, ExprConfig config) {
        Expr expr = ExprCompiler.SIMPLE.visit(Exprs.op(op, values));
        if (expr instanceof VariadicOpExpr && ((VariadicOpExpr) expr).getOp() instanceof VariadicGeneralOp) {
            throw new FailEvaluatingValues(this, Arrays.stream(values).map(Object::getClass).toArray(Class<?>[]::new));
        }
        return expr.eval(null, config);
    }

    @Override
    public @NonNull String getName() {
        return op.getName();
    }
}
