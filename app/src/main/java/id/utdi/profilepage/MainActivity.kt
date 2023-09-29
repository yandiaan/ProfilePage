package id.utdi.profilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.utdi.profilepage.ui.theme.ProfilePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Kolom dibawah digunakan untuk menata letak component Profilehead, dan beberapa profile menu
                    Column {
                        ProfileHead() // Memanggil Component ProfileHead
                        // ProfileMenu dipanggil berulang karena saya menggunakan parameter yang berbeda setiap memanggil componentnya
                        ProfileMenu("Account", Icons.Outlined.Person)
                        ProfileMenu("Security", Icons.Outlined.Lock)
                        ProfileMenu("Contact", Icons.Outlined.Phone)
                        ProfileMenu("Email", Icons.Outlined.MailOutline)
                        ProfileMenu("Log Out", Icons.Default.ExitToApp)
                    }
                }
            }
        }
    }
}


// Component ProfileHead yang berisi title profile, image profile, nama user, dan button edit profile
@Composable
fun ProfileHead() {
    // Column dibawah digunakan untuk menata letak kolom component text, image, text lagi, dan button
    Column(
        modifier = Modifier
            .fillMaxWidth() // membuat column mempunyai lebar yang penuh/max
            .padding(0.dp, 25.dp), // memberikan padding horizontal 0dp dan vertical 25dp
        horizontalAlignment = Alignment.CenterHorizontally // membuat seluruh component yang ada di column menjadi ke tengah secara horizontal
    ) {
        // Text dibawah merupakan title dari screen/page yaitu Profile
        Text(
            text = "Profile",
            fontWeight = FontWeight.SemiBold, // memberikan ketebalan font semibold
            fontSize = 20.sp // ukuran dari font menjadi 20sp
        )
        // Spacer dibawah memberikan jarak sebesar 64 dp antara title dan profile image
        Spacer(modifier = Modifier.height(64.dp))
        Image(
            painter = painterResource(R.drawable.dian), // Ganti dengan ID gambar sesuai kebutuhan
            contentDescription = null, // contentDescription saya kosongkan karena belum digunakan
            modifier = Modifier
                .size(128.dp) // mengubah ukuran dari profile image
                .clip(CircleShape) // membuat bentuk dari profile image menjadi lingkaran
                .border(BorderStroke(2.dp, Color.Black), CircleShape), // memberikan border hitam berbentuk lingkaran ke gambar
        )

        // Memberikan jarak vertikal antara gambar dan nama
        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = "Dian Setiawan",
            fontWeight = FontWeight.Bold, // ketebalan font bold
            fontSize = 24.sp, // ukuran font 24 sp
            color = Color(0xFF03055E) // warna font biru tua menggunakan hexacode yang ditandai dengan awalan (0x)
        )

        // Button Edit Profile
        Button(
            onClick = {},
        ) {
            Text(text = "Edit Profile")
        }
    }

}


// Component profileMenu menerima parameter title dan icon agar text dan icon dari component dapat disesuaikan dan digunakan berulang
@Composable
fun ProfileMenu(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // memberikan lebar full ke row dari profile menu
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically, // membuat seluruh component yang ada di row ini menjadi tengah secara vertical
    ) {
        // Icon with background
        Icon(
            imageVector = icon, // variable icon didapat dari parameter
            contentDescription = null,
            tint = Color.White, // mengubah warna icon jadi putih
            modifier = Modifier
                .size(36.dp) // ukuran font 36 dp
                .background(MaterialTheme.colorScheme.secondary, CircleShape) // membuat warna background font menjadi abu abu atau secondary
                .padding(8.dp) // memberikan padding atau jarak antara content dan border sebesar 8.dp
        )

        // memberikan jarak antara icon dan teks sebesar 16.dp
        Spacer(modifier = Modifier.width(16.dp))

        // Menu Item Text
        Text(
            title, // variable title didapat dari parameter
            fontWeight = FontWeight.Bold, // ketebalan font bold
            fontSize = 14.sp // ukuran font sebesar 14sp
            )

        Spacer(modifier = Modifier.weight(1f)) // jarak 1f berarti dia akan fleksible sesuai dengan jarak yang tersedia
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowRight, // icon panah ke kanan
            contentDescription = null,
            tint = Color.Black, // warna icon hitam
            modifier = Modifier.size(24.dp) //ukuran icon 24dp
        )
    }
}


// dibawah merupakan cara menampilkan component dengan preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfilePageTheme {
        // Kolom dibawah digunakan untuk menata letak component Profilehead, dan beberapa profile menu
        Column {
            ProfileHead() // Memanggil Component ProfileHead
            // ProfileMenu dipanggil berulang karena saya menggunakan parameter yang berbeda setiap memanggil componentnya
            ProfileMenu("Account", Icons.Outlined.Person)
            ProfileMenu("Security", Icons.Outlined.Lock)
            ProfileMenu("Contact", Icons.Outlined.Phone)
            ProfileMenu("Email", Icons.Outlined.MailOutline)
            ProfileMenu("Log Out", Icons.Default.ExitToApp)
        }

    }
}