package com.example.pdm0126

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import com.example.pdm0126.taller1_00012523.quizQuestion
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdm0126.ui.theme.Pdm0126Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuizScreenTheme {
                // Superficie principal con fondo blanco
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    AndroidPediaWelcomeScreen()
                }
            }
        }
    }
}
@Composable
fun QuizScreenTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}

@Composable
fun AndroidPediaWelcomeScreen() {
    // Variable para rastrear el estado del Checkbox
    var terminosAceptados by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), // Margen alrededor de toda la pantalla
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        // --- 1. Tarjeta Amarilla de Título (Header) ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Toma 1 parte del espacio vertical
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFBFEB47)) // Color amarillo exacto
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // Nombre de la app (top-left)
                Text(
                    text = "AndroidPedia",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                // Título principal centrado
                Box(modifier = Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "¿Cuánto sabes de\nAndroid?",
                        fontSize = 32.sp, // Tamaño grande para el título
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        lineHeight = 40.sp, // Ajuste para que las líneas no se peguen
                        modifier = Modifier.padding(bottom = 30.dp) // Espacio para no chocar con el nombre
                    )
                }

                // Nombre del estudiante (bottom-left)
                Text(
                    text = "Eduardo Andrés Sigüenza Argueta- 00012523",
                    fontSize = 14.sp,
                    color = Color.Black.copy(alpha = 0.8f), // Ligeramente más opaco
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp)) // Espacio entre tarjetas

        // --- 2. Tarjeta Naranja del Botón ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.3f), // Un poco más alta que la amarilla
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF3AE1CE)) // Color naranja exacto
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                // Botón blanco
                Button(
                    onClick = { /* Acción al pulsar */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(30.dp), // Botón muy redondeado
                    modifier = Modifier.width(230.dp).height(65.dp) // Tamaño del botón
                ) {
                    Text(
                        text = "Comenzar Quiz",
                        fontSize = 20.sp, // Texto grande
                        color = Color.Black,
                        fontWeight = FontWeight.W500 // Peso medio
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp)) // Espacio entre tarjetas

        // --- 3. Tarjeta Rosa de Términos ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.1f), // Un poco más alta que la amarilla
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFDA4671)) // Color rosa exacto
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                // Texto de términos
                Text(
                    text = "Acepto terminos y condiciones",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Checkbox grande (un poco más complejo para que sea cuadrado y tenga el icono exacto)
                Row(
                    modifier = Modifier.fillMaxWidth().padding(start = 5.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Card(
                        modifier = Modifier.size(40.dp), // Tamaño grande
                        shape = RoundedCornerShape(4.dp), // Esquinas apenas redondeadas
                        colors = CardDefaults.cardColors(containerColor = if (terminosAceptados) Color(0xFF7986CB) else Color.White), // Fondo azul al marcar
                        border = if (terminosAceptados) null else androidx.compose.foundation.BorderStroke(2.dp, Color.Gray), // Borde si no está marcado
                        onClick = { terminosAceptados = !terminosAceptados } // Acción al pulsar el cuadrado
                    ) {
                        if (terminosAceptados) {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = androidx.compose.material.icons.Icons.Default.Check, // Icono de Check
                                    contentDescription = "Aceptado",
                                    tint = Color.White,
                                    modifier = Modifier.size(30.dp) // Tamaño del icono dentro
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// Para ver una vista previa sin ejecutar en el dispositivo
@Preview(showBackground = true)
@Composable
fun PreviewQuizScreen() {
    QuizScreenTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
            AndroidPediaWelcomeScreen()
        }
    }
}


