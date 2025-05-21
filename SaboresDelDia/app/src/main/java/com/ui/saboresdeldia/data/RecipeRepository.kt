package com.ui.saboresdeldia.data

import com.ui.saboresdeldia.model.Recipe

object RecipeRepository {
    fun getRecipes(): List<Recipe> = listOf(
        Recipe("Día 1", "Lunes de Lasagna", "Una deliciosa lasagna casera con carne molida, salsa de tomate y queso derretido.", "https://images.unsplash.com/photo-1601924638867-3ec2d55f0c2b?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 2", "Martes de Tacos", "Tacos al estilo mexicano con carne asada, cebolla y cilantro fresco.", "https://images.unsplash.com/photo-1600891964599-f61ba0e24092?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 3", "Miércoles de Pollo al Curry", "Pollo cocido en una cremosa salsa de curry con arroz blanco.", "https://images.unsplash.com/photo-1613145992493-d429a0c4a61a?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 4", "Jueves de Ensalada César", "Una ensalada refrescante con lechuga romana, pollo, croutones y aderezo césar.", "https://images.unsplash.com/photo-1589302168068-964664d93dc0?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 5", "Viernes de Pizza Artesanal", "Pizza con masa delgada, salsa casera, pepperoni y vegetales frescos.", "https://images.unsplash.com/photo-1548365328-8b849fd54f2b?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 6", "Sábado de Hamburguesas", "Jugosas hamburguesas con queso, lechuga, tomate y papas fritas.", "https://images.unsplash.com/photo-1550547660-d9450f859349?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 7", "Domingo de Pasta Alfredo", "Pasta fettuccine en una cremosa salsa Alfredo con pollo.", "https://images.unsplash.com/photo-1627308595229-7830a5c91f9f?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 8", "Ensalada Mediterránea", "Tomates cherry, pepino, aceitunas negras y queso feta.", "https://images.unsplash.com/photo-1565895405130-0609be27a4be?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 9", "Cazuela de Mariscos", "Una mezcla de mariscos cocidos con especias y salsa criolla.", "https://images.unsplash.com/photo-1607330283522-b58b25190bd2?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 10", "Pollo a la Parrilla", "Pechuga de pollo a la parrilla con especias y vegetales asados.", "https://images.unsplash.com/photo-1625943806112-1b9c7ec75278?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 11", "Sopa de Tomate", "Sopa cremosa de tomate con croutones y albahaca fresca.", "https://images.unsplash.com/photo-1601315379608-6b84758e0151?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 12", "Curry de Garbanzos", "Plato vegetariano lleno de sabor con garbanzos y especias.", "https://images.unsplash.com/photo-1620842227635-7f0241d1d159?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 13", "Arepas con Queso", "Arepas colombianas rellenas de queso derretido.", "https://images.unsplash.com/photo-1592159602314-15b1642b15d1?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 14", "Pescado al Horno", "Filete de pescado horneado con limón y finas hierbas.", "https://images.unsplash.com/photo-1585238341986-ef36f1e1f9ad?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 15", "Tallarines con Verduras", "Tallarines salteados con una mezcla de vegetales frescos.", "https://images.unsplash.com/photo-1619890025593-d90eac2e1188?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 16", "Bowl de Quinoa", "Quinoa con aguacate, frijoles negros y maíz.", "https://images.unsplash.com/photo-1556911073-52527ac437f5?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 17", "Croquetas de Pollo", "Croquetas crujientes por fuera y suaves por dentro.", "https://images.unsplash.com/photo-1616013425597-6de88f9bddec?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 18", "Sándwich Club", "Pan tostado con jamón, pollo, lechuga y mayonesa.", "https://images.unsplash.com/photo-1600628422011-03bb2516c53c?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 19", "Tostadas Francesas", "Pan dulce empapado en huevo y leche, servido con miel.", "https://images.unsplash.com/photo-1551024601-bec78aea704b?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 20", "Burritos de Desayuno", "Tortilla rellena con huevo, queso y tocino.", "https://images.unsplash.com/photo-1552332386-f8dd00dc2f85?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 21", "Empanadas de Carne", "Empanadas crujientes rellenas de carne molida y condimentos.", "https://images.unsplash.com/photo-1606335543042-18fa08a4e094?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 22", "Arroz con Pollo", "Un clásico plato casero con arroz, verduras y pollo.", "https://images.unsplash.com/photo-1624876941549-135a54ef69a1?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 23", "Ramen Casero", "Sopa japonesa con fideos, huevo y cerdo.", "https://images.unsplash.com/photo-1590080876494-0c67fdfcf3e0?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 24", "Galletas de Chocolate", "Galletas recién horneadas con trozos de chocolate.", "https://images.unsplash.com/photo-1601924582971-868e7b2b93f0?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 25", "Brownies", "Deliciosos brownies de chocolate, húmedos y esponjosos.", "https://images.unsplash.com/photo-1587731532758-6c65e1cddeb0?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 26", "Panqueques con Frutas", "Panqueques esponjosos servidos con frutas frescas y miel.", "https://images.unsplash.com/photo-1587733481587-3d70d78e0c93?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 27", "Tarta de Manzana", "Clásica tarta con relleno de manzana y canela.", "https://images.unsplash.com/photo-1601004890684-d8cbf643f5f2?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 28", "Helado Artesanal", "Helado cremoso hecho en casa con tus sabores favoritos.", "https://images.unsplash.com/photo-1589987607627-76b6b0c0824d?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 29", "Smoothie de Fresa", "Bebida refrescante con fresas, yogur y miel.", "https://images.unsplash.com/photo-1590080876494-0c67fdfcf3e0?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 30", "Muffins de Arándanos", "Muffins suaves y esponjosos con arándanos.", "https://images.unsplash.com/photo-1610440942625-f9dbf5fc1c7b?auto=format&fit=crop&w=800&q=80"),
        Recipe("Día 31", "Nachos con Guacamole", "Totopos cubiertos con queso, guacamole y pico de gallo.", "https://images.unsplash.com/photo-1601924577961-c86e6dce63e6?auto=format&fit=crop&w=800&q=80")
    )
}
