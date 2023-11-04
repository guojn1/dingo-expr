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

package io.dingodb.expr.runtime.op.mathematical;

import io.dingodb.expr.annotations.Operators;
import io.dingodb.expr.runtime.op.BinaryNumericOp;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Operators
abstract class MaxFun extends BinaryNumericOp {
    public static final String NAME = "MAX";

    private static final long serialVersionUID = 4474991409650817406L;

    static int max(int value0, int value1) {
        return Math.max(value0, value1);
    }

    static long max(long value0, long value1) {
        return Math.max(value0, value1);
    }

    static float max(float value0, float value1) {
        return Math.max(value0, value1);
    }

    static double max(double value0, double value1) {
        return Math.max(value0, value1);
    }

    static boolean max(boolean value0, boolean value1) {
        return value0 || value1;
    }

    static @NonNull BigDecimal max(@NonNull BigDecimal value0, @NonNull BigDecimal value1) {
        return value0.compareTo(value1) >= 0 ? value0 : value1;
    }

    static @NonNull String max(@NonNull String value0, @NonNull String value1) {
        return value0.compareTo(value1) >= 0 ? value0 : value1;
    }

    static @NonNull Date max(@NonNull Date value0, @NonNull Date value1) {
        return value0.compareTo(value1) >= 0 ? value0 : value1;
    }

    static @NonNull Time max(@NonNull Time value0, @NonNull Time value1) {
        return value0.compareTo(value1) >= 0 ? value0 : value1;
    }

    static @NonNull Timestamp max(@NonNull Timestamp value0, @NonNull Timestamp value1) {
        return value0.compareTo(value1) >= 0 ? value0 : value1;
    }

    @Override
    public final @NonNull String getName() {
        return NAME;
    }
}
