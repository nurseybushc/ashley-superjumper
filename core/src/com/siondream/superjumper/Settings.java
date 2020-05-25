/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
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

package com.siondream.superjumper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Settings {
	public static boolean soundEnabled = true;
	public final static int[] highscores = new int[] {100, 80, 50, 30, 10};
	public final static String file = ".superjumper";

	public static final String PREFERENCES_NAME = "preferences";
	private static final String MAX_SCORE_PREFERENCE = "max_score";
	private static final String MAX_SCORE_DATE_PREFERENCE = "max_score_date";
	private static final String SOUND_ENABLED_PREFERENCE = "sound_enabled";
	private static final String MAX_LEVEL_PREFERENCE = "max_level";
	private static final String CURRENT_LEVEL_PREFERENCE = "current_level";
	private static final String CURRENT_SCORE_PREFERENCE = "current_score";

	private static Preferences getPreferences() {
		return Gdx.app.getPreferences(PREFERENCES_NAME);
	}

	public static void saveMaxScore(int score) {
		Preferences preferences = getPreferences();
		int maxScore = preferences.getInteger(MAX_SCORE_PREFERENCE, 0);
		if (score > maxScore) {
			preferences.putInteger(MAX_SCORE_PREFERENCE, score);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
			String dateString = format.format(new Date());
			saveMaxScoreDate(dateString);

			preferences.flush();
		}
	}

	public static int getMaxScore() {
		return getPreferences().getInteger(MAX_SCORE_PREFERENCE, 0);
	}

	public static int getCurrentLevel() {
		return getPreferences().getInteger(CURRENT_LEVEL_PREFERENCE, 1);
	}

	public static void saveCurrentLevel(int level) {
		Preferences preferences = getPreferences();
		preferences.putInteger(CURRENT_LEVEL_PREFERENCE, level);
		preferences.flush();
	}

	public static int getCurrentScore() {
		return getPreferences().getInteger(CURRENT_SCORE_PREFERENCE, 0);
	}

	public static void saveCurrentScore(int score) {
		Preferences preferences = getPreferences();
		preferences.putInteger(CURRENT_SCORE_PREFERENCE, score);
		preferences.flush();
	}

	public static void saveMaxLevel(int level) {
		Preferences preferences = getPreferences();
		int maxLevel = preferences.getInteger(MAX_LEVEL_PREFERENCE, 1);
		if (level > maxLevel) {
			preferences.putInteger(MAX_LEVEL_PREFERENCE, level);
			preferences.flush();
		}
	}

	public static int getMaxLevel() {
		return getPreferences().getInteger(MAX_LEVEL_PREFERENCE, 1);
	}

	public static boolean getSoundEnabled() {
		return getPreferences().getBoolean(SOUND_ENABLED_PREFERENCE, true);
	}

	public static void toggleSoundEnabled() {
		Preferences preferences = getPreferences();
		boolean enabled = preferences.getBoolean(SOUND_ENABLED_PREFERENCE, true);

		preferences.putBoolean(SOUND_ENABLED_PREFERENCE, !enabled);
		preferences.flush();
	}

	public static void saveMaxScoreDate(String date) {
		Preferences preferences = getPreferences();
		preferences.putString(MAX_SCORE_DATE_PREFERENCE, date);
		preferences.flush();
	}

	public static String getMaxScoreDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		String dateString = format.format( new Date()   );
		return getPreferences().getString(MAX_SCORE_DATE_PREFERENCE, dateString);
	}
}
