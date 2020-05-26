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

package com.siondream.superjumper.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Rectangle;
import com.siondream.superjumper.Testing;
import com.siondream.superjumper.components.BobComponent;
import com.siondream.superjumper.components.CoinComponent;
import com.siondream.superjumper.components.StateComponent;
import com.siondream.superjumper.components.TransformComponent;

public class CoinSystem extends IteratingSystem {

    private static final Family family = Family.all(CoinComponent.class,
            TransformComponent.class,
            StateComponent.class).get();

    private ComponentMapper<TransformComponent> tm;
    private ComponentMapper<StateComponent> sm;

    public CoinSystem() {
        super(family);

        tm = ComponentMapper.getFor(TransformComponent.class);
        sm = ComponentMapper.getFor(StateComponent.class);
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {

    }

    public void moveToBob (Entity entity, Rectangle bob) {
        if (!family.matches(entity)) return;
        TransformComponent tran = tm.get(entity);
        StateComponent state = sm.get(entity);

        if(state.get() != CoinComponent.STATE_MOVE_TO_BOB){
            state.set(CoinComponent.STATE_MOVE_TO_BOB);
        }

        float tempX, tempY;
        tempX = tran.pos.x;
        tempY = tran.pos.y;

        tran.pos.x += Testing.gatherCoinSpeedAugment * (bob.x > tempX ? 1 : -1);
        tran.pos.y += Testing.gatherCoinSpeedAugment * (bob.y > tempY ? 1 : -1);
    }
}
