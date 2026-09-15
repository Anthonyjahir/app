package com.example.lazylayoutsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    LazyLayoutsScreen()
                }
            }
        }
    }
}

@Composable
fun LazyLayoutsScreen() {

    val categorias = listOf(
        "Todos",
        "Celulares",
        "Laptops",
        "Consolas",
        "Videojuegos",
        "Accesorios",
        "Audífonos"
    )

    val productos = listOf(
        Producto("iPhone 15", "Celulares", 15999.0),
        Producto("Samsung Galaxy S24", "Celulares", 18999.0),
        Producto("Xiaomi 14", "Celulares", 13999.0),
        Producto("Motorola Edge 50", "Celulares", 9999.0),
        Producto("Laptop Lenovo", "Laptops", 14999.0),
        Producto("Laptop ASUS", "Laptops", 16999.0),
        Producto("Laptop HP", "Laptops", 12999.0),
        Producto("Xbox Series S", "Consolas", 6999.0),
        Producto("PlayStation 5", "Consolas", 11999.0),
        Producto("Nintendo Switch", "Consolas", 7999.0),
        Producto("FC 26", "Videojuegos", 1399.0),
        Producto("Forza Horizon 5", "Videojuegos", 999.0),
        Producto("Resident Evil 4", "Videojuegos", 1199.0),
        Producto("Minecraft", "Videojuegos", 799.0),
        Producto("Control Xbox", "Accesorios", 1499.0),
        Producto("Teclado Gamer", "Accesorios", 899.0),
        Producto("Mouse Gamer", "Accesorios", 599.0),
        Producto("Audífonos Sony", "Audífonos", 1999.0),
        Producto("Audífonos JBL", "Audífonos", 1299.0),
        Producto("Audífonos Logitech", "Audífonos", 1599.0)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Lazy Layouts Demo",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Categorías",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(categorias) { categoria ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Text(
                        text = categoria,
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 10.dp
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Productos",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(productos) { producto ->
                ProductoItem(producto)
            }
        }
    }
}

@Composable
fun ProductoItem(producto: Producto) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = producto.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = producto.categoria,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "$${producto.precio}",
                    style = MaterialTheme.typography.titleSmall
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Ver",
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.primary,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(
                        horizontal = 14.dp,
                        vertical = 8.dp
                    ),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
