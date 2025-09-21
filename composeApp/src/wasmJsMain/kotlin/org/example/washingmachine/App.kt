package org.example.washingmachine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import kotlinx.browser.window
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.w3c.dom.events.Event
import washingmachine.composeapp.generated.resources.Res
import washingmachine.composeapp.generated.resources._8e16bda7_68fa_46e1_af03_3f7062500ef0
import washingmachine.composeapp.generated.resources.ha0e_k0jq_220304
import washingmachine.composeapp.generated.resources.`high_angle_man_working_as_plumber_min(1)`
import washingmachine.composeapp.generated.resources.icons8_whatsapp_240
import washingmachine.composeapp.generated.resources.vecteezy_icon_wet_floor_sign_related_to_cleaning_symbol_long_shadow_33126107

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val sectionOffsets = remember { mutableStateMapOf<String, Int>() }
    val windowSize = rememberWindowSizeClass()

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F8F9))
        ) {
            Header(
                windowSize = windowSize,
                onNavigate = { section ->
                    sectionOffsets[section]?.let { y ->
                        coroutineScope.launch { scrollState.animateScrollTo(y) }
                    }
                }
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState)
            ) {
                Spacer(
                    Modifier.height(
                        when (windowSize) {
                            WindowSizeClass.Compact -> 16.dp
                            WindowSizeClass.Medium -> 24.dp
                            WindowSizeClass.Expanded -> 32.dp
                        }
                    )
                )

                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Home"] = coords.positionInParent().y.toInt()
                }) { Home(windowSize) }

                Spacer(Modifier.height(24.dp))
                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Service"] = coords.positionInParent().y.toInt()
                }) { Service(windowSize) }

                Spacer(Modifier.height(32.dp))
                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["About"] = coords.positionInParent().y.toInt()
                }) { About(windowSize) }

                Spacer(Modifier.height(32.dp))
                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Testimonials"] = coords.positionInParent().y.toInt()
                }) { Testimonials(windowSize) }

                Spacer(Modifier.height(32.dp))
                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Footer"] = coords.positionInParent().y.toInt()
                }) { Footer(windowSize) }
            }
        }
    }
}

// -------- Sections --------
@Composable
fun Home(windowSize: WindowSizeClass) {
    val headingSize = when (windowSize) {
        WindowSizeClass.Compact -> 24.sp
        WindowSizeClass.Medium -> 40.sp
        WindowSizeClass.Expanded -> 64.sp
    }
    val subHeadingSize = when (windowSize) {
        WindowSizeClass.Compact -> 14.sp
        WindowSizeClass.Medium -> 20.sp
        WindowSizeClass.Expanded -> 32.sp
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(if (windowSize == WindowSizeClass.Compact) 300.dp else 500.dp)
    ) {
        Image(
            painterResource(Res.drawable.`high_angle_man_working_as_plumber_min(1)`),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Reliable Washing Machine Repair & Service",
                fontSize = headingSize,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Chill Problems, We Fix Fast!",
                fontSize = subHeadingSize,
                color = Color.Yellow
            )
            Text(
                "Doorstep Repair Service for Washing Machines, Refrigerators & RO Water Purifiers.",
                fontSize = subHeadingSize,
                color = Color.Yellow
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "+91 9361731890",
                style = TextStyle(
                    fontSize = subHeadingSize,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.clickable { }
            )
            Spacer(Modifier.height(4.dp))
            Text("Municipal Colony,", color = Color.White, fontSize = subHeadingSize)
            Text("Tanjavur - 613007", color = Color.White, fontSize = subHeadingSize)
        }
    }
}

@Composable
fun Service(windowSize: WindowSizeClass) {
    val arrangement = when (windowSize) {
        WindowSizeClass.Compact -> Arrangement.Top
        else -> Arrangement.spacedBy(16.dp)
    }
    val orientation: @Composable (@Composable () -> Unit) -> Unit =
        if (windowSize == WindowSizeClass.Compact) { content -> Column(content = { content() }) }
        else { content ->
            Row(
                horizontalArrangement = arrangement as Arrangement.Horizontal,
                modifier = Modifier.fillMaxWidth()
            ) { content() }
        }

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Our Services",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2196F3)
        )
        Spacer(Modifier.height(16.dp))

        orientation {
            ServiceCard(
                title = "Washing Machine Services",
                imgRes = Res.drawable._8e16bda7_68fa_46e1_af03_3f7062500ef0,
                details = "Installation • Maintenance • Repairs • Drum Cleaning • Noise Fixes"
            )
            ServiceCard(
                title = "Refrigerator Services",
                imgRes = Res.drawable.ha0e_k0jq_220304,
                details = "Gas Filling • Cooling Issues • Compressor Repairs • Gasket Replacement"
            )
            ServiceCard(
                title = "RO Water Purifier Services",
                imgRes = Res.drawable.vecteezy_icon_wet_floor_sign_related_to_cleaning_symbol_long_shadow_33126107,
                details = "Filter Replacement • UV/UF Membrane • Pump & Motor Repairs"
            )
        }
    }
}

@Composable
fun ServiceCard(title: String, imgRes: Any, details: String) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painterResource(imgRes as DrawableResource),
                contentDescription = "",
                modifier = Modifier.size(120.dp)
            )
            Spacer(Modifier.height(8.dp))
            Text(title, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(details, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun About(windowSize: WindowSizeClass) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "About Us",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF2196F3)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "We specialize in expert maintenance and repair services for washing machines, refrigerators, and RO water purifiers. With a commitment to excellence, we deliver timely, reliable, and customer-focused solutions.",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = when (windowSize) {
                    WindowSizeClass.Compact -> 14.sp
                    else -> 16.sp
                }
            )
        }
    }
}

@Composable
fun Testimonials(windowSize: WindowSizeClass) {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color(0xFF2196F3)).padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "10+ Years • 200+ Clients • 99% Satisfaction",
            color = Color.White,
            fontSize = when (windowSize) {
                WindowSizeClass.Compact -> 14.sp
                WindowSizeClass.Medium -> 18.sp
                WindowSizeClass.Expanded -> 22.sp
            }
        )
    }
}

@Composable
fun Footer(windowSize: WindowSizeClass) {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color(0xFF333333)).padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "© 2025 Vimal Tech Service Business",
            color = Color.White,
            fontSize = when (windowSize) {
                WindowSizeClass.Compact -> 12.sp
                else -> 16.sp
            }
        )
    }
}

@Composable
fun Header(windowSize: WindowSizeClass, onNavigate: (String) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth().height(80.dp).background(Color(0xFF0c2b14))
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Vimal Tech Service",
                color = Color.White,
                style = TextStyle(
                    fontSize = when (windowSize) {
                        WindowSizeClass.Compact -> 18.sp
                        else -> 24.sp
                    }
                )
            )
            if (windowSize != WindowSizeClass.Compact) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    NavItem("Home", onNavigate)
                    NavItem("About", onNavigate)
                    NavItem("Services", onNavigate)
                    Spacer(Modifier.width(16.dp))
                    Image(
                        painterResource(Res.drawable.icons8_whatsapp_240),
                        modifier = Modifier.size(32.dp).clickable {
                            window.open("https://wa.me/9361731890", "_blank")
                        },
                        contentDescription = ""
                    )
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    NavItem("Home", onNavigate)
                    NavItem("About", onNavigate)
                    NavItem("Services", onNavigate)
                    Spacer(Modifier.width(16.dp))
                    Image(
                        painterResource(Res.drawable.icons8_whatsapp_240),
                        modifier = Modifier.size(32.dp).clickable {
                            window.open("https://wa.me/9361731890", "_blank")
                        },
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun NavItem(text: String, onNavigate: (String) -> Unit) {
    Text(
        text,
        color = Color.White,
        modifier = Modifier.padding(horizontal = 8.dp).clickable { onNavigate(text) },
        style = MaterialTheme.typography.bodyLarge
    )
}


enum class WindowSizeClass { Compact, Medium, Expanded }

@Composable
fun rememberWindowSizeClass(): WindowSizeClass {
    var width by remember { mutableStateOf(window.innerWidth) }

    DisposableEffect(Unit) {
        val listener: (Event) -> Unit = {
            width = window.innerWidth
        }
        window.addEventListener("resize", listener)
        onDispose {
            window.removeEventListener("resize", listener)
        }
    }

    return when {
        width < 600 -> WindowSizeClass.Compact   // Mobile
        width < 840 -> WindowSizeClass.Medium    // Tablet
        else -> WindowSizeClass.Expanded         // Desktop
    }
}
