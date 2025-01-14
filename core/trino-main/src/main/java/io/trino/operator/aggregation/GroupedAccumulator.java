/*
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
package io.trino.operator.aggregation;

import io.trino.operator.GroupByIdBlock;
import io.trino.spi.Page;
import io.trino.spi.block.Block;
import io.trino.spi.block.BlockBuilder;

public interface GroupedAccumulator
{
    long getEstimatedSize();

    void setGroupCount(long groupCount);

    void addInput(GroupByIdBlock groupIdsBlock, Page page, AggregationMask mask);

    void addIntermediate(GroupByIdBlock groupIdsBlock, Block block);

    void evaluateIntermediate(int groupId, BlockBuilder output);

    void evaluateFinal(int groupId, BlockBuilder output);

    void prepareFinal();
}
