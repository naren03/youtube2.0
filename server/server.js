const express = require("express");

const app = express();

const PORT =8000;

app.get("/",(req,res)=>{
    res.send("<h1>Hiiii</h1>")
})

app.listen(PORT,()=>{console.log(`Server is running on port ${PORT}`)})
