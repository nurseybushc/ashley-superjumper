/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.siondream.superjumper.components;

import com.badlogic.ashley.core.Component;
import com.siondream.superjumper.Testing;

public class SquirrelComponent implements Component {
	public static final float WIDTH = 1;
	public static final float HEIGHT = 0.6f;
	public static final float VELOCITY = 3f * Testing.speedAugment;
	public static final int TYPE_STATIC = 0;
	public static final int TYPE_MOVING = 1;
	
	public static final int STATE_NORMAL = 0;

	public int type = TYPE_STATIC;
}
