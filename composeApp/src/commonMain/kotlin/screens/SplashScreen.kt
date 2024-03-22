package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kopikap.composeapp.generated.resources.Res
import kopikap.composeapp.generated.resources.compose_multiplatform
import kopikap.composeapp.generated.resources.splash_icon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreenUI() {
    val navigator = LocalNavigator.currentOrThrow
    val scope = rememberCoroutineScope()
    Box(Modifier.fillMaxSize().background(Color(0xFF1BAE76))) {

        Image(painterResource(Res.drawable.splash_icon), null,
            modifier = Modifier.size(300.dp).align(Alignment.Center)
            )

        scope.launch {
            delay(3000)
            withContext(Dispatchers.Main){
                navigator.push(GetStartedScreenNav())
            }
        }
    }
}

class GetStartedScreenNav : Screen {
    @Composable
    override fun Content() {
        GetStartedScreenUI()
    }
}