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

package io.dingodb.expr.runtime.op.arithmetic;

import io.dingodb.expr.annotations.Operators;
import io.dingodb.expr.runtime.op.OpType;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.math.BigDecimal;

@Operators
abstract class MulOp extends ArithmeticOp {
    private static final long serialVersionUID = 4677892788590745542L;

    static int mul(int value0, int value1) {
        return value0 * value1;
    }

    static long mul(long value0, long value1) {
        return value0 * value1;
    }

    static float mul(float value0, float value1) {
        return value0 * value1;
    }

    static double mul(double value0, double value1) {
        return value0 * value1;
    }

    static @NonNull BigDecimal mul(@NonNull BigDecimal value0, @NonNull BigDecimal value1) {
        return value0.multiply(value1);
    }

    @Override
    public final @NonNull OpType getOpType() {
        return OpType.MUL;
    }
}
