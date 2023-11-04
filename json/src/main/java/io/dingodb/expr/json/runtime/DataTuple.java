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

package io.dingodb.expr.json.runtime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public final class DataTuple implements DataSchema {
    private static final long serialVersionUID = -9026108762514887254L;

    @Getter
    private final DataSchema[] children;

    @Override
    public int createIndex(int start) {
        for (DataSchema s : children) {
            start = s.createIndex(start);
        }
        return start;
    }

    @Override
    public int getIndex() {
        return -1;
    }

    @Override
    public <R, T> R accept(@NonNull DataSchemaVisitor<R, T> visitor, T obj) {
        return visitor.visitTuple(this, obj);
    }

    @Override
    public DataSchema getChild(Object index) {
        return children[(int) index];
    }

    @Override
    public @NonNull String toString() {
        return "[" + Arrays.stream(children)
            .map(Objects::toString)
            .collect(Collectors.joining(", ")) + "]";
    }
}
