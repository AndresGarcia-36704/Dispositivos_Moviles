package com.ui.saboresdeldia.data

import com.ui.saboresdeldia.model.Recipe

object RecipeRepository {
    fun getRecipes(): List<Recipe> = listOf(
        Recipe("Día 1", "Lunes de Lasagna", "Una deliciosa lasagna casera con carne molida, salsa de tomate y queso derretido.", "https://source.unsplash.com/400x300/?lasagna"),
        Recipe("Día 2", "Martes de Tacos", "Tacos al estilo mexicano con carne asada, cebolla y cilantro fresco.", "https://source.unsplash.com/400x300/?tacos"),
        Recipe("Día 3", "Miércoles de Pollo al Curry", "Pollo cocido en una cremosa salsa de curry con arroz blanco.", "https://source.unsplash.com/400x300/?chicken,curry"),
        Recipe("Día 4", "Jueves de Ensalada César", "Una ensalada refrescante con lechuga romana, pollo, croutones y aderezo césar.", "https://source.unsplash.com/400x300/?salad,caesar"),
        Recipe("Día 5", "Viernes de Pizza Artesanal", "Pizza con masa delgada, salsa casera, pepperoni y vegetales frescos.", "https://source.unsplash.com/400x300/?pizza"),
        Recipe("Día 6", "Sábado de Hamburguesas", "Jugosas hamburguesas con queso, lechuga, tomate y papas fritas.", "https://source.unsplash.com/400x300/?burger"),
        Recipe("Día 7", "Domingo de Pasta Alfredo", "Pasta fettuccine en una cremosa salsa Alfredo con pollo.", "https://source.unsplash.com/400x300/?pasta,alfredo"),
        Recipe("Día 8", "Ensalada Mediterránea", "Tomates cherry, pepino, aceitunas negras y queso feta.", "https://source.unsplash.com/400x300/?mediterranean,salad"),
        Recipe("Día 9", "Cazuela de Mariscos", "Una mezcla de mariscos cocidos con especias y salsa criolla.", "https://source.unsplash.com/400x300/?seafood,stew"),
        Recipe("Día 10", "Pollo a la Parrilla", "Pechuga de pollo a la parrilla con especias y vegetales asados.", "https://source.unsplash.com/400x300/?grilled,chicken"),
        Recipe("Día 11", "Sopa de Tomate", "Sopa cremosa de tomate con croutones y albahaca fresca.", "https://source.unsplash.com/400x300/?tomato,soup"),
        Recipe("Día 12", "Curry de Garbanzos", "Plato vegetariano lleno de sabor con garbanzos y especias.", "https://source.unsplash.com/400x300/?chickpea,curry"),
        Recipe("Día 13", "Arepas con Queso", "Arepas colombianas rellenas de queso derretido.", "https://source.unsplash.com/400x300/?arepas"),
        Recipe("Día 14", "Pescado al Horno", "Filete de pescado horneado con limón y finas hierbas.", "https://source.unsplash.com/400x300/?baked,fish"),
        Recipe("Día 15", "Tallarines con Verduras", "Tallarines salteados con una mezcla de vegetales frescos.", "https://source.unsplash.com/400x300/?noodles,vegetables"),
        Recipe("Día 16", "Bowl de Quinoa", "Quinoa con aguacate, frijoles negros y maíz.", "https://source.unsplash.com/400x300/?quinoa,bowl"),
        Recipe("Día 17", "Croquetas de Pollo", "Croquetas crujientes por fuera y suaves por dentro.", "https://source.unsplash.com/400x300/?chicken,croquettes"),
        Recipe("Día 18", "Sándwich Club", "Pan tostado con jamón, pollo, lechuga y mayonesa.", "https://source.unsplash.com/400x300/?club,sandwich"),
        Recipe("Día 19", "Tostadas Francesas", "Pan dulce empapado en huevo y leche, servido con miel.", "https://source.unsplash.com/400x300/?french,toast"),
        Recipe("Día 20", "Burritos de Desayuno", "Tortilla rellena con huevo, queso y tocino.", "https://source.unsplash.com/400x300/?breakfast,burrito"),
        Recipe("Día 21", "Empanadas de Carne", "Empanadas crujientes rellenas de carne molida y condimentos.", "https://source.unsplash.com/400x300/?empanadas"),
        Recipe("Día 22", "Arroz con Pollo", "Un clásico plato casero con arroz, verduras y pollo.", "https://source.unsplash.com/400x300/?chicken,rice"),
        Recipe("Día 23", "Ramen Casero", "Sopa japonesa con fideos, huevo y cerdo.", "https://source.unsplash.com/400x300/?ramen"),
        Recipe("Día 24", "Galletas de Chocolate", "Galletas recién horneadas con trozos de chocolate.", "https://source.unsplash.com/400x300/?chocolate,cookies"),
        Recipe("Día 25", "Brownies", "Deliciosos brownies de chocolate, húmedos y esponjosos.", "https://source.unsplash.com/400x300/?brownies"),
        Recipe("Día 26", "Panqueques con Frutas", "Panqueques esponjosos servidos con frutas frescas y miel.", "https://source.unsplash.com/400x300/?pancakes,fruit"),
        Recipe("Día 27", "Tarta de Manzana", "Clásica tarta con relleno de manzana y canela.", "https://source.unsplash.com/400x300/?apple,pie"),
        Recipe("Día 28", "Helado Artesanal", "Helado cremoso hecho en casa con tus sabores favoritos.", "https://source.unsplash.com/400x300/?icecream"),
        Recipe("Día 29", "Smoothie de Fresa", "Bebida refrescante con fresas, yogur y miel.", "https://source.unsplash.com/400x300/?strawberry,smoothie"),
        Recipe("Día 30", "Muffins de Arándanos", "Muffins suaves y esponjosos con arándanos.", "https://source.unsplash.com/400x300/?blueberry,muffins"),
        Recipe("Día 31", "Nachos con Guacamole", "Totopos cubiertos con queso, guacamole y pico de gallo.", "https://source.unsplash.com/400x300/?nachos,guacamole")
    )
}
