package com.example.pdm0126.taller1_00012523

import com.example.pdm0126.taller1_00012523.Question.kt.Question

val pregunta = Question(
    id = 1,
    pregunta = "Para que dispositivos se creo originalmente el sistema Android?",
    opciones = listOf(
        "Submarinos",
        "Tostadoras",
        "Camaras digitales",
        "Celulares"
    ),
    respuesta = "Camaras digitales",
    datoCusioso = "La idea original de Andy Rubin era crear una \"plataforma de cámaras inteligentes\" que no solo sacaran fotos, sino que se conectaran a una PC y, desde ahí, a un servicio en la nube llamado \"Android Datacenter\""
)
val pregunta2 = Question(
    id = 2,
    pregunta = "Que telefono fue el que los obligo a crear el HTC Dream y en que año?",
    opciones = listOf(
        "Samsung Note, 2004",
        "IPhone, 2007",
        "Alcatel DL1000, 2006",
        "HTC Desire 12, 2005"
    ),
    respuesta = "Iphone, 2007",
    datoCusioso = "el primer iPhone de 2007 era pura magia visual, pero tenía carencias que hoy nos parecerían una tortura. \nEl primer iPhone no podía copiar ni pegar texto."
)
val pregunta3 = Question(
    id = 3,
    pregunta = "Que nombre en clave se ocupa para Android 13?",
    opciones = listOf(
        "Tiramisu",
        "KitKat",
        "Waffles",
        "Jelly Bean"
    ),
    respuesta = "Tiramisu",
    datoCusioso = "Android 13 es que fue la versión que finalmente le dio a los políglotas el superpoder que tanto esperaban: los idiomas por aplicación."
)


val quizQuestion = listOf(
    pregunta,
    pregunta2,
    pregunta3
)





