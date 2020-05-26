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

public class CoinComponent implements Component {
	public static final float WIDTH = 0.5f;
	public static final float HEIGHT = 0.8f;
	public static final int SCORE = 20;
	
	public static final int STATE_NORMAL = 1;
	public static final int STATE_MOVE_TO_BOB = 2;
}
