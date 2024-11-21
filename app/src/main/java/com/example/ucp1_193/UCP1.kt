package com.example.ucp1_193

import android.R
import android.graphics.Paint.Style
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable

fun Ujian(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var nomorHp by remember { mutableStateOf("") }
    var jenisK by remember { mutableStateOf("") }

    var datanama by remember { mutableStateOf("") }
    var datanomorHp by remember { mutableStateOf("") }
    var datajenisK by remember { mutableStateOf("") }
    val datajk = listOf("Laki-Laki", "Perempuan")

    Column {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(11.dp),

        ){
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Blue)
            .padding(20.dp)
        ) {
            Icon(Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Row {
                Column {
                    Text(
                        text ="Halo,",
                        color = Color.White,
                        fontSize = 50.sp
                    )
                    Text(
                        datanama,
                        fontSize = 25.sp
                    )

                }

//                Image(
//                    painter = painterResource(R.drawable.auu),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .size(60.dp)
//                        .align(Alignment.CenterVertically)
//                )
            }

        }
        Spacer(modifier = Modifier.padding(10.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),
        ){
            Spacer(modifier = Modifier.padding(30.dp))
            Text(
                "Yuk lengkapi data dirimu !",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(20.dp)
            )

        }
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),

        ){
            TextField(
                value = nama,
                onValueChange = {nama = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Nama")},
                placeholder = {
                    Text("Masukkan Nama Anda", color = Color.Gray)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.padding(5.dp))

            TextField(
                value = nomorHp,
                onValueChange = {nomorHp = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text("Nomor Telepon")},
                placeholder = {
                    Text("Masukkan Nomor Telepon Anda", color = Color.Gray)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text("  Jenis Kelamin",
                fontSize = 15.sp)
            Row {
                datajk.forEach { selectedJK ->
                    Row (verticalAlignment = Alignment.CenterVertically){
                        RadioButton(
                            selected = jenisK == selectedJK,
                            onClick ={
                                jenisK = selectedJK
                            })
                        Text(selectedJK)
                    }
                }
            }
            Button(onClick = {
                datanama = nama
                datajenisK = jenisK
                datanomorHp = nomorHp}, modifier = Modifier.padding(vertical = 5.dp)) {
                Text("Simpan",)
            }
            Card(modifier = Modifier.fillMaxWidth().padding(5.dp)) {
                Column {
                    NampilData(
                        judul = "Nomor HP",
                        isinya = datanomorHp
                    )
                    NampilData(
                        judul = "Jenis Kelamin",
                        isinya = datajenisK
                    )
                }
            }
        }
    }
}

@Composable
fun NampilData(
    judul:String,
    isinya:String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(judul, modifier = Modifier.weight(0.8f))
        Text(":", modifier = Modifier.weight(0.2f))
        Text(
            isinya,
            modifier = Modifier.weight(2f)
        )
    }
}
