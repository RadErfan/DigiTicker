package ir.erfanrad.coin.presentation.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import ir.erfanrad.coin.R
import ir.erfanrad.coin.presentation.ViewModel.CryptoViewModel


@Composable
fun CryptoPriceScreen(
    modifier: Modifier = Modifier,
    viewModel: CryptoViewModel = hiltViewModel()
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()

        InfoMain(
            title = "Ethereum",
            price = "293.018",
            onButtonClicked = {},
            onTextBtnSavedClcicked = {} ,
            onTextBtnWatchListClcicked = {},
            isRising = false ,
            nameCoin = "Bitcoin" , nikNameCoin = "BTC"  )

    }
}

@Composable
fun InfoMain(
    onTextBtnSavedClcicked: () -> Unit,
    onTextBtnWatchListClcicked: () -> Unit,
    title: String,
    url: String? = null,
    price: String,
    onButtonClicked: () -> Unit ,
    nameCoin:String ,
    nikNameCoin: String,
    isRising: Boolean
) {

    LazyColumn(modifier = Modifier.fillMaxWidth() . padding(bottom = 15.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center) {
        item{

            Text(text = title, fontSize = 29.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp)) // یه فاصله برای زیبایی
            val imageModifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
            if (url != null) {
                AsyncImage(
                    model = url,
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.img_signup),
                    contentDescription = "Default Profile",
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            }
            Spacer(modifier = Modifier.height(26.dp)) // یه فاصله برای زیبایی

            Text(text = price, fontSize = 60.sp, fontWeight = FontWeight.Bold)


            Card(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .size(220.dp, 40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(
                        id =
                        R.color.Abi
                    )
                )
            ) {


            }


            Button(
                onClick = onButtonClicked, modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(0.9f)
                    .height(60.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.diagram), // اینجا اسم عکس رو بذار
                        contentDescription = "Button Icon",
                        modifier = Modifier.size(24.dp) // اندازه دلخواه آیکن
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // اگه خواستی بین آیکن و متن فاصله بدی
                    Text(text = "View Stock", fontSize = 22.sp)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bar_chart),
                        contentDescription = "Button Icon",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    TextButton(onClick = onTextBtnWatchListClcicked) {
                        Text(
                            text = "Watchlist",
                            fontSize = 22.sp
                        )
                    }

                }
                Spacer(modifier = Modifier.width(8.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heart),
                        contentDescription = "Button Icon",
                        modifier = Modifier.size(24.dp),
                        colorFilter = ColorFilter.tint(color = Color.White)

                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    TextButton(onClick = onTextBtnSavedClcicked) {
                        Text(text = "Saved", fontSize = 22.sp, color = Color.White)
                    }
                }

            }

            val coins = listOf(
                Triple("Bitcoin", "BTC", true),
                Triple("Ethereum", "ETH", false),
                Triple("Tether", "USDT", true),
                Triple("Solana", "SOL", false),
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp , start = 10.dp , end = 10.dp)
            ) {
                items(coins) { coin ->
                    CardCoin(
                        nameCoin = coin.first,
                        nikNameCoin = coin.second,
                        price = price,
                        isRising = coin.third,
                        modifier = Modifier
                            .fillParentMaxWidth(0.68f) // فقط یه کارت دیده بشه، بقیه با اسکرول بیان
                    )
                }
            }





        }
    }



}

@Composable
fun CardCoin(nameCoin: String, nikNameCoin: String, url: String? = null, price: String, isRising: Boolean ,
             modifier: Modifier = Modifier // 👈 اضافه کن
) {
    val curveColor = if (isRising) Brush.horizontalGradient(
        listOf(Color(0xFF2196F3), Color(0xFF0D47A1))
    ) else Brush.horizontalGradient(
        listOf(Color(0xFFFF5252), Color(0xFFD32F2F))
    )

    Card(
        modifier = modifier
            .height(320.dp), // ارتفاع ثابت، ولی عرض از modifier بیرونی میاد
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1E)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp), // فضایی برای نوار خمیده پایین
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.padding(top = 17.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = nameCoin,
                            fontSize = 29.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(text = nikNameCoin, color = Color.White)
                    }

                    val imageModifier = Modifier
                        .padding(end = 19.dp)
                        .size(45.dp)
                        .clip(CircleShape)
                        .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)

                    if (url != null) {
                        AsyncImage(
                            model = url,
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                        )
                    } else {
                        Image(
                            painter = painterResource(R.drawable.img_signup),
                            contentDescription = "Default Profile",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                        )
                    }
                }


                    Text(
                        text = price,
                        modifier = Modifier.fillMaxWidth()
                            .padding(start = 10.dp),
                        textAlign = TextAlign.Left,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )


                Spacer(modifier = Modifier.height(12.dp))

                MiniChartLine(isRising = isRising)

                ChangeRow(teagirat = "1,250.67", percent = 2.41f) // صعودی
                ChangeRow(teagirat = "−983.23", percent = -3.12f) // نزولی

            }

            // 🎨 نوار گرادینت خمیده پایین
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(70.dp)) {

                val width = size.width
                val height = size.height

                val path = Path().apply {
                    moveTo(0f, 0f)
                    quadraticBezierTo(
                        width / 2, height * 1.5f,  // خم مرکزی
                        width, 0f
                    )
                    lineTo(width, height)
                    lineTo(0f, height)
                    close()
                }

                drawPath(
                    path = path,
                    brush = curveColor
                )
            }
        }
    }
}



@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    profileImageUrl: String? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // بخش پروفایل و نام
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val imageModifier = Modifier
                .size(35.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)

            if (profileImageUrl != null) {
                AsyncImage(
                    model = profileImageUrl,
                    contentDescription = "Profile Image",
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            } else {
                Image(
                    painter = painterResource(R.drawable.img_signup),
                    contentDescription = "Default Profile",
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            }

            Text(
                text = "ErfanRad",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }

        // بخش آیکون‌ها
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* عملیات جستجو */ },
                modifier = Modifier.size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }

            Box {
                IconButton(
                    onClick = { /* عملیات نوتیفیکیشن */ },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }

                // نقطه قرمز نوتیفیکیشن
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Color.Red, shape = CircleShape)
                        .align(Alignment.TopEnd)
                        .offset(x = 2.dp, y = (-2).dp)
                )
            }
        }
    }
}


@Composable
fun MiniChartLine(isRising: Boolean) {
    val lineColor = if (isRising) Color(0xFF4FC3F7) else Color(0xFFFF5252) // آبی یا قرمز

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 16.dp)
    ) {
        val path = Path()
        val height = size.height
        val width = size.width

        // دیتا تستی برای ساخت نمودار (قابل تغییر با API)
        val points = if (isRising) listOf(0.2f, 0.3f, 0.25f, 0.4f, 0.5f, 0.45f, 0.6f) else
            listOf(0.6f, 0.5f, 0.55f, 0.4f, 0.3f, 0.35f, 0.2f)

        val step = width / (points.size - 1)

        path.moveTo(0f, height * (1 - points[0]))
        points.forEachIndexed { index, point ->
            path.lineTo(index * step, height * (1 - point))
        }

        drawPath(
            path = path,
            color = lineColor,
            style = Stroke(width = 4f, cap = StrokeCap.Round)
        )
    }
}

@Composable
fun ChangeRow(teagirat: String, percent: Float) {
    val isRising = percent >= 0

    val arrowIcon = if (isRising) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown
    val color = if (isRising) Color(0xFF00C853) else Color(0xFFD50000)
    val sign = if (isRising) "+" else ""

    Row(
        modifier = Modifier.padding(top = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            imageVector = arrowIcon,
            contentDescription = if (isRising) "Up" else "Down",
            tint = color,
            modifier = Modifier.size(20.dp)
        )

        Text(
            text = teagirat,
            color = color,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 4.dp, end = 4.dp)
        )

        Text(
            text = "($sign${percent}%)",
            color = color,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Today",
            color = Color.Gray,
            fontSize = 13.sp
        )
    }
}

