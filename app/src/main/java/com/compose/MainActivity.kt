package com.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.compose.features.main.screens.MainScreen
import com.compose.features.onboarding.navigation.NavigationOnBoarding
import com.compose.features.onboarding.screens.FirstNameScreen
import com.compose.ui.theme.BottomNavigationTheme
import com.compose.utils.Constants
import com.compose.utils.PrefsManager
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val prefManager: PrefsManager by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            BottomNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    setContent {
                        if (prefManager.keyExistsInPreferences(Constants.ONBOARDING_COMPLETED)) {
                            when (prefManager.getBooleanFromPreferences(Constants.ONBOARDING_COMPLETED)) {
                                true -> MainScreen(navController = navController)
                                false -> {
                                    FirstNameScreen(navigateToLastName = {
                                        navController.navigate("lastName")
                                    })
                                    NavigationOnBoarding(navController = navController)
                                }
                            }
                        } else {
                            FirstNameScreen(navigateToLastName = {
                                navController.navigate("lastName")
                            })
                            NavigationOnBoarding(navController = navController)
                        }
                    }

                }
            }
        }
    }
}



