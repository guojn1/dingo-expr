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

package io.dingodb.expr.runtime.op.time;

import io.dingodb.expr.runtime.ExprConfig;
import io.dingodb.expr.runtime.expr.Expr;
import io.dingodb.expr.runtime.expr.Exprs;
import io.dingodb.expr.runtime.op.BinaryOp;
import org.checkerframework.checker.nullness.qual.NonNull;

abstract class BinaryFormatFun extends BinaryOp {
    private static final long serialVersionUID = 1510248248729287723L;

    @Override
    public @NonNull Expr compile(@NonNull Expr operand0, @NonNull Expr operand1, @NonNull ExprConfig config) {
        if (config.getTimeFormatStringStyle() == ExprConfig.TimeFormatStringStyle.SQL) {
            operand1 = Exprs._CTF.compile(operand1, config).simplify();
        }
        return super.compile(operand0, operand1, config);
    }
}
