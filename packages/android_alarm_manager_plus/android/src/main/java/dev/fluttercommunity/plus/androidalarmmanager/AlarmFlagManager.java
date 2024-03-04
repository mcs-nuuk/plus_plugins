package dev.fluttercommunity.plus.androidalarmmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class AlarmFlagManager {

    private static final String FLUTTER_SHARED_PREFERENCE_KEY = "FlutterSharedPreferences";
    private static final String ALARM_FLAG_KEY = "flutter.alarmFlagKey";

    static public void set(Context context, Intent intent) {
        int callbackId = intent.getIntExtra("id", -1);
        long alarmId = getActualIdFrom(callbackId);

        SharedPreferences prefs = context.getSharedPreferences(FLUTTER_SHARED_PREFERENCE_KEY, 0);
        prefs.edit().putLong(ALARM_FLAG_KEY, alarmId).apply();
    }

    /** * Returns the converted ID of the alarm object.
     * Returns the ID converted to the ID of the alarm object.
     *.
     * In the case of `Timer`, the ID is 0, so the return value is also 0, so there is no problem.
     */
    static private long getActualIdFrom(long callbackId) {
        return (long) Math.floor(callbackId / 7.0);
    }

}
