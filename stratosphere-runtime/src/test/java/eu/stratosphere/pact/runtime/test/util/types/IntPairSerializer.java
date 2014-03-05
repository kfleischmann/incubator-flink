/***********************************************************************************************************************
 * Copyright (C) 2010-2013 by the Stratosphere project (http://stratosphere.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 **********************************************************************************************************************/

package eu.stratosphere.pact.runtime.test.util.types;

import java.io.IOException;

import eu.stratosphere.api.common.typeutils.TypeSerializer;
import eu.stratosphere.core.memory.DataInputView;
import eu.stratosphere.core.memory.DataOutputView;


public class IntPairSerializer extends TypeSerializer<IntPair>
{

	@Override
	public IntPair createInstance()
	{
		return new IntPair();
	}

	@Override
	public IntPair copy(IntPair from, IntPair reuse)
	{
		reuse.setKey(from.getKey());
		reuse.setValue(from.getValue());
		return reuse;
	}
	

	@Override
	public int getLength()
	{
		return 8;
	}

	@Override
	public void serialize(IntPair record, DataOutputView target) throws IOException
	{
		target.writeInt(record.getKey());
		target.writeInt(record.getValue());
	}

	@Override
	public IntPair deserialize(IntPair reuse, DataInputView source) throws IOException {
		reuse.setKey(source.readInt());
		reuse.setValue(source.readInt());
		return reuse;
	}

	@Override
	public void copy(DataInputView source, DataOutputView target) throws IOException
	{
		for (int i = 0; i < 8; i++) {
			target.writeByte(source.readUnsignedByte());
		}
	}
}
