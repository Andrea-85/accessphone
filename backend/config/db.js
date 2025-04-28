// backend/config/db.js

const mongoose = require('mongoose');

const connectDB = async () => {
    try {
        await mongoose.connect('mongodb+srv://AndeloyClau:Herrera2025@cluster0.dwvduag.mongodb.net/AccessPhone?retryWrites=true&w=majority', {
            
        });
        console.log('✅ Conectado a MongoDB correctamente');
    } catch (error) {
        console.error('❌ Error conectando a MongoDB:', error.message);
        process.exit(1); // Forzar salir si falla la conexión
    }
};

module.exports = connectDB;
