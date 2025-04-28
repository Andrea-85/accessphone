const connectDB = require('./config/db');

// Conectar a la base de datos
connectDB();

// backend/app.js

const express = require('express');
const app = express();
const PORT = 3000;

const productRoutes = require('./routes/productRoutes');

app.use(express.json());

app.use('/api/products', productRoutes);

app.get('/', (req, res) => {
    res.send('¡Bienvenido al backend de AccessPhone!');
});

app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});
