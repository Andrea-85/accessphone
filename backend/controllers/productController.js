// backend/controllers/productController.js

const Product = require('../models/productModel');

const updateProduct = async (req, res) => {
    try {
        const updatedProduct = await Product.findByIdAndUpdate(
            req.params.id,
            req.body,
            { new: true }
        );
        if (!updatedProduct) {
            return res.status(404).json({ message: "Producto no encontrado" });
        }
        res.json(updatedProduct);
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

const deleteProduct = async (req, res) => {
    try {
        const deletedProduct = await Product.findByIdAndDelete(req.params.id);
        if (!deletedProduct) {
            return res.status(404).json({ message: "Producto no encontrado" });
        }
        res.json({ message: "Producto eliminado correctamente" });
    } catch (error) {
        res.status(500).json({ message: error.message });
    }
};

// Mostrar productos
const getProducts = async (req, res) => {
    const products = await Product.find();
    res.json(products);
};

// Agregar producto
const addProduct = async (req, res) => {
    const { nombre, descripcion, precio, stock } = req.body;

    const newProduct = new Product({
        nombre,
        descripcion,
        precio,
        stock
    });

    const savedProduct = await newProduct.save();
    res.status(201).json(savedProduct);
};

module.exports = {
    getProducts,
    addProduct,
    updateProduct,
    deleteProduct
};
