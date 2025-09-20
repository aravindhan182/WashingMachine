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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import washingmachine.composeapp.generated.resources.Res
import washingmachine.composeapp.generated.resources._8e16bda7_68fa_46e1_af03_3f7062500ef0
import washingmachine.composeapp.generated.resources.ha0e_k0jq_220304
import washingmachine.composeapp.generated.resources.high_angle_man_working_as_plumber
import washingmachine.composeapp.generated.resources.icons8_whatsapp_240
import washingmachine.composeapp.generated.resources.vecteezy_icon_wet_floor_sign_related_to_cleaning_symbol_long_shadow_33126107


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    val sectionOffsets = remember { mutableStateMapOf<String, Int>() }

    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF7F8F9))
        ) {

            Header(
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
                Spacer(Modifier.height(24.dp))

                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Home"] = coords.positionInParent().y.toInt()
                }) { Home() }
                Spacer(Modifier.height(24.dp))
                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Service"] = coords.positionInParent().y.toInt()
                }) { Service() }

                Spacer(Modifier.height(32.dp))

                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["About"] = coords.positionInParent().y.toInt()
                }) { About() }

                Spacer(Modifier.height(32.dp))

                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Testimonials"] = coords.positionInParent().y.toInt()
                }) { Testimonials() }

                Spacer(Modifier.height(32.dp))

                Box(Modifier.onGloballyPositioned { coords ->
                    sectionOffsets["Footer"] = coords.positionInParent().y.toInt()
                }) { Footer() }
            }
        }
    }
}

@Composable
fun Testimonials() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2196F3)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "10+ Years Experience • 200+ Clients Served • 99% Satisfaction",
            color = Color.White
        )
    }
}

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF333333))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("© 2025 Vimal Tech Service Business", color = Color.White)
    }
}

@Composable
fun Home() {
    Column(
        modifier = Modifier.height(500.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painterResource(Res.drawable.high_angle_man_working_as_plumber),
                contentDescription = "",
                modifier = Modifier.height(500.dp).fillMaxWidth(), contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    "Reliable Washing Machine Repair & Service",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 64.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    "Chill Problems, We Fix Fast!",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 32.sp,
                    color = Color.Yellow
                )
                Text(
                    "Doorstep Repair Service for All Brands of Washing Machines, Refrigerators, and RO Water Purifiers.",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 32.sp,
                    color = Color.Yellow
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "+91 9361731890",
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Serif
                    ),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                    }.padding(start = 16.dp)
                )
                Spacer(Modifier.padding(8.dp))
                Text(
                    "Municipal Colony,",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color.White,
                    fontSize = 24.sp
                )
                Text(
                    "Tanjavur - 613007",
                    modifier = Modifier.padding(start = 16.dp),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun Service() {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Our Services",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2196F3)
        )
        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp).fillMaxSize()
                ) {
                    Image(
                        painterResource(Res.drawable._8e16bda7_68fa_46e1_af03_3f7062500ef0),
                        modifier = Modifier.size(200.dp),
                        contentDescription = ""
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Washing Machine Services",
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Installation & Setup \n" +
                                "Regular Maintenance\n" +
                                "General Servicing\n" +
                                "Drum Cleaning & Descaling\n" +
                                "Leak & Noise Fixes\n" +
                                "Motor, Belt & Pump Repairs\n" +
                                "Door Lock & Sensor Issues\n",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp).fillMaxSize()
                ) {
                    Image(
                        painterResource(Res.drawable.ha0e_k0jq_220304),
                        modifier = Modifier.size(200.dp),
                        contentDescription = ""
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Refrigerator Services",
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Installation & Gas filling \n" +
                                "Cooling and Temperature Issue\n" +
                                "Regular Maintenance and Servicing\n" +
                                "Compressor & Thermostat Repairs\n" +
                                "Door Seal & Gasket Replacement\n" +
                                "Ice Maker & Water Dispenser Repairs\n" +
                                "Noise & Power Fluctuation Solutions\n",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp).fillMaxSize()
                ) {
                    Image(
                        painterResource(Res.drawable.vecteezy_icon_wet_floor_sign_related_to_cleaning_symbol_long_shadow_33126107),
                        modifier = Modifier.size(200.dp),
                        contentDescription = ""
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "RO Water Purifier Services",
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Installation & Uninstallation \n" +
                                "Regular Servicing & Maintenance\n" +
                                "Filter & Cartridge Replacement\n" +
                                "UV/UF Membrane Replacement\n" +
                                "Water Leakage Fixes\n" +
                                "Pump & Motor Repairs \n" +
                                "Water Taste & Purity Issues\n",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }

        }
    }
}


@Composable
fun Header(onNavigate: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0xFF0c2b14))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Vimal Tech Service",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Home",
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { onNavigate("Home") },
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    "About",
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { onNavigate("About") },
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    "Services",
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { onNavigate("Service") },
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(Modifier.width(16.dp))

                Image(
                    painterResource(Res.drawable.icons8_whatsapp_240),
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            val waWebUrl = "https://wa.me/9361731890"
                            window.open(waWebUrl, "_blank")
                        },
                    contentDescription = ""
                )
            }
        }
    }
}

@Composable
fun About() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                "About Us",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF2196F3)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "We specialize in expert maintenance and repair services for washing machines, refrigerators, and RO water purifiers. With a commitment to excellence, we deliver timely, reliable, and customer-focused solutions to ensure the long-lasting performance of your appliances",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
