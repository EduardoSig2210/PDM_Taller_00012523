package com.example.foodspot

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.foodspot.clases.Dish
import com.example.foodspot.clases.Restaurant
import com.example.foodspot.ui.theme.FoodSpotTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodSpotTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    AppNav()
}

val restaurant = listOf(
    Restaurant(
        Id = 1,
        Name = "Burger House",
        Description = "Las mejores hamburguesas",
        imgUrl = "",
        Category = listOf("Comida Rápida"),
        Menu = listOf(
            Dish(1, "Hamburguesa Clásica", "Carne y queso", "https://resuelveconbimbo.com/ca/hamburguesa-explosiva"),
            Dish(2, "Papas Fritas", "Papas crujientes", "https://lalagourmetkc.com/product/papas-fritas/"),
            Dish(3, "Malteada", "Chocolate", "https://sazonsula.com/recetas/bebidas/malteada-de-cafe")
        )
    ),


    Restaurant(
        Id = 2,
        Name = "Pizza Place",
        Description = "Pizza italiana artesanal",
        imgUrl = "",
        Category = listOf("Comida Italiana"),
        Menu = listOf(
            Dish(4, "Pizza Pepperoni", "Pepperoni y queso", "https://www.papajohns.com.pe/pepperoni"),
            Dish(5, "Lasaña", "Lasaña tradicional", "https://www.tasteofhome.com/recipes/best-lasagna/"),
            Dish(6, "Pan de Ajo", "Con mantequilla", "https://jetextramar.com/recetas/pan-con-ajo-la-tapa-que-no-puede-faltar-en-tu-menu/")
        )
    ),

    Restaurant(
        Id = 3,
        Name = "Sushi Bar",
        Description = "Especialidades japonesas",
        imgUrl = "",
        Category = listOf("Comida Asiática"),
        Menu = listOf(
            Dish(7, "Sushi Roll", "Roll de salmón", "https://sushicentral.mx/category/rollos/rollos_salmon/"),
            Dish(8, "Ramen", "Caldo japonés", "https://www.bonappetit.com/recipe/vegetarian-ramen?srsltid=AfmBOooX2XeV3dKI7ywlI2kEsY-B5-lfUjB7zyDe5QV1lKsSDlqyQfv3"),
            Dish(9, "Tempura", "Vegetales fritos", "https://www.kikkoman.es/recetas/detail/tempura-de-marisco-y-verduras")
        )
    ),

    Restaurant(
        Id = 4,
        Name = "Taco Fiesta",
        Description = "Auténtica comida mexicana",
        imgUrl = "",
        Category = listOf("Mexicana"),
        Menu = listOf(
            Dish(10, "Tacos al Pastor", "Cerdo y piña", "https://www.cocinafacil.com.mx/recetas/como-hacer-unos-tacos-al-pastor-caseros"),
            Dish(11, "Quesadilla", "Queso derretido", "https://www.kikkoman.es/food-service/recetas/detail/quesadilla-asiatica-de-pato-con-un-toque-frutal"),
            Dish(12, "Nachos", "Con guacamole", "https://www.simplotfood.com/es/recipe/spicy-corn-and-jalapeno-nachos")
        )
    ),

    Restaurant(
        Id = 5,
        Name = "Pollo Loco",
        Description = "Pollo asado y combos",
        imgUrl = "",
        Category = listOf("Comida Rápida"),
        Menu = listOf(
            Dish(13, "Pollo Asado", "Con papas", "https://comoquiero.net/es-CL/receta/5313/pollo-asado-con-papas-fritas"),
            Dish(14, "Alitas BBQ", "Picantes", "https://www.labuena.com.co/hazlo-facil-cat/receta-casera-de-alitas-bbq/"),
            Dish(15, "Ensalada", "Vegetales frescos", "https://veggiefestchicago.org/es/recipe/thai-chopped-salad/")
        )
    ),

    Restaurant(
        Id = 6,
        Name = "Bella Pasta",
        Description = "Pastas italianas",
        imgUrl = "",
        Category = listOf("Comida Italiana"),
        Menu = listOf(
            Dish(16, "Spaghetti", "Salsa roja", ""),
            Dish(17, "Fettuccine Alfredo", "Salsa cremosa", ""),
            Dish(18, "Ravioli", "Rellenos de queso", "")
        )
    ),

    Restaurant(
        Id = 7,
        Name = "Wok Express",
        Description = "Comida china rápida",
        imgUrl = "",
        Category = listOf("Comida Asiática"),
        Menu = listOf(
            Dish(19, "Chow Mein", "Fideos salteados", ""),
            Dish(20, "Arroz Frito", "Con vegetales", ""),
            Dish(21, "Pollo Agridulce", "Salsa especial", "")
        )
    ),

    Restaurant(
        Id = 8,
        Name = "Sea Food Grill",
        Description = "Especialidades marinas",
        imgUrl = "",
        Category = listOf("Mariscos"),
        Menu = listOf(
            Dish(22, "Camarones", "Al ajillo", ""),
            Dish(23, "Pescado Frito", "Con limón", ""),
            Dish(24, "Ceviche", "Fresco", "")
        )
    ),

    Restaurant(
        Id = 9,
        Name = "Healthy Green",
        Description = "Comida saludable",
        imgUrl = "",
        Category = listOf("Saludable"),
        Menu = listOf(
            Dish(25, "Ensalada César", "Con pollo", ""),
            Dish(26, "Smoothie", "Frutas naturales", ""),
            Dish(27, "Wrap Vegetal", "Vegetales frescos", "")
        )
    ),

    Restaurant(
        Id = 10,
        Name = "Sweet Bakery",
        Description = "Postres y café",
        imgUrl = "",
        Category = listOf("Postres"),
        Menu = listOf(
            Dish(28, "Cheesecake", "Fresa", ""),
            Dish(29, "Cupcake", "Chocolate", ""),
            Dish(30, "Café Latte", "Caliente", "")
        )
    )
)

@Composable
fun PantallaFoodSpot(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    val restaurantesFiltradosPorBusqueda = restaurant.filter { res ->
        res.Name.contains(searchQuery, ignoreCase = true) ||
                res.Menu.any { dish -> dish.name.contains(searchQuery, ignoreCase = true) }
    }

    val categorias = restaurant
        .flatMap { it.Category }
        .toSet()
        .toList()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Buscar restaurante o platillo...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color(0xFF5B4FCF)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF5B4FCF),
                    unfocusedBorderColor = Color.LightGray
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        if (searchQuery.isEmpty()) {
            items(categorias) { categoria ->
                Text(
                    text = categoria,
                    style = TextStyle(
                        color = Color(0xFF5B4FCF),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                val restaurantesDeCategoria = restaurant.filter {
                    it.Category.contains(categoria)
                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(restaurantesDeCategoria) { restaurantItem ->
                        RestaurantCard(restaurantItem) {
                            navController.navigate("Detalle/${restaurantItem.Id}")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        } else {
            item {
                Text(
                    text = "${restaurantesFiltradosPorBusqueda.size} resultados encontrados",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            if (restaurantesFiltradosPorBusqueda.isEmpty()) {
                item {
                    EstadoVacioBusqueda()
                }
            } else {
                items(restaurantesFiltradosPorBusqueda) { restaurantItem ->
                    SearchRestaurantCard(restaurantItem) {
                        navController.navigate("Detalle/${restaurantItem.Id}")
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun RestaurantCard(restaurant: Restaurant, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(150.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = restaurant.imgUrl,
                contentDescription = "Imagen de ${restaurant.Name}",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = restaurant.Name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun SearchRestaurantCard(restaurant: Restaurant, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xECECECEC))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = restaurant.imgUrl,
                contentDescription = "Imagen de ${restaurant.Name}",
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE0E0E0)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = restaurant.Name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = restaurant.Description,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .background(Color(0xFFF0EFFF), RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = restaurant.Category.firstOrNull() ?: "",
                        fontSize = 11.sp,
                        color = Color(0xFF5B4FCF),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun EstadoVacioBusqueda() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp)
            .border(1.dp, Color(0xFFE5E5E5), RoundedCornerShape(12.dp))
            .background(Color(0xFFFAFAFA), RoundedCornerShape(12.dp))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(44.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "No se encontraron resultados",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaDetalleRestaurante(navController: NavController, restaurantId: Int?) {
    val context = LocalContext.current
    val restauranteSeleccionado = restaurant.find { it.Id == restaurantId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = restauranteSeleccionado?.Name ?: "Detalle",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        containerColor = Color.White
    ) { paddingValues ->

        if (restauranteSeleccionado == null) return@Scaffold

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            item {
                Text(
                    text = restauranteSeleccionado.Description,
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 16.dp),
                    lineHeight = 20.sp
                )
            }

            items(restauranteSeleccionado.Menu) { platillo ->
                ItemPlatillo(platillo) {
                    Toast.makeText(context, "${platillo.name} agregado", Toast.LENGTH_SHORT).show()
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ItemPlatillo(platillo: Dish, onAddClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xECECECEC))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = platillo.imgURL,
                contentDescription = "Imagen de ${platillo.name}",
                modifier = Modifier
                    .size(85.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE0E0E0)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = platillo.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Text(
                    text = platillo.description,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 4.dp),
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Button(
                    onClick = onAddClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2A237E)),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text(text = "+ Agregar", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun AppNav() {
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = "Home"
    ) {
        composable("Home") {
            PantallaFoodSpot(nav)
        }
        composable("Detalle/{resId}") { backStackEntry ->
            val resId = backStackEntry.arguments?.getString("resId")?.toIntOrNull()
            PantallaDetalleRestaurante(nav, resId)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodSpotTheme {
        Greeting()
    }
}