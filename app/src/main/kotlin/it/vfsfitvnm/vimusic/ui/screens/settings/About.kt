package it.vfsfitvnm.vimusic.ui.screens.settings

import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import it.vfsfitvnm.vimusic.BuildConfig
import it.vfsfitvnm.vimusic.LocalPlayerAwareWindowInsets
import it.vfsfitvnm.vimusic.ui.components.themed.Header
import it.vfsfitvnm.vimusic.ui.styling.LocalAppearance
import it.vfsfitvnm.vimusic.utils.secondary
import kotlinx.coroutines.FlowPreview

@ExperimentalAnimationApi
@Composable
fun About() {
    val (colorPalette, typography) = LocalAppearance.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .background(colorPalette.background0)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                LocalPlayerAwareWindowInsets.current
                    .only(WindowInsetsSides.Vertical + WindowInsetsSides.End)
                    .asPaddingValues()
            )
    ) {
        Header(title = "About") {
            BasicText(
                text = "v${BuildConfig.VERSION_NAME} by Sidharth Prabhu",
                style = typography.s.secondary
            )
        }

        SettingsEntryGroupText(title = "Application Info")

        SettingsEntry(
            title = "ScradleX",
            text = "ScradleX is a brand new flavour of the Scradle Project. This is an online Music Player which is a respin of ViMusic App. The app uses YouTube API to play the music.",
            onClick = {
                uriHandler.openUri("https://scradlex.netlify.app/")
            }
        )

        SettingsEntry(
            title = "Launched by",
            text = "M E D U S A  Infosystems India",
            onClick = {
                uriHandler.openUri("https://play.google.com/store/apps/dev?id=8331228622407376932")
            }
        )
        SettingsEntry(
            title = "Distributed by",
            text = "Frissco Creative Labs",
            onClick = {
                uriHandler.openUri("https://frisscocreativelab.wixsite.com/frissco-group")
            }
        )

        SettingsGroupSpacer()

        SettingsEntryGroupText(title = "TROUBLESHOOTING")

        SettingsEntry(
            title = "Report an issue or bug",
            text = "You will be redirected to Gmail",
            onClick = {
                uriHandler.openUri("mailto:medusainfosystems@gmail.com")
            }
        )

        SettingsEntry(
            title = "Request a feature or suggest an idea",
            text = "You will be redirected to Gmail",
            onClick = {
                uriHandler.openUri("mailto:medusainfosystems@gmail.com")
            }
        )

        SettingsGroupSpacer()

        SettingsEntry(title = "View Source code", text = "Click here to view the official GitHub repository of ScradleX",
            onClick = {
                uriHandler.openUri("https://github.com/Cyber-Zypher/ScradleX-Android")
            }) {

        }

        SettingsGroupSpacer()

        SettingsEntryGroupText(title = "Unspinned Release Info")

        SettingsEntry(
            title = "ViMusic",
            text = "View the Unforked Source code",
            onClick = {
                uriHandler.openUri("https://github.com/vfsfitvnm/ViMusic")
            }
        )
    }
}
