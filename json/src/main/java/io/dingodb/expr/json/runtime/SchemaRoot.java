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
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.Serializable;

public final class SchemaRoot implements Serializable {
    private static final long serialVersionUID = -7987188049979019761L;

    @Getter
    private final DataSchema schema;
    @Getter
    private final int maxIndex;

    /**
     * Create an {@link SchemaRoot}. {@link SchemaRoot} is container of {@link DataSchema}.
     * This constructor also calls {@link DataSchema#createIndex}, which will recursively create all index
     * for the children.
     *
     * @param schema the {@link DataSchema}
     */
    public SchemaRoot(@NonNull DataSchema schema) {
        this.schema = schema;
        this.maxIndex = schema.createIndex(0);
    }
}
