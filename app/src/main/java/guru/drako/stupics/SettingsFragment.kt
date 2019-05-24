package guru.drako.stupics

import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import javax.inject.Inject

class SettingsFragment : PreferenceFragmentCompat() {
    private fun <T : Preference> findPreference(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return super.findPreference(key) as T
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }
}
